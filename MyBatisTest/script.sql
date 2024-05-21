show user;

drop table tblAddress;
drop table tblMemo;
drop table tblInfo;

create table tblAddress(
    seq number primary key,
    name varchar2(30) not null,
    age number not null,
    address varchar2(100) not null,
    gender char(1) not null
);
drop sequence seqAddress;
create sequence seqAddress;

insert into tblAddress values(seqAddress.nextVal, 'ȫ�浿', 20, '�����', 'm');

delete from tblAddress;
delete from tblAddress;
select * from tblAddress;

insert into tblAddress values (seqAddress.nextVal, '������', 3, '����� ������ ���ﵿ �ѵ����� 8��', 'm');
insert into tblAddress values (seqAddress.nextVal, '�����', 2, '����� ������ ���ﵿ �ѵ����� 3��', 'f');
insert into tblAddress values (seqAddress.nextVal, '���Ƹ�', 1, '����� ������ ���ﵿ �ѵ����� 2��', 'f');
insert into tblAddress values (seqAddress.nextVal, '����', 7, '����� ������ ��ġ��', 'm');
insert into tblAddress values (seqAddress.nextVal, 'ȣ����', 6, '����� ������ �б�����', 'f');
insert into tblAddress values (seqAddress.nextVal, '��ѱ�', 3, '����� ������ õȣ��', 'f');
insert into tblAddress values (seqAddress.nextVal, 'Ÿ��', 4, '����� ������ �ϻ絿', 'm');
insert into tblAddress values (seqAddress.nextVal, '�ܽ���', 1, '����� ���ϱ� ���̵�', 'm');
insert into tblAddress values (seqAddress.nextVal, '��Ÿ', 5, '����� ���ϱ� ����', 'm');
insert into tblAddress values (seqAddress.nextVal, '������', 3, '����� ���ϱ� �̾Ƶ�', 'm');

commit;

drop table tblUser;
drop table tblDetail;
create table tblUser (
    seq number primary key,
    name varchar2(30) not null
);
drop sequence seqUser;
create sequence seqUser;

create table tblDetail (
    seq number primary key,
    email varchar2(100) not null,
    user_seq number not null references tblUser(seq)
);

drop sequence seqDetail;
create sequence seqDetail;

select * from tblUser;
select * from tblDetail;
commit;

create table tblInfo (
	seq number,
	school varchar2(100) not null,
	country varchar2(100) not null,
	
	constraint info_pk primary key(seq),
	constraint info_kf foreign key(seq) references tblAddress(seq) 
);

insert into tblInfo values (1, '���� �����б�', '���ѹα�');
insert into tblInfo values (2, '���� �����б�', '���ѹα�');
insert into tblInfo values (3, '���� ��ī����', '�̱�');
insert into tblInfo values (4, '���� �Ʒÿ�', '�Ϻ�');
insert into tblInfo values (5, '����¡ �Ʒü�', '�߱�');

create table tblMemo (
	seq number primary key,
	memo varchar2(500) not null,
	regdate date default sysdate not null,
	aseq number not null references tblAddress(seq) 
);
drop sequence seqMemo;
create sequence seqMemo;

insert into tblMemo values (seqMemo.nextVal, '�ȳ��ϼ���.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '������ ���� �����.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '�������Դϴ�.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '������ �����ϰ� �־��.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '���� �谡 ���Ŀ�.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '���õ� ������ ���� ��', default, 2);
insert into tblMemo values (seqMemo.nextVal, '����� �䳻����!', default, 2);
insert into tblMemo values (seqMemo.nextVal, '�߾�߾�', default, 3);
insert into tblMemo values (seqMemo.nextVal, '����', default, 6);
insert into tblMemo values (seqMemo.nextVal, '�ϴ��� ����.', default, 9);
insert into tblMemo values (seqMemo.nextVal, '���� ���ƿ�.', default, 8);


commit;

select * from tblInfo;
select * from tblMemo;
select * from tblAddress;

select * from tblAddress a inner join tblInfo i on a.seq = i.seq;

select * 
from tblAddress a 
    left outer join tblMemo m
        on a.seq = m.aseq;
