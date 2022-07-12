DECLARE
TYPE FIRSTTYPE IS RECORD -- RECORD�� ��� �����̸�:FIRSTTYPE
(A ���.�����%TYPE, B ���.����%TYPE, C ���.�޿�%TYPE);

CUS FIRSTTYPE; --CUS : ��������

BEGIN 
SELECT �����,����,�޿� INTO CUS FROM ��� WHERE �����ȣ=2001;

DBMS_OUTPUT.PUT_LINE('����� ���� �޿�');
DBMS_OUTPUT.PUT_LINE('----------------');
DBMS_OUTPUT.PUT_LINE(CUS.A||'  '||CUS.B||'  '||TO_CHAR(CUS.C)); --���ڿ����� ��������
DBMS_OUTPUT.PUT_LINE('������ �����: '||USER||'�Դϴ�'); --USER:�ý��� ����
DBMS_OUTPUT.PUT_LINE('������ �ð�: '||TO_CHAR(SYSDATE,'YYYY-MM-DD HH:MI:SS'));

END;


-----------------------------------------------------------------------
--��ü ��

DECLARE
SAWON_RECORD ���%ROWTYPE;
BEGIN
SELECT * INTO SAWON_RECORD FROM ��� WHERE �����ȣ=2001;
DBMS_OUTPUT.PUT_LINE('�����ȣ: '||SAWON_RECORD.�����ȣ);
DBMS_OUTPUT.PUT_LINE('�����: '||SAWON_RECORD.�����);
DBMS_OUTPUT.PUT_LINE('�ּ�: '||SAWON_RECORD.�ּ�);
DBMS_OUTPUT.PUT_LINE('�޿�: '||SAWON_RECORD.�޿�);
END;
/

---------------------------------------------------------------
--�÷��� ��������

K : SELECT �����,���� FROM ��� (��� ����)
I : ����INDEX ����

DECLARE
TYPE NAME_TYPE IS TABLE OF ���.�����%TYPE
INDEX BY BINARY_INTEGER; --�ε����� �ο�
TYPE JIK_TYPE IS TABLE OF ���.����%TYPE
INDEX BY BINARY_INTEGER;--�ε����� �ο�

SANAME_COL NAME_TYPE; --��������
SAJIK_COL  JIK_TYPE; --��������
I BINARY_INTEGER :=0; --�����ʱ�ȭ

BEGIN
FOR K IN (SELECT �����,���� FROM ���) LOOP -- K : SELECT �����,���� FROM ��� (��� ����)
I := I+1; --I : ����INDEX ���� I++
SANAME_COL(I) := K.�����;
SAJIK_COL(I) := K.����;
END LOOP;

DBMS_OUTPUT.PUT_LINE('�����  ����');
DBMS_OUTPUT.PUT_LINE('------------');

FOR J IN 1..I LOOP --J:1���� I(8)����
DBMS_OUTPUT.PUT_LINE(RPAD(SANAME_COL(J),12)||RPAD(SAJIK_COL(J),9));
END LOOP;
END;
/
�����  ����
------------
�̼���      ����
ȫ�浿      �븮
������      ���
������      ����
���        �븮
������      ���
�ڼֹ�      �븮
��ȿ��      ���

PL/SQL procedure successfully completed.

------------------------------------------------------
--�̸��� �ִ� PROCEDURE �����

CREATE OR REPLACE PROCEDURE CHANGE_PAY
(V_SANO IN NUMBER, V_NEW_PAY IN NUMBER) --�ܺ� �Ű�����
IS
BEGIN
UPDATE ��� SET �޿�=V_NEW_PAY WHERE �����ȣ=V_SANO;
COMMIT; --UPDATE�� TRANSACTION ������ �����Ƿ� �� COMMIT���ֱ�
END CHANGE_PAY;
LEE@XE> /

Procedure created.

LEE@XE> EXEC CHANGE_PAY(2001,5000);

PL/SQL procedure successfully completed.
------------------------------------------------------------------

--�Լ������

CREATE OR REPLACE FUNCTION F_TAX
(V_SANO NUMBER)
RETURN NUMBER
IS
V_TAX NUMBER;
BEGIN
SELECT ((�޿�*12) + NVL(Ŀ�̼�,0))*0.05 INTO V_TAX
FROM ��� WHERE �����ȣ=V_SANO;
RETURN V_TAX;
END;
LEE@XE> /

