--kim
select * from tab;

select * from PERSONNEL;

--Data -> Record(Row) -> table(ǥ).RDBMS -> TableSpace -> DB

/*
SQL (Structured Query Language : ����ȭ�� ���� ���)
Ansi ǥ��PERSONNEL


1. query
   select data�˻���

2. dml(data maipulation language)
    insert, update, delete
    
3. ddl(data difinition language)
    create, alter, drop, rename
    
4. tcl(transaction control language)
    commit, rollback
    
5. dcl(data control language)
    grant, revoke

*/

select * from personnel;

select pno,job,pay from personnel;

select pay,pno,job from PERSONNEL;

select distinct job from PERSONNEL;

select * from PERSONNEL
order by pay asc; --��������(�⺻��. asc ���� ����)

select * from PERSONNEL
order by pay desc; --��������

select * from PERSONNEL
order by pay;

select * from PERSONNEL
order by pname desc;

--��Ī
Select pno,pname,pay,pay+1000 as ���ʽ� from PERSONNEL; --(pay+1000)�Ļ��÷� /(as)��Ī
Select pno,pname,pay,pay+1000 ���ʽ� from PERSONNEL; --as ���� ����
Select pno,pname,pay,pay+1000 as "�� �� ��" from PERSONNEL; --���� �ϰ������ "" ���

Select pno ��ȣ,pname as �̸�,pay ����,pay+1000 as ���ʽ� from PERSONNEL;

Select pno,pname,pay,pay+1000 as ���ʽ� from PERSONNEL
order by ���ʽ�; --��������. order by�� ��Ī ��� ����

Select pno,pname,pay,pay+1000 as ���ʽ� from PERSONNEL
order by pay+1000; --��Ī���� �� ���� �����.

Select pno,pname,pay,pay+1000 as ���ʽ� from PERSONNEL
order by 4; --�׹�° �÷����� �����ض�.

Select pno,pname,pay,pay+1000 as ���ʽ� from PERSONNEL
order by 4 desc;

select * from PERSONNEL
order by 4 desc; --manager�� ����

select dno,pno,pname from PERSONNEL
order by dno,pno; --dno ���� �� pno ����

select dno,pno,pname from PERSONNEL
order by dno,pno desc;

--�μ���ȣ�� ��������, �����ȣ�� ��������

select * from personnel
order by dno, pno desc;

--null
select manager from PERSONNEL
order by manager asc;

select manager from PERSONNEL
order by manager desc; --null�� ���� ū ������ �ν��Ѵ�.

--����� �޿��� ������ ����Ͻÿ�
select pno,pname,pay,pay*12 ���� from PERSONNEL;

--���� ������ ||
select pname||pno from PERSONNEL;

select pname||' '||pno from PERSONNEL;

select * from PERSONNEL;


--���� ���ʽ� ���� ���� ������ 0���� ǥ��
--���ʽ� ���� ������ �״�� �����ϰ�
select pno,pname,pay,nvl(bonus,0),(pay*12)+ nvl(bonus,0) ���� from PERSONNEL; 

--������(Where)
select * from PERSONNEL;

select pno,pname,job from PERSONNEL
where job ='SALESMAN';

select pno,pname,job from PERSONNEL
where job ='salesman';


--������
-- =, >, >=, <=, <, <>

--�޿��� 1600�� ����� �˻�
select * from PERSONNEL
where pay = 1600;

--�����ȣ�� 1116�� ����� �˻�
select * from PERSONNEL
where pno=1116;

--����޿��� 2000 ������ ��� �˻�
select * from PERSONNEL
where pay <= 2000;

--90��12��17�Ͽ� �Ի��� ����� �˻�
select * from PERSONNEL
where startdate='1990-12-17';

--������ clerk�� ����� �˻�
select * from PERSONNEL
where job = 'CLERK';

--�̸��� JAMES�� ����� �˻�
select * from PERSONNEL
where pname = 'JAMES';

--�� ������
--AND, OR, NOT(!)

--�μ���ȣ�� 10���̰� �޿��� 3000�̻��� ���
select * from PERSONNEL
where dno=10 and pay>=3000; --where�� and �ڿ��� �ݵ�� �÷����� ���;���

--������ SALESMAN�̰� 90�� ���Ŀ� �Ի��� ������ ã���ÿ�
select * from PERSONNEL
where job='SALESMAN' and startdate>'1990/12/31'; -- >='1991/01/01'

--91�� 9���� �Ի��� ������ ã���ÿ�
select * from PERSONNEL
where STARTDATE>='1991-09-01' and startdate<='1991-09-30';

select * from nls_session_parameters; --ȯ�漳��


--or
--�μ���ȣ�� 10���̰ų� �޿��� 3000 �̻��� ����� ã���ÿ�
select * from PERSONNEL
where dno=10 or pay>=3000;

--������ MANAGER �̰ų� 90�� ������ �Ի��� ������ ã���ÿ�
select * from PERSONNEL
where job='MANAGER' or STARTDATE<'1990/01/01';

--not
--������ SALESMAN �̰ų� CLERK�� ������ �˻�
select * from PERSONNEL
where job='SALESMAN' or job='CLERK';

--������ SALESMAN �� �ƴϰų� CLERK�� �ƴ� ������ �˻�
select * from PERSONNEL
where job<>'SALESMAN' and job<>'CLERK';

--������ SALESMAN �̰ų� CLERK�� ������ �˻� -- in : ���ڿ� ������
select * from PERSONNEL
where job in('SALESMAN','CLERK');

--������ SALESMAN �� �ƴϰų� CLERK�� �ƴ� ������ �˻� -- in : ���ڿ� ������
select * from PERSONNEL
where job not in('SALESMAN','CLERK');

select * from PERSONNEL
where not job in('SALESMAN','CLERK');

