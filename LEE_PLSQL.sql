DECLARE
TYPE FIRSTTYPE IS RECORD -- RECORD를 담는 변수이름:FIRSTTYPE
(A 사원.사원명%TYPE, B 사원.직급%TYPE, C 사원.급여%TYPE);

CUS FIRSTTYPE; --CUS : 변수선언

BEGIN 
SELECT 사원명,직급,급여 INTO CUS FROM 사원 WHERE 사원번호=2001;

DBMS_OUTPUT.PUT_LINE('사원명 직급 급여');
DBMS_OUTPUT.PUT_LINE('----------------');
DBMS_OUTPUT.PUT_LINE(CUS.A||'  '||CUS.B||'  '||TO_CHAR(CUS.C)); --숫자연결은 에러생김
DBMS_OUTPUT.PUT_LINE('질의한 사용자: '||USER||'입니다'); --USER:시스템 변수
DBMS_OUTPUT.PUT_LINE('질의한 시간: '||TO_CHAR(SYSDATE,'YYYY-MM-DD HH:MI:SS'));

END;


-----------------------------------------------------------------------
--전체 줄

DECLARE
SAWON_RECORD 사원%ROWTYPE;
BEGIN
SELECT * INTO SAWON_RECORD FROM 사원 WHERE 사원번호=2001;
DBMS_OUTPUT.PUT_LINE('사원번호: '||SAWON_RECORD.사원번호);
DBMS_OUTPUT.PUT_LINE('사원명: '||SAWON_RECORD.사원명);
DBMS_OUTPUT.PUT_LINE('주소: '||SAWON_RECORD.주소);
DBMS_OUTPUT.PUT_LINE('급여: '||SAWON_RECORD.급여);
END;
/

---------------------------------------------------------------
--컬럼값 데려오기

K : SELECT 사원명,직급 FROM 사원 (담는 변수)
I : 순서INDEX 변수

DECLARE
TYPE NAME_TYPE IS TABLE OF 사원.사원명%TYPE
INDEX BY BINARY_INTEGER; --인덱스값 부여
TYPE JIK_TYPE IS TABLE OF 사원.직급%TYPE
INDEX BY BINARY_INTEGER;--인덱스값 부여

SANAME_COL NAME_TYPE; --변수만듦
SAJIK_COL  JIK_TYPE; --변수만듦
I BINARY_INTEGER :=0; --변수초기화

BEGIN
FOR K IN (SELECT 사원명,직급 FROM 사원) LOOP -- K : SELECT 사원명,직급 FROM 사원 (담는 변수)
I := I+1; --I : 순서INDEX 변수 I++
SANAME_COL(I) := K.사원명;
SAJIK_COL(I) := K.직급;
END LOOP;

DBMS_OUTPUT.PUT_LINE('사원명  직급');
DBMS_OUTPUT.PUT_LINE('------------');

FOR J IN 1..I LOOP --J:1부터 I(8)까지
DBMS_OUTPUT.PUT_LINE(RPAD(SANAME_COL(J),12)||RPAD(SAJIK_COL(J),9));
END LOOP;
END;
/
사원명  직급
------------
이순신      부장
홍길동      대리
성유리      사원
옥주현      과장
길건        대리
한지혜      사원
박솔미      대리
이효리      사원

PL/SQL procedure successfully completed.

------------------------------------------------------
--이름이 있는 PROCEDURE 만들기

CREATE OR REPLACE PROCEDURE CHANGE_PAY
(V_SANO IN NUMBER, V_NEW_PAY IN NUMBER) --외부 매개변수
IS
BEGIN
UPDATE 사원 SET 급여=V_NEW_PAY WHERE 사원번호=V_SANO;
COMMIT; --UPDATE는 TRANSACTION 과정이 있으므로 꼭 COMMIT해주기
END CHANGE_PAY;
LEE@XE> /

Procedure created.

LEE@XE> EXEC CHANGE_PAY(2001,5000);

PL/SQL procedure successfully completed.
------------------------------------------------------------------

--함수만들기

