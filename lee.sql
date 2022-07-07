--LEE
select * from tab;
select * from sales;

select * from custom;

select username, rpad(substr(jumin,1,8),14,'*') jumin from custom;

select * from custom
where addr1 like '%광역시%' and point >=500 order by AGE;

select age, trunc(age,-1) 반올림나이 from custom;

select regdate,last_day(regdate)from custom;

select regdate,next_day(regdate,'토요일') from custom;

select regdate,round((sysdate-regdate)/365)||'년' 년수 from custom;

select regdate,add_months(regdate,13) from custom;

select addr1||' '||addr2||' '||addr3 주소 from custom;

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
WHEN '1' THEN '남자' --ELSE '여자'
WHEN '0' THEN '여자'
END GENDER,
COUNT(*),ROUND(AVG(AGE))AVG_AGE
FROM CUSTOM
GROUP BY SEX;

--케이스문의 문법 
SELECT 
CASE 컬럼명
WHEN 1 THEN 100
WHEN 2 THEN 200
WHEN 3 THEN 300
WHEN 4 THEN 400
ELSE 500
END AS 별칭,
FROM DUAL;

SELECT 
CASE 컬럼명 WHEN 1 THEN 100 ELSE 0,
CASE 컬럼명 WHEN 2 THEN 200 ELSE 0,
CASE 컬럼명 WHEN 3 THEN 300 ELSE 0,
CASE 컬럼명 WHEN 4 THEN 400 ELSE 0,
FROM DUAL;

--위에방식이 안됨 
SELECT 
CASE ADDR1 WHEN '서울특별시' THEN '서울'
WHEN '경기도' THEN '경기'
WHEN '경상남도' THEN '경남'
END ADDR
FROM CUSTOM;

--JOIN문 
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

--EQUIE조인(INNER JOIN)
SELECT A.USERID,USERNAME 이름,AGE,ADDR1,B.USERID,COMPANY,PAY
FROM CUSTOM A,COMPANY B --테이블에 별칭 줄때 AS 사용할 수 없음
WHERE A.USERID = B.USERID;

SELECT A.USERID,USERNAME 이름,AGE,ADDR1,B.USERID,COMPANY,PAY
FROM CUSTOM A INNER JOIN COMPANY B --테이블에 별칭 줄때 AS 사용할 수 없음
ON A.USERID = B.USERID;

--'CUSTOM'에서 USERID, USERNAME을 검색하고 POINT 테이블에서 제품 구입,
--로그인에 관계된 POINT 점수 (PRODUCT,LOGIN)을 검색

SELECT A.USERID,USERNAME,PRODUCT,LOGIN
FROM CUSTOM A, POINT B
WHERE A.USERID = B.USERID AND LOGIN >=10;

SELECT A.USERID,USERNAME,PRODUCT,LOGIN
FROM CUSTOM A INNER JOIN POINT B
ON A.USERID = B.USERID --AND LOGIN >=10;  --JOIN사용시 : ON 뒤에 AND로 붙여도 되고 WHERE를 사용해도됨
WHERE LOGIN >=10;

---------------------<외부조인>----------------------------
SELECT COUNT(*) FROM CUSTOM; --459
SELECT COUNT(*) FROM COMPANY; --464

SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A, COMPANY B
WHERE A.USERID = B.USERID; --AND B.COMPANY IS NULL;


SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A, COMPANY B
WHERE A.USERID = B.USERID(+) --(+)없으면 널 값 안나옴
ORDER BY B.COMPANY DESC;
--같음
SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A LEFT OUTER JOIN COMPANY B
ON A.USERID = B.USERID
ORDER BY B.COMPANY DESC;


SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A, COMPANY B
WHERE A.USERID(+) = B.USERID
ORDER BY A.USERID DESC;
--같음
SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM


------------------------------------------------------------
SELECT * FROM CUSTOM;

SELECT ADDR1,COUNT(*),ROUND(AVG(POINT)),COUNT(*) FROM CUSTOM
GROUP BY ADDR1;

SELECT--≒Oracle의 switch문
CASE SEX
WHEN '1' THEN '남자' ELSE '여자'
--WHEN '0' THEN '여자'
END GENDER,
COUNT(*),ROUND(AVG(AGE)) FROM CUSTOM
GROUP BY SEX;