--���ڿ� ������
--Between A and B

--�޿��� 1000���� 2000 ������ ���
select * from PERSONNEL
where pay >=1000 and pay <=2000;

select * from PERSONNEL
where pay between 1000 and 2000;

select * from PERSONNEL
where pay between 2000 and 1000; --����

select * from  PERSONNEL
where STARTDATE between '1991-09-01' and '1991-09-30';

--�μ���ȣ�� 20�� 30 ���̰� �ƴ� ����� ã���ÿ�
select * from PERSONNEL
where dno not in (20,30); --20�� 30

select * from PERSONNEL
where not dno between 20 and 30; --20~30 ���̰��� ã��

select * from DIVISION;
select * from PERSONNEL;

--�̸��� A�� ���۵Ǵ� ���
select * from PERSONNEL
where pname like 'A%'; --%���� �ݵ��!!!!!!! like ����

--�����ȣ�� 111_�� �����ϴ� ��� -- _ : �ڸ����� ǥ��. 111_ (���ڸ����̰� �տ� ���ڸ��� 111��)
select * from PERSONNEL
where pno like '111_';

--�����ȣ�� 111%�� �����ϴ� ���
select * from PERSONNEL
where pno like '111%'; -- %:4�ڸ� �̻��̸鼭 111�� ����

select * from PERSONNEL
where pno like '1__1';

--90�⵵�� �Ի��� ���
select * from PERSONNEL
where STARTDATE like '90%'; --�⺻�� ���ڸ�(YY/MM/DD). 1990%�ϸ� �ȳ���

select * from PERSONNEL;

INSERT INTO PERSONNEL
values(2000,'HELLO_KIM','SALESMAN',1116,'2022-07-04',5000,'',20);

INSERT INTO PERSONNEL
VALUES(2001,'HELLO_KIM','SALESMAN',1116,'2022-07-04',5000,'',20);

--O_K�� ������ �̸� �˻�

select * from PERSONNEL
where pname like '%O\_K%' escape '\'; --\ : �ڿ� �����°� ���ڷ� ����

--null
select * from PERSONNEL
where manager = null; --�����?

select * from PERSONNEL
where manager = 'null'; --null�̶�� ���ڸ� ã��

select * from PERSONNEL
where MANAGER is null;

select * from PERSONNEL
where MANAGER is not null;

--�켱����
--������ MANAGER�̰� �޿��� 1500 �̻��� ���
--�Ǵ� ������ SALESMAN�� ����� �˻�
select * from PERSONNEL
where (job = 'MANAGER' and pay >=1500) or job='SALESMAN';

select * from PERSONNEL
where job = 'MANAGER' and (pay >=1500 or job='SALESMAN');

--������ PRESIDENT �Ǵ� SALESMAN �̰� �޿��� 1500 �̻��� ���
select * from PERSONNEL
where (job='PRESIDENT' or job='SALESMAN') and pay>=1500;

select * from PERSONNEL
where job in ('PRESIDENT','SALESMAN') and pay>=1500;

delete from PERSONNEL
where pname like 'HELLO%';

commit;

--�Լ�
--�����Լ�
--Round(�ݿø�)

select round(45.275,1) from dual; --dual:table�� ������ ���������� ���
--1�� �Ҽ��� 1 ���� �����ְ� �ʹٴ� ��. �� 1 �Ʒ����� �ݿø�

select round(45.275,1) from personnel;

select * from dual;

--  1  2  3  4  .  5  6  7 
-- -4 -3 -2 -1  0  1  2  3


/*
ROUND: Ư�� �Ҽ����� �ݿø��ϴ� �Լ�
ROUND(��,�ڸ���)
ROUND(@,0): �Ҽ��� ù��° �ڸ����� �ݿø�, ������ ǥ��
ROUND(@,1): �Ҽ��� �ι�° �ڸ����� �ݿø�, �Ҽ��� ù��° �ڸ����� ǥ��
ROUND(@,-1): ���� �ݿø�. ���� ù��° �ڸ����� �ݿø�
*/

select round(45.245,1) from dual; --1�ڸ����� �����ְڴ�
select round(45.245,-1) from dual; -- -1�ڸ����� �ݿø�
select round(45.245,0) from dual; -- .���� �ݿø�
select round(45.245) from dual;

select pno,pname,pay,round(pay,-2) pay1 from PERSONNEL;


/*
TRUNC(@,1): �ݿø����� �ʰ� �Ҽ��� ù°�ڸ����� ����[�Ҽ��� ù°�ڸ����� ǥ��]
TRUNC(@,-1): ���� ù��°�ڸ��� ����(0���� ����)
*/

--trunc(����). �Ҽ��� ǥ��
select trunc(45.245,2) from dual;
select trunc(49.245,-1) from dual;
select trunc(49.254)from dual;

select pno,pname,pay,trunc(pay,-2) pay1 from PERSONNEL;

--ceil / floor (�ø�/����) : ������ ��ȯ. �Ҽ��� x

select ceil(461.21) from dual; --�Ҽ��� ���� �ִ� ��� ������ �÷��� ���� ���� ���� ��ȯ�Ѵ�
select floor(461.91) from dual;

--mod(������)
select mod(10,3) from dual;

--abs(���밪)
select abs(-123) from dual;

--sign(������ -> ���:1,����:-1,0:0)
select sign(100-20), sign(100-102),sign(100-100) from dual;

--power(����)
select power(2,4) from dual;

--������
select sqrt(9) from dual;

--�����Լ�
--upper(�ҹ���->�빮��)
select upper('Oracle') from dual;

--lower(��->��)
select lower('ORACLE') from dual;

select * from division;

select * from division
where dname = upper('sales');

select * from DIVISION
where lower(dname)='sales';