CREATE OR REPLACE FUNCTION F_TAX
(V_SANO NUMBER)
RETURN NUMBER
IS
V_TAX NUMBER;
BEGIN
SELECT ((급여*12) + NVL(커미션,0))*0.05 INTO V_TAX
FROM 사원 WHERE 사원번호=V_SANO;
RETURN V_TAX;
END;
LEE@XE> /

Function created.

LEE@XE> SELECT 사원번호,사원명,직급,커미션,F_TAX(2001) TAX
FROM 사원 WHERE 사원번호=2001;

  사원번호 사원명               직급                     커미션        TAX
---------- -------------------- -------------------- ---------- ----------
      2001 이순신               부장                        100       3005
      

--------------------------------------------------------------

CREATE OR REPLACE PROCEDURE P_OUTEX
(V_SANO IN 사원.사원번호%TYPE,
V_SANAME OUT 사원.사원명%TYPE,
V_PAY OUT 사원.급여%TYPE,
V_COMM OUT 사원.커미션%TYPE)
IS
BEGIN
SELECT 사원명,급여,커미션 INTO V_SANAME,V_PAY,V_COMM
FROM 사원 WHERE 사원번호=V_SANO;
END;
LEE@XE> /

Procedure created.

--변수만들어주기

LEE@XE> VARIABLE NAME VARCHAR2(10);
LEE@XE> VARIABLE PAY  NUMBER;
LEE@XE> VARIABLE COMM  NUMBER;
LEE@XE> EXEC P_OUTEX(2001,:NAME,:PAY,:COMM);
PL/SQL procedure successfully completed.

LEE@XE> SELECT :NAME,:PAY,:COMM FROM DUAL;

:NAME                                                                  :PAY      :COMM
---------------------------------------------------------------- ---------- ----------
이순신                                                                 5000        100



--------------------------------------------------------

LEE@XE> CREATE OR REPLACE PROCEDURE ADD_ONE
(V_TEL IN OUT VARCHAR2)
IS
BEGIN
V_TEL:=SUBSTR(V_TEL,1,4)||'-'||SUBSTR(V_TEL,4);
END;
/

Procedure created.

LEE@XE> VARIABLE TEL VARCHAR2(15);
LEE@XE> EXEC :TEL := '123405678';

PL/SQL procedure successfully completed.

LEE@XE> EXEC ADD_ONE(:TEL);

PL/SQL procedure successfully completed.

LEE@XE> PRINT TEL;

TEL
------------------------------------------
1234-405678

LEE@XE> COL TEL FORMAT A17;
LEE@XE> PRINT TEL;

TEL
-----------------
1234-405678


-------------------------------------------------

CREATE OR REPLACE PROCEDURE P_GOJUTOT
(V_GNO IN VARCHAR2)
IS
TOT NUMBER;
BEGIN
SELECT COUNT(*) INTO TOT FROM SALES
WHERE USERID=V_GNO
GROUP BY USERID;
DBMS_OUTPUT.PUT_LINE (V_GNO||'번 고객님의 총 주문 횟수는 '||TO_CHAR(TOT)||'번 입니다');
END;
/

Procedure created.

LEE@XE> EXEC P_GOJUTOT('og6675');
og6675번 고객님의 총 주문 횟수는 1번 입니다

PL/SQL procedure successfully completed.

LEE@XE> EXEC P_GOJUTOT('mh3020');
mh3020번 고객님의 총 주문 횟수는 18번 입니다

PL/SQL procedure successfully completed.



-----------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE SEARCHJIK
(JIK IN VARCHAR2)
IS
A NUMBER:=0;
B NUMBER(12,2):=0;
C NUMBER:=0;
BEGIN
SELECT SUM(PAY),AVG(PAY),COUNT(*) INTO A,B,C
FROM COMPANY WHERE POSIT=JIK;

DBMS_OUTPUT.PUT_LINE('급여총액: '||A||'원');
DBMS_OUTPUT.PUT_LINE('평균월급: '||B||'원');
DBMS_OUTPUT.PUT_LINE('인원수: '||C||'명');
END;
/

LEE@XE> EXEC SEARCHJIK('과장');
급여총액: 125984000원
평균월급: 1749777.78원
인원수: 72명

---------------------------------------------------------------



  1  CREATE TABLE TEST
  2  (A NUMBER(10),
  3  B NUMBER(10),
  4* C DATE DEFAULT SYSDATE)
LEE@XE> ;
  1  CREATE TABLE TEST
  2  (A NUMBER(10),
  3  B NUMBER(10),
  4* C DATE DEFAULT SYSDATE)
LEE@XE>
LEE@XE> ED
Wrote file afiedt.buf

  1  CREATE TABLE TEST
  2  (A NUMBER(10),
  3  B NUMBER(10),
  4* C DATE DEFAULT SYSDATE)
LEE@XE> /

Table created.

LEE@XE> INSERT INTO TEST(A,B) VALUES (10,20);

1 row created.

LEE@XE> COMMIT;

Commit complete.

LEE@XE> SELECT * FROM TEST;

         A          B C
---------- ---------- --------
        10         20 22/07/11


--INSERT PROCEDURE

LEE@XE> CREATE OR REPLACE PROCEDURE P_EX
  2  (A IN NUMBER, B IN NUMBER)
  3  IS
  4  BEGIN
  5  INSERT INTO TEST (A,B) VALUES(A,B);
  6  COMMIT;
  7  END;
  8  /

Procedure created.

LEE@XE> EXEC P_EX(20,30);

PL/SQL procedure successfully completed.

-----------------------------------------------------------------------

--UPDATE PROCEDURE
CREATE OR REPLACE PROCEDURE P_UP
(A_C NUMBER, B_C NUMBER)
IS
BEGIN
UPDATE TEST SET B=B_C WHERE A=A_C;
COMMIT;
END;
LEE@XE> /

Procedure created.

LEE@XE> EXEC P_UP(10,100);

PL/SQL procedure successfully completed.

LEE@XE> SELECT * FROM TEST;

         A          B C
---------- ---------- --------
        10        100 22/07/11
        20         30 22/07/11
        
-----------------------------------------------------------------------
--DELETE PROCEDURE

LEE@XE> CREATE OR REPLACE PROCEDURE P_DE
(A_C NUMBER)
IS
BEGIN
DELETE TEST WHERE A=A_C;
COMMIT;
END;
/

Procedure created.

LEE@XE> EXEC P_DE(10);

PL/SQL procedure successfully completed.

LEE@XE> SELECT * FROM TEST;

         A          B C
---------- ---------- --------
        20        500 22/07/11
        
-------------------------------------------------------------------------
--CUSTOM 테이블에 INSERT 시키는 프로시져
CREATE OR REPLACE PROCEDURE CUS_IN
(A IN CUSTOM.USERID%TYPE,
B IN CUSTOM.USERNAME%TYPE,
C IN CUSTOM.JUMIN%TYPE,
D IN CUSTOM.AGE%TYPE,
E IN CUSTOM.SEX%TYPE,
F IN CUSTOM.ZIP%TYPE,
G IN CUSTOM.ADDR1%TYPE,
H IN CUSTOM.ADDR2%TYPE,
I IN CUSTOM.ADDR3%TYPE,
J IN CUSTOM.TEL%TYPE,
K IN CUSTOM.JOB%TYPE,
L IN CUSTOM.SCHOL%TYPE,
M IN CUSTOM.POINT%TYPE,
N IN CUSTOM.REGDATE%TYPE)
IS
BEGIN
INSERT INTO CUSTOM VALUES(A,B,C,D,E,F,G,H,I,J,K,I,M,N);
COMMIT;
 END;
LEE@XE> /

Procedure created.

LEE@XE> EXEC CUS_IN('A001','SUZI','123',27,0,'123-123','서울','강남구','역삼동','010-111-2222','가수','대졸',100,SYSDATE);


--CUSTOM 테이블에 UPDATE 시키는 프로시져
CREATE OR REPLACE PROCEDURE CUS_UP


CREATE OR REPLACE PROCEDURE CUS_UP
(A IN CUSTOM.USERID%TYPE,
B IN CUSTOM.USERNAME%TYPE,
C IN CUSTOM.JUMIN%TYPE,
D IN CUSTOM.AGE%TYPE,
E IN CUSTOM.SEX%TYPE,
F IN CUSTOM.ZIP%TYPE,
G IN CUSTOM.ADDR1%TYPE,
H IN CUSTOM.ADDR2%TYPE,
I IN CUSTOM.ADDR3%TYPE,
J IN CUSTOM.TEL%TYPE,
K IN CUSTOM.JOB%TYPE,
L IN CUSTOM.SCHOL%TYPE,
M IN CUSTOM.POINT%TYPE,
N IN CUSTOM.REGDATE%TYPE)
IS
BEGIN
UPDATE CUSTOM SET USERNAME=B,JUMIN=C,AGE=D,SEX=E,
ZIP=F,ADDR1=G,ADDR2=H,ADDR3=I,TEL=J,JOB=K,SCHOL=L,
POINT=M,REGDATE=N WHERE USERID=A;
COMMIT;
END;
LEE@XE> /

Procedure created.

LEE@XE> EXEC CUS_UP('A001','INNA','123',27,0,'123-123','서울','강남구','역삼동','010-111-2222','배우','대졸',100,SYSDATE);

PL/SQL procedure successfully completed.

LEE@XE> SELECT * FROM CUSTOM WHERE USERID='A001';




--CUSTOM 테이블에 DELETE 시키는 프로시져
CREATE OR REPLACE PROCEDURE CUS_DEL

CREATE OR REPLACE PROCEDURE CUS_DEL
(A IN CUSTOM.USERID%TYPE)
IS BEGIN
DELETE CUSTOM WHERE USERID=A;
COMMIT;
END;

---------------------------------------------------
--함수
CREATE OR REPLACE FUNCTION F_CUBVOL
(GILI NUMBER, POK NUMBER,NOPI NUMBER)
RETURN NUMBER
IS
BUPI NUMBER;
BEGIN
BUPI:=GILI*POK*NOPI;
RETURN BUPI;
END;
/
SELECT F_CUBVOL(4,7,8) BUPI FROM DUAL;

--이름 끝 두자리 함수

CREATE OR REPLACE FUNCTION F_NAME
(NAME IN VARCHAR2)
RETURN VARCHAR2
IS NA VARCHAR2(8);
BEGIN
NA:=SUBSTR(NAME,-2);
RETURN NA;
END;
/
SELECT F_NAME('영웅재중') NAME FROM DUAL;


SELECT F_NAME(USERNAME) FROM CUSTOM WHERE ADDR1='제주도';
-------------

SELECT
FLOOR(MONTHS_BETWEEN(SYSDATE,'2002-06-01')/12) || '년' ||
FLOOR(MOD(MONTHS_BETWEEN(SYSDATE,'2002-06-01'),12))||'개월'
FROM DUAL;



--
CREATE OR REPLACE FUNCTION F_SDAY
(V_DATE IN DATE)
RETURN VARCHAR2
IS
GUNDATE VARCHAR2(20);
BEGIN
GUNDATE:=FLOOR(MONTHS_BETWEEN(SYSDATE,V_DATE)/12)||'년'||
FLOOR(MOD(MONTHS_BETWEEN(SYSDATE,V_DATE),12))||'개월';
RETURN GUNDATE;
END;
/


SELECT USERNAME,REGDATE,F_SDAY(REGDATE) GUNDATE
FROM CUSTOM
WHERE ADDR1='제주도'

--성별반환



CREATE OR REPLACE FUNCTION F_GENDER
(V_JUMIN IN VARCHAR2)
RETURN VARCHAR2
IS
GENDER VARCHAR2(2);
BEGIN
GENDER:=SUBSTR(V_JUMIN,8,1);
IF GENDER IN ('1','3') THEN
GENDER :='남';
ELSE
GENDER :='여';
END IF;
RETURN GENDER;
END;

--월급등급 (IF)
CREATE OR REPLACE FUNCTION F_PAYGRADE
(V_PAY IN NUMBER)
RETURN VARCHAR2
IS
RESULT VARCHAR2(20);
BEGIN
IF V_PAY>2500000 THEN
RESULT :='A';
ELSIF V_PAY>2000000 THEN
RESULT:='B';
ELSIF V_PAY>1500000 THEN
RESULT:='C';
ELSIF V_PAY>1000000 THEN
RESULT:='D';
ELSE
RESULT:='E';
END IF;
RETURN RESULT;
END;