SELECT SEX,COUNT(*),ROUND(AVG(AGE)) FROM CUSTOM
GROUP BY SEX;

SELECT
CASE 컬럼명
   WHEN 1 THEN 100
   WHEN 2 THEN 200
   WHEN 3 THEN 300
   WHEN 4 THEN 400
   ELSE 500
END AS 별칭
FROM DUAL;--CASE문법. 이런게 있다는걸 보여줌. 실행은 안됨

SELECT
CASE 컬럼명 WHEN 1 THEN 100 ELSE 0,
CASE 컬럼명 WHEN 2 THEN 200 ELSE 0,
CASE 컬럼명 WHEN 3 THEN 300 ELSE 0,
CASE 컬럼명 WHEN 4 THEN 400 ELSE 0,
FROM DUAL;--이런게 있다는걸 보여줌. 실행은 안됨

SELECT * FROM CUSTOM;

SELECT
CASE ADDR1
WHEN '서울특별시' THEN '서울'
WHEN '경기도' THEN '경기'
WHEN '경상남도' THEN '경남'
END ADDR
FROM CUSTOM;

--JOIN문 : 지금까지는 하나의 TABLE에서만 SELECT했는데,
--         JOIN문에서는 하나 이상의 TABLE에서 SELECT할 수 있다
--EQUIE JOIN(INNER JOIN)
--NON-EQUIE JOIN
--OUTER JOIN
--CROSS JOIN
--SELF JOIN

SELECT * FROM TAB;

--공통 calumn이 USERID→공통 calumn이 있어야 JOIN이 가능하다
/*
CUSTOM-USERID,USERNAME,AGE 와
COMPANY-COMPANY,PAY 를 가져오고 싶음
→CUSTOM과 COMPANY의 공통분모가 있어야 한다
→CUSTOM.USERID=COMPANY.USERID
*/
SELECT * FROM CUSTOM WHERE USERID='nu7634';
SELECT * FROM COMPANY WHERE USERID='nu7634';--(만들때 참고)TABLE과 Calumn명이 달라야한다
SELECT * FROM POINT WHERE USERID='nu7634';
SELECT * FROM SALES WHERE USERID='nu7634';

--여러 TABLE에 중복되는 Calumn이 있을 때, TABLER과 Calumn명을 구분하려면 .을 이용한다.
--한 TABLE에만 있는 Calumn은 구분할 필요 없다
SELECT CUSTOM.USERID,USERNAME,AGE,ADDR1,COMPANY.USERID,COMPANY,PAY--방법①
FROM CUSTOM,COMPANY
WHERE CUSTOM.USERID = COMPANY.USERID;

--EQUIE JOIN(INNER JOIN)
SELECT A.USERID,USERNAME,AGE,ADDR1,B.USERID,COMPANY,PAY
--FROM CUSTOM AS A,COMPANY AS B--TABLE에는 별칭을 쓸때는 AS를 쓰지 않는다
FROM CUSTOM A,COMPANY B--방법② 多
WHERE A.USERID = B.USERID;

--※select의 조건문은 where, group by의 조건문은 having, join문의 조건문은 on
SELECT A.USERID,USERNAME,AGE,ADDR1,B.USERID,COMPANY,PAY
FROM CUSTOM A INNER JOIN COMPANY B--방법③. INNER은 생략가능
ON A.USERID = B.USERID;

--'CUSTOM'에서 UserID, UserName을 검색하고 POINT 테이블에서 제품 구입,
--로그인에 관계된 POINT 점수(Product, Login)를 검색
SELECT A.USERID,USERNAME,PRODUCT,LOGIN
FROM CUSTOM A, POINT B
WHERE A.USERID = B.USERID;

--위와 동일한데 로그인이 10회 이상인 사람만 검색
SELECT A.USERID,USERNAME,PRODUCT,LOGIN
FROM CUSTOM A, POINT B
WHERE A.USERID = B.USERID AND LOGIN>=10;

SELECT A.USERID,USERNAME,PRODUCT,LOGIN
FROM CUSTOM A INNER JOIN POINT B
ON A.USERID = B.USERID AND LOGIN>=10;--방법① JOIN & ON

SELECT A.USERID,USERNAME,PRODUCT,LOGIN
FROM CUSTOM A INNER JOIN POINT B
ON A.USERID = B.USERID
WHERE LOGIN>=10;--방법② SELECT & WHERE