--initcap ù���ڸ� �빮�ڷ�
select initcap ('korea fighting') from dual;

--concat(||) ���ڿ� ����
select pname || dno from PERSONNEL;
select concat(pname,dno) from PERSONNEL;

CREATE TABLE post (
	seq  NUMBER  NOT NULL
	,zipcode  VARCHAR2(10)
	,sido  VARCHAR2(50)
	,gugun  VARCHAR2(100)
	,dong  VARCHAR2(100)
	,bunji  VARCHAR2(50)
    ,PRIMARY KEY (seq)
);

select * from post
where dong like '�ູ%';

select sido || ' '||gugun||' '||dong as juso from post
where dong like '�ູ%';

--length
select length ('korea')from dual;
select length ('korea fighting')from dual;

--substr
select substr('abcdefg',1,3) from dual; --1���� ���� ������ �о�Ͷ�
select substr('abcdefg',3,2) from dual; --3���� ���� �ΰ��� �о�Ͷ�
select substr('abcdefg',-3,2) from dual;
select substr('abcdefg',-4) from dual;

--instr
select instr('abcdefg','c')from dual; --index�� ã�� 1

select instr('ABCDEFG','a') from dual; --0

--rpad/LPAD
select rpad(pname,15,'*') from PERSONNEL; --15�ڸ��� �����Ѱ� ���� ä����

--jumin
--941010-2015368
--941010-2******
select rpad(substr('941022-2067210',1,8),14,'*') jumin from dual;
select rpad(substr('941022-2067210',1,8),length('941022-2067210'),'*') jumin from dual;


--rtrim/LTRIM
select rtrim('ABBBBBBB','B') from dual;
select rtrim('A        ',' ')from dual;

select ltrim('BBBBABBB','B') from dual;

--sysdate
select sysdate from dual; --select�ϴ� ���� ���� ��¥�� �ð�

select sysdate-1,sysdate,sysdate+1 from dual;

--kim ����� ������� �ٹ��� �� ���� ���Ͻÿ�
select startdate, sysdate,round((sysdate-startdate)/365) ||'��' ��� from PERSONNEL
where pname='KIM';

--round
select startdate,round(startdate,'year') from PERSONNEL; --7/1 ����
select startdate,round(startdate,'month') from PERSONNEL; --16�� ����

--trunc
select startdate,trunc(startdate,'year') from PERSONNEL;
select startdate,trunc(startdate,'month') from PERSONNEL;

--months_between (���� ��)
select trunc((months_between(sysdate,'2002/06/01'))/12) dal from dual;
select trunc((months_between(sysdate,'2002/06/01'))) dal from dual;

--last_day (���� ���ϱ�)
select startdate,last_day(startdate) from PERSONNEL;


--next_day(���ƿ��� ��)
select next_day(sysdate,'�ݿ���') from dual;

--add_months(���� �߰�)
select add_months(sysdate,24) from dual;



commit;


--��ȯ�Լ�
--TO_CHAR (���ڷ� �ٲ۰��̹Ƿ� ����Ұ�)
/*
MM : ��(10)
MON : 3���� ���̸�(MAR)
MONTH : MARCH
DD : ���� ��¥��(22)
D : ���� �ϼ�(2)
DY : 3���� ����(MON)
DAY : MONTH
RM : �θ��� �޼�
YYYY : 2022
*/
select sysdate,to_char(sysdate,'MM') from dual;
select sysdate,to_char(sysdate,'d') from dual; --3.ȭ����(�Ͽ�ȭ~)
select sysdate,to_char(sysdate,'dy') from dual;
select sysdate,to_char(sysdate,'rm') from dual;
select sysdate,to_char(sysdate,'yyyy') from dual;
select sysdate,to_char(sysdate,'dd') from dual;
select sysdate,to_char(sysdate,'yy-mm-dd') from dual;

select sysdate,to_char(sysdate,'hh24:mi:ss') from dual;
select sysdate,to_char(sysdate,'am hh:mi:ssss') from dual;
select sysdate,to_char(sysdate,'pm hh:mi:ssss') from dual; --(�����϶��� �����̴ϱ� �����̶�� ����)

select to_char(12506,'99,999') from dual; --���ڷ� �ٲٴ°ű� ������ ''�� �����ֱ�. ������ �ȵȴ�.
select to_char(12506,'099,999') from dual; --�ڸ��� ���߱�. 6�ڸ��� �ȵǸ� 0���� ä����
select to_char(12506,'9,999') from dual; --�ڸ����� ���ڶ�� #���� ǥ��. �ڸ��� ���߱�
select to_char(12506.99,'99,999.99') from dual; --�ڿ�.99:�̱��� ��Ʈ

select sysdate,to_char(sysdate,'dd') from dual;
select sysdate,to_char(sysdate,'ddsp') from dual;
select sysdate,to_char(sysdate,'ddth') from dual;
select sysdate,to_char(sysdate,'ddspth') from dual; --����

--TO_DATE
select to_date('22-07-06','yy-mm-dd') from dual; --���ڰ� ��¥�� �ٲ�� ��
select to_date('22-07-06','yy-mm-dd')+1 from dual; --��¥�� �ٲ��� ������ ���갡��
select to_date('11:05','hh24:mi')from dual; --��¥�� �� ���� ù���� ���

--TO_NUMBER
select to_number('123') from dual;
select to_number('123')+1 from dual; --���ڷ� �ٲ��� ������ ���� ����
select to_number('ABC') from dual; --����.���ڴ� ���ڷ� �ٲ� �� ����

--NVL
select bonus,nvl(bonus,0) from PERSONNEL;

select manager from PERSONNEL;

