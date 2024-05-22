show user;

create table tblCode(
    seq number primary key,
    subject varchar2(300) not null,
    code varchar2(2000) not null,
    regdate date default sysdate not null,
    language varchar2(30) not null
);

drop sequence seqCode;
create sequence seqCode;

delete from tblCode;

select * from tblCode;

commit;