---------------------------------------------
--OUTER JOIN(외부조인)
--누가 물건을 안 샀는지 알고 싶음→ex: 할인쿠폰/이메일 보냄

SELECT COUNT(*) FROM CUSTOM;--459
SELECT COUNT(*) FROM COMPANY;--464→데이터의 개수가 다르다→어느쪽을 기준으로 하는지에 따라 개수가 달라짐

SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A, COMPANY B
WHERE A.USERID = B.USERID(+) AND B.COMPANY IS NULL;


SELECT * FROM CUSTOM;--459
SELECT * FROM COMPANY;



SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A, COMPANY B
WHERE A.USERID = B.USERID(+)--CUSTOM를 기준(대각선에 +넣음)
ORDER BY B.COMPANY DESC;--회사정보 TABLE에는 NULL인 값들이 생김

SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A, COMPANY B
WHERE A.USERID(+) = B.USERID--COMPANY를 기준(대각선에 +넣음)
ORDER BY B.COMPANY DESC;--회사정보 TABLE에는 NULL인 값들이 생김

---------------------------------------------
SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A LEFT OUTER JOIN COMPANY B--안시 표준 기준
ON A.USERID = B.USERID--왼쪽에 있는 애(CUSTOM)를 기준(대각선에 +넣음)
ORDER BY B.COMPANY DESC;--회사정보 TABLE에는 NULL인 값들이 생김

SELECT A.USERID,USERNAME,ADDR1,COMPANY,DEPT
FROM CUSTOM A RIGHT OUTER JOIN COMPANY B
ON A.USERID = B.USERID--오른쪽에 있는 애(COMPANY)를 기준(대각선에 +넣음)
ORDER BY B.COMPANY DESC;--회사정보 TABLE에는 NULL인 값들이 생김

--CROSS JOIN(상호 조인) : 많은 양의 데이터를 사용할 때 사용. 그 외에 큰 의미는 없다
--212976 rows(459, 464가 매치됨)
SELECT A.USERID,USERNAME,AGE,ADDR1,B.USERID,COMPANY,PAY--방법①
FROM CUSTOM A,COMPANY B;

SELECT A.USERID,USERNAME,AGE,ADDR1,B.USERID,COMPANY,PAY--방법②
FROM CUSTOM A CROSS JOIN COMPANY B;--안시

SELECT A.USERID,USERNAME,AGE,ADDR1,B.USERID,COMPANY,PAY
FROM CUSTOM A cross JOIN COMPANY B
where A.USERID = B.USERID;--INNER JOIN(CROSS JOIN밑에 WHERE 적으면 INNER JOIN이 된다)

--SELF JOIN
--똑같은걸 올려두고
--→지금까지는 CUSTOM-COMPANY 식으로 했는데, SELF JOIN은 CUSTOM-CUMSTOM 식으로 적어야함

SELECT * FROM CUSTOM--이름이 중복되는 사람 찾고 싶음
ORDER BY USERNAME;

--이름은 같으면서 ID는 달라야함→동명이인 제거. +DISTINCT→동명삼인 제거
SELECT DISTINCT A.*--한쪽의 모든 Calumn만을 가져옴. ※DISTINCT: 동명삼인을 제거함(얘는 공식이라서 외우기!)
FROM CUSTOM A,CUSTOM B
WHERE A.USERNAME = B.USERNAME
AND A.USERID<>B.USERID--동명이인 제거함. 이거 없으면 USERID가 중복되서 나옴. ex: 김성섭 P김-P김,8김. 8김-P김,8김으로 총 4번 비교하니까 USERID가 똑같은것도 4번 나옴→USERID는 달라야함
ORDER BY A.USERNAME;

--'CUSTOM' 테이블에서 '제주도'에 살고 있는 사람 중에 동일한 이름을 갖는 행을 검색
SELECT A.*
FROM CUSTOM A INNER JOIN CUSTOM B
ON A.USERNAME = B.USERNAME
WHERE A.USERID<>B.USERID AND A.ADDR1 = '제주도'
--AND A.ADDR1 = B.ADDR1--충청도와 제주도의 동일한 이름을 가진 '노영훈' 제거
AND B.ADDR1 = '제주도';

--3개 이상의 테이블 조인
--CUSTOM : USERID,USERNAME
--COMPANY : COMPANY,DEPT
--POINT : PRODUCT,LOGIN

SELECT A.USERID,USERNAME,COMPANY,DEPT,PRODUCT,LOGIN--방법①
FROM CUSTOM A, COMPANY B, POINT C
WHERE A.USERID = B.USERID AND A.USERID = C.USERID;

SELECT A.USERID,USERNAME,COMPANY,DEPT,PRODUCT,LOGIN--방법② INNER JOIN
FROM CUSTOM A INNER JOIN COMPANY B
ON A.USERID = B.USERID INNER JOIN POINT C
ON A.USERID = C.USERID;

--파생 테이블과 JOIN
--파생 테이블 : 실제로 존재하지 않는 테이블

--아이디별로 판매횟수와 판매금액의 합 검색
SELECT * FROM SALES;

SELECT USERID,COUNT(*) CNT,SUM(PRICE) HAP
FROM SALES
GROUP BY USERID;

--그 중에서 150만원 이상 산 사람만 검색
SELECT USERID,COUNT(*) CNT,SUM(PRICE) HAP
FROM SALES
GROUP BY USERID
HAVING SUM(PRICE)>=1500000;--여기에는 별칭 쓸 수 없어서, HAP 적을 수 없다

--150만원 이상 산 사람들이 얼만큼 샀는지 합계를 알고 싶음
--INLINE-VIEW : 실제 있는 데이터와 JOIN을 해서 만들어 냄
--공통조건인 USERID가 있어야 함
SELECT A.USERID,USERNAME,ADDR1,CNT,HAP
FROM CUSTOM A,(
SELECT USERID,COUNT(*) CNT,SUM(PRICE) HAP--실제로 존재하지 않는 데이터. 파생테이블을 B, 실제테이블을 A라고 둠
FROM SALES
GROUP BY USERID
HAVING SUM(PRICE)>=1500000
) B
WHERE A.USERID = B.USERID;

------------------------------
SELECT * FROM CUSTOM;

--테이블 만드는 방법
CREATE TABLE JEJU--분류해서 빼냄
AS
SELECT * FROM CUSTOM WHERE ADDR1='제주도';--CUSTOM의 ADDR1이 제주도인 사람을 빼서 JEJU라는 TABLE에 넣음

CREATE TABLE SEOUL
AS
SELECT * FROM CUSTOM WHERE ADDR1='서울특별시';

CREATE TABLE KYUNG
AS
SELECT * FROM CUSTOM WHERE ADDR1='경기도';

SELECT * FROM TAB;

--테이블마다 따로따로 저장해야함
SELECT * FROM JEJU;
SELECT * FROM SEOUL;
SELECT * FROM KYUNG;

SELECT * FROM JEJU--제주와 서울에 사는 사람들
UNION
SELECT * FROM SEOUL;--Query는 내가 원하는 것을 나눠서가 아니라 한번에 가져와야함→UNION 사용(Calumn은 똑같아야함)
--(똑같은 Calumn이라서) 같은 모양의 Table들을 합칠 때 UNION 사용

SELECT * FROM JEJU
UNION
SELECT * FROM SEOUL
UNION
SELECT * FROM KYUNG;--primary key순으로 정렬됨

---------------------------------------------------------------------------------------

--SUBQUERY(하위쿼리)

--COMPANY 테이블에서 USERID,COMPANY,DEPT,PAY,평균월급
select * from company;

select round(avg(pay))a_pay from company;

select USERID,COMPANY,DEPT,PAY,
(select round(avg(pay))a_pay from company a_pay) -- 하위쿼리는 ()안에 꼭 넣어야함
from company;

--custom테이블에서 평균 나이보다 많은 사원의 정보 검색
select * from custom;

select round(avg(age)) from custom; --29
select * from custom where age>=29;
select * from custom where age>=(select round(avg(age)) from custom); --비교하는 컬럼 갯수 맞추기
--                        age           =         age(컬럼 종류와 갯수도 동일)


--현대자동자 그룹에 근무하는 직원

select * from company
where company like '현대자동차%';

--그 직원의 아이디
select userid from company
where company like '현대자동차%';

