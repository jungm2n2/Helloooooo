--LEE
select * from tab;
select * from sales;

select * from custom;

select username, rpad(substr(jumin,1,8),14,'*') jumin from custom;

select * from custom
where addr1 like '%������%' and point >=500 order by AGE;

select age, trunc(age,-1) �ݿø����� from custom;

select regdate,last_day(regdate)from custom;

select regdate,next_day(regdate,'�����') from custom;

select regdate,round((sysdate-regdate)/365)||'��' ��� from custom;

select regdate,add_months(regdate,13) from custom;

select addr1||' '||addr2||' '||addr3 �ּ� from custom;

commit;

---------------------------------------------------------------------------
select * from tab;
select * from custom;

select USERNAME, RPAD(SUBSTR(JUMIN,1,8),14,'*') JUMIN FROM CUSTOM;

SELECT * FROM CUSTOM;

SELECT ADDR1,COUNT(*)CNT,ROUND(AVG(POINT))AVG_POINT FROM CUSTOM
GROUP BY ADDR1;

SELECT SEX,COUNT(*)CNT,ROUND(AVG(AGE))AVG_AGE
FROM CUSTOM
GROUP BY SEX;

SELECT 
CASE SEX
WHEN '1' THEN '����' --ELSE '����'
WHEN '0' THEN '����'
END GENDER,
COUNT(*),ROUND(AVG(AGE))AVG_AGE
FROM CUSTOM
GROUP BY SEX;

--���̽����� ���� 
SELECT 
CASE �÷���
WHEN 1 THEN 100
WHEN 2 THEN 200
WHEN 3 THEN 300
WHEN 4 THEN 400
ELSE 500
END AS ��Ī,
FROM DUAL;

SELECT 
CASE �÷��� WHEN 1 THEN 100 ELSE 0,
CASE �÷��� WHEN 2 THEN 200 ELSE 0,
CASE �÷��� WHEN 3 THEN 300 ELSE 0,
CASE �÷��� WHEN 4 THEN 400 ELSE 0,
FROM DUAL;

--��������� �ȵ� 
SELECT 
CASE ADDR1 WHEN '����Ư����' THEN '����'
WHEN '��⵵' THEN '���'
WHEN '��󳲵�' THEN '�泲'
END ADDR
FROM CUSTOM;

--JOIN�� 
--EQUIE JOIN(INNER JOIN) 
--NON_EQUIE JOIN
--OUTER JOIN
--CROSS JOIN
--SELF JOIN

SELECT * FROM TAB;
SELECT * FROM COMPANY WHERE USERID='nu7634';
SELECT * FROM CUSTOM WHERE USERID='nu7634';
SELECT * FROM POINT WHERE USERID='nu7634';
SELECT * FROM SALES WHERE USERID='nu7634';

--EQUIE����(INNER JOIN)
SELECT A.USERID,USERNAME �̸�,AGE,ADDR1,B.USERID,COMPANY,PAY
FROM CUSTOM A,COMPANY B --���̺� ��Ī �ٶ� AS ����� �� ����
WHERE A.USERID = B.USERID;

SELECT A.USERID,USERNAME �̸�,AGE,ADDR1,B.USERID,COMPANY,PAY
FROM CUSTOM A INNER JOIN COMPANY B --���̺� ��Ī �ٶ� AS ����� �� ����
ON A.USERID = B.USERID;

--'CUSTOM'���� USERID, USERNAME�� �˻��ϰ� POINT ���̺��� ��ǰ ����,
--�α��ο� ����� POINT ���� (PRODUCT,LOGIN)�� �˻�

SELECT A.USERID,USERNAME,PRODUCT,LOGIN
FROM CUSTOM A, POINT B
WHERE A.USERID = B.USERID AND LOGIN >=10;

SELECT A.USERID,USERNAME,PRODUCT,LOGIN
FROM CUSTOM A INNER JOIN POINT B
ON A.USERID = B.USERID --AND LOGIN >=10;  --JOIN���� : ON �ڿ� AND�� �ٿ��� �ǰ� WHERE�� ����ص���
WHERE LOGIN >=10;

---------------------<�ܺ�����>----------------------------
SELECT COUNT(*) FROM CUSTOM; --459
SELECT COUNT(*) FROM COMPANY; --464

SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A, COMPANY B
WHERE A.USERID = B.USERID; --AND B.COMPANY IS NULL;


SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A, COMPANY B
WHERE A.USERID = B.USERID(+) --(+)������ �� �� �ȳ���
ORDER BY B.COMPANY DESC;
--����
SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A LEFT OUTER JOIN COMPANY B
ON A.USERID = B.USERID
ORDER BY B.COMPANY DESC;


SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A, COMPANY B
WHERE A.USERID(+) = B.USERID
ORDER BY A.USERID DESC;
--����
SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM


------------------------------------------------------------
SELECT * FROM CUSTOM;

SELECT ADDR1,COUNT(*),ROUND(AVG(POINT)),COUNT(*) FROM CUSTOM
GROUP BY ADDR1;

SELECT--��Oracle�� switch��
CASE SEX
WHEN '1' THEN '����' ELSE '����'
--WHEN '0' THEN '����'
END GENDER,
COUNT(*),ROUND(AVG(AGE)) FROM CUSTOM
GROUP BY SEX;

SELECT SEX,COUNT(*),ROUND(AVG(AGE)) FROM CUSTOM
GROUP BY SEX;

SELECT
CASE �÷���
   WHEN 1 THEN 100
   WHEN 2 THEN 200
   WHEN 3 THEN 300
   WHEN 4 THEN 400
   ELSE 500
END AS ��Ī
FROM DUAL;--CASE����. �̷��� �ִٴ°� ������. ������ �ȵ�

SELECT
CASE �÷��� WHEN 1 THEN 100 ELSE 0,
CASE �÷��� WHEN 2 THEN 200 ELSE 0,
CASE �÷��� WHEN 3 THEN 300 ELSE 0,
CASE �÷��� WHEN 4 THEN 400 ELSE 0,
FROM DUAL;--�̷��� �ִٴ°� ������. ������ �ȵ�

SELECT * FROM CUSTOM;

SELECT
CASE ADDR1
WHEN '����Ư����' THEN '����'
WHEN '��⵵' THEN '���'
WHEN '��󳲵�' THEN '�泲'
END ADDR
FROM CUSTOM;

--JOIN�� : ���ݱ����� �ϳ��� TABLE������ SELECT�ߴµ�,
--         JOIN�������� �ϳ� �̻��� TABLE���� SELECT�� �� �ִ�
--EQUIE JOIN(INNER JOIN)
--NON-EQUIE JOIN
--OUTER JOIN
--CROSS JOIN
--SELF JOIN

SELECT * FROM TAB;

--���� calumn�� USERID����� calumn�� �־�� JOIN�� �����ϴ�
/*
CUSTOM-USERID,USERNAME,AGE ��
COMPANY-COMPANY,PAY �� �������� ����
��CUSTOM�� COMPANY�� ����и� �־�� �Ѵ�
��CUSTOM.USERID=COMPANY.USERID
*/
SELECT * FROM CUSTOM WHERE USERID='nu7634';
SELECT * FROM COMPANY WHERE USERID='nu7634';--(���鶧 ����)TABLE�� Calumn���� �޶���Ѵ�
SELECT * FROM POINT WHERE USERID='nu7634';
SELECT * FROM SALES WHERE USERID='nu7634';

--���� TABLE�� �ߺ��Ǵ� Calumn�� ���� ��, TABLER�� Calumn���� �����Ϸ��� .�� �̿��Ѵ�.
--�� TABLE���� �ִ� Calumn�� ������ �ʿ� ����
SELECT CUSTOM.USERID,USERNAME,AGE,ADDR1,COMPANY.USERID,COMPANY,PAY--�����
FROM CUSTOM,COMPANY
WHERE CUSTOM.USERID = COMPANY.USERID;

--EQUIE JOIN(INNER JOIN)
SELECT A.USERID,USERNAME,AGE,ADDR1,B.USERID,COMPANY,PAY
--FROM CUSTOM AS A,COMPANY AS B--TABLE���� ��Ī�� ������ AS�� ���� �ʴ´�
FROM CUSTOM A,COMPANY B--����� ��
WHERE A.USERID = B.USERID;

--��select�� ���ǹ��� where, group by�� ���ǹ��� having, join���� ���ǹ��� on
SELECT A.USERID,USERNAME,AGE,ADDR1,B.USERID,COMPANY,PAY
FROM CUSTOM A INNER JOIN COMPANY B--�����. INNER�� ��������
ON A.USERID = B.USERID;

--'CUSTOM'���� UserID, UserName�� �˻��ϰ� POINT ���̺��� ��ǰ ����,
--�α��ο� ����� POINT ����(Product, Login)�� �˻�
SELECT A.USERID,USERNAME,PRODUCT,LOGIN
FROM CUSTOM A, POINT B
WHERE A.USERID = B.USERID;