select manager,nvl(manager,'NON MANAGER') from PERSONNEL; --����. manager�� ���ڸ� �� �� �����Ƿ� ���ڰ� �� �� ����
select manager,nvl(to_char(manager),'NON MANAGER') from PERSONNEL; --to_char�� manager�� ���ڷ� �ٲ��ָ� ����

--DECODE(IF)
--�� ����� �޿��� �μ��� 10�� ��� 10%, �μ��� 20�� ��� 20%
--�������� 30%�� �λ��ؼ� ���

select pname,bonus,dno,pay,
decode(dno,10,pay*1.1,20,pay*1.2,pay*1.3) �λ�� from PERSONNEL;

--�޿��� 3500�̻��� ��쿡�� 'GOOD'��, �̸��� ��쿡�� 'POOR'�� ����Ͻÿ�

--sign(������ -> ���:1,����:-1,0:0)
select sign(100-20), sign(100-102),sign(100-100) from dual;


select pname,pay,
decode(sign(pay-3500),1,'GOOD','POOR')Grade from PERSONNEL;

select pname,pay,
decode(pay>=3500,'GOOD','POOR')Grade from PERSONNEL; --����. �ε�ȣ�� true/false ��ȯ

--�׷��Լ�. �ݵ�� �ϳ��� ��
--count
select * from PERSONNEL;

select count(*) from PERSONNEL; --�������� ����
select count(manager) from PERSONNEL; --null���� �ȼ�
select count(bonus) from PERSONNEL;

--�޿��� 3000�̻��� ��� ��
select count(*) from PERSONNEL
where pay>=3000;

--AVG
select avg(pay) from PERSONNEL;

--bonus�� ���
select avg(nvl(bonus,0)) from PERSONNEL;

--SUM
select sum(pay) from PERSONNEL;

--MAX/MIN
select max(pay),min(pay) from PERSONNEL;

--�Ի����� ���� ������ ���
select min(startdate) from PERSONNEL;

--�Ի����� ���� ������ ����� ���Ի������ ����
select round((max(startdate) - min(startdate))/365)���� from PERSONNEL;

--�м��Լ�

--�μ��� ��� ���ϱ�
select * from PERSONNEL
order by dno;

select distinct dno,avg(pay) over (partition by dno) "�μ��� ���" from PERSONNEL
order by dno;

--���� ����
select pname,pay,rank() over (order by pay desc) ���޼� from PERSONNEL;

--1200�� �޴� ����� ����
select rank(1200) within GROUP (order by pay desc) rank from PERSONNEL;

select count(*) from PERSONNEL; --���ϰ��� ��ȯ�ϴ� Ŀ��
select pname from PERSONNEL; --���߰��� ��ȯ
select pname from PERSONNEL
where pay=1600;

select pname,min(startdate) from PERSONNEL;

select pno,pname,startdate from PERSONNEL
where startdate=(select min(startdate) from PERSONNEL);

--�μ��� ��� �޿��� ���Ͻÿ� -- ~�� : group by
select dno,avg(pay) from PERSONNEL
group by dno;

--������ ��ձ޿�, �ο����� ���Ͻÿ�
select * from PERSONNEL;

select job,round(avg(pay))��ձ޿�,count(*)�ο��� from PERSONNEL
group by job;


--���μ��� ��ձ޿��� ��ü��ձ޿�(2973)���� ũ�� 'GOOD'
--������ 'POOR' ���


select round(avg(pay)) from PERSONNEL;


SELECT dno,avg(pay),
decode(sign(round(avg(pay))-(select round(avg(pay))from PERSONNEL)),'1','Good','POOR') ����
from PERSONNEL
group by dno;
 

--HAVING : GROUP BY�� ���ǹ�
select dno,avg(pay) ��� from PERSONNEL
group by dno
having avg(pay)>3000;

select dno,avg(pay) ��� from PERSONNEL
group by dno
having ���>3000; --����.��Ī ��� ��??

--�μ��ο��� 2���� ���� �μ��� �μ���ȣ, �޿��� ���� ���Ͻÿ�

select dno"�μ���ȣ",count(*)"�ο���",sum(PAY)"�޿��� ��" from PERSONNEL
group by dno
having count(*)>2;



-- JOIN��
-- EQUIE JOIN(INNER JOIN)
-- NON-EQUIE JOIN
-- OUTER JOIN
-- CROSS JOIN
-- SELF JOIN

--self join
--������ �����ڸ� ��Ī

select * from PERSONNEL;

select a.pno ���,a.pname ����,b.pno ���,b.pname ������
from PERSONNEL a, PERSONNEL b
where a.manager = b.pno;


-----------------------------------------------------
-- NON-EQUIE JOIN --���� ���� ������
select * from PERSONNEL;
select * from PAYGRADE;

select pname,pay,B.grade
from PERSONNEL A, PAYGRADE B
where pay between lowpay and highpay;


---------------------------------------------------------

--OPERATOR
--A=[1,2,5,6]
--B=[1,2,4]

--A UNION ALL B = [1,2,5,6,1,2,4]
--A UNION B = [1,2,4,5,6]
--A MINUS B = [5,6]
--A INTERSCEPT B = [1,2]

--UNION/ALL --�÷��� ������ ������(���̺��� ������ �Ȱ�����)
select * from PERSONNEL
union ALL
select * from PERSONNEL;

select * from PERSONNEL
union
select * from PERSONNEL;

--MINUS
select dno from DIVISION --10 20 30 40
MINUS
select dno from PERSONNEL; --10 20 30

--INTERSCEPT
select dno from DIVISION --10 20 30 40
INTERSECT
select dno from PERSONNEL; --10 20 30


COMMIT;


CREATE TABLE MANAGER
AS 
	SELECT * FROM PERSONNEL
	WHERE 1=2; --������ �������� ��⶧���� �����ʹ� ����ȵǰ� Ʋ�� ����

CREATE TABLE SALESMAN
AS 
	SELECT * FROM PERSONNEL
	WHERE 1=2;

CREATE TABLE BUSEO
AS SELECT * FROM DIVISION;

CREATE TABLE SAWON
AS SELECT * FROM PERSONNEL;

CREATE TABLE EXAM1
AS SELECT * FROM PERSONNEL;

CREATE TABLE EXAM2
AS SELECT * FROM DIVISION;

SELECT * FROM TAB;
SELECT * FROM DIVISION;
DESC DIVISION;
SELECT * FROM EXAM2;

insert into division values(50,'OPERATION','031-123-4567','DAEGU');

INSERT INTO DIVISION (DNAME,POSITION) VALUES ('ACCOUNT','DAEJUN'); --X DNO�� NULL�� ���� �ȵ�
INSERT INTO DIVISION (DNO,DNAME,POSITION) VALUES (70,'ACCOUNT','DAEJUN'); --0
DESC DIVISION;

insert into division(dno) values(60);

DESC personnel;

insert into personnel (pno,pname,pay,dno)
values (7711,'YOUNG',400,20);

SELECT * FROM PERSONNEL;

INSERT INTO DIVISION VALUES(80,'PLANNING','010-123-1234',NULL); --����� NULL ����
INSERT INTO DIVISION VALUES(90,'SERVICE','010-222-3333','');
SELECT * FROM DIVISION;

SELECT * FROM PERSONNEL;
DESC PERSONNEL;

--Primary Key (�ߺ�x nullx ���̺� �ϳ���)
INSERT INTO PERSONNEL(pno,pname,job,startdate,dno)
values (1304,'suzi','singer',sysdate,10); --�״�� �ѹ� �� �����ϸ� ����. �ߺ����� ����⶧��

--ġȯ����
SELECT PNO,PNAME,JOB,STARTDATE,DNO
FROM PERSONNEL
WHERE DNO=&D_NO;

--SUBQUERY�� ����ؼ� INSERT

SELECT * FROM MANAGER;

SELECT * FROM PERSONNEL
WHERE JOB = 'MANAGER';

INSERT INTO MANAGER(PNO,PNAME,STARTDATE) --Ư�������͸�
SELECT PNO,PNAME,STARTDATE
FROM PERSONNEL
WHERE JOB = 'MANAGER';

INSERT INTO MANAGER --��絥����
SELECT * FROM PERSONNEL
WHERE JOB = 'MANAGER';

--������ SALESMAN�� ����� ��� ������ SALESMAN���̺�� ����
SELECT * FROM SALESMAN;


SELECT * FROM PERSONNEL
WHERE JOB = 'SALESMAN';

INSERT INTO SALESMAN --�̹� ���̺��� �־�� �Ѵ�. AS�� ����
SELECT * FROM PERSONNEL
WHERE JOB = 'SALESMAN';

CREATE TABLE SALESMAN --CREATE�� ���̺��� ���� ���¿��� ����鼭. AS�� �ִ�
AS 
SELECT * FROM PERSONNEL;

--UPDATE
SELECT * FROM PERSONNEL
WHERE PNO='1111';

UPDATE PERSONNEL SET DNO=30 --�ݵ�� WHERE�� ������ �����. �ȱ׷��� ��� DNO���� 30���� �ٲ�
WHERE PNO='1111';

UPDATE PERSONNEL SET PNAME='INNA',MANAGER=1004,STARTDATE=SYSDATE,PAY=8000 --�ݵ�� WHERE�� ������ �����. 
WHERE PNO='1111';

SELECT PNO,PNAME,TO_CHAR(STARTDATE,'YYYY-MM-DD')STARTDATE FROM PERSONNEL
WHERE PNO='1111';

SELECT * FROM SAWON;

UPDATE SAWON SET DNO='20'; --WHERE �Ⱦ��� ��� DNO���� 20���� �ٲ�

ROLLBACK; --���� ����� �����. COMMIT �� �Ŀ��� �ҿ����. INSERT,UPDATE,DELETE ���� ��� / CREATE�� COMMIT�� ���� �ֱ⶧���� �ҿ����

--SUBQUERY�� UPDATE
SELECT JOB FROM PERSONNEL
WHERE DNO=(SELECT DNO FROM DIVISION WHERE DNAME='SALES'); --DNO=30

UPDATE PERSONNEL SET JOB = 'SALES'
WHERE DNO=(SELECT DNO FROM DIVISION WHERE DNAME='SALES'); --����

--JOIN��
SELECT A.*
FROM PERSONNEL A,DIVISION B
WHERE A.DNO=B.DNO AND DNAME='SALES';

--JOIN���� UPDATE������ (����Ŭ������ ����Ұ�)
UPDATE PERSONNEL SET JOB='SALESMAN' --SELECT���� �ٲ��ֱ�
FROM PERSONNEL A,DIVISION B --���Ǳ״��
WHERE A.DNO=B.DNO AND DNAME='SALES'; --���Ǳ״��


ROLLBACK;


----------------------------------------------------------------------
--DELETE

SELECT * FROM PERSONNEL WHERE PNO='1112';
DELETE FROM PERSONNEL WHERE PNO='1111';

SELECT * FROM PERSONNEL WHERE PNO='1112';
DELETE PERSONNEL WHERE PNO='1112'; --FROM ���� ����

--SUBQUERY�� ���� --�ߺ����� �ʴ� ���� ������ �־�� �Ѵ�

SELECT * FROM DIVISION;
SELECT * FROM PERSONNEL;

SELECT * FROM PERSONNEL
WHERE DNO=(SELECT DNO FROM DIVISION WHERE DNAME='FINANCE');

DELETE PERSONNEL
WHERE DNO=(SELECT DNO FROM DIVISION WHERE DNAME='FINANCE');