--그 직원의 전체정보
select * from CUSTOM
where USERID in (select userid from company where company like '현대자동차%');
--    userid       =    userid (일치)


select A.*
from custom A ,company B
where a.userid=b.userid and company like '현대자동차%';

--4회 이상 판매 기록이 있는 고객들의 기본 정보를 검색

--내가한거
select * from sales;

select userid, count(*)횟수 from sales 
group by userid;


select A.*
from custom A,
(select userid, count(*)횟수 from sales 
group by userid) B
where a.userid=b.userid and 횟수>=4;
-------------------------------------------------------

--수업시간 답

select userid, count(*)횟수 from sales 
group by userid
having count(*)>=4;


select * from CUSTOM
where userid IN (select userid from sales 
group by userid
having count(*) >=4);


select A.*,횟수
from custom A,
(select userid, count(*)횟수 from sales 
group by userid
having count(*) >=4) B
where a.userid=b.userid;

-----------------------------------------------------

--ANY(범위가 포함),ALL(범위가 미포함)
-- >ANY : 최소값보다 큰 데이터
-- <ANY : 최대값보다 작은 데이터
-- >ALL : 최대값보다 큰 데이터
-- <ALL : 최소값보다 작은 데이터

select point from CUSTOM
where addr1='제주도' order by point; --132/269

select * from CUSTOM
where point >any (select point from CUSTOM where addr1='제주도');

select * from CUSTOM
where point > (select min(point) from CUSTOM where addr1='제주도'); --제주도에 사는 사람 포인트중에서 가장 작은 사람

-------------------------------------------------------------------------

select * from CUSTOM
where point <any (select point from CUSTOM where addr1='제주도');

select * from CUSTOM
where point < (select max(point) from CUSTOM where addr1='제주도');

-----------------------------------------------------------------------------

select * from CUSTOM
where point >all (select point from CUSTOM where addr1='제주도');

select * from CUSTOM
where point > (select max(point) from CUSTOM where addr1='제주도');


-----------------------------------------------------------------------------

select * from CUSTOM
where point <all (select point from CUSTOM where addr1='제주도');

select * from CUSTOM
where point < (select MIN(point) from CUSTOM where addr1='제주도');


UPDATE CUSTOM SET POINT = 130 WHERE USERID='nu7634';--기존데이터 업데이트


-----------------------------------------------
select point from custom where age>=70; --결과없음

select * from CUSTOM
where point >any (select point from custom where age>=70); -- any : 하위커리의 결과가 없기때문에 상위커리 결과도 안나옴
--상위커리        하위쿼리

select * from CUSTOM
where point >all (select point from custom where age>=70); --all : 하위쿼리가 없을때 all은 크건 작건 모든 데이터가 나옴. age>=70라고 생각하면 안됨

---------------------------------------------------------------------------

select * from CUSTOM
where USERID in (select userid from company where company like '현대자동차%');

select * from CUSTOM
where USERID =any (select userid from company where company like '현대자동차%'); -- in 과 =any는 같다 

---------------------------------------------------------------------------

select * from CUSTOM
where USERID not in (select userid from company where company like '현대자동차%'); --현차 근무하지 않는 사람

select * from CUSTOM
where USERID <>any (select userid from company where company like '현대자동차%'); --XXXXXXXXXXX not in =/ <>any

select * from CUSTOM
where USERID <>all (select userid from company where company like '현대자동차%'); --사용OOOOOOOO not in = <>all


---------------------------------------------------------------------------
--하위쿼리
select userid,username,addr1,schol from CUSTOM
where userid IN (select userid from company where company like '현대자동차%');

select userid from company where company like '현대자동차%'; --실행가능

--상관쿼리
select userid,username,addr1,schol from CUSTOM
where EXISTS
(select * from company where userid=custom.userid and company like '현대자동차%');

select * from company where userid=custom.userid and company like '현대자동차%'; --실행불가능

-------------------------------------------------------------------------------
select * from custom
where addr1 = '경기도';

select * from (select * from custom where addr1='경기도') A;

------------------------------------
select * from custom
where addr1 = '경기도' and age<=20; --경기도에 살면서 나이가 20살보다 적은사람

select * from (select * from custom where addr1='경기도') A
where age<=20;

------------------------------------

--DML(INSERT,UPDATE,DELETE)


COMMIT;