--���� �����ѵ� �α����� 10ȸ �̻��� ����� �˻�
SELECT A.USERID,USERNAME,PRODUCT,LOGIN
FROM CUSTOM A, POINT B
WHERE A.USERID = B.USERID AND LOGIN>=10;

SELECT A.USERID,USERNAME,PRODUCT,LOGIN
FROM CUSTOM A INNER JOIN POINT B
ON A.USERID = B.USERID AND LOGIN>=10;--����� JOIN & ON

SELECT A.USERID,USERNAME,PRODUCT,LOGIN
FROM CUSTOM A INNER JOIN POINT B
ON A.USERID = B.USERID
WHERE LOGIN>=10;--����� SELECT & WHERE

---------------------------------------------
--OUTER JOIN(�ܺ�����)
--���� ������ �� ����� �˰� ������ex: ��������/�̸��� ����

SELECT COUNT(*) FROM CUSTOM;--459
SELECT COUNT(*) FROM COMPANY;--464�浥������ ������ �ٸ��١������� �������� �ϴ����� ���� ������ �޶���

SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A, COMPANY B
WHERE A.USERID = B.USERID(+) AND B.COMPANY IS NULL;


SELECT * FROM CUSTOM;--459
SELECT * FROM COMPANY;



SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A, COMPANY B
WHERE A.USERID = B.USERID(+)--CUSTOM�� ����(�밢���� +����)
ORDER BY B.COMPANY DESC;--ȸ������ TABLE���� NULL�� ������ ����

SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A, COMPANY B
WHERE A.USERID(+) = B.USERID--COMPANY�� ����(�밢���� +����)
ORDER BY B.COMPANY DESC;--ȸ������ TABLE���� NULL�� ������ ����

---------------------------------------------
SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A LEFT OUTER JOIN COMPANY B--�Ƚ� ǥ�� ����
ON A.USERID = B.USERID--���ʿ� �ִ� ��(CUSTOM)�� ����(�밢���� +����)
ORDER BY B.COMPANY DESC;--ȸ������ TABLE���� NULL�� ������ ����

SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A RIGHT OUTER JOIN COMPANY B
ON A.USERID = B.USERID--�����ʿ� �ִ� ��(COMPANY)�� ����(�밢���� +����)
ORDER BY B.COMPANY DESC;--ȸ������ TABLE���� NULL�� ������ ����

--CROSS JOIN(��ȣ ����) : ���� ���� �����͸� ����� �� ���. �� �ܿ� ū �ǹ̴� ����
--212976 rows(459, 464�� ��ġ��)
SELECT A.USERID,USERNAME,AGE,ADDR1,B.USERID,COMPANY,PAY--�����
FROM CUSTOM A,COMPANY B;

SELECT A.USERID,USERNAME,AGE,ADDR1,B.USERID,COMPANY,PAY--�����
FROM CUSTOM A CROSS JOIN COMPANY B;--�Ƚ�

SELECT A.USERID,USERNAME,AGE,ADDR1,B.USERID,COMPANY,PAY
FROM CUSTOM A cross JOIN COMPANY B
where A.USERID = B.USERID;--INNER JOIN(CROSS JOIN�ؿ� WHERE ������ INNER JOIN�� �ȴ�)

--SELF JOIN
--�Ȱ����� �÷��ΰ�
--�����ݱ����� CUSTOM-COMPANY ������ �ߴµ�, SELF JOIN�� CUSTOM-CUMSTOM ������ �������

SELECT * FROM CUSTOM--�̸��� �ߺ��Ǵ� ��� ã�� ����
ORDER BY USERNAME;

--�̸��� �����鼭 ID�� �޶���ԡ浿������ ����. +DISTINCT�浿����� ����
SELECT DISTINCT A.*--������ ��� Calumn���� ������. ��DISTINCT: ��������� ������(��� �����̶� �ܿ��!)
FROM CUSTOM A,CUSTOM B
WHERE A.USERNAME = B.USERNAME
AND A.USERID<>B.USERID--�������� ������. �̰� ������ USERID�� �ߺ��Ǽ� ����. ex: �輺�� P��-P��,8��. 8��-P��,8������ �� 4�� ���ϴϱ� USERID�� �Ȱ����͵� 4�� ���ȡ�USERID�� �޶����
ORDER BY A.USERNAME;

--'CUSTOM' ���̺��� '���ֵ�'�� ��� �ִ� ��� �߿� ������ �̸��� ���� ���� �˻�
SELECT A.*
FROM CUSTOM A INNER JOIN CUSTOM B
ON A.USERNAME = B.USERNAME
WHERE A.USERID<>B.USERID AND A.ADDR1 = '���ֵ�'
--AND A.ADDR1 = B.ADDR1--��û���� ���ֵ��� ������ �̸��� ���� '�뿵��' ����
AND B.ADDR1 = '���ֵ�';

--3�� �̻��� ���̺� ����
--CUSTOM : USERID,USERNAME
--COMPANY : COMPANY,DEPT
--POINT : PRODUCT,LOGIN

SELECT A.USERID,USERNAME,COMPANY,DEPT,PRODUCT,LOGIN--�����
FROM CUSTOM A, COMPANY B, POINT C
WHERE A.USERID = B.USERID AND A.USERID = C.USERID;

SELECT A.USERID,USERNAME,COMPANY,DEPT,PRODUCT,LOGIN--����� INNER JOIN
FROM CUSTOM A INNER JOIN COMPANY B
ON A.USERID = B.USERID INNER JOIN POINT C
ON A.USERID = C.USERID;

--�Ļ� ���̺�� JOIN
--�Ļ� ���̺� : ������ �������� �ʴ� ���̺�

--���̵𺰷� �Ǹ�Ƚ���� �Ǹűݾ��� �� �˻�
SELECT * FROM SALES;

SELECT USERID,COUNT(*) CNT,SUM(PRICE) HAP
FROM SALES
GROUP BY USERID;

--�� �߿��� 150���� �̻� �� ����� �˻�
SELECT USERID,COUNT(*) CNT,SUM(PRICE) HAP
FROM SALES
GROUP BY USERID
HAVING SUM(PRICE)>=1500000;--���⿡�� ��Ī �� �� ���, HAP ���� �� ����

--150���� �̻� �� ������� ��ŭ ����� �հ踦 �˰� ����
--INLINE-VIEW : ���� �ִ� �����Ϳ� JOIN�� �ؼ� ����� ��
--���������� USERID�� �־�� ��
SELECT A.USERID,USERNAME,ADDR1,CNT,HAP
FROM CUSTOM A,(
SELECT USERID,COUNT(*) CNT,SUM(PRICE) HAP--������ �������� �ʴ� ������. �Ļ����̺��� B, �������̺��� A��� ��
FROM SALES
GROUP BY USERID
HAVING SUM(PRICE)>=1500000
) B
WHERE A.USERID = B.USERID;

------------------------------
SELECT * FROM CUSTOM;

--���̺� ����� ���
CREATE TABLE JEJU--�з��ؼ� ����
AS
SELECT * FROM CUSTOM WHERE ADDR1='���ֵ�';--CUSTOM�� ADDR1�� ���ֵ��� ����� ���� JEJU��� TABLE�� ����

CREATE TABLE SEOUL
AS
SELECT * FROM CUSTOM WHERE ADDR1='����Ư����';

CREATE TABLE KYUNG
AS
SELECT * FROM CUSTOM WHERE ADDR1='��⵵';

SELECT * FROM TAB;

--���̺��� ���ε��� �����ؾ���
SELECT * FROM JEJU;
SELECT * FROM SEOUL;
SELECT * FROM KYUNG;

SELECT * FROM JEJU--���ֿ� ���￡ ��� �����
UNION
SELECT * FROM SEOUL;--Query�� ���� ���ϴ� ���� �������� �ƴ϶� �ѹ��� �����;��ԡ�UNION ���(Calumn�� �Ȱ��ƾ���)
--(�Ȱ��� Calumn�̶�) ���� ����� Table���� ��ĥ �� UNION ���

SELECT * FROM JEJU
UNION
SELECT * FROM SEOUL
UNION
SELECT * FROM KYUNG;--primary key������ ���ĵ�

---------------------------------------------------------------------------------------

--SUBQUERY(��������)

--COMPANY ���̺��� USERID,COMPANY,DEPT,PAY,��տ���
select * from company;

select round(avg(pay))a_pay from company;

select USERID,COMPANY,DEPT,PAY,
(select round(avg(pay))a_pay from company a_pay) -- ���������� ()�ȿ� �� �־����
from company;

--custom���̺��� ��� ���̺��� ���� ����� ���� �˻�
select * from custom;

select round(avg(age)) from custom; --29
select * from custom where age>=29;
select * from custom where age>=(select round(avg(age)) from custom); --���ϴ� �÷� ���� ���߱�
--                        age           =         age(�÷� ������ ������ ����)


--�����ڵ��� �׷쿡 �ٹ��ϴ� ����

select * from company
where company like '�����ڵ���%';

--�� ������ ���̵�
select userid from company
where company like '�����ڵ���%';