--INSERT ERROR
SELECT * FROM PERSONNEL;

INSERT INTO PERSONNEL (PNO,PNAME,DNO)
VALUES(1113,'INNA',30); --���� (�������ǿ� �ȸ���) PNO�� �ߺ���

SELECT * FROM USER_CONSTRAINTS; --���������� ���� ��ɾ�

--UPDATE ERROR
SELECT * FROM DIVISION;
SELECT * FROM PERSONNEL;
SELECT * FROM TAB;

INSERT INTO PERSONNEL (PNO,PNAME,DNO)
VALUES(1133,'INNA',51); --�������� ����.DNO�� 51���� ����

UPDATE PERSONNEL SET DNO=51
WHERE DNO=20; -- DIVISION���� ���� 20�� �ִ��� Ȯ�� �� ������ ����

--DELETE ERROR
DELETE DIVISION WHERE DNO=20; --����(�ڽ��� PERSONNEL�� 20�� �ֱ� ������ �θ��� DIVISION���� 20�� �������� �ȵ�)
DELETE DIVISION WHERE DNO=50; --����(�ڽ��� 50�� ���������� �ʱ⶧���� ���� ����)



COMMIT;

--TRANSACTION

--AUTO COMMIT : ��ü������ COMMIT
--DDL(CREATE,ALTER,DROP,RENAME)
--DCL(GRANT,REVOKE)
--���������� �����(ROLLBACK :COMMIT������)

--DDL(CREATE,ALTER,DROP)
--OBJECT�� ���鶧 ����ϴ� ��ɾ�
--OBJECT(TABLE,INDEX,SYNONYM,SEQUENCE,VIEW)

--TABLE
--DATA TYPE
--CHAR : ����(��������) �̸�,�����ȣ / ��������� ���� �ִ�
--VARCHAR : ����(��������) �ּ� / ��������� ���� ���� ��� �۾��� ������ �� �ִٴ� ����
--NUMBER(P,S) : ����(��������) (P��ü�ڸ���,S�Ҽ����ڸ�)
--DATE : ��¥,�ð�(��������)
--LONG : ����(�������� 2G)

CREATE TABLE BUSEO2
(DNO NUMBER(2),
DNAME VARCHAR(14),
ZIPCODE CHAR(7));

DESC BUSEO1; --ȯ�漳��
INSERT INTO BUSEO1 VALUES(10,'AAA','123-123');
SELECT * FROM BUSEO1;


