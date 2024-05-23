package com.test.websocket.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.test.websocket.domain.Message;

@ServerEndpoint("/chatserver.do")
public class ChatServer {

	// 현재 채팅 서버에 접속한 클라이언트 세션
	private static List<Session> sessionList = new ArrayList<Session>();
	
	//여러 채팅방
	//private static List<List<Session>>

	@OnOpen
	public void handleOpen(Session session) { // 세션안에 전용 소켓이 있음

		System.out.println("클라이언트가 접속했습니다.");
		sessionList.add(session);

	}

	@OnMessage
	public void handleMessage(String msg, Session session) {

		// System.out.println(msg);
		// {"code":"1","sender":"강아지","receiver":"","content":"","regdate":"2024-05-23 15:35:18"}

		// JSON의 형식으로 출력된 것을 자바의 Message.java의 오브젝트 객체에 각각 저장해야함
		Gson gson = new Gson();

		Message message = gson.fromJson(msg, Message.class);

		//System.out.println(message); // Message(code=1, sender=강아지, receiver=, content=, regdate=2024-05-23 15:41:40)

		if (message.getCode().equals("1")) { //새로운 유저 접속
			
			//해당 유저 제외하고 다른 유저에게 해당 유저가 접속하여 작성한 문자열을 보내줌
			for (Session s : sessionList) {
				if(s != session) {
					try {
						s.getBasicRemote().sendText(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
			
		} else if (message.getCode().equals("2")) { //기존 유저 나감

			//나간 유저의 세션을 제거
			sessionList.remove(session);
			
			//해당 유저 제외하고 다른 유저에게 해당 유저가 접속하여 작성한 문자열을 보내줌
			for (Session s : sessionList) {
					try {
						s.getBasicRemote().sendText(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			
			
		} else if (message.getCode().equals("3") || message.getCode().equals("4")) {
			
			//대화 내용을 전달
			for (Session s : sessionList) {
				if (s != session) {
					try {
						s.getBasicRemote().sendText(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
		
	}

	@OnClose
	public void handleClose() {

		System.out.println("클라이언트와 연결이 종료되었습니다.");

	}

	@OnError
	public void handleError(Throwable e) {

	}

}
