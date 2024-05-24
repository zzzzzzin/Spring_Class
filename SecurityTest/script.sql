
-- SecurityTest > "script.sql"
-- 29. PasswordEncoder

create table users (
	username varchar2(50) not null primary key,
	password varchar2(50) not null,
	enabled char(1) default '1'
);

create table authorities (
	username varchar2(50) not null,
	authority varchar2(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username, authority);

insert into users (username, password) values ('dog', '1111');
insert into users (username, password) values ('cat', '1111');
insert into users (username, password) values ('tiger', '1111');

insert into authorities (username, authority) values ('dog', 'ROLE_USER');
insert into authorities (username, authority) values ('cat', 'ROLE_MANAGER');
insert into authorities (username, authority) values ('tiger', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('tiger', 'ROLE_MANAGER');

commit;

select * from users;
select * from authorities;

-- users-by-username-query


-- 30. ����ڰ� ���� ���� ������ ��Ű�� ���

drop table member;
create table member (
    memberid varchar2(50) primary key,  --���̵�
    memberpw varchar2(50) not null,     --��ȣ
    membername varchar2(50) not null,   --�̸�   
    enabled char(1) default '1',        --Ȱ��ȭ
    email varchar2(100) not null,
    gender char(1) not null,
    regdate date default sysdate not null
);

create table member_auth (
    memberid varchar2(50) not null,
    auth varchar2(50) not null,
    constraint fk_member_auth foreign key(memberid) references member(memberid)
);

select * from member;
select * from member_auth;

alter table member
     add(membername varchar2(50) not null);

alter table member
     modify (memberpw varchar2(100));
desc member;

--PasswordEncoder ���� �ۼ�
-- users-by-username-query="" 
-- select * from users where username = ? (���� ���������� ����)
--select memberid as username, memberpw as password, enabled from member where memberid = ?


-- authorities-by-username-query=""
--select memberid as username, auth as authority from member_auth where username = ?

select * from member;

commit;



    