Function created.

LEE@XE> SELECT �����ȣ,�����,����,Ŀ�̼�,F_TAX(2001) TAX
FROM ��� WHERE �����ȣ=2001;

  �����ȣ �����               ����                     Ŀ�̼�        TAX
---------- -------------------- -------------------- ---------- ----------
      2001 �̼���               ����                        100       3005
      

--------------------------------------------------------------

CREATE OR REPLACE PROCEDURE P_OUTEX
(V_SANO IN ���.�����ȣ%TYPE,
V_SANAME OUT ���.�����%TYPE,
V_PAY OUT ���.�޿�%TYPE,
V_COMM OUT ���.Ŀ�̼�%TYPE)
IS
BEGIN
SELECT �����,�޿�,Ŀ�̼� INTO V_SANAME,V_PAY,V_COMM
FROM ��� WHERE �����ȣ=V_SANO;
END;
LEE@XE> /

Procedure created.

--����������ֱ�

LEE@XE> VARIABLE NAME VARCHAR2(10);
LEE@XE> VARIABLE PAY  NUMBER;
LEE@XE> VARIABLE COMM  NUMBER;
LEE@XE> EXEC P_OUTEX(2001,:NAME,:PAY,:COMM);
PL/SQL procedure successfully completed.

LEE@XE> SELECT :NAME,:PAY,:COMM FROM DUAL;

:NAME                                                                  :PAY      :COMM
---------------------------------------------------------------- ---------- ----------
�̼���                                                                 5000        100



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
DBMS_OUTPUT.PUT_LINE (V_GNO||'�� ������ �� �ֹ� Ƚ���� '||TO_CHAR(TOT)||'�� �Դϴ�');
END;
/

Procedure created.

LEE@XE> EXEC P_GOJUTOT('og6675');
og6675�� ������ �� �ֹ� Ƚ���� 1�� �Դϴ�

PL/SQL procedure successfully completed.

LEE@XE> EXEC P_GOJUTOT('mh3020');
mh3020�� ������ �� �ֹ� Ƚ���� 18�� �Դϴ�

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

DBMS_OUTPUT.PUT_LINE('�޿��Ѿ�: '||A||'��');
DBMS_OUTPUT.PUT_LINE('��տ���: '||B||'��');
DBMS_OUTPUT.PUT_LINE('�ο���: '||C||'��');
END;
/

LEE@XE> EXEC SEARCHJIK('����');
�޿��Ѿ�: 125984000��
��տ���: 1749777.78��
�ο���: 72��

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
--CUSTOM ���̺� INSERT ��Ű�� ���ν���
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

LEE@XE> EXEC CUS_IN('A001','SUZI','123',27,0,'123-123','����','������','���ﵿ','010-111-2222','����','����',100,SYSDATE);


--CUSTOM ���̺� UPDATE ��Ű�� ���ν���
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

LEE@XE> EXEC CUS_UP('A001','INNA','123',27,0,'123-123','����','������','���ﵿ','010-111-2222','���','����',100,SYSDATE);

PL/SQL procedure successfully completed.

LEE@XE> SELECT * FROM CUSTOM WHERE USERID='A001';




--CUSTOM ���̺� DELETE ��Ű�� ���ν���
CREATE OR REPLACE PROCEDURE CUS_DEL

CREATE OR REPLACE PROCEDURE CUS_DEL
(A IN CUSTOM.USERID%TYPE)
IS BEGIN
DELETE CUSTOM WHERE USERID=A;
COMMIT;
END;

---------------------------------------------------
--�Լ�
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

--�̸� �� ���ڸ� �Լ�

CREATE OR REPLACE FUNCTION F_NAME
(NAME IN VARCHAR2)
RETURN VARCHAR2
IS NA VARCHAR2(8);
BEGIN
NA:=SUBSTR(NAME,-2);
RETURN NA;
END;
/
SELECT F_NAME('��������') NAME FROM DUAL;


SELECT F_NAME(USERNAME) FROM CUSTOM WHERE ADDR1='���ֵ�';
-------------

SELECT
FLOOR(MONTHS_BETWEEN(SYSDATE,'2002-06-01')/12) || '��' ||
FLOOR(MOD(MONTHS_BETWEEN(SYSDATE,'2002-06-01'),12))||'����'
FROM DUAL;



--
CREATE OR REPLACE FUNCTION F_SDAY
(V_DATE IN DATE)
RETURN VARCHAR2
IS
GUNDATE VARCHAR2(20);
BEGIN
GUNDATE:=FLOOR(MONTHS_BETWEEN(SYSDATE,V_DATE)/12)||'��'||
FLOOR(MOD(MONTHS_BETWEEN(SYSDATE,V_DATE),12))||'����';
RETURN GUNDATE;
END;
/


SELECT USERNAME,REGDATE,F_SDAY(REGDATE) GUNDATE
FROM CUSTOM
WHERE ADDR1='���ֵ�'

--������ȯ



CREATE OR REPLACE FUNCTION F_GENDER
(V_JUMIN IN VARCHAR2)
RETURN VARCHAR2
IS
GENDER VARCHAR2(2);
BEGIN
GENDER:=SUBSTR(V_JUMIN,8,1);
IF GENDER IN ('1','3') THEN
GENDER :='��';
ELSE
GENDER :='��';
END IF;
RETURN GENDER;
END;

--���޵�� (IF)
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
SELECT USERID,POSIT,PAY,F_PAYGRADE(PAY)||'���' PAYGRADE
FROM COMPANY WHERE USERID='XA9776';

--LOOP (DO~WHILE)

CREATE TABLE TEST2
(NO NUMBER,
NAME VARCHAR2(10) DEFAULT 'ȫ�浿');

DECLARE
V_COUNT NUMBER(2):=1;
BEGIN
LOOP
INSERT INTO TEST2(NO) VALUES(V_COUNT);
V_COUNT:=V_COUNT+1;
EXIT WHEN V_COUNT>10;
END LOOP;
DBMS_OUTPUT.PUT_LINE('������ �Է� �Ϸ�');
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
DBMS_OUTPUT.PUT_LINE(TO_CHAR(V_START)||'���� '||TO_CHAR(V_END)||
'������ ���� '||TO_CHAR(TOT)||'�Դϴ�');
END;

EXEC P_WHILE(1,100);

1���� 100������ ���� 5050�Դϴ�

--����ó��


CREATE OR REPLACE PROCEDURE EXE_TEST
IS
SW_REC ���%ROWTYPE;
BEGIN
SELECT * INTO SW_REC FROM ���; --���������
DBMS_OUTPUT.PUT_LINE('������ �˻� ����');

EXCEPTION

WHEN TOO_MANY_ROWS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('�����Ͱ� �����ϴ�');

WHEN NO_DATA_FOUND THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('�����Ͱ� �����ϴ�');

WHEN OTHERS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('�ٸ� �����Դϴ�');

END;

--����� ���� ����


CREATE OR REPLACE PROCEDURE PAY_VALIDATE
(V_SANO ���.�����ȣ%TYPE)
IS

NOT_ENOUGH_PAY EXCEPTION;

SW_REC ���%ROWTYPE;

BEGIN
SELECT * INTO SW_REC FROM ��� WHERE �����ȣ=V_SANO;

IF SW_REC.�޿� >=3000 THEN
DBMS_OUTPUT.PUT_LINE('�޿��� 3000 �̻� ������');

ELSIF SW_REC.�޿�<3000 THEN
RAISE NOT_ENOUGH_PAY;

ELSE
DBMS_OUTPUT.PUT_LINE('�޿��� �̻���');
END IF;

EXCEPTION

WHEN NOT_ENOUGH_PAY THEN
RAISE_APPLICATION_ERROR(-20001,'�޿��� ������� ����');
END;

EXEC PAY_VALIDATE(2001);
�޿��� 3000 �̻� ������

-------------------------------------------------------------------

BEGIN
FOR i IN 1..10 LOOP
CONTINUE WHEN MOD(i,2)=0;
DBMS_OUTPUT.PUT_LINE('���� i�� �� : '||i);
END LOOP;
END;
/
----------------------------------------------------------------------

--Ŀ��(CURSOR)

CREATE OR REPLACE PROCEDURE P_DEPTNO
(I_DEPTNO ���.�μ���ȣ%TYPE)
IS

CURSOR CUR_DEPTNO --SELECT�� ������ ������
IS
SELECT �μ���ȣ,�����,����,�޿� FROM ���
WHERE �μ���ȣ=I_DEPTNO;

V_DEPTNO ���.�μ���ȣ%TYPE;
V_SANAME ���.�����%TYPE;
V_JIK ���.����%TYPE;
V_SAL ���.�޿�%TYPE;

BEGIN

OPEN CUR_DEPTNO; --Ŀ������

DBMS_OUTPUT.PUT_LINE('�μ���ȣ  �����  ����  �޿�');
DBMS_OUTPUT.PUT_LINE('-------------------------------');

LOOP
FETCH CUR_DEPTNO INTO V_DEPTNO,V_SANAME,V_JIK,V_SAL;

EXIT WHEN CUR_DEPTNO%NOTFOUND; --Ŀ���ȿ� ������ ������ ���߱�

DBMS_OUTPUT.PUT_LINE(TO_CHAR(V_DEPTNO)||'  '||
V_SANAME||'  '||V_JIK||'  '||TO_CHAR(V_SAL));
END LOOP;

DBMS_OUTPUT.PUT_LINE('��ü�������� ����: '||TO_CHAR(CUR_DEPTNO%ROWCOUNT));

CLOSE CUR_DEPTNO; --�ݾ��ֱ�
END;

EXEC P_DEPTNO(20);

�μ���ȣ  �����  ����  �޿�
-------------------------------
20  ������  ���  2500
20  ������  ���  2000
��ü�������� ����: 2

-----------------------------------------------------------------------------------
--FOR ����� Ŀ��. �ڵ����� Ŀ���� �����ϰ� �ݾ��ش�.

CREATE OR REPLACE PROCEDURE P_DEPTNO1
(I_DEPTNO ���.�μ���ȣ%TYPE)
IS

CURSOR CUR_DEPTNO
IS
SELECT �μ���ȣ,�����,����,�޿� FROM ���
WHERE �μ���ȣ=I_DEPTNO;

V_CNT NUMBER;

BEGIN

DBMS_OUTPUT.PUT_LINE('�μ���ȣ  �����  ����  �޿�');
DBMS_OUTPUT.PUT_LINE('-------------------------------');

FOR CURDEPT IN CUR_DEPTNO LOOP

DBMS_OUTPUT.PUT_LINE(TO_CHAR(CURDEPT.�μ���ȣ)||'  '||
CURDEPT.�����||'  '||CURDEPT.����||'  '||TO_CHAR(CURDEPT.�޿�));

V_CNT :=CUR_DEPTNO%ROWCOUNT;

END LOOP;

DBMS_OUTPUT.PUT_LINE('��ü�������� ����: '||TO_CHAR(V_CNT));

END;

----------------------------------------------------------------------------
--�����ȣ�� �Է½�, ����̸�,������ ��ǰ���� ����Ͻÿ�

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
DBMS_OUTPUT.PUT_LINE('���̵�  �̸�  ��ǰ��');
DBMS_OUTPUT.PUT_LINE('--------------------');

FOR SA_REC IN SA_CUR LOOP

DBMS_OUTPUT.PUT_LINE(SA_REC.USERID||'  '||
SA_REC.USERNAME||'  '||SA_REC.PRODUCTNAME);

V_CNT:=SA_CUR%ROWCOUNT;

END LOOP;

DBMS_OUTPUT.PUT_LINE('��ü�������� ����: '||TO_CHAR(V_CNT));
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
	SELECT * FROM ���;
PROCEDURE SANO_OUT
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�����ȣ');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW.�����ȣ);
END LOOP;
END;
PROCEDURE SANAME_OUT
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�����');
DBMS_OUTPUT.PUT_LINE('------');
FOR SW IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW.�����);
END LOOP;
END;
PROCEDURE BUNO_OUT
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('�μ���ȣ');
DBMS_OUTPUT.PUT_LINE('--------');
FOR SW IN SW_CUR LOOP
DBMS_OUTPUT.PUT_LINE(SW.�μ���ȣ);
END LOOP;
END;
END;
/

EXEC SAWON_PACK.SANO_OUT;

�����ȣ
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
INSERT INTO MEMO VALUES (SE100.NEXTVAL,'���� INSERT �Ǿ����ϴ�');
END;
/

INSERT INTO HAKSANG VALUES(111,'SUZI');

SELECT * FROM MEMO;

        NO BIGO
---------- -----------------------
         1 ���� INSERT �Ǿ����ϴ�
           
--FOR EACH ROW (:OLD/:NEW) ã�Ƴ���. FOR EACH�� ������� :OLD/:NEW ��� ����

CREATE OR REPLACE TRIGGER TRI_HAKSANG_IN
AFTER INSERT
ON LEE.HAKSANG
FOR EACH ROW
BEGIN
INSERT INTO MEMO VALUES (SE100.NEXTVAL,:NEW.NAME||'���� INSERT �Ǿ����ϴ�'); --NAME�� ���Ӱ� ���� �����͸� ã�´�
END;
/

INSERT INTO HAKSANG VALUES(222,'INNA');
SELECT * FROM MEMO;
        NO BIGO
---------- ------------------------------
         1 ���� INSERT �Ǿ����ϴ�
         2 INNA���� INSERT �Ǿ����ϴ�
         

--�Է��� ������ �ٸ� ���̺� �����ϱ�

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
         1 ���� INSERT �Ǿ����ϴ�
         2 INNA���� INSERT �Ǿ����ϴ�
         3 INSUN���� INSERT �Ǿ����ϴ�

SELECT * FROM COPY_HAKSANG;

HAKBUN               NAME
-------------------- --------------------
333                  INSUN

--UPDATE

CREATE OR REPLACE TRIGGER TRI_HAKSANG_UP
AFTER UPDATE OF NAME --NAME �÷��� ������Ʈ �Ǹ� ����Ƕ�
ON LEE.HAKSANG
FOR EACH ROW
BEGIN
INSERT INTO MEMO VALUES (SE100.NEXTVAL,:OLD.NAME||'���� '||
:NEW.NAME||'���� UPDATE �Ǿ����ϴ�');
END;
/

UPDATE HAKSANG SET NAME='SHIN' WHERE HAKBUN=111;

SELECT * FROM MEMO;
        NO BIGO
---------- ------------------------------
         1 ���� INSERT �Ǿ����ϴ�
         2 INNA���� INSERT �Ǿ����ϴ�
         3 INSUN���� INSERT �Ǿ����ϴ�
         4 SUZI���� SHIN���� UPDATE �Ǿ����ϴ�
         
--DELETE
CREATE OR REPLACE TRIGGER TRI_HAKSANG_DEL
AFTER DELETE
ON LEE.HAKSANG
FOR EACH ROW
BEGIN
INSERT INTO MEMO VALUES (SE100.NEXTVAL,:OLD.NAME||'���� DELETE ��');
INSERT INTO COPY_HAKSANG VALUES (:OLD.HAKBUN,:OLD.NAME);
END;
/

DELETE HAKSANG WHERE HAKBUN=111;

SELECT * FROM MEMO;

        NO BIGO
---------- ----------------------------------------
         1 ���� INSERT �Ǿ����ϴ�
         2 INNA���� INSERT �Ǿ����ϴ�
         3 INSUN���� INSERT �Ǿ����ϴ�
         4 SUZI���� SHIN���� UPDATE �Ǿ����ϴ�
         5 SHIN���� DELETE ��
         
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
IF TO_CHAR(SYSDATE,'DAY') IN ('�����','�Ͽ���') OR
TO_CHAR(SYSDATE,'HH24')<12 OR TO_CHAR(SYSDATE,'HH24')>17 THEN
RAISE IMPOSSIBLE_TIME;
END IF;

EXCEPTION
WHEN IMPOSSIBLE_TIME THEN
RAISE_APPLICATION_ERROR(-20007,'�����Ϻ��� �ݿ��ϱ��� ���� 12:00���� 5�� ������ DML�۾��� �����մϴ�');
END;
/

INSERT INTO INSA VALUES(1,'�����','����',5000); --12�� ���� �۾��ϸ�

ERROR at line 1:
ORA-20007: �����Ϻ��� �ݿ��ϱ��� ���� 12:00���� 5�� ������ DML�۾��� �����մϴ�
ORA-06512: at "LEE.TRI_INSA", line 12
ORA-04088: error during execution of trigger 'LEE.TRI_INSA'

--�ֹι�ȣ
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
RAISE_APPLICATION_ERROR(-20001,'�ֹι�ȣ�� Ʋ���ϴ�!');
END;
/



