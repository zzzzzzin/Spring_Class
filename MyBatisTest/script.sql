show user;

drop table tblAddress;
create table tblAddress(
    seq number primary key,
    name varchar2(30) not null,
    age number not null,
    address varchar2(100) not null,
    gender char(1) not null
);

create sequence seqAddress;

insert into tblAddress values(seqAddress.nextVal, 'ȫ�浿', 20, '�����', 'm');