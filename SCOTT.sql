--2. EMP ���̺��� �޿��� 3000�̻��� ����� ������ �����ȣ,�̸�,������,�޿��� ����ϴ� SELECT ������ �ۼ��Ͻÿ�.

select empno,ename,job,sal from emp
where sal>=3000;

--3. EMP ���̺��� �����ȣ�� 7782�� ����� �̸��� �μ���ȣ�� ����ϴ� SELECT ������ �ۼ��Ͻÿ�.
select * from emp;
select ename,deptno from emp
where empno = 7782;

--4. EMP ���̺��� �Ի����� February 20, 1981�� May 1, 1981 ���̿� �Ի��� ����� �̸�,����,�Ի����� ����ϴ� SELECT ������ �ۼ��Ͻÿ�.
--�� �Ի��� ������ ����Ͻÿ�.

select ename,job,hiredate from emp
where hiredate>='1981/02/20' and hiredate<='1981/05/01' order by HIREDATE;

select ename,job,hiredate from emp
where hiredate between '1981/02/20' and '1981/05/01' order by HIREDATE;

--5. EMP ���̺��� �μ���ȣ�� 10,20�� ����� ��� ������ ����ϴ� SELECT ������ �ۼ��Ͻÿ�.
--�� �̸������� �����Ͽ���.
select * from EMP
where deptno in(10,20) order by ename;


--6. EMP ���̺��� �޿��� 1500�̻��̰� �μ���ȣ�� 10,30�� ����� �̸��� �޿��� ����ϴ� SELECT ������ �ۼ��Ͽ���.
--�� HEADING�� Employee�� Monthly Salary�� ����Ͽ���.

select ename "Employee",sal "Monthly Salary" from emp
where sal>=1500 and deptno in(10,30);

--7. EMP ���̺��� 1982�⿡ �Ի��� ����� ��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
select * from EMP
where hiredate like '82%';

SELECT * FROM EMP WHERE HIREDATE BETWEEN '1982-01-01' AND '1982-12-31';

--8. EMP ���̺��� COMM�� NULL�� �ƴ� ����� ��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
select * from EMP
where comm is not null;

--9. EMP ���̺��� ���ʽ��� �޿����� 10%�� ���� ��� �������� ���Ͽ�
--�̸�,�޿�,���ʽ��� ����ϴ� SELECT ���� �ۼ��Ͽ���.
select * from emp;

select ename,sal,comm from EMP
where comm>=(sal*0.1);

--10. EMP ���̺��� ������ Clerk�̰ų� Analyst�̰�
--�޿��� 1000,3000,5000�� �ƴ� ��� ����� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.

select * from EMP
where job in('CLERK','ANALYST') and sal not in (1000,3000,5000);

 

--11. EMP ���̺��� �̸��� L�� �� �ڰ� �ְ�  �μ��� 30�̰ų�
--�Ǵ� �����ڰ� 7782�� ����� ��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.

select * from EMP
where (ename like '%L%L%' and deptno = 30) or mgr = 7782;





commit;

---------------------------------------------------------------------------

--1. ���� ��¥�� ����ϰ� �� ���̺��� Current Date�� ����ϴ� SELECT ������ ����Ͻÿ�.
select sysdate "Currnet Date" from dual;


 

--2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ������ ����Ͻÿ�.
select * from emp;

select empno,ename,job,to_char(sal,'9,999')sal,to_char((sal*1.15),'9,999.99')"New Salary",to_char((sal*0.15),'999.99')"Increase"
from emp;
 

--3. EMP ���̺��� �̸�,�Ի���,�Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
select ename,hiredate,next_day(add_months(hiredate,6),'������') from emp;
 

--4. EMP ���̺��� �̸�,�Ի���, �Ի��Ϸκ��� ��������� ����,�޿�, �Ի��Ϻ��� ��������� �޿��� �Ѱ踦 ����ϴ� SELECT ������ ����Ͻÿ�.
--select ename,hiredate,round((sysdate-hiredate)/30)sal

select ename,hiredate,trunc(months_between(sysdate,hiredate))����,
to_char(sal,'9,999')sal,to_char(sal*trunc(months_between(sysdate,hiredate)),'9,999,999')��������޿� from emp;

SELECT ENAME,HIREDATE,ROUND(MONTHS_BETWEEN(SYSDATE,HIREDATE),0)����,
SAL, SAL*ROUND(MONTHS_BETWEEN(SYSDATE,HIREDATE),0) �޿��Ѱ� 
FROM EMP;

 
/*
5. EMP ���̺��� ������ ����� ��µǵ��� �ۼ��Ͻÿ�.

Dream Salary

------------------------------------------------------------

KING earns $5,000.00 monthly but wants $15,000.00

BLAKE earns $2,850.00 monthly but wants $8,550.00

CLARK earns $2,450.00 monthly but wants $7,350.00

. . . . . . . . . .

14 rows selected
 */ 
select * from emp;

select ename,'earns '||'$'||to_char(sal,'9,999.99')||' monthly but wants '||'$'||to_char(sal*3,'99,999.99') "Dream Salary" from emp;


--6. EMP ���̺��� ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ ����� ��*���� ��ġ)�� ����ϴ� SELECT ������ ����Ͻÿ�.
select ename,Lpad(sal,15,'*') from emp;
 

--7. EMP ���̺��� ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
select ename,job,hiredate,to_char(hiredate,'dy')||'����'���� from emp;
 

--8. EMP ���̺��� �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ����ϴ� SELECT ������ ����Ͻÿ�.
select ename,LENGTH(ename)�̸�����,job from emp
where length(ename)>=6;
 

--9. EMP ���̺��� ��� ����� ������ �̸�,����,�޿�,���ʽ�,�޿�+���ʽ��� ����ϴ� SELECT ������ ����Ͻÿ�.
select ename,job,to_char(sal,'9,999')sal,nvl(comm,0)"���ʽ�",to_char(sal+nvl(comm,0),'9,999')"�޿�+���ʽ�" from emp;

---------------------------------------------------------------------------------------------------------------------
SELECT 
case SEX 
when '1' then '����'
when '0' then '����'
end gender,
COUNT(*) �ο��� FROM CUSTOM
GROUP BY SEX;

WHEN '1' THEN '����' ELSE '����'

SELECT 
CASE �÷���                         
	WHEN 1 THEN 100                          
	WHEN 2 THEN 200                         
	WHEN 3 THEN 300                         
	WHEN 4 THEN 400                          
	ELSE 500                        
END AS RESULT             
FROM DUAL;




--1. EMP ���̺��� �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ����Ͽ� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT COUNT(EMPNO),MAX(SAL),MIN(SAL),SUM(SAL) FROM EMP;



--2. EMP ���̺��� �� �������� �ִ� �޿�,�ּ� �޿�,�޿��� ���� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT JOB ����,MAX(SAL)"�ִ� �޿�",MIN(SAL)"�ּ� �޿�",SUM(SAL)"�޿��� ��" FROM EMP
GROUP BY JOB;



--3. EMP ���̺��� ������ �ο����� ���Ͽ� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT JOB,COUNT(*) FROM EMP
GROUP BY JOB;
 

--4. EMP ���̺��� �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT MAX(SAL) - MIN(SAL)"�ְ� �޿�-�ּ� �޿�" FROM EMP;

 
/*
5. EMP ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.(group by)

H_YEAR  COUNT(*)  MIN(SAL)  MAX(SAL)  AVG(SAL)  SUM(SAL)

------ --------- --------- --------- --------- ---------

    81       10       950      5000    2282.5	  22825

    82        1      1300      1300      1300      1300

    80        1       800       800       800       800
*/


SELECT * FROM(SELECT DISTINCT
EXTRACT(YEAR FROM HIREDATE)
FROM EMP)"H_YEAR",
(SELECT COUNT(*) FROM EMP
GROUP BY (EXTRACT(YEAR FROM HIREDATE)))"COUNT(*)",
(SELECT MIN(SAL)
FROM EMP
GROUP BY EXTRACT(YEAR FROM HIREDATE))"MIN(SAL)",
(SELECT MAX(SAL)
FROM EMP
GROUP BY EXTRACT(YEAR FROM HIREDATE))"MAX(SAL)",
(SELECT AVG(SAL)
FROM EMP
GROUP BY EXTRACT(YEAR FROM HIREDATE))"AVG(SAL)",
(SELECT SUM(SAL)
FROM EMP
GROUP BY EXTRACT(YEAR FROM HIREDATE));
------------------------------------------------


SELECT * FROM 
(SELECT DISTINCT EXTRACT(YEAR FROM HIREDATE) FROM EMP),
(SELECT COUNT(*) FROM EMP
GROUP BY (EXTRACT(YEAR FROM HIREDATE)))
;


------------------------------------------------

SELECT HIREDATE,
EXTRACT(YEAR FROM HIREDATE)YEAR,
EXTRACT(MONTH FROM HIREDATE)MONTH,
EXTRACT(DAY FROM HIREDATE)DAY
FROM EMP;

SELECT * FROM EMP;


SELECT DISTINCT JOB
FROM EMP;



SELECT 
EXTRACT(YEAR FROM HIREDATE)
FROM EMP;


SELECT COUNT(*) FROM EMP
GROUP BY (EXTRACT(YEAR FROM HIREDATE));
--ORDER BY COUNT(*) DESC;

------------------------------------------------------------
SELECT
substr(EXTRACT(YEAR FROM HIREDATE),3,4)H_YEAR,
COUNT(*),
MIN(SAL),
MAX(SAL),
AVG(SAL),
SUM(SAL)
FROM EMP
GROUP BY EXTRACT(YEAR FROM HIREDATE)
order by sum(sal) desc;
-----------------------------------------------------------


SELECT MIN(SAL)
FROM EMP
GROUP BY EXTRACT(YEAR FROM HIREDATE);

SELECT MAX(SAL)
FROM EMP
GROUP BY EXTRACT(YEAR FROM HIREDATE);

SELECT AVG(SAL)
FROM EMP
GROUP BY EXTRACT(YEAR FROM HIREDATE);

SELECT SUM(SAL)
FROM EMP
GROUP BY EXTRACT(YEAR FROM HIREDATE);


--SELECT
--()


--GROUP BY 


SELECT
TO_CHAR(HIREDATE,'YY')H_YEAR,COUNT(*), MIN(SAL),MAX(SAL),AVG(SAL),SUM(SAL) FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YY');

SELECT 
EXTRACT(YEAR FROM HIREDATE)
FROM EMP;

 
/*
6. EMP ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.(case,sum)

    TOTAL      1980      1981      1982      1983

--------- --------- --------- --------- ---------

       12         1        10         1         0
*/

       
SELECT * FROM EMP;





SELECT
COUNT(*) TOTAL,
SUM(CASE EXTRACT(YEAR FROM HIREDATE) WHEN 1980 THEN 1 END) "1980",
SUM(CASE EXTRACT(YEAR FROM HIREDATE) WHEN 1981 THEN 1 END) "1981",
SUM(CASE EXTRACT(YEAR FROM HIREDATE) WHEN 1982 THEN 1 END) "1982",
SUM(CASE EXTRACT(YEAR FROM HIREDATE) WHEN 1983 THEN 1 ELSE 0 END) "1983"
FROM EMP;


       
       
       
       
       
       
 

 
/*
7. EMP ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.

JOB         Deptno 10    Deptno 20     Deptno 30     Total

---------   ---------    ---------     ---------     ---------

CLERK            1300         1900           950          4150

SALESMAN                                    5600          5600

PRESIDENT	   5000                                     5000

MANAGER	       2450         2975          2850          8275

ANALYST	                     6000                        6000
 
*/


--select JOB,




--sum(sal)


select JOB,
sum(case deptno when 10 then SAL else 0 end) "Deptno 10",
SUM(case deptno when 20 then SAL else 0 end) "Deptno 20",
sum(case deptno when 30 then SAL else 0 end) "Deptno 30",
sum(SAL) "Total" from EMP group by job;






select
JOB,

from emp
group by job;

select sum(sal)
from emp
group by job;




COMMIT;




--1.10�� �μ��� �ٹ��ϴ� ��� �� 30�� �μ����� �������� �ʴ� ��å�� ���� ������� ��� ����, �μ������� ������ ���� ���

select * from tab;
select * from dept;
select * from emp;

select job from EMP
where deptno=30;


--job not in (select job from EMP where deptno=30)


select * from EMP
where deptno=10 and job not in (select job from EMP where deptno=30);





--2.�μ���ȣ�� 30���� ������� �ִ�޿����� �� ���� �޿��� �޴� ��� ����ϱ� (ANY)


select * from EMP
where sal>all(select max(sal) from EMP where deptno=30);


select max(sal) from EMP
where deptno=30;



--3.��å�� SALESMAN�� ������� �ְ� �޿����� ���� �޿��� �޴� ������� �������, �޿������� ����ϴ� SQL�� �ۼ�


select max(sal) from EMP
where job= 'SALESMAN';

select * from EMP
where sal>(select max(sal) from EMP where job= 'SALESMAN');


select * from tab;

select * from dept;
select * from emp;
select * from salgrade;

--4.�μ�����, �������, �޿��������, ������� ���ӻ���� ������  �μ���ȣ,�����ȣ ������ �����Ͽ� ����غ�����


SELECT A.EMPNO,A.ENAME,B.EMPNO,B.ENAME
FROM EMP A, EMP B
WHERE A.MGR=B.EMPNO(+);



select a.deptno,dname,a.empno,mgr,sal,d.deptno,losal,hisal,grade,d.empno,d.ename
from emp A ,emp b,salgrade c,DEPT d
where sal between losal and hisal and a.mgr=d.empno and a.deptno=d.deptno 
order by a.deptno;


SELECT DEPTNO,EMPNO,ENAME,MGR,HIREDATE,SAL,COMM,DEPTNO
FROM EMP;
------------------------------------------------------
select a.deptno,dname,empno,mgr,sal,c.deptno,losal,hisal,grade,job,hiredate,loc
from emp A ,salgrade B,DEPT C
where sal between losal and hisal and a.deptno=c.deptno
order by a.deptno,empno;
---------------------------------------------------


SELECT A.EMPNO,A.ENAME,B.EMPNO,B.ENAME
FROM EMP A, EMP B
WHERE A.MGR=B.EMPNO(+);

---------------------------------------------
--����
select a.deptno,dname,A.empno,A.ENAME,A.mgr,A.sal,c.deptno,B.losal,B.hisal,B.grade,D.EMPNO,D.ENAME
from emp A ,salgrade B,DEPT C,EMP D
where A.sal between losal and hisal and a.deptno=c.deptno AND A.MGR=D.EMPNO(+)
order by a.deptno,A.empno;
------------------------------------------

--------------------------------------------------------------------------------------------
--������ ����
SELECT A.DEPTNO,DNAME,A.EMPNO,A.ENAME,A.MGR,A.SAL,D.DEPTNO DEPTNO_1,LOSAL,HISAL,GRADE,B.EMPNO MGR_EMPNO,B.ENAME MGR_ENAME
FROM EMP A, EMP B,SALGRADE C,DEPT D
WHERE A.SAL BETWEEN LOSAL AND HISAL
AND A.DEPTNO=D.DEPTNO
AND A.MGR=B.EMPNO(+)
ORDER BY A.DEPTNO,A.EMPNO;

--------------------------------------------------------------------------------------------
--������ ����.��õ�
SELECT A.DEPTNO,DNAME,A.EMPNO,A.ENAME,A.MGR,A.SAL,D.DEPTNO DEPTNO_1,LOSAL,HISAL,GRADE,B.EMPNO MGR_EMPNO,B.ENAME MGR_ENAME
FROM EMP A, EMP B,SALGRADE C,DEPT D
WHERE A.SAL BETWEEN LOSAL AND HISAL
AND A.DEPTNO=D.DEPTNO
AND A.MGR=B.EMPNO(+)
ORDER BY A.DEPTNO,A.EMPNO;
---------------------------------


--5.�޿��� 2000�ʰ��� ������� �μ�����, ��������� ����غ�����



select * from EMP
where sal >2000;

select * from dept;


select a.deptno,dname,loc,empno,ename,SAL
from emp A, DEPT B
where sal >2000 and a.deptno=b.deptno
order by deptno;

-------------------------------------------------------------

--6.�μ��� ��� �޿�, �ִ� �޿�, �ּ� �޿�, ������� ���


SELECT A.DEPTNO,B.DNAME,ROUND(AVG(SAL))AVG_SAL,ROUND(MAX(SAL))MAX_SAL,ROUND(MIN(SAL))MIN_SAL,COUNT(*)CNT
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO
GROUP BY A.DEPTNO, B.DNAME;
--------------------------------------------------

--��� �μ� ������ ��� ������ �μ���ȣ, ����̸������� �����Ͽ� ���

SELECT A.DEPTNO,DNAME,EMPNO,ENAME,JOB,SAL
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO
ORDER BY A.DEPTNO,EMPNO;


------------------------------------------------------------
--���� 4 / 1. EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT ENAME,EMPNO,DNAME
FROM EMP A,DEPT B
WHERE A.DEPTNO=B.DEPTNO;


 

--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT * FROM EMP;

SELECT ENAME,JOB,SAL,DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO AND B.DEPTNO=10;



 

--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT ENAME,DNAME,LOC
FROM EMP A,DEPT B
WHERE A.DEPTNO=B.DEPTNO AND NVL(COMM,0) <>0;

 

--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT ENAME,JOB,DNAME,LOC
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO AND A.ENAME LIKE '%L%';
 
/*
5. �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.(�����ڰ� ���� King�� �����Ͽ� ��� ����� ���)

Employee        Emp# Manager         Mgr#

---------- --------- ---------- ---------

KING            7839

BLAKE           7698 KING            7839

CLARK           7782 KING            7839

. . . . . . . . . .

14 rows selected.
 */
 
 
SELECT * FROM EMP;

SELECT A.ENAME"Employee",A.EMPNO Emp#,B.ENAME"Manager",B.EMPNO Mgr#
FROM EMP A, EMP B
WHERE A.MGR = B.EMPNO(+)
ORDER BY B.ENAME DESC;

--6. EMP ���̺��� �׵��� ������ ���� ���� �Ի��� ����� ���Ͽ� �̸�,�Ի���,������ �̸�, ������ �Ի����� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT ENAME,HIREDATE FROM EMP;


SELECT A.ENAME,B.ENAME,B.HIREDATE
FROM EMP A, EMP B
WHERE A.MGR = B.EMPNO(+)
ORDER BY B.ENAME DESC;

SELECT A.ENAME,A.HIREDATE,B.ENAME"������ �̸�",B.HIREDATE"������ �Ի���"
FROM EMP A, EMP B
WHERE A.MGR = B.EMPNO(+)
ORDER BY B.ENAME DESC;


/*
7. EMP ���̺��� ����� �޿��� ����� �޿� �縸ŭ ��*���� ����ϴ� SELECT ������ �ۼ��Ͽ���. �� ��*���� 100�� �ǹ��Ѵ�.

Employee and their salary

-----------------------------------------------------------------

KING      **************************************************

BLAKE     ****************************

CLARK     ************************

JONES     *****************************

MARTIN    ************

ALLEN     ****************

TURNER    ***************

. . . . . . . . . .

14 rows selected.
 
*/

SELECT ENAME||RPAD(' ',TRUNC(SAL/100)+1,'*')"Employee and their salary"
FROM EMP;


SELECT RPAD(ENAME,TRUNC(SAL/100)+LENGTH(ENAME),'*')"Employee and their salary"
FROM EMP;

COMMIT;