COL PAYGRADE FORMAT A8;
SELECT USERID,POSIT,PAY,F_PAYGRADE(PAY)||'등급' PAYGRADE
FROM COMPANY WHERE USERID='XA9776';

--LOOP (DO~WHILE)

CREATE TABLE TEST2
(NO NUMBER,
NAME VARCHAR2(10) DEFAULT '홍길동');

DECLARE
V_COUNT NUMBER(2):=1;
BEGIN
LOOP
INSERT INTO TEST2(NO) VALUES(V_COUNT);
V_COUNT:=V_COUNT+1;
EXIT WHEN V_COUNT>10;
END LOOP;
DBMS_OUTPUT.PUT_LINE('데이터 입력 완료');
END;

SELET * FROM TEST2;

--FOR
CREATE OR REPLACE PROCEDURE P_FOR
IS
BEGIN
FOR I IN 11..20 LOOP
INSERT INTO TEST2(NO) VALUES(I);
COMMIT;
END LOOP;
END;

EXEC P_FOR;


--WHILE

CREATE OR REPLACE PROCEDURE P_WHILE
(V_START NUMBER,V_END NUMBER)
IS
CNT NUMBER:=V_START;
TOT NUMBER:=0;
BEGIN
WHILE CNT<=V_END LOOP
TOT:=TOT+CNT;
CNT:=CNT+1;
END LOOP;
DBMS_OUTPUT.PUT_LINE(TO_CHAR(V_START)||'부터 '||TO_CHAR(V_END)||
'까지의 합은 '||TO_CHAR(TOT)||'입니다');
END;

EXEC P_WHILE(1,100);

1부터 100까지의 합은 5050입니다

--예외처리


CREATE OR REPLACE PROCEDURE EXE_TEST
IS
SW_REC 사원%ROWTYPE;
BEGIN
SELECT * INTO SW_REC FROM 사원; --조건줘야함
DBMS_OUTPUT.PUT_LINE('데이터 검색 성공');

EXCEPTION

WHEN TOO_MANY_ROWS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('데이터가 많습니다');

WHEN NO_DATA_FOUND THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('데이터가 없습니다');

WHEN OTHERS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('다른 에러입니다');

END;

--사용자 정의 에러


CREATE OR REPLACE PROCEDURE PAY_VALIDATE
(V_SANO 사원.사원번호%TYPE)
IS

NOT_ENOUGH_PAY EXCEPTION;

SW_REC 사원%ROWTYPE;

BEGIN
SELECT * INTO SW_REC FROM 사원 WHERE 사원번호=V_SANO;

IF SW_REC.급여 >=3000 THEN
DBMS_OUTPUT.PUT_LINE('급여가 3000 이상 적당함');

ELSIF SW_REC.급여<3000 THEN
RAISE NOT_ENOUGH_PAY;

ELSE
DBMS_OUTPUT.PUT_LINE('급여가 이상함');
END IF;

EXCEPTION

WHEN NOT_ENOUGH_PAY THEN
RAISE_APPLICATION_ERROR(-20001,'급여가 충분하지 못함');
END;

EXEC PAY_VALIDATE(2001);
급여가 3000 이상 적당함

-------------------------------------------------------------------

BEGIN
FOR i IN 1..10 LOOP
CONTINUE WHEN MOD(i,2)=0;
DBMS_OUTPUT.PUT_LINE('현재 i의 값 : '||i);
END LOOP;
END;
/
----------------------------------------------------------------------

--커서(CURSOR)

CREATE OR REPLACE PROCEDURE P_DEPTNO
(I_DEPTNO 사원.부서번호%TYPE)
IS

CURSOR CUR_DEPTNO --SELECT한 내용이 들어가있음
IS
SELECT 부서번호,사원명,직급,급여 FROM 사원
WHERE 부서번호=I_DEPTNO;

V_DEPTNO 사원.부서번호%TYPE;
V_SANAME 사원.사원명%TYPE;
V_JIK 사원.직급%TYPE;
V_SAL 사원.급여%TYPE;

BEGIN

OPEN CUR_DEPTNO; --커서오픈

DBMS_OUTPUT.PUT_LINE('부서번호  사원명  직급  급여');
DBMS_OUTPUT.PUT_LINE('-------------------------------');

LOOP
FETCH CUR_DEPTNO INTO V_DEPTNO,V_SANAME,V_JIK,V_SAL;

EXIT WHEN CUR_DEPTNO%NOTFOUND; --커서안에 데이터 없으면 멈추기

DBMS_OUTPUT.PUT_LINE(TO_CHAR(V_DEPTNO)||'  '||
V_SANAME||'  '||V_JIK||'  '||TO_CHAR(V_SAL));
END LOOP;

DBMS_OUTPUT.PUT_LINE('전체데이터의 갯수: '||TO_CHAR(CUR_DEPTNO%ROWCOUNT));

CLOSE CUR_DEPTNO; --닫아주기
END;

EXEC P_DEPTNO(20);

부서번호  사원명  직급  급여
-------------------------------
20  성유리  사원  2500
20  한지혜  사원  2000
전체데이터의 갯수: 2

-----------------------------------------------------------------------------------
--FOR 사용한 커서. 자동으로 커서를 오픈하고 닫아준다.

CREATE OR REPLACE PROCEDURE P_DEPTNO1
(I_DEPTNO 사원.부서번호%TYPE)
IS

CURSOR CUR_DEPTNO
IS
SELECT 부서번호,사원명,직급,급여 FROM 사원
WHERE 부서번호=I_DEPTNO;

V_CNT NUMBER;

BEGIN

DBMS_OUTPUT.PUT_LINE('부서번호  사원명  직급  급여');
DBMS_OUTPUT.PUT_LINE('-------------------------------');

FOR CURDEPT IN CUR_DEPTNO LOOP

DBMS_OUTPUT.PUT_LINE(TO_CHAR(CURDEPT.부서번호)||'  '||
CURDEPT.사원명||'  '||CURDEPT.직급||'  '||TO_CHAR(CURDEPT.급여));

V_CNT :=CUR_DEPTNO%ROWCOUNT;

END LOOP;

DBMS_OUTPUT.PUT_LINE('전체데이터의 갯수: '||TO_CHAR(V_CNT));

END;

----------------------------------------------------------------------------
--사원번호를 입력시, 사원이름,구입한 제품명을 출력하시오

CREATE OR REPLACE PROCEDURE P_JEPUM
(V_USERID IN VARCHAR2)
IS
V_CNT NUMBER;
CURSOR SA_CUR
IS
SELECT C.USERID,C.USERNAME,S.PRODUCTNAME
FROM CUSTOM C, SALES S
WHERE C.USERID=S.USERID AND S.USERID=V_USERID;

BEGIN
DBMS_OUTPUT.PUT_LINE('아이디  이름  제품명');
DBMS_OUTPUT.PUT_LINE('--------------------');

FOR SA_REC IN SA_CUR LOOP

DBMS_OUTPUT.PUT_LINE(SA_REC.USERID||'  '||
SA_REC.USERNAME||'  '||SA_REC.PRODUCTNAME);

V_CNT:=SA_CUR%ROWCOUNT;

END LOOP;

DBMS_OUTPUT.PUT_LINE('전체데이터의 갯수: '||TO_CHAR(V_CNT));
END;
/

-------------------------------------------------------------------------
--PACKAGE

CREATE OR REPLACE PACKAGE SAWON_PACK
IS
PROCEDURE SANO_OUT;
PROCEDURE SANAME_OUT;
PROCEDURE BUNO_OUT;
END;

CREATE OR REPLACE PACKAGE BODY SAWON_PACK
IS
	CURSOR SW_CUR
	IS
	SELECT * FROM 사원;
PROCEDURE SANO_OUT
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('사원번호');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW.사원번호);
END LOOP;
END;
PROCEDURE SANAME_OUT
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('사원명');
DBMS_OUTPUT.PUT_LINE('------');
FOR SW IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW.사원명);
END LOOP;
END;
PROCEDURE BUNO_OUT
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('부서번호');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW.부서번호);
END LOOP;
END;
END;
/

