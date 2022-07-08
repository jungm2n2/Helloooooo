--2. EMP 테이블에서 급여가 3000이상인 사원의 정보를 사원번호,이름,담당업무,급여를 출력하는 SELECT 문장을 작성하시오.

select empno,ename,job,sal from emp
where sal>=3000;

--3. EMP 테이블에서 사원번호가 7782인 사원의 이름과 부서번호를 출력하는 SELECT 문장을 작성하시오.
select * from emp;
select ename,deptno from emp
where empno = 7782;

--4. EMP 테이블에서 입사일이 February 20, 1981과 May 1, 1981 사이에 입사한 사원의 이름,업무,입사일을 출력하는 SELECT 문장을 작성하시오.
--단 입사일 순으로 출력하시오.

select ename,job,hiredate from emp
where hiredate>='1981/02/20' and hiredate<='1981/05/01' order by HIREDATE;

select ename,job,hiredate from emp
where hiredate between '1981/02/20' and '1981/05/01' order by HIREDATE;

--5. EMP 테이블에서 부서번호가 10,20인 사원의 모든 정보를 출력하는 SELECT 문장을 작성하시오.
--단 이름순으로 정렬하여라.
select * from EMP
where deptno in(10,20) order by ename;


--6. EMP 테이블에서 급여가 1500이상이고 부서번호가 10,30인 사원의 이름과 급여를 출력하는 SELECT 문장을 작성하여라.
--단 HEADING을 Employee과 Monthly Salary로 출력하여라.

select ename "Employee",sal "Monthly Salary" from emp
where sal>=1500 and deptno in(10,30);

--7. EMP 테이블에서 1982년에 입사한 사원의 모든 정보를 출력하는 SELECT 문을 작성하여라.
select * from EMP
where hiredate like '82%';

SELECT * FROM EMP WHERE HIREDATE BETWEEN '1982-01-01' AND '1982-12-31';

--8. EMP 테이블에서 COMM에 NULL이 아닌 사원의 모든 정보를 출력하는 SELECT 문을 작성하여라.
select * from EMP
where comm is not null;

--9. EMP 테이블에서 보너스가 급여보다 10%가 많은 모든 종업원에 대하여
--이름,급여,보너스를 출력하는 SELECT 문을 작성하여라.
select * from emp;

select ename,sal,comm from EMP
where comm>=(sal*0.1);

--10. EMP 테이블에서 업무가 Clerk이거나 Analyst이고
--급여가 1000,3000,5000이 아닌 모든 사원의 정보를 출력하는 SELECT 문을 작성하여라.

select * from EMP
where job in('CLERK','ANALYST') and sal not in (1000,3000,5000);

 

--11. EMP 테이블에서 이름에 L이 두 자가 있고  부서가 30이거나
--또는 관리자가 7782인 사원의 모든 정보를 출력하는 SELECT 문을 작성하여라.

select * from EMP
where (ename like '%L%L%' and deptno = 30) or mgr = 7782;





commit;

---------------------------------------------------------------------------

--1. 현재 날짜를 출력하고 열 레이블은 Current Date로 출력하는 SELECT 문장을 기술하시오.
select sysdate "Currnet Date" from dual;


 

--2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장을 기술하시오.
select * from emp;

select empno,ename,job,to_char(sal,'9,999')sal,to_char((sal*1.15),'9,999.99')"New Salary",to_char((sal*0.15),'999.99')"Increase"
from emp;
 

--3. EMP 테이블에서 이름,입사일,입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
select ename,hiredate,next_day(add_months(hiredate,6),'월요일') from emp;
 

--4. EMP 테이블에서 이름,입사일, 입사일로부터 현재까지의 월수,급여, 입사일부터 현재까지의 급여의 총계를 출력하는 SELECT 문장을 기술하시오.
--select ename,hiredate,round((sysdate-hiredate)/30)sal

select ename,hiredate,trunc(months_between(sysdate,hiredate))월수,
to_char(sal,'9,999')sal,to_char(sal*trunc(months_between(sysdate,hiredate)),'9,999,999')현재까지급여 from emp;

