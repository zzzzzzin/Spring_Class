show user;

drop table tblAddress;
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

