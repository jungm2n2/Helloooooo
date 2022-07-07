--kim
select * from tab;

select * from PERSONNEL;

--Data -> Record(Row) -> table(표).RDBMS -> TableSpace -> DB

/*
SQL (Structured Query Language : 구조화된 질의 언어)
Ansi 표준PERSONNEL


1. query
   select data검색어

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
order by pay asc; --오름차순(기본값. asc 생략 가능)

select * from PERSONNEL
order by pay desc; --내림차순

select * from PERSONNEL
order by pay;

select * from PERSONNEL
order by pname desc;

--별칭
Select pno,pname,pay,pay+1000 as 보너스 from PERSONNEL; --(pay+1000)파생컬럼 /(as)별칭
Select pno,pname,pay,pay+1000 보너스 from PERSONNEL; --as 생략 가능
Select pno,pname,pay,pay+1000 as "보 너 스" from PERSONNEL; --띄어쓰기 하고싶을땐 "" 사용

Select pno 번호,pname as 이름,pay 월급,pay+1000 as 보너스 from PERSONNEL;

Select pno,pname,pay,pay+1000 as 보너스 from PERSONNEL
order by 보너스; --오름차순. order by만 별칭 사용 가능

Select pno,pname,pay,pay+1000 as 보너스 from PERSONNEL
order by pay+1000; --별칭보다 더 많이 사용함.

Select pno,pname,pay,pay+1000 as 보너스 from PERSONNEL
order by 4; --네번째 컬럼으로 정렬해라.

Select pno,pname,pay,pay+1000 as 보너스 from PERSONNEL
order by 4 desc;

select * from PERSONNEL
order by 4 desc; --manager로 정렬

select dno,pno,pname from PERSONNEL
order by dno,pno; --dno 정렬 후 pno 정렬

select dno,pno,pname from PERSONNEL
order by dno,pno desc;

--부서번호는 오름차순, 사원번호는 내림차순

select * from personnel
order by dno, pno desc;

--null
select manager from PERSONNEL
order by manager asc;

select manager from PERSONNEL
order by manager desc; --null을 가장 큰 값으로 인식한다.

--사원의 급여와 연봉을 출력하시오
select pno,pname,pay,pay*12 연봉 from PERSONNEL;

--연결 연산자 ||
select pname||pno from PERSONNEL;

select pname||' '||pno from PERSONNEL;

select * from PERSONNEL;


--현재 보너스 값에 널이 있으면 0으로 표시
--보너스 값이 있으면 그대로 연산하고
select pno,pname,pay,nvl(bonus,0),(pay*12)+ nvl(bonus,0) 연봉 from PERSONNEL; 

--조건절(Where)
select * from PERSONNEL;

select pno,pname,job from PERSONNEL
where job ='SALESMAN';

select pno,pname,job from PERSONNEL
where job ='salesman';


--연산자
-- =, >, >=, <=, <, <>

--급여가 1600인 사원을 검색
select * from PERSONNEL
where pay = 1600;

--사원번호가 1116인 사원을 검색
select * from PERSONNEL
where pno=1116;

--사원급여가 2000 이하인 사원 검색
select * from PERSONNEL
where pay <= 2000;

--90년12월17일에 입사한 사원을 검색
select * from PERSONNEL
where startdate='1990-12-17';

--업무가 clerk인 사원을 검색
select * from PERSONNEL
where job = 'CLERK';

--이름이 JAMES인 사원을 검색
select * from PERSONNEL
where pname = 'JAMES';

--논리 연산자
--AND, OR, NOT(!)

--부서번호가 10번이고 급여가 3000이상인 사원
select * from PERSONNEL
where dno=10 and pay>=3000; --where와 and 뒤에는 반드시 컬럼명이 나와야함

--직업이 SALESMAN이고 90년 이후에 입사한 직원을 찾으시오
select * from PERSONNEL
where job='SALESMAN' and startdate>'1990/12/31'; -- >='1991/01/01'

--91년 9월에 입사한 직원을 찾으시오
select * from PERSONNEL
where STARTDATE>='1991-09-01' and startdate<='1991-09-30';

select * from nls_session_parameters; --환경설정


--or
--부서번호가 10번이거나 급여가 3000 이상인 사원을 찾으시오
select * from PERSONNEL
where dno=10 or pay>=3000;

--직업이 MANAGER 이거나 90년 이전에 입사한 직원을 찾으시오
select * from PERSONNEL
where job='MANAGER' or STARTDATE<'1990/01/01';

--not
--직업이 SALESMAN 이거나 CLERK인 직원을 검색
select * from PERSONNEL
where job='SALESMAN' or job='CLERK';

--직업이 SALESMAN 이 아니거나 CLERK이 아닌 직원을 검색
select * from PERSONNEL
where job<>'SALESMAN' and job<>'CLERK';

--직업이 SALESMAN 이거나 CLERK인 직원을 검색 -- in : 문자열 연산자
select * from PERSONNEL
where job in('SALESMAN','CLERK');

--직업이 SALESMAN 이 아니거나 CLERK이 아닌 직원을 검색 -- in : 문자열 연산자
select * from PERSONNEL
where job not in('SALESMAN','CLERK');

select * from PERSONNEL
where not job in('SALESMAN','CLERK');

--문자열 연산자
--Between A and B

--급여가 1000에서 2000 사이인 사원
select * from PERSONNEL
where pay >=1000 and pay <=2000;

select * from PERSONNEL
where pay between 1000 and 2000;

select * from PERSONNEL
where pay between 2000 and 1000; --오류

select * from  PERSONNEL
where STARTDATE between '1991-09-01' and '1991-09-30';

--부서번호가 20과 30 사이가 아닌 사원을 찾으시오
select * from PERSONNEL
where dno not in (20,30); --20과 30

select * from PERSONNEL
where not dno between 20 and 30; --20~30 사이값도 찾음

select * from DIVISION;
select * from PERSONNEL;

--이름이 A로 시작되는 사원
select * from PERSONNEL
where pname like 'A%'; --%에는 반드시!!!!!!! like 쓰기

--사원번호가 111_로 시작하는 사원 -- _ : 자릿수를 표현. 111_ (네자릿수이고 앞에 세자리가 111인)
select * from PERSONNEL
where pno like '111_';

--사원번호가 111%로 시작하는 사원
select * from PERSONNEL
where pno like '111%'; -- %:4자리 이상이면서 111로 시작

select * from PERSONNEL
where pno like '1__1';

--90년도에 입사한 사원
select * from PERSONNEL
where STARTDATE like '90%'; --기본이 두자리(YY/MM/DD). 1990%하면 안나옴

select * from PERSONNEL;

INSERT INTO PERSONNEL
values(2000,'HELLO_KIM','SALESMAN',1116,'2022-07-04',5000,'',20);

INSERT INTO PERSONNEL
VALUES(2001,'HELLO_KIM','SALESMAN',1116,'2022-07-04',5000,'',20);

--O_K를 포함한 이름 검색

select * from PERSONNEL
where pname like '%O\_K%' escape '\'; --\ : 뒤에 나오는걸 문자로 봐라

--null
select * from PERSONNEL
where manager = null; --실행안?

select * from PERSONNEL
where manager = 'null'; --null이라는 문자를 찾음

select * from PERSONNEL
where MANAGER is null;

select * from PERSONNEL
where MANAGER is not null;

--우선순위
--업무가 MANAGER이고 급여가 1500 이상인 사원
--또는 업무가 SALESMAN인 사원을 검색
select * from PERSONNEL
where (job = 'MANAGER' and pay >=1500) or job='SALESMAN';

select * from PERSONNEL
where job = 'MANAGER' and (pay >=1500 or job='SALESMAN');

--업무가 PRESIDENT 또는 SALESMAN 이고 급여가 1500 이상인 사원
select * from PERSONNEL
where (job='PRESIDENT' or job='SALESMAN') and pay>=1500;

select * from PERSONNEL
where job in ('PRESIDENT','SALESMAN') and pay>=1500;

delete from PERSONNEL
where pname like 'HELLO%';

commit;

--함수
--숫자함수
--Round(반올림)

select round(45.275,1) from dual; --dual:table이 없을때 문법적으로 사용
--1은 소숫점 1 까지 보여주고 싶다는 뜻. 즉 1 아래에서 반올림

select round(45.275,1) from personnel;

select * from dual;

--  1  2  3  4  .  5  6  7 
-- -4 -3 -2 -1  0  1  2  3


/*
ROUND: 특정 소수점을 반올림하는 함수
ROUND(값,자리수)
ROUND(@,0): 소수점 첫번째 자리에서 반올림, 정수로 표시
ROUND(@,1): 소수점 두번째 자리에서 반올림, 소수점 첫번째 자리까지 표시
ROUND(@,-1): 정수 반올림. 정수 첫번째 자리에서 반올림
*/

select round(45.245,1) from dual; --1자리까지 보여주겠다
select round(45.245,-1) from dual; -- -1자리에서 반올림
select round(45.245,0) from dual; -- .에서 반올림
select round(45.245) from dual;

select pno,pname,pay,round(pay,-2) pay1 from PERSONNEL;


/*
TRUNC(@,1): 반올림하지 않고 소수점 첫째자리에서 절사[소수점 첫째자리까지 표현]
TRUNC(@,-1): 정수 첫번째자리를 절사(0으로 만듦)
*/

--trunc(절삭). 소수도 표현
select trunc(45.245,2) from dual;
select trunc(49.245,-1) from dual;
select trunc(49.254)from dual;

select pno,pname,pay,trunc(pay,-2) pay1 from PERSONNEL;

--ceil / floor (올림/내림) : 정수만 반환. 소수는 x

select ceil(461.21) from dual; --소수점 값이 있는 경우 무조건 올려서 다음 정수 값을 반환한다
select floor(461.91) from dual;

--mod(나머지)
select mod(10,3) from dual;

--abs(절대값)
select abs(-123) from dual;

--sign(연산결과 -> 양수:1,음수:-1,0:0)
select sign(100-20), sign(100-102),sign(100-100) from dual;

--power(지수)
select power(2,4) from dual;

--제곱근
select sqrt(9) from dual;

--문자함수
--upper(소문자->대문자)
select upper('Oracle') from dual;

--lower(대->소)
select lower('ORACLE') from dual;

select * from division;

select * from division
where dname = upper('sales');

select * from DIVISION
where lower(dname)='sales';

--initcap 첫글자만 대문자로
select initcap ('korea fighting') from dual;

--concat(||) 문자열 연결
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
where dong like '행복%';

select sido || ' '||gugun||' '||dong as juso from post
where dong like '행복%';

--length
select length ('korea')from dual;
select length ('korea fighting')from dual;

--substr
select substr('abcdefg',1,3) from dual; --1부터 문자 세개를 읽어와라
select substr('abcdefg',3,2) from dual; --3부터 문자 두개를 읽어와라
select substr('abcdefg',-3,2) from dual;
select substr('abcdefg',-4) from dual;

--instr
select instr('abcdefg','c')from dual; --index값 찾기 1

select instr('ABCDEFG','a') from dual; --0

--rpad/LPAD
select rpad(pname,15,'*') from PERSONNEL; --15자리를 부족한걸 별로 채워라

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
select sysdate from dual; --select하는 순간 현재 날짜와 시간

select sysdate-1,sysdate,sysdate+1 from dual;

--kim 사원이 현재까지 근무한 년 수를 구하시오
select startdate, sysdate,round((sysdate-startdate)/365) ||'년' 년수 from PERSONNEL
where pname='KIM';

--round
select startdate,round(startdate,'year') from PERSONNEL; --7/1 기준
select startdate,round(startdate,'month') from PERSONNEL; --16일 기준

--trunc
select startdate,trunc(startdate,'year') from PERSONNEL;
select startdate,trunc(startdate,'month') from PERSONNEL;

--months_between (달의 수)
select trunc((months_between(sysdate,'2002/06/01'))/12) dal from dual;
select trunc((months_between(sysdate,'2002/06/01'))) dal from dual;

--last_day (말일 구하기)
select startdate,last_day(startdate) from PERSONNEL;


--next_day(돌아오는 날)
select next_day(sysdate,'금요일') from dual;

--add_months(개월 추가)
select add_months(sysdate,24) from dual;



commit;


--변환함수
--TO_CHAR (문자로 바꾼것이므로 연산불가)
/*
MM : 달(10)
MON : 3문자 달이름(MAR)
MONTH : MARCH
DD : 일의 날짜수(22)
D : 주의 일수(2)
DY : 3자의 요일(MON)
DAY : MONTH
RM : 로마식 달수
YYYY : 2022
*/
select sysdate,to_char(sysdate,'MM') from dual;
select sysdate,to_char(sysdate,'d') from dual; --3.화요일(일월화~)
select sysdate,to_char(sysdate,'dy') from dual;
select sysdate,to_char(sysdate,'rm') from dual;
select sysdate,to_char(sysdate,'yyyy') from dual;
select sysdate,to_char(sysdate,'dd') from dual;
select sysdate,to_char(sysdate,'yy-mm-dd') from dual;

select sysdate,to_char(sysdate,'hh24:mi:ss') from dual;
select sysdate,to_char(sysdate,'am hh:mi:ssss') from dual;
select sysdate,to_char(sysdate,'pm hh:mi:ssss') from dual; --(오전일때는 오전이니까 오전이라고 나옴)

select to_char(12506,'99,999') from dual; --문자로 바꾸는거기 때문에 ''로 묶어주기. 연산이 안된다.
select to_char(12506,'099,999') from dual; --자리값 맞추기. 6자리가 안되면 0으로 채워라
select to_char(12506,'9,999') from dual; --자리값이 모자라면 #으로 표시. 자리값 맞추기
select to_char(12506.99,'99,999.99') from dual; --뒤에.99:미국식 센트

select sysdate,to_char(sysdate,'dd') from dual;
select sysdate,to_char(sysdate,'ddsp') from dual;
select sysdate,to_char(sysdate,'ddth') from dual;
select sysdate,to_char(sysdate,'ddspth') from dual; --서수

--TO_DATE
select to_date('22-07-06','yy-mm-dd') from dual; --문자가 날짜로 바뀌는 것
select to_date('22-07-06','yy-mm-dd')+1 from dual; --날짜로 바꼈기 때문에 연산가능
select to_date('11:05','hh24:mi')from dual; --날짜는 그 달의 첫날로 출력

--TO_NUMBER
select to_number('123') from dual;
select to_number('123')+1 from dual; --숫자로 바꼈기 때문에 연산 가능
select to_number('ABC') from dual; --오류.문자는 숫자로 바꿀 수 없다

--NVL
select bonus,nvl(bonus,0) from PERSONNEL;

select manager from PERSONNEL;

select manager,nvl(manager,'NON MANAGER') from PERSONNEL; --오류. manager는 숫자만 들어갈 수 있으므로 문자가 들어갈 수 없음
select manager,nvl(to_char(manager),'NON MANAGER') from PERSONNEL; --to_char로 manager를 문자로 바꿔주면 가능

--DECODE(IF)
--각 사원의 급여를 부서가 10인 경우 10%, 부서가 20인 경우 20%
--나머지는 30%를 인상해서 출력

select pname,bonus,dno,pay,
decode(dno,10,pay*1.1,20,pay*1.2,pay*1.3) 인상분 from PERSONNEL;

--급여가 3500이상인 경우에는 'GOOD'을, 미만인 경우에는 'POOR'를 출력하시오

--sign(연산결과 -> 양수:1,음수:-1,0:0)
select sign(100-20), sign(100-102),sign(100-100) from dual;


select pname,pay,
decode(sign(pay-3500),1,'GOOD','POOR')Grade from PERSONNEL;

select pname,pay,
decode(pay>=3500,'GOOD','POOR')Grade from PERSONNEL; --오류. 부등호는 true/false 반환

--그룹함수. 반드시 하나의 값
--count
select * from PERSONNEL;

select count(*) from PERSONNEL; --데이터의 갯수
select count(manager) from PERSONNEL; --null값은 안셈
select count(bonus) from PERSONNEL;

--급여가 3000이상인 사원 수
select count(*) from PERSONNEL
where pay>=3000;

--AVG
select avg(pay) from PERSONNEL;

--bonus의 평균
select avg(nvl(bonus,0)) from PERSONNEL;

--SUM
select sum(pay) from PERSONNEL;

--MAX/MIN
select max(pay),min(pay) from PERSONNEL;

--입사한지 가장 오래된 사원
select min(startdate) from PERSONNEL;

--입사한지 가장 오래된 사원과 신입사원과의 연차
select round((max(startdate) - min(startdate))/365)년차 from PERSONNEL;

--분석함수

--부서별 평균 구하기
select * from PERSONNEL
order by dno;

select distinct dno,avg(pay) over (partition by dno) "부서별 평균" from PERSONNEL
order by dno;

--월급 순위
select pname,pay,rank() over (order by pay desc) 월급순 from PERSONNEL;

--1200을 받는 사람의 순위
select rank(1200) within GROUP (order by pay desc) rank from PERSONNEL;

select count(*) from PERSONNEL; --단일값을 반환하는 커리
select pname from PERSONNEL; --다중값을 반환
select pname from PERSONNEL
where pay=1600;

select pname,min(startdate) from PERSONNEL;

select pno,pname,startdate from PERSONNEL
where startdate=(select min(startdate) from PERSONNEL);

--부서별 평균 급여를 구하시오 -- ~별 : group by
select dno,avg(pay) from PERSONNEL
group by dno;

--직업별 평균급여, 인원수를 구하시오
select * from PERSONNEL;

select job,round(avg(pay))평균급여,count(*)인원수 from PERSONNEL
group by job;


--각부서의 평균급여가 전체평균급여(2973)보다 크면 'GOOD'
--작으면 'POOR' 출력


select round(avg(pay)) from PERSONNEL;


SELECT dno,avg(pay),
decode(sign(round(avg(pay))-(select round(avg(pay))from PERSONNEL)),'1','Good','POOR') 판정
from PERSONNEL
group by dno;
 

--HAVING : GROUP BY의 조건문
select dno,avg(pay) 평균 from PERSONNEL
group by dno
having avg(pay)>3000;

select dno,avg(pay) 평균 from PERSONNEL
group by dno
having 평균>3000; --오류.별칭 사용 안??

--부서인원이 2명보다 많은 부서의 부서번호, 급여의 합을 구하시오

select dno"부서번호",count(*)"인원수",sum(PAY)"급여의 합" from PERSONNEL
group by dno
having count(*)>2;



-- JOIN문
-- EQUIE JOIN(INNER JOIN)
-- NON-EQUIE JOIN
-- OUTER JOIN
-- CROSS JOIN
-- SELF JOIN

--self join
--직원의 관리자를 매칭

select * from PERSONNEL;

select a.pno 사번,a.pname 직원,b.pno 사번,b.pname 관리자
from PERSONNEL a, PERSONNEL b
where a.manager = b.pno;


-----------------------------------------------------
-- NON-EQUIE JOIN --같지 않은 데이터
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

--UNION/ALL --컬럼의 종류가 같을때(테이블의 구조가 똑같을때)
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
	WHERE 1=2; --조건을 거짓으로 줬기때문에 데이터는 복사안되고 틀만 복사

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

INSERT INTO DIVISION (DNAME,POSITION) VALUES ('ACCOUNT','DAEJUN'); --X DNO에 NULL이 들어가면 안됨
INSERT INTO DIVISION (DNO,DNAME,POSITION) VALUES (70,'ACCOUNT','DAEJUN'); --0
DESC DIVISION;

insert into division(dno) values(60);

DESC personnel;

insert into personnel (pno,pname,pay,dno)
values (7711,'YOUNG',400,20);

SELECT * FROM PERSONNEL;

INSERT INTO DIVISION VALUES(80,'PLANNING','010-123-1234',NULL); --명시적 NULL 삽입
INSERT INTO DIVISION VALUES(90,'SERVICE','010-222-3333','');
SELECT * FROM DIVISION;

SELECT * FROM PERSONNEL;
DESC PERSONNEL;

--Primary Key (중복x nullx 테이블에 하나만)
INSERT INTO PERSONNEL(pno,pname,job,startdate,dno)
values (1304,'suzi','singer',sysdate,10); --그대로 한번 더 저장하면 오류. 중복값이 생기기때문

--치환변수
SELECT PNO,PNAME,JOB,STARTDATE,DNO
FROM PERSONNEL
WHERE DNO=&D_NO;

--SUBQUERY를 사용해서 INSERT

SELECT * FROM MANAGER;

SELECT * FROM PERSONNEL
WHERE JOB = 'MANAGER';

INSERT INTO MANAGER(PNO,PNAME,STARTDATE) --특정데이터만
SELECT PNO,PNAME,STARTDATE
FROM PERSONNEL
WHERE JOB = 'MANAGER';

INSERT INTO MANAGER --모든데이터
SELECT * FROM PERSONNEL
WHERE JOB = 'MANAGER';

--업무가 SALESMAN인 사원의 모든 정보를 SALESMAN테이블로 복사
SELECT * FROM SALESMAN;


SELECT * FROM PERSONNEL
WHERE JOB = 'SALESMAN';

INSERT INTO SALESMAN --이미 테이블이 있어야 한다. AS가 없다
SELECT * FROM PERSONNEL
WHERE JOB = 'SALESMAN';

CREATE TABLE SALESMAN --CREATE는 테이블이 없는 상태에서 만들면서. AS가 있다
AS 
SELECT * FROM PERSONNEL;

--UPDATE
SELECT * FROM PERSONNEL
WHERE PNO='1111';

UPDATE PERSONNEL SET DNO=30 --반드시 WHERE로 조건을 줘야함. 안그러면 모든 DNO값이 30으로 바꿈
WHERE PNO='1111';

UPDATE PERSONNEL SET PNAME='INNA',MANAGER=1004,STARTDATE=SYSDATE,PAY=8000 --반드시 WHERE로 조건을 줘야함. 
WHERE PNO='1111';

SELECT PNO,PNAME,TO_CHAR(STARTDATE,'YYYY-MM-DD')STARTDATE FROM PERSONNEL
WHERE PNO='1111';

SELECT * FROM SAWON;

UPDATE SAWON SET DNO='20'; --WHERE 안쓰면 모든 DNO값이 20으로 바뀜

ROLLBACK; --위에 명령을 취소함. COMMIT 한 후에는 소용없음. INSERT,UPDATE,DELETE 에만 사용 / CREATE는 COMMIT이 같이 있기때문에 소용없음

--SUBQUERY로 UPDATE
SELECT JOB FROM PERSONNEL
WHERE DNO=(SELECT DNO FROM DIVISION WHERE DNAME='SALES'); --DNO=30

UPDATE PERSONNEL SET JOB = 'SALES'
WHERE DNO=(SELECT DNO FROM DIVISION WHERE DNAME='SALES'); --조건

--JOIN문
SELECT A.*
FROM PERSONNEL A,DIVISION B
WHERE A.DNO=B.DNO AND DNAME='SALES';

--JOIN문을 UPDATE문으로 (오라클에서는 실행불가)
UPDATE PERSONNEL SET JOB='SALESMAN' --SELECT문만 바꿔주기
FROM PERSONNEL A,DIVISION B --조건그대로
WHERE A.DNO=B.DNO AND DNAME='SALES'; --조건그대로


ROLLBACK;


----------------------------------------------------------------------
--DELETE

SELECT * FROM PERSONNEL WHERE PNO='1112';
DELETE FROM PERSONNEL WHERE PNO='1111';

SELECT * FROM PERSONNEL WHERE PNO='1112';
DELETE PERSONNEL WHERE PNO='1112'; --FROM 생략 가능

--SUBQUERY로 삭제 --중복되지 않는 값을 가지고 있어야 한다

SELECT * FROM DIVISION;
SELECT * FROM PERSONNEL;

SELECT * FROM PERSONNEL
WHERE DNO=(SELECT DNO FROM DIVISION WHERE DNAME='FINANCE');

DELETE PERSONNEL
WHERE DNO=(SELECT DNO FROM DIVISION WHERE DNAME='FINANCE');

--INSERT ERROR
SELECT * FROM PERSONNEL;

INSERT INTO PERSONNEL (PNO,PNAME,DNO)
VALUES(1113,'INNA',30); --에러 (제약조건에 안맞음) PNO가 중복됨

SELECT * FROM USER_CONSTRAINTS; --제약조건을 보는 명령어

--UPDATE ERROR
SELECT * FROM DIVISION;
SELECT * FROM PERSONNEL;
SELECT * FROM TAB;

INSERT INTO PERSONNEL (PNO,PNAME,DNO)
VALUES(1133,'INNA',51); --제약조건 오류.DNO에 51값이 없음

UPDATE PERSONNEL SET DNO=51
WHERE DNO=20; -- DIVISION으로 가서 20이 있는지 확인 후 있으면 실행

--DELETE ERROR
DELETE DIVISION WHERE DNO=20; --오류(자식인 PERSONNEL에 20이 있기 때문에 부모인 DIVISION에서 20이 지워지면 안됨)
DELETE DIVISION WHERE DNO=50; --가능(자식이 50을 가지고있지 않기때문에 삭제 가능)



COMMIT;

--TRANSACTION

--AUTO COMMIT : 자체적으로 COMMIT
--DDL(CREATE,ALTER,DROP,RENAME)
--DCL(GRANT,REVOKE)
--비정상적인 종료시(ROLLBACK :COMMIT전까지)

--DDL(CREATE,ALTER,DROP)
--OBJECT를 만들때 사용하는 명령어
--OBJECT(TABLE,INDEX,SYNONYM,SEQUENCE,VIEW)

--TABLE
--DATA TYPE
--CHAR : 문자(고정길이) 이름,우편번호 / 저장공간의 낭비가 있다
--VARCHAR : 문자(가변길이) 주소 / 저장공간의 낭비가 없음 대신 작업이 느려질 수 있다는 단점
--NUMBER(P,S) : 숫자(가변길이) (P전체자릿수,S소숫점자리)
--DATE : 날짜,시간(고정길이)
--LONG : 문자(가변길이 2G)

CREATE TABLE BUSEO2
(DNO NUMBER(2),
DNAME VARCHAR(14),
ZIPCODE CHAR(7));

DESC BUSEO1; --환경설정
INSERT INTO BUSEO1 VALUES(10,'AAA','123-123');
SELECT * FROM BUSEO1;


--테이블 이름
--반드시 영문자로 시작
--특수문자(_,$,#)
--중복허용 불가
--컬럼명과 달라야 한다
--예약어(INSERT,VALUES etc...) 사용 못함

--SAWON,P_NO,DIV10, (O)
--10DIV(영문자시작아님),$SAL(영문자시작아님),ALTER(예약어임) (X)

CREATE TABLE CUSINFO
(ID CHAR(5) PRIMARY KEY, --아이디에 중복값 넣을 수 없다
NAME CHAR(10),
JUMIN CHAR(14),
AGE NUMBER(3),
ADDR VARCHAR2(100));

DESC CUSINFO;

INSERT INTO CUSINFO VALUES('A100','SUZI','123456-1234567',27,'서울');
SELECT * FROM CUSINFO;

SELECT * FROM USER_CONSTRAINTS;

----------------------------------------------
--년월일 추출

SELECT STARTDATE,
EXTRACT(YEAR FROM STARTDATE)YEAR,
EXTRACT(MONTH FROM STARTDATE)MONTH,
EXTRACT(DAY FROM STARTDATE)DAY
FROM PERSONNEL;

COMMIT;

----------------------------------------------

--데이터 초기화
create table SALESMAN1
AS
select pno,pname,job,pay from PERSONNEL
where job = 'SALESMAN';


select * from user_constraints;


select * from SALESMAN1;

DESC SALESMAN1;

--PERSONNEL 테이블에서 업무가 MANAGER인 사원의 모든 내용을
--새로운 테이블인 MANAGER1에 생성

CREATE TABLE MANAGER1
AS
SELECT * FROM PERSONNEL
WHERE JOB='MANAGER';

SELECT * FROM MANAGER1;

--PAY가 3000이상인 직원의 데이터를 PAY3000테이블로 생성
CREATE TABLE PAY3000
AS
SELECT * FROM PERSONNEL
WHERE PAY>=3000;

SELECT * FROM PAY3000;

--PERSONNEL 테이블에서 12월달에 입사한 사람을
--MON12이란 테이블로 생성


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



--부서번호가 10인 부서의 총 급여의 정보를 DIV10테이블로 만드시오



CREATE TABLE DIV10
AS
SELECT DNO,SUM(PAY) SUM_PAY FROM PERSONNEL 
GROUP BY DNO
HAVING DNO=10;

SELECT * FROM DIV10;

-- 테이블 구조 복사 (WHERE 조건을 거짓으로 주면 데이터는 복사되지 않고 구조만 복사)
SELECT * FROM PERSONNEL;


CREATE TABLE SAWON1
AS
SELECT * FROM PERSONNEL
WHERE 0=1;

SELECT * FROM SAWON1;
DESC PERSONNEL;
DESC SAWON1; --제약조건은 복사가 안돼서 PNO의 PRIMARY KEY는 복사안?

-- 테이블 수정

SELECT * FROM SALESMAN1;
DESC SALESMAN1;

--ADD(컬럼 추가) 두개이상 컬럼 추가는 반드시 ()로 묶어주기 --좋은 테이블이 아님 : 테이블을 만든 후 컬럼을 추가했으므로
ALTER TABLE SALESMAN1
ADD (DNO NUMBER(2)); 

INSERT INTO SALESMAN1 VALUES(1234,'SUZI','SALESMAN',3000,10); --L TABLE(최악의 테이블1. NULL값)

ALTER TABLE SALESMAN1
ADD (JUMIN CHAR(14),ZIP CHAR(7));

INSERT INTO SALESMAN1 VALUES(4444,'INNA','SALESMAN',2000,10,'1234','1234'); --계단식 테이블(최악의 테이블2)


ALTER TABLE SALESMAN1 --컬럼 추가하면서 기본값 넣기(DEFAULT)
ADD BIGO VARCHAR2(10) DEFAULT('AA');

CREATE TABLE CUSINFO
(ID NUMBER(3) CONSTRAINT CUSINFO_ID_PK PRIMARY KEY, --테이블 만들면서 제약조건 넣기
NAME CHAR(10),
BIRTH DATE DEFAULT SYSDATE);

INSERT INTO CUSINFO VALUES (111,'SUZI'); --오라클에서는 오류. BIRTH를 안넣었기때문에
INSERT INTO CUSINFO(ID,NAME) VALUES (111,'SUZI');

SELECT * FROM CUSINFO;

ALTER TABLE SALESMAN1
ADD (MARRIAGE CHAR(8) CONSTRAINT SALESMAN1_MARRIAGE_CK
CHECK (MARRIAGE IN ('SINGLE','MARRIED')));

SELECT * FROM SALESMAN1;
INSERT INTO SALESMAN1
VALUES(5555,'INSUN','SALESMAN',2000,10,'1234','1234','BB','SOLO'); --오류. 제약조건 위반


SELECT * FROM SALESMAN1;
INSERT INTO SALESMAN1
VALUES(5555,'INSUN','SALESMAN',2000,10,'1234','1234','BB','SINGLE'); --성공

SELECT * FROM SALESMAN1;


DESC SALESMAN1;
SELECT * FROM USER_CONSTRAINTS;

ALTER TABLE SALESMAN1 --제약조건이 없는 기존 테이블에 제약조건 추가해주기
ADD CONSTRAINT SALESMAN1_PNO_PK PRIMARY KEY(PNO); --컬럼명 명시(PNO)



--PRIMARY KEY (NULL값 X, 중복불가, 테이블에서 유일한 값을 가지는 하나만)
--UNIQUE KEY (중복불가,NULL허용(오라클은 여러번),256개까지 여러개 만들 수 있음.)
--CHECK KEY (조건주기)
--NOT NULL KEY (반드시 NULL값 허용 안함. 이름,과목명 등등)
--FOREIGN KEY (부모한테 데이터가 있는지. 부모와 제약조건 똑같이.
--             부모는 PK 또는 UK --중복값을 허용하지 않기때문에. EX.과목을 여러가지 선택해야하는 경우를 없애기 위해)
  

SELECT * FROM USER_CONSTRAINTS; --DICTIONARY의 종류. 끝은 항상 복수.

ALTER TABLE MANAGER1
ADD COMM NUMBER(5);

SELECT * FROM TAB;
DESC MANAGER1;

SELECT * FROM MANAGER1;

ALTER TABLE MANAGER1
ADD CONSTRAINT MANAGER1_PNO_PK PRIMARY KEY (PNO);


--MODIFY(컬럼 수정)
SELECT * FROM MANAGER1;
DESC MANAGER1;

ALTER TABLE MANAGER1
MODIFY PNAME VARCHAR2(16);

ALTER TABLE MANAGER1
MODIFY PNAME VARCHAR2(5); --에러. 기존에 들어있는 데이터에 5보다 큰 데이터가 있기때문에.

ALTER TABLE MANAGER1
MODIFY PNAME VARCHAR2(7); --가능

ALTER TABLE MANAGER1
MODIFY PNAME VARCHAR2(7) NOT NULL; --PNO의 NOT NULL과 다르다.(PNO는 PRIMARY KEY를 줘서 NOT NULL)

--DROP(컬럼이나, 제약조건 삭제)
SELECT * FROM MANAGER1;
DESC MANAGER1;
SELECT * FROM USER_CONSTRAINTS;

ALTER TABLE MANAGER1
DROP CONSTRAINT MANAGER1_PNO_PK; -- 1. 이름으로 지우는 방법

ALTER TABLE SALESMAN1
DROP PRIMARY KEY; -- 2. PRIMARY KEY는 테이블에 하나이므로 굳이 이름으로 안지워도 가능


ALTER TABLE DIVISION --부모
DROP CONSTRAINT DIVISION_DNO_PK; --PERSONNEL(자식)이 참조하고 있기 때문에 오류. 부모PK를 지우려면 참조하는 자식의 FK도 지워야함 

ALTER TABLE DIVISION --부모
DROP CONSTRAINT DIVISION_DNO_PK CASCADE; -- CASCADE : DIVISION PK, PERSONNEL FK 동시에 지워짐

--컬럼삭제
SELECT * FROM SALESMAN1;
SELECT * FROM USER_CONSTRAINTS;
DESC SALESMAN1;

ALTER TABLE SALESMAN1
DROP COLUMN MARRIAGE; --데이터가 있어도 지워짐

ALTER TABLE SALESMAN1
SET UNUSED COLUMN DNO; -- SET UNUSED : 일시적으로 컬럼 안보이게 하는 명령어. 삭제한것이 아님. 숨긴것.

ALTER TABLE SALESMAN1
DROP UNUSED COLUMN; --전에 UNUSED 한것 지움. 컬럼명 써줄 필요 없다.

SELECT * FROM DBA_UNUSED_COL_TABS; --일반사용자는 볼수없음.

SELECT COUNT(*) FROM DICTIONARY;

--DROP(테이블 삭제)
SELECT * FROM TAB;

DROP TABLE SALESMAN1;

SELECT * FROM RECYCLEBIN;

DROP TABLE SALESMAN1;

--복구방법

FLASHBACK TABLE "BIN$uXvaRbhZRvmmIu5D3yeEzw==$0" TO BEFORE DROP; -- 1.

FLASHBACK TABLE SALESMAN1 TO BEFORE DROP; --2.

SELECT * FROM 'BIN$YaMC0+LsQmelsQLyXd89yQ==$0'; --복구 후 데이터 보기

PURGE RECYCLEBIN; --완전삭제

DROP TABLE MANAGER1 PURGE; --쓰레기통에 넣지 않고 바로 지움

COMMIT;

--레코드 삭제
--TRUNCATE / DELETE

SELECT * FROM CUSINFO;

DELETE CUSINFO;

SELECT * FROM CUSINFO;

ROLLBACK; --살려내기

SELECT * FROM CUSINFO;

COMMIT;

--TRUNCATE (되살릴 수 없음. TRANSACTION이 없음.)

TRUNCATE TABLE CUSINFO; --데이터를 지움.

ROLLBACK; --되살릴 수 없음. TRANSACTION이 없음.


--RENAME (테이블 이름 변경)

SELECT * FROM TAB;


SELECT * FROM PAY3000;

RENAME PAY3000 TO HIGHPAY;

-- 테이블에 컬럼이름을?변경
--ALTER?TABLE?테이블명?RENAME COLUMN 이전컬럼명?TO 바꿀컬럼명
--EX1)?ALTER?TABLE?EMP?RENAME COLUMN?EMP_ADDR?TO?EMP_ADDR1;?-- EMP 테이블에 EMP_ADDR이라는 컬럼명을?EMP_ADDR1으로 변경


--COMMENT (주석 다는 방법)
SELECT * FROM USER_TAB_COMMENTS; --테이블 주석 확인

COMMENT ON TABLE HIGHPAY
IS '월급 많이 받는 사람';

COMMENT ON TABLE HIGHPAY
IS ''; --내용 지우기

COMMENT ON COLUMN HIGHPAY.PAY
IS '실수령 금액';

SELECT * FROM USER_COL_COMMENTS; --컬럼 주석 확인

COMMENT ON COLUMN HIGHPAY.BONUS
IS '올해 보너스 없다';

--DCL(GRANT,REVOKE)
--GRANT : USER나 OBJECT에 권한을 부여할때 사용
--REVOKE : USER나 OBJECT에 권한을 회수할때 사용

CREATE USER YOUNG
IDENTIFIED BY YOUNG
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP; --KIM도 계정 만들 수 있음. SYS에서 GRANT CREATE USER 권한 줌.

--OBJECT 권한
GRANT SELECT ON PERSONNEL TO TEST; --KIM이 TEST한테
GRANT SELECT,INSERT,DELETE ON DIVISION TO TEST; --KIM이 TEST한테

SELECT * FROM USER_TAB_PRIVS_MADE;
REVOKE SELECT ON PERSONNEL FROM TEST; 

REVOKE SELECT ON DIVISION FROM TEST; 

REVOKE INSERT ON DIVISION FROM TEST;

REVOKE DELETE ON DIVISION FROM TEST;


CREATE ROLE KIMOBJ;

GRANT SELECT,INSERT,DELETE ON DIVISION TO KIMOBJ; --role에 SELECT,INSERT,DELETE 담아줌
GRANT KIMOBJ TO lee; --lee한테 KIMOBJ이라는 ROLE을 줌. (LEE는 SELECT,INSERT,DELETE 사용가능)

SELECT * FROM ROLE_SYS_PRIVS; --현재 KIM이 가지고 있는 ROLE의 종류

------------------------------


--제약조건(CONSTRAINT) : 무결성(알고있기)
--PRIMARY KEY(PK)
--FOREIGN KEY(FK)
--UNIQUE KEY(UK)
--NOT NULL(NN)
--CHECK KEY(CK)

--PRIMARY KEY (NULL값 X, 중복불가, 테이블에서 유일한 값을 가지는 하나만)
--UNIQUE KEY (중복불가,NULL허용(오라클은 여러번),256개까지 여러개 만들 수 있음.)
--CHECK KEY (조건주기)
--NOT NULL KEY (반드시 NULL값 허용 안함. 이름,과목명 등등)
--FOREIGN KEY (부모한테 데이터가 있는지. 부모와 제약조건 똑같이.
--             부모는 PK 또는 UK --중복값을 허용하지 않기때문에. EX.과목을 여러가지 선택해야하는 경우를 없애기 위해)
  





COMMIT;