EXEC SAWON_PACK.SANO_OUT;

사원번호
--------
2001
2002
2003
2004
2005
2006
2007
2008

----------------------------------------------------------------

--TRIGGER

CREATE TABLE HAKSANG
(HAKBUN VARCHAR2(10),
NAME VARCHAR2(10));

CREATE TABLE MEMO
(NO NUMBER,
BIGO VARCHAR2(200));

CREATE SEQUENCE SE100
START WITH 1
INCREMENT BY 1
MAXVALUE 100
NOCYCLE
NOCACHE;

--AFTER TRIGGER(INSERT TRIGGER)

CREATE OR REPLACE TRIGGER TRI_HAKSANG_IN
AFTER INSERT
ON LEE.HAKSANG
BEGIN
INSERT INTO MEMO VALUES (SE100.NEXTVAL,'행이 INSERT 되었습니다');
END;
/

INSERT INTO HAKSANG VALUES(111,'SUZI');

SELECT * FROM MEMO;

        NO BIGO
---------- -----------------------
         1 행이 INSERT 되었습니다
           
--FOR EACH ROW (:OLD/:NEW) 찾아낸다. FOR EACH를 써야지만 :OLD/:NEW 사용 가능

CREATE OR REPLACE TRIGGER TRI_HAKSANG_IN
AFTER INSERT
ON LEE.HAKSANG
FOR EACH ROW
BEGIN
INSERT INTO MEMO VALUES (SE100.NEXTVAL,:NEW.NAME||'행이 INSERT 되었습니다'); --NAME에 새롭게 들어온 데이터를 찾는다
END;
/

INSERT INTO HAKSANG VALUES(222,'INNA');
SELECT * FROM MEMO;
        NO BIGO
---------- ------------------------------
         1 행이 INSERT 되었습니다
         2 INNA행이 INSERT 되었습니다
         

--입력한 데이터 다른 테이블에 복사하기

CREATE TABLE COPY_HAKSANG
(HAKBUN VARCHAR2(10),
NAME VARCHAR2(10))
/

CREATE OR REPLACE TRIGGER TRI_COPY_HAKSANG_IN
AFTER INSERT
ON LEE.HAKSANG
FOR EACH ROW
BEGIN
INSERT INTO COPY_HAKSANG VALUES (:NEW.HAKBUN,:NEW.NAME);
END;

INSERT INTO HAKSANG VALUES (333,'INSUN');

SELECT * FROM HAKSANG;
HAKBUN               NAME
-------------------- --------------------
111                  SUZI
222                  INNA
333                  INSUN

SELECT * FROM MEMO;
        NO BIGO
---------- ------------------------------
         1 행이 INSERT 되었습니다
         2 INNA행이 INSERT 되었습니다
         3 INSUN행이 INSERT 되었습니다

SELECT * FROM COPY_HAKSANG;

HAKBUN               NAME
-------------------- --------------------
333                  INSUN

--UPDATE

CREATE OR REPLACE TRIGGER TRI_HAKSANG_UP
AFTER UPDATE OF NAME --NAME 컬럼에 업데이트 되면 실행되라
ON LEE.HAKSANG
FOR EACH ROW
BEGIN
INSERT INTO MEMO VALUES (SE100.NEXTVAL,:OLD.NAME||'행이 '||
:NEW.NAME||'으로 UPDATE 되었습니다');
END;
/

UPDATE HAKSANG SET NAME='SHIN' WHERE HAKBUN=111;

SELECT * FROM MEMO;
        NO BIGO
---------- ------------------------------
         1 행이 INSERT 되었습니다
         2 INNA행이 INSERT 되었습니다
         3 INSUN행이 INSERT 되었습니다
         4 SUZI행이 SHIN으로 UPDATE 되었습니다
         
--DELETE
CREATE OR REPLACE TRIGGER TRI_HAKSANG_DEL
AFTER DELETE
ON LEE.HAKSANG
FOR EACH ROW
BEGIN
INSERT INTO MEMO VALUES (SE100.NEXTVAL,:OLD.NAME||'행이 DELETE 됨');
INSERT INTO COPY_HAKSANG VALUES (:OLD.HAKBUN,:OLD.NAME);
END;
/

