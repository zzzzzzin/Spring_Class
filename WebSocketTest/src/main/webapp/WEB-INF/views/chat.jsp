<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
<style>
	
	html, body {
		padding: 0 !important;
		margin: 0 !important;
		background-color: #FFF !important; 
		display: block;
		overflow: hidden;
	}
	
	body > div {
		margin: 0; 
		padding: 0; 
	}

	#main {
		width: 400px;
		height: 510px;
		margin: 3px;
		display: grid;
		grid-template-rows: repeat(12, 1fr);
	}
	
	#header {
	
	}
	
	#header > h2 {		
		margin: 0px;
		margin-bottom: 10px;
		padding: 5px;
	}

	#list {
		border: 1px solid var(--border-color);
		box-sizing: content-box;
		padding: .5rem;
		grid-row-start: 2;
		grid-row-end: 12;
		font-size: 14px;
		overflow: auto;
	}
	
	
	#msg {
		margin-top: 3px;
	}
	
	#list .item {
		font-size: 14px;
		margin: 15px 0;
	}
	
	#list .item > div:first-child {
		display: flex;
	}
	
	#list .item.me > div:first-child {
		justify-content: flex-end;
	}
	
	#list .item.other > div:first-child {
		justify-content: flex-end;
		flex-direction: row-reverse;
	}
	
	#list .item > div:first-child > div:first-child {
		font-size: 10px;
		color: #777;
		margin: 3px 5px;
	}
	
	#list .item > div:first-child > div:nth-child(2) {
		border: 1px solid var(--border-color);
		display: inline-block;
		min-width: 100px;
		max-width: 250px;
		text-align: left;
		padding: 3px 7px;
	}
	
	#list .state.item > div:first-child > div:nth-child(2) {
		background-color: #EEE;
	}
	
	#list .item > div:last-child {
		font-size: 10px;
		color: #777;
		margin-top: 5px;
	}
	
	#list .me {
		text-align: right;
	}
	
	#list .other {
		text-align: left;
	}
	
	#list .msg.me.item > div:first-child > div:nth-child(2) {
		background-color: rgba(255, 99, 71, .2);
	}
	
	#list .msg.other.item > div:first-child > div:nth-child(2) {
		background-color: rgba(100, 149, 237, .2);
	}
	
	#list .msg img {
		width: 150px;
	}
	
</style>
</head>
<body>
	<!-- chat.jsp -->
	<div id="main">
		<div id="header"><h2>WebSocket <small>강아지</small></h2></div>
		<div id="list"></div>
		<input type="text" id="msg" placeholder="대화 내용을 입력하세요.">
	</div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/dayjs@1.11.11/dayjs.min.js"></script>
	
	<script>
	
	/* 
		*****중요*****
		전달 메시지 형식
		- code: 상태 코드
			- 1: 새로운 유저가 들어옴
			- 2: 기존 유저가 나감
			- 3: 메시지 전달
			- 4: 이모티콘 전달(수업용으로 임의로 정한 것)
		- sender: 보내는 유저명
		- receiver: 받는 유저명
		- content: 대화 내용
		- regdate: 날짜/시간
	 */
		let name; //대화명
		
		//중복창 방지
		$(window).on('beforeunload', function() {
			
			$(opener.document).find('.in').css('opacity', 1);
			$(opener.document).find('.in').prop('disabled', false);
			$(opener.document).find('#name').val('');
			$(opener.document).find('#name').prop('readOnly', false);
			
			//서버와의 연결 종료
			disconnect();
			
		});
		
		//서버 주소
		const url = 'ws://localhost:8080/websocket/chatserver.do';
		
		//소켓 객체 생성
		let ws;
		
		//창 > 서버 연결하기
		function connect(name) {
			
			$('#header small').text(name);
			
			//연결하기 > 소켓 생성
			ws = new WebSocket(url);
			log('서버와 연결을 시도합니다.');
			
			//소켓 이벤트 매핑
			ws.onopen = evt => {
				log('서버와 연결이 되었습니다.');
				
				//접속한 유저명을 서버에게 전달
				const message = {
						code: '1',
						sender: name,
						receiver: '',
						content: '',
						regdate: dayjs().format('YYYY-MM-DD HH:mm:ss')
				};
				
				ws.send(JSON.stringify(message)); //{"code":"1","sender":"강아지","receiver":"","content":"","regdate":"2024-05-23 15:35:18"}
				
			};
			
			ws.onmessage = evt => {
				log('메세지를 수신했습니다.');
				//$('#list').append(evt.data);
				
				let message = JSON.parse(evt.data);
				
				if(message.code == '1') {
					print('', `[\${message.sender}]님이 들어왔습니다.`, 'other', 'state', message.regdate);
				} else if(message.code == '2') {
					print('', `[\${message.sender}]님이 나갔습니다.`, 'other', 'state', message.regdate);
				} else if(message.code == '3') {
					print(message.sender, message.content , 'other', 'msg', message.regdate);
				} else if (message.code == '4') {
					printEmoticon(message.sender, message.content, 'other', 'msg', message.regdate);
				}
			};
			
			ws.onclose = evt => {
				log('서버와 연결이 종료되었습니다.');
			};
			
			ws.onerror = evt => {};
			
			
		}
		
		function log(msg) {
			console.log(`[\${new Date().toLocaleTimeString()}] \${msg}`);
		}
		
		function disconnect() {
			
			//소켓 종료 전 메시지 보내기
			const message = {
						code: '2',
						sender: $('#header small').text(),
						receiver: '',
						content: '',
						regdate: dayjs().format('YYYY-MM-DD HH:mm:ss')
				};
				
			ws.send(JSON.stringify(message));
			
			//소켓 종료
			ws.close();
		}
		
		$('#msg').keydown(evt => {
			
			if (evt.keyCode == 13) { //enter키를 눌렀을 때 반응
				
// 				ws.send($(event.target).val());
			
				const message = {
						code: '3',
						sender: $('#header small').text(),
						receiver: '',
						content: $(event.target).val(),
						regdate: dayjs().format('YYYY-MM-DD HH:mm:ss')
				};
				
				if ($('#msg').val().startsWith('/')) {
					message.code = '4';
				}
				
				ws.send(JSON.stringify(message));
				
				if (message.code == '3') {
					print(message.sender, message.content, 'me', 'msg', message.regdate); 
				} else {
					printEmoticon(message.sender, message.content, 'me', 'msg', message.regdate); 
				}
				
				$('#msg').val('').focus();
				
			}
			
		});
		
		//list의 길이가 길어지면 스크롤바 생성하
		function scrollList() {
			$("#list").scrollTop($("#list")[0].scrollHeight + 300);
		}

		//list에 이름과 문자내용 위치 조정
		function print(name, msg, side, state, time) {
			let temp = `
			<div class="item \${state} \${side}">
				<div>
					<div>\${name}</div>
					<div>\${msg}</div>
				</div>
				<div>\${time}</div>
			</div>		
			`;
			
			$('#list').append(temp);
			
			scrollList();
		}
		
		function printEmoticon(name, msg, side, state, time) {
			let temp = `
				<div class="item \${state} \${side}">
					<div>
						<div>\${name}</div>
						<div style='background-color: #FFF;border: 0;'><img src='/websocket/resources/emoticon/\${msg}.png'></div>
					</div>
					<div>\${time}</div>
				</div>		
				`;
				
				$('#list').append(temp);
				
				setTimeout(scrollList, 100);
			}
	
	</script>
</body>
</html>