--�� ������ ��ü����
select * from CUSTOM
where USERID in (select userid from company where company like '�����ڵ���%');
--    userid       =    userid (��ġ)


select A.*
from custom A ,company B
where a.userid=b.userid and company like '�����ڵ���%';

--4ȸ �̻� �Ǹ� ����� �ִ� ������ �⺻ ������ �˻�

--�����Ѱ�
select * from sales;

select userid, count(*)Ƚ�� from sales 
group by userid;


select A.*
from custom A,
(select userid, count(*)Ƚ�� from sales 
group by userid) B
where a.userid=b.userid and Ƚ��>=4;
-------------------------------------------------------

--�����ð� ��

select userid, count(*)Ƚ�� from sales 
group by userid
having count(*)>=4;


select * from CUSTOM
where userid IN (select userid from sales 
group by userid
having count(*) >=4);


select A.*,Ƚ��
from custom A,
(select userid, count(*)Ƚ�� from sales 
group by userid
having count(*) >=4) B
where a.userid=b.userid;

-----------------------------------------------------

--ANY(������ ����),ALL(������ ������)
-- >ANY : �ּҰ����� ū ������
-- <ANY : �ִ밪���� ���� ������
-- >ALL : �ִ밪���� ū ������
-- <ALL : �ּҰ����� ���� ������

select point from CUSTOM
where addr1='���ֵ�' order by point; --132/269

select * from CUSTOM
where point >any (select point from CUSTOM where addr1='���ֵ�');

select * from CUSTOM
where point > (select min(point) from CUSTOM where addr1='���ֵ�'); --���ֵ��� ��� ��� ����Ʈ�߿��� ���� ���� ���

-------------------------------------------------------------------------

select * from CUSTOM
where point <any (select point from CUSTOM where addr1='���ֵ�');

select * from CUSTOM
where point < (select max(point) from CUSTOM where addr1='���ֵ�');

-----------------------------------------------------------------------------

select * from CUSTOM
where point >all (select point from CUSTOM where addr1='���ֵ�');

select * from CUSTOM
where point > (select max(point) from CUSTOM where addr1='���ֵ�');


-----------------------------------------------------------------------------

select * from CUSTOM
where point <all (select point from CUSTOM where addr1='���ֵ�');

select * from CUSTOM
where point < (select MIN(point) from CUSTOM where addr1='���ֵ�');


UPDATE CUSTOM SET POINT = 130 WHERE USERID='nu7634';--���������� ������Ʈ


-----------------------------------------------
select point from custom where age>=70; --�������

select * from CUSTOM
where point >any (select point from custom where age>=70); -- any : ����Ŀ���� ����� ���⶧���� ����Ŀ�� ����� �ȳ���
--����Ŀ��        ��������

select * from CUSTOM
where point >all (select point from custom where age>=70); --all : ���������� ������ all�� ũ�� �۰� ��� �����Ͱ� ����. age>=70��� �����ϸ� �ȵ�

---------------------------------------------------------------------------

select * from CUSTOM
where USERID in (select userid from company where company like '�����ڵ���%');

select * from CUSTOM
where USERID =any (select userid from company where company like '�����ڵ���%'); -- in �� =any�� ���� 

---------------------------------------------------------------------------

select * from CUSTOM
where USERID not in (select userid from company where company like '�����ڵ���%'); --���� �ٹ����� �ʴ� ���

select * from CUSTOM
where USERID <>any (select userid from company where company like '�����ڵ���%'); --XXXXXXXXXXX not in =/ <>any

select * from CUSTOM
where USERID <>all (select userid from company where company like '�����ڵ���%'); --���OOOOOOOO not in = <>all


---------------------------------------------------------------------------
--��������
select userid,username,addr1,schol from CUSTOM
where userid IN (select userid from company where company like '�����ڵ���%');

select userid from company where company like '�����ڵ���%'; --���డ��

--�������
select userid,username,addr1,schol from CUSTOM
where EXISTS
(select * from company where userid=custom.userid and company like '�����ڵ���%');

select * from company where userid=custom.userid and company like '�����ڵ���%'; --����Ұ���

-------------------------------------------------------------------------------
select * from custom
where addr1 = '��⵵';

select * from (select * from custom where addr1='��⵵') A;

------------------------------------
select * from custom
where addr1 = '��⵵' and age<=20; --��⵵�� ��鼭 ���̰� 20�캸�� �������

select * from (select * from custom where addr1='��⵵') A
where age<=20;

------------------------------------

--DML(INSERT,UPDATE,DELETE)


COMMIT;