DELETE HAKSANG WHERE HAKBUN=111;

SELECT * FROM MEMO;

        NO BIGO
---------- ----------------------------------------
         1 행이 INSERT 되었습니다
         2 INNA행이 INSERT 되었습니다
         3 INSUN행이 INSERT 되었습니다
         4 SUZI행이 SHIN으로 UPDATE 되었습니다
         5 SHIN행이 DELETE 됨
         
SELECT * FROM COPY_HAKSANG;

HAKBUN               NAME
-------------------- --------------------
333                  INSUN
111                  SHIN


--------------------------------------------------------
--BEFORE TRIGGER

CREATE TABLE INSA
(EMPNO NUMBER(4) PRIMARY KEY,
ENAME VARCHAR2(10),
JIK VARCHAR2(10),
SAL NUMBER);

CREATE OR REPLACE TRIGGER TRI_INSA
BEFORE INSERT OR UPDATE OR DELETE
ON LEE.INSA

DECLARE
IMPOSSIBLE_TIME EXCEPTION;

BEGIN
IF TO_CHAR(SYSDATE,'DAY') IN ('토요일','일요일') OR
TO_CHAR(SYSDATE,'HH24')<12 OR TO_CHAR(SYSDATE,'HH24')>17 THEN
RAISE IMPOSSIBLE_TIME;
END IF;

EXCEPTION
WHEN IMPOSSIBLE_TIME THEN
RAISE_APPLICATION_ERROR(-20007,'월요일부터 금요일까지 정오 12:00부터 5시 까지만 DML작업이 가능합니다');
END;
/

INSERT INTO INSA VALUES(1,'배수지','과장',5000); --12시 전에 작업하면

ERROR at line 1:
ORA-20007: 월요일부터 금요일까지 정오 12:00부터 5시 까지만 DML작업이 가능합니다
ORA-06512: at "LEE.TRI_INSA", line 12
ORA-04088: error during execution of trigger 'LEE.TRI_INSA'

--주민번호
CREATE TABLE MEMBER
(ID NUMBER(3) PRIMARY KEY,
NAME VARCHAR2(10),
JUBUN VARCHAR2(13));

CREATE OR REPLACE TRIGGER TRI_MEMBER_JUBUN
BEFORE INSERT OR UPDATE OF JUBUN
ON LEE.MEMBER
FOR EACH ROW
DECLARE
A NUMBER;B NUMBER;C NUMBER;D NUMBER;E NUMBER;
F NUMBER;G NUMBER;H NUMBER;I NUMBER;J NUMBER;
K NUMBER;L NUMBER;M NUMBER;
CK NUMBER;
JUBUNFAIL EXCEPTION;
BEGIN
A:=SUBSTR(:NEW.JUBUN,1,1);
B:=SUBSTR(:NEW.JUBUN,2,1);
C:=SUBSTR(:NEW.JUBUN,3,1);
D:=SUBSTR(:NEW.JUBUN,4,1);
E:=SUBSTR(:NEW.JUBUN,5,1);
F:=SUBSTR(:NEW.JUBUN,6,1);
G:=SUBSTR(:NEW.JUBUN,7,1);
H:=SUBSTR(:NEW.JUBUN,8,1);
I:=SUBSTR(:NEW.JUBUN,9,1);
J:=SUBSTR(:NEW.JUBUN,10,1);
K:=SUBSTR(:NEW.JUBUN,11,1);
L:=SUBSTR(:NEW.JUBUN,12,1);
M:=SUBSTR(:NEW.JUBUN,13,1);
CK:=(A*2)+(B*3)+(C*4)+(D*5)+(E*6)+(F*7)+(G*8)+(H*9)+(I*2)+(J*3)+(K*4)+(L*5);
CK:=MOD(CK,11);
CK:=11-CK;
CK:=MOD(CK,10);
IF M!=CK THEN
RAISE JUBUNFAIL;
END IF;
EXCEPTION
WHEN JUBUNFAIL THEN
RAISE_APPLICATION_ERROR(-20001,'주민번호가 틀립니다!');
END;
/