SELECT ENAME,HIREDATE,ROUND(MONTHS_BETWEEN(SYSDATE,HIREDATE),0)월수,
SAL, SAL*ROUND(MONTHS_BETWEEN(SYSDATE,HIREDATE),0) 급여총계 
FROM EMP;

 
/*
5. EMP 테이블에서 다음의 결과가 출력되도록 작성하시오.

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


--6. EMP 테이블에서 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈곳은 “*”로 대치)를 출력하는 SELECT 문장을 기술하시오.
select ename,Lpad(sal,15,'*') from emp;
 

--7. EMP 테이블에서 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
select ename,job,hiredate,to_char(hiredate,'dy')||'요일'요일 from emp;
 

--8. EMP 테이블에서 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력하는 SELECT 문장을 기술하시오.
select ename,LENGTH(ename)이름길이,job from emp
where length(ename)>=6;
 

--9. EMP 테이블에서 모든 사원의 정보를 이름,업무,급여,보너스,급여+보너스를 출력하는 SELECT 문장을 기술하시오.
select ename,job,to_char(sal,'9,999')sal,nvl(comm,0)"보너스",to_char(sal+nvl(comm,0),'9,999')"급여+보너스" from emp;

---------------------------------------------------------------------------------------------------------------------
SELECT 
case SEX 
when '1' then '남자'
when '0' then '여자'
end gender,
COUNT(*) 인원수 FROM CUSTOM
GROUP BY SEX;

WHEN '1' THEN '남자' ELSE '여자'

SELECT 
CASE 컬럼명                         
	WHEN 1 THEN 100                          
	WHEN 2 THEN 200                         
	WHEN 3 THEN 300                         
	WHEN 4 THEN 400                          
	ELSE 500                        
END AS RESULT             
FROM DUAL;




--1. EMP 테이블에서 인원수,최대 급여,최소 급여,급여의 합을 계산하여 출력하는 SELECT 문장을 작성하여라.
SELECT COUNT(EMPNO),MAX(SAL),MIN(SAL),SUM(SAL) FROM EMP;



--2. EMP 테이블에서 각 업무별로 최대 급여,최소 급여,급여의 합을 출력하는 SELECT 문장을 작성하여라.
SELECT JOB 업무,MAX(SAL)"최대 급여",MIN(SAL)"최소 급여",SUM(SAL)"급여의 합" FROM EMP
GROUP BY JOB;



--3. EMP 테이블에서 업무별 인원수를 구하여 출력하는 SELECT 문장을 작성하여라.
SELECT JOB,COUNT(*) FROM EMP
GROUP BY JOB;
 

--4. EMP 테이블에서 최고 급여와 최소 급여의 차이는 얼마인가 출력하는 SELECT 문장을 작성하여라.

SELECT MAX(SAL) - MIN(SAL)"최고 급여-최소 급여" FROM EMP;

 
/*
5. EMP 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.(group by)

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
6. EMP 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.(case,sum)

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
7. EMP 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.

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




--1.10번 부서에 근무하는 사원 중 30번 부서에서 존재하지 않는 직책을 가진 사원들의 사원 정보, 부서정보를 다음과 같이 출력

select * from tab;
select * from dept;
select * from emp;

select job from EMP
where deptno=30;


--job not in (select job from EMP where deptno=30)


select * from EMP
where deptno=10 and job not in (select job from EMP where deptno=30);





--2.부서번호가 30번인 사원들의 최대급여보다 더 많은 급여를 받는 사원 출력하기 (ANY)


select * from EMP
where sal>all(select max(sal) from EMP where deptno=30);


select max(sal) from EMP
where deptno=30;



--3.직책이 SALESMAN인 사람들의 최고 급여보다 높은 급여를 받는 사원들의 사원정보, 급여정보를 출력하는 SQL문 작성


select max(sal) from EMP
where job= 'SALESMAN';

select * from EMP
where sal>(select max(sal) from EMP where job= 'SALESMAN');


select * from tab;

select * from dept;
select * from emp;
select * from salgrade;

--4.부서정보, 사원정보, 급여등급정보, 각사원의 직속상관의 정보를  부서번호,사원번호 순서로 정렬하여 출력해보세요


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
--정답
select a.deptno,dname,A.empno,A.ENAME,A.mgr,A.sal,c.deptno,B.losal,B.hisal,B.grade,D.EMPNO,D.ENAME
from emp A ,salgrade B,DEPT C,EMP D
where A.sal between losal and hisal and a.deptno=c.deptno AND A.MGR=D.EMPNO(+)
order by a.deptno,A.empno;
------------------------------------------

--------------------------------------------------------------------------------------------
--정리한 정답
SELECT A.DEPTNO,DNAME,A.EMPNO,A.ENAME,A.MGR,A.SAL,D.DEPTNO DEPTNO_1,LOSAL,HISAL,GRADE,B.EMPNO MGR_EMPNO,B.ENAME MGR_ENAME
FROM EMP A, EMP B,SALGRADE C,DEPT D
WHERE A.SAL BETWEEN LOSAL AND HISAL
AND A.DEPTNO=D.DEPTNO
AND A.MGR=B.EMPNO(+)
ORDER BY A.DEPTNO,A.EMPNO;

--------------------------------------------------------------------------------------------
--정리한 정답.재시도
SELECT D.DEPTNO,DNAME,A.EMPNO,A.ENAME,A.MGR,A.SAL,A.DEPTNO DEPTNO_1,LOSAL,HISAL,GRADE,B.EMPNO MGR_EMPNO,B.ENAME MGR_ENAME
FROM EMP A
RIGHT OUTER JOIN DEPT D
ON A.DEPTNO=D.DEPTNO
LEFT OUTER JOIN EMP B
ON A.MGR=B.EMPNO
LEFT OUTER JOIN SALGRADE C
ON A.SAL BETWEEN C.LOSAL AND C.HISAL
ORDER BY A.DEPTNO,A.EMPNO;
---------------------------------
SELECT D.DEPTNO,DNAME,A.EMPNO,A.ENAME,A.MGR,A.SAL,A.DEPTNO DEPTNO_1,LOSAL,HISAL,GRADE,B.EMPNO MGR_EMPNO,B.ENAME MGR_ENAME
FROM DEPT D
LEFT OUTER JOIN EMP A
ON A.DEPTNO=D.DEPTNO
LEFT OUTER JOIN EMP B
ON A.MGR=B.EMPNO
LEFT OUTER JOIN SALGRADE C
ON A.SAL BETWEEN C.LOSAL AND C.HISAL
ORDER BY A.DEPTNO,A.EMPNO;
--------------------------------


--5.급여가 2000초과인 사원들의 부서정보, 사원정보를 출력해보세요



select * from EMP
where sal >2000;

select * from dept;


select a.deptno,dname,loc,empno,ename,SAL
from emp A, DEPT B
where sal >2000 and a.deptno=b.deptno
order by deptno;

-------------------------------------------------------------

--6.부서별 평균 급여, 최대 급여, 최소 급여, 사원수를 출력


SELECT A.DEPTNO,B.DNAME,ROUND(AVG(SAL))AVG_SAL,ROUND(MAX(SAL))MAX_SAL,ROUND(MIN(SAL))MIN_SAL,COUNT(*)CNT
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO
GROUP BY A.DEPTNO, B.DNAME;
--------------------------------------------------

--모든 부서 정보와 사원 정보를 부서번호, 사원이름순으로 정렬하여 출력

SELECT A.DEPTNO,DNAME,EMPNO,ENAME,JOB,SAL
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO
ORDER BY A.DEPTNO,EMPNO;


------------------------------------------------------------
--문제 4 / 1. EMP 테이블에서 모든 사원에 대한 이름,부서번호,부서명을 출력하는 SELECT 문장을 작성하여라.

SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT ENAME,EMPNO,DNAME
FROM EMP A,DEPT B
WHERE A.DEPTNO=B.DEPTNO;


 

--2. EMP 테이블에서 NEW YORK에서 근무하고 있는 사원에 대하여 이름,업무,급여,부서명을 출력하는 SELECT 문장을 작성하여라.

SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT ENAME,JOB,SAL,DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO AND LOC='NEW YORK';



 

--3. EMP 테이블에서 보너스를 받는 사원에 대하여 이름,부서명,위치를 출력하는 SELECT 문장을 작성하여라.

SELECT ENAME,DNAME,LOC
FROM EMP A,DEPT B
WHERE A.DEPTNO=B.DEPTNO AND NVL(COMM,0) <>0;

 

--4. EMP 테이블에서 이름 중 L자가 있는 사원에 대하여 이름,업무,부서명,위치를 출력하는 SELECT 문장을 작성하여라.

SELECT ENAME,JOB,DNAME,LOC
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO AND A.ENAME LIKE '%L%';
 
/*
5. 아래의 결과를 출력하는 SELECT 문장을 작성하여라.(관리자가 없는 King을 포함하여 모든 사원을 출력)

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

--6. EMP 테이블에서 그들의 관리자 보다 먼저 입사한 사원에 대하여 이름,입사일,관리자 이름, 관리자 입사일을 출력하는 SELECT 문장을 작성하여라.

SELECT ENAME,HIREDATE FROM EMP;


SELECT A.ENAME,B.ENAME,B.HIREDATE
FROM EMP A, EMP B
WHERE A.MGR = B.EMPNO(+)
ORDER BY B.ENAME DESC;

SELECT A.ENAME,A.HIREDATE,B.ENAME"관리자 이름",B.HIREDATE"관리자 입사일"
FROM EMP A, EMP B
WHERE A.MGR = B.EMPNO(+) AND A.HIREDATE>B.HIREDATE;


/*
7. EMP 테이블에서 사원의 급여와 사원의 급여 양만큼 “*”를 출력하는 SELECT 문장을 작성하여라. 단 “*”는 100을 의미한다.

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

-----------------------------------------------------------------------------------
SELECT * FROM EMP;

--1. EMP 테이블에서 Blake와 같은 부서에 있는 모든 사원의 이름과 입사일자를 출력하는 SELECT문을 작성하시오.

SELECT ENAME, HIREDATE
FROM EMP
WHERE DEPTNO = 
(SELECT DEPTNO FROM EMP
WHERE ENAME = 'BLAKE');

 

--2. EMP 테이블에서 평균 급여 이상을 받는 모든 종업원에 대해서 종업원 번호와 이름을 출력하는 SELECT문을 작성하시오.
--단 급여가 많은 순으로 출력하여라.
SELECT * FROM EMP;

SELECT AVG(SAL) FROM EMP;

SELECT EMPNO,ENAME FROM EMP
WHERE SAL>=(SELECT AVG(SAL) FROM EMP);

 

--3. EMP 테이블에서 이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 종업원에 대해 사원 번호,이름,급여를 출력하는 SELECT문을 작성하시오. 단 사원번호 순으로 출력하여라.


SELECT * FROM EMP;

SELECT DISTINCT DEPTNO FROM EMP
WHERE ENAME LIKE '%T%';

SELECT EMPNO,ENAME,SAL FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP
WHERE ENAME LIKE '%T%');

 

--4. EMP 테이블에서 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여를 출력하는 SELECT문을 작성하시오.
SELECT * FROM TAB;
SELECT * FROM DEPT;

SELECT DEPTNO
FROM DEPT
WHERE LOC='DALLAS';

SELECT ENAME,JOB,SAL
FROM EMP A
WHERE DEPTNO =
(SELECT DEPTNO
FROM DEPT
WHERE LOC='DALLAS');
 

 

--5. EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여를 출력하는 SELECT문을 작성하시오.
SELECT * FROM EMP;

SELECT EMPNO FROM EMP
WHERE ENAME='KING';


SELECT ENAME,SAL FROM EMP
WHERE MGR=(SELECT EMPNO FROM EMP
WHERE ENAME='KING');

 

--6. EMP 테이블에서 SALES부서 사원의 이름,업무를 출력하는 SELECT문을 작성하시오.

SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT DEPTNO FROM DEPT
WHERE DNAME='SALES';

SELECT ENAME,JOB FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT
WHERE DNAME='SALES');

--7. EMP 테이블에서 월급이 부서 30의 최저 월급보다 높은 사원을 출력하는 SELECT문을 작성하시오.
SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT MIN(SAL) FROM EMP
WHERE DEPTNO=30
GROUP BY DEPTNO;

SELECT * FROM EMP
WHERE SAL >(SELECT MIN(SAL) FROM EMP
WHERE DEPTNO=30
GROUP BY DEPTNO);

 

--8. EMP 테이블에서 부서 10에서 부서 30의 사원과 같은 업무를 맡고 있는 사원의 이름과 업무를 출력하는 SELECT문을 작성하시오.


SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT DISTINCT JOB FROM EMP
WHERE DEPTNO=30;


SELECT ENAME,JOB FROM EMP
WHERE JOB IN (SELECT DISTINCT JOB FROM EMP) AND DEPTNO=10;


 

 

--9. EMP 테이블에서 FORD와 업무도 월급도 같은 사원의 모든 정보를 출력하는 SELECT문을 작성하시오.

SELECT * FROM EMP;
SELECT * FROM DEPT; 

SELECT JOB FROM EMP
WHERE ENAME = 'FORD';

SELECT SAL FROM EMP
WHERE ENAME = 'FORD';


SELECT * FROM EMP
WHERE JOB=(SELECT JOB FROM EMP
WHERE ENAME = 'FORD') AND SAL = (SELECT SAL FROM EMP
WHERE ENAME = 'FORD');


--10. EMP 테이블에서 업무가 JONES와 같거나 월급이 FORD이상인 사원의 정보를 이름,업무,부서번호,급여를 출력하는 SELECT문을 작성하시오.
 --단 업무별, 월급이 많은 순으로 출력하여라.

SELECT * FROM EMP;
SELECT * FROM DEPT; 

SELECT JOB FROM EMP
WHERE ENAME='JONES';

SELECT SAL FROM EMP
WHERE ENAME='JONES';

SELECT ENAME,JOB,DEPTNO,SAL FROM EMP
WHERE JOB=(SELECT JOB FROM EMP
WHERE ENAME='JONES') OR SAL=(SELECT SAL FROM EMP
WHERE ENAME='JONES');
 

--11. EMP 테이블에서 SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여를 출력하는 SELECT문을 작성하시오.

SELECT * FROM EMP;
SELECT * FROM DEPT; 

SELECT SAL FROM EMP
WHERE ENAME='SCOTT' OR ENAME='WARD';

SELECT ENAME,JOB,SAL FROM EMP
WHERE SAL=(SELECT SAL FROM EMP
WHERE ENAME='SCOTT' OR ENAME='WARD');
 

 

--12. EMP 테이블에서 CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원의 이름,업무를 출력하는 SELECT문을 작성하시오.

SELECT * FROM EMP;
SELECT * FROM DEPT; 

SELECT DEPTNO FROM DEPT
WHERE LOC='CHICAGO';

SELECT JOB FROM EMP
WHERE DEPTNO=(SELECT DEPTNO FROM DEPT
WHERE LOC='CHICAGO');

SELECT ENAME,JOB FROM EMP
WHERE JOB IN (SELECT JOB FROM EMP
WHERE DEPTNO=(SELECT DEPTNO FROM DEPT
WHERE LOC='CHICAGO'));
 

 

--13. EMP 테이블에서 부서별로 월급이 평균 월급보다 높은 사원을 부서번호,이름,급여를 출력하는 SELECT문을 작성하시오.



SELECT DEPTNO,AVG(SAL) FROM EMP
GROUP BY DEPTNO;

SELECT A.DEPTNO,A.ENAME,A.SAL
FROM EMP A,
(SELECT DEPTNO,AVG(SAL)평균 FROM EMP
GROUP BY DEPTNO)B
WHERE A.DEPTNO=B.DEPTNO AND SAL>평균;



 

--14. EMP 테이블에서 업무별로 월급이 평균 월급보다 낮은 사원을 부서번호,이름,급여를 출력하는 SELECT문을 작성하시오.
--(해결못함)

SELECT JOB,AVG(SAL) FROM EMP
GROUP BY JOB;

SELECT A.DEPTNO,A.ENAME,A.SAL
FROM EMP A,
(SELECT JOB,AVG(SAL)평균 FROM EMP
GROUP BY JOB)B
WHERE A.JOB=B.JOB AND SAL<평균; 

 

--15. EMP 테이블에서 적어도 한명 이상으로부터 보고를 받을 수 있는 사원을 업무,이름,사원번호,부서번호를 출력하는 SELECT문을 작성하시오.
SELECT * FROM EMP;
SELECT * FROM DEPT; 


SELECT A.ENAME,A.MGR,A.EMPNO,B.ENAME 매니저이름,B.EMPNO 매니저사번
FROM EMP A, EMP B
WHERE A.MGR=B.EMPNO(+);

SELECT B.ENAME
FROM EMP A, EMP B
WHERE A.MGR=B.EMPNO
GROUP BY B.ENAME;


SELECT JOB,ENAME,EMPNO,DEPTNO
FROM EMP A
WHERE ENAME IN(SELECT B.ENAME
FROM EMP A, EMP B
WHERE A.MGR=B.EMPNO
GROUP BY B.ENAME);

 

 

--16. EMP 테이블에서 말단 사원의 사원번호,이름,업무,부서번호를 출력하는 SELECT문을 작성하시오.
SELECT MAX(HIREDATE) FROM EMP;



SELECT EMPNO,ENAME,JOB,DEPTNO FROM EMP
WHERE HIREDATE =(SELECT MAX(HIREDATE) FROM EMP);