--���̺� �̸�
--�ݵ�� �����ڷ� ����
--Ư������(_,$,#)
--�ߺ���� �Ұ�
--�÷���� �޶�� �Ѵ�
--�����(INSERT,VALUES etc...) ��� ����

--SAWON,P_NO,DIV10, (O)
--10DIV(�����ڽ��۾ƴ�),$SAL(�����ڽ��۾ƴ�),ALTER(�������) (X)

CREATE TABLE CUSINFO
(ID CHAR(5) PRIMARY KEY, --���̵� �ߺ��� ���� �� ����
NAME CHAR(10),
JUMIN CHAR(14),
AGE NUMBER(3),
ADDR VARCHAR2(100));

DESC CUSINFO;

INSERT INTO CUSINFO VALUES('A100','SUZI','123456-1234567',27,'����');
SELECT * FROM CUSINFO;

SELECT * FROM USER_CONSTRAINTS;

----------------------------------------------
--����� ����

SELECT STARTDATE,
EXTRACT(YEAR FROM STARTDATE)YEAR,
EXTRACT(MONTH FROM STARTDATE)MONTH,
EXTRACT(DAY FROM STARTDATE)DAY
FROM PERSONNEL;

COMMIT;

----------------------------------------------

--������ �ʱ�ȭ
create table SALESMAN1
AS
select pno,pname,job,pay from PERSONNEL
where job = 'SALESMAN';


select * from user_constraints;


select * from SALESMAN1;

DESC SALESMAN1;

--PERSONNEL ���̺��� ������ MANAGER�� ����� ��� ������
--���ο� ���̺��� MANAGER1�� ����

CREATE TABLE MANAGER1
AS
SELECT * FROM PERSONNEL
WHERE JOB='MANAGER';

SELECT * FROM MANAGER1;

--PAY�� 3000�̻��� ������ �����͸� PAY3000���̺�� ����
CREATE TABLE PAY3000
AS
SELECT * FROM PERSONNEL
WHERE PAY>=3000;

SELECT * FROM PAY3000;

--PERSONNEL ���̺��� 12���޿� �Ի��� �����
--MON12�̶� ���̺�� ����


SELECT * FROM PERSONNEL;

SELECT * FROM PERSONNEL
WHERE TO_CHAR(STARTDATE,'MM')=12; 

CREATE TABLE MON12
AS
SELECT * FROM PERSONNEL
WHERE TO_CHAR(STARTDATE,'MM')=12;

SELECT * FROM MON12;

SELECT PNO,PNAME,JOB,DNO FROM PERSONNEL
WHERE JOB='ANALYST';

CREATE TABLE ANALYST(NUM,NAME,JOB,DNUM)
AS
SELECT PNO,PNAME,JOB,DNO FROM PERSONNEL
WHERE JOB='ANALYST';

SELECT * FROM ANALYST;



--�μ���ȣ�� 10�� �μ��� �� �޿��� ������ DIV10���̺�� ����ÿ�



CREATE TABLE DIV10
AS
SELECT DNO,SUM(PAY) SUM_PAY FROM PERSONNEL 
GROUP BY DNO
HAVING DNO=10;

SELECT * FROM DIV10;

-- ���̺� ���� ���� (WHERE ������ �������� �ָ� �����ʹ� ������� �ʰ� ������ ����)
SELECT * FROM PERSONNEL;


CREATE TABLE SAWON1
AS
SELECT * FROM PERSONNEL
WHERE 0=1;

SELECT * FROM SAWON1;
DESC PERSONNEL;
DESC SAWON1; --���������� ���簡 �ȵż� PNO�� PRIMARY KEY�� �����?

-- ���̺� ����

SELECT * FROM SALESMAN1;
DESC SALESMAN1;

--ADD(�÷� �߰�) �ΰ��̻� �÷� �߰��� �ݵ�� ()�� �����ֱ� --���� ���̺��� �ƴ� : ���̺��� ���� �� �÷��� �߰������Ƿ�
ALTER TABLE SALESMAN1
ADD (DNO NUMBER(2)); 

INSERT INTO SALESMAN1 VALUES(1234,'SUZI','SALESMAN',3000,10); --L TABLE(�־��� ���̺�1. NULL��)

ALTER TABLE SALESMAN1
ADD (JUMIN CHAR(14),ZIP CHAR(7));

INSERT INTO SALESMAN1 VALUES(4444,'INNA','SALESMAN',2000,10,'1234','1234'); --��ܽ� ���̺�(�־��� ���̺�2)


ALTER TABLE SALESMAN1 --�÷� �߰��ϸ鼭 �⺻�� �ֱ�(DEFAULT)
ADD BIGO VARCHAR2(10) DEFAULT('AA');

CREATE TABLE CUSINFO
(ID NUMBER(3) CONSTRAINT CUSINFO_ID_PK PRIMARY KEY, --���̺� ����鼭 �������� �ֱ�
NAME CHAR(10),
BIRTH DATE DEFAULT SYSDATE);

INSERT INTO CUSINFO VALUES (111,'SUZI'); --����Ŭ������ ����. BIRTH�� �ȳ־��⶧����
INSERT INTO CUSINFO(ID,NAME) VALUES (111,'SUZI');

SELECT * FROM CUSINFO;

ALTER TABLE SALESMAN1
ADD (MARRIAGE CHAR(8) CONSTRAINT SALESMAN1_MARRIAGE_CK
CHECK (MARRIAGE IN ('SINGLE','MARRIED')));

SELECT * FROM SALESMAN1;
INSERT INTO SALESMAN1
VALUES(5555,'INSUN','SALESMAN',2000,10,'1234','1234','BB','SOLO'); --����. �������� ����


SELECT * FROM SALESMAN1;
INSERT INTO SALESMAN1
VALUES(5555,'INSUN','SALESMAN',2000,10,'1234','1234','BB','SINGLE'); --����

SELECT * FROM SALESMAN1;


DESC SALESMAN1;
SELECT * FROM USER_CONSTRAINTS;

ALTER TABLE SALESMAN1 --���������� ���� ���� ���̺� �������� �߰����ֱ�
ADD CONSTRAINT SALESMAN1_PNO_PK PRIMARY KEY(PNO); --�÷��� ���(PNO)



--PRIMARY KEY (NULL�� X, �ߺ��Ұ�, ���̺��� ������ ���� ������ �ϳ���)
--UNIQUE KEY (�ߺ��Ұ�,NULL���(����Ŭ�� ������),256������ ������ ���� �� ����.)
--CHECK KEY (�����ֱ�)
--NOT NULL KEY (�ݵ�� NULL�� ��� ����. �̸�,����� ���)
--FOREIGN KEY (�θ����� �����Ͱ� �ִ���. �θ�� �������� �Ȱ���.
--             �θ�� PK �Ǵ� UK --�ߺ����� ������� �ʱ⶧����. EX.������ �������� �����ؾ��ϴ� ��츦 ���ֱ� ����)
  

SELECT * FROM USER_CONSTRAINTS; --DICTIONARY�� ����. ���� �׻� ����.

ALTER TABLE MANAGER1
ADD COMM NUMBER(5);

SELECT * FROM TAB;
DESC MANAGER1;

SELECT * FROM MANAGER1;

ALTER TABLE MANAGER1
ADD CONSTRAINT MANAGER1_PNO_PK PRIMARY KEY (PNO);


--MODIFY(�÷� ����)
SELECT * FROM MANAGER1;
DESC MANAGER1;

ALTER TABLE MANAGER1
MODIFY PNAME VARCHAR2(16);

ALTER TABLE MANAGER1
MODIFY PNAME VARCHAR2(5); --����. ������ ����ִ� �����Ϳ� 5���� ū �����Ͱ� �ֱ⶧����.

ALTER TABLE MANAGER1
MODIFY PNAME VARCHAR2(7); --����

ALTER TABLE MANAGER1
MODIFY PNAME VARCHAR2(7) NOT NULL; --PNO�� NOT NULL�� �ٸ���.(PNO�� PRIMARY KEY�� �༭ NOT NULL)

--DROP(�÷��̳�, �������� ����)
SELECT * FROM MANAGER1;
DESC MANAGER1;
SELECT * FROM USER_CONSTRAINTS;

ALTER TABLE MANAGER1
DROP CONSTRAINT MANAGER1_PNO_PK; -- 1. �̸����� ����� ���

ALTER TABLE SALESMAN1
DROP PRIMARY KEY; -- 2. PRIMARY KEY�� ���̺� �ϳ��̹Ƿ� ���� �̸����� �������� ����


ALTER TABLE DIVISION --�θ�
DROP CONSTRAINT DIVISION_DNO_PK; --PERSONNEL(�ڽ�)�� �����ϰ� �ֱ� ������ ����. �θ�PK�� ������� �����ϴ� �ڽ��� FK�� �������� 

ALTER TABLE DIVISION --�θ�
DROP CONSTRAINT DIVISION_DNO_PK CASCADE; -- CASCADE : DIVISION PK, PERSONNEL FK ���ÿ� ������

--�÷�����
SELECT * FROM SALESMAN1;
SELECT * FROM USER_CONSTRAINTS;
DESC SALESMAN1;

ALTER TABLE SALESMAN1
DROP COLUMN MARRIAGE; --�����Ͱ� �־ ������

ALTER TABLE SALESMAN1
SET UNUSED COLUMN DNO; -- SET UNUSED : �Ͻ������� �÷� �Ⱥ��̰� �ϴ� ��ɾ�. �����Ѱ��� �ƴ�. �����.

ALTER TABLE SALESMAN1
DROP UNUSED COLUMN; --���� UNUSED �Ѱ� ����. �÷��� ���� �ʿ� ����.

SELECT * FROM DBA_UNUSED_COL_TABS; --�Ϲݻ���ڴ� ��������.

SELECT COUNT(*) FROM DICTIONARY;

--DROP(���̺� ����)
SELECT * FROM TAB;

DROP TABLE SALESMAN1;

SELECT * FROM RECYCLEBIN;

DROP TABLE SALESMAN1;

--�������

FLASHBACK TABLE "BIN$uXvaRbhZRvmmIu5D3yeEzw==$0" TO BEFORE DROP; -- 1.

FLASHBACK TABLE SALESMAN1 TO BEFORE DROP; --2.

SELECT * FROM 'BIN$YaMC0+LsQmelsQLyXd89yQ==$0'; --���� �� ������ ����

PURGE RECYCLEBIN; --��������

DROP TABLE MANAGER1 PURGE; --�������뿡 ���� �ʰ� �ٷ� ����

COMMIT;

--���ڵ� ����
--TRUNCATE / DELETE

SELECT * FROM CUSINFO;

DELETE CUSINFO;

SELECT * FROM CUSINFO;

ROLLBACK; --�������

SELECT * FROM CUSINFO;

COMMIT;

--TRUNCATE (�ǻ츱 �� ����. TRANSACTION�� ����.)

TRUNCATE TABLE CUSINFO; --�����͸� ����.

ROLLBACK; --�ǻ츱 �� ����. TRANSACTION�� ����.


--RENAME (���̺� �̸� ����)

SELECT * FROM TAB;


SELECT * FROM PAY3000;

RENAME PAY3000 TO HIGHPAY;

-- ���̺� �÷��̸���?����
--ALTER?TABLE?���̺��?RENAME COLUMN �����÷���?TO �ٲ��÷���
--EX1)?ALTER?TABLE?EMP?RENAME COLUMN?EMP_ADDR?TO?EMP_ADDR1;?-- EMP ���̺� EMP_ADDR�̶�� �÷�����?EMP_ADDR1���� ����


--COMMENT (�ּ� �ٴ� ���)
SELECT * FROM USER_TAB_COMMENTS; --���̺� �ּ� Ȯ��

COMMENT ON TABLE HIGHPAY
IS '���� ���� �޴� ���';

COMMENT ON TABLE HIGHPAY
IS ''; --���� �����

COMMENT ON COLUMN HIGHPAY.PAY
IS '�Ǽ��� �ݾ�';

SELECT * FROM USER_COL_COMMENTS; --�÷� �ּ� Ȯ��

COMMENT ON COLUMN HIGHPAY.BONUS
IS '���� ���ʽ� ����';

--DCL(GRANT,REVOKE)
--GRANT : USER�� OBJECT�� ������ �ο��Ҷ� ���
--REVOKE : USER�� OBJECT�� ������ ȸ���Ҷ� ���

CREATE USER YOUNG
IDENTIFIED BY YOUNG
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP; --KIM�� ���� ���� �� ����. SYS���� GRANT CREATE USER ���� ��.

--OBJECT ����
GRANT SELECT ON PERSONNEL TO TEST; --KIM�� TEST����
GRANT SELECT,INSERT,DELETE ON DIVISION TO TEST; --KIM�� TEST����

SELECT * FROM USER_TAB_PRIVS_MADE;
REVOKE SELECT ON PERSONNEL FROM TEST; 

REVOKE SELECT ON DIVISION FROM TEST; 

REVOKE INSERT ON DIVISION FROM TEST;

REVOKE DELETE ON DIVISION FROM TEST;


CREATE ROLE KIMOBJ;

GRANT SELECT,INSERT,DELETE ON DIVISION TO KIMOBJ; --role�� SELECT,INSERT,DELETE �����
GRANT KIMOBJ TO lee; --lee���� KIMOBJ�̶�� ROLE�� ��. (LEE�� SELECT,INSERT,DELETE ��밡��)

SELECT * FROM ROLE_SYS_PRIVS; --���� KIM�� ������ �ִ� ROLE�� ����

------------------------------


--��������(CONSTRAINT) : ���Ἲ(�˰��ֱ�)
--PRIMARY KEY(PK)
--FOREIGN KEY(FK)
--UNIQUE KEY(UK)
--NOT NULL(NN)
--CHECK KEY(CK)

--PRIMARY KEY (NULL�� X, �ߺ��Ұ�, ���̺��� ������ ���� ������ �ϳ���)
--UNIQUE KEY (�ߺ��Ұ�,NULL���(����Ŭ�� ������),256������ ������ ���� �� ����.)
--CHECK KEY (�����ֱ�)
--NOT NULL KEY (�ݵ�� NULL�� ��� ����. �̸�,����� ���)
--FOREIGN KEY (�θ����� �����Ͱ� �ִ���. �θ�� �������� �Ȱ���.
--             �θ�� PK �Ǵ� UK --�ߺ����� ������� �ʱ⶧����. EX.������ �������� �����ؾ��ϴ� ��츦 ���ֱ� ����)
  





COMMIT;



