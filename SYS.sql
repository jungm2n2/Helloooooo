--SYS

--DBA�� �����ϴ� DICTIONARY�� �����ڸ�忡���� �����ִ�.
SELECT * FROM DBA_UNUSED_COL_TABS; --DICTIONARY --��Ȱ��ȭ ��Ų ���̺� ������ ������

--DCL(GRANT,REVOKE)
--GRANT : USER�� OBJECT�� ������ �ο��� �� ���
--REVOKE : ������ ȸ���� �� ���

CREATE USER TEST
IDENTIFIED BY TEST
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP
QUOTA 1M ON USERS;

CREATE USER INSA
IDENTIFIED BY INSA
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP
QUOTA 1M ON USERS;


SELECT * FROM DBA_USERS;

--���� DB�� ������ ������� ����Ʈ Ȯ��
SELECT * FROM V$SESSION
WHERE USERNAME IS NOT NULL;

--������ ���� 
--CREATE TABLE ������ �ްԵǸ� ALTER,DROP TABLE�� �ڵ����� �ο���
--CREATE ANY TABLE : �ٸ� ������� ���̺� ������� �� ���� 

--SYSTEM ���� : DATABACE�� OBJECT���� CREATE(����),ALTER(����),DROP(����) �� �� �ִ� ����
--              DBA -> USERS
--OBJECT ���� : USER�� ���� OBJECT�� ����(INSERT,UPDATE,DELETE,SELECT)
--OBJECT : TABLE,ROLE,SEQUENCE,VIEW,SYNONIM
--------------------------------------------------
SELECT * FROM SYSTEM_PRIVILEGE_MAP;

GRANT CREATE USER TO KIM; --PUBLIC : �����
GRANT CREATE SESSION TO TEST;

SELECT * FROM ALL_USERS;

--OBJECT ����
--�ٸ� ����ڿ��� ���� ���̺����� ������ ��
--TEST�� KIM���̺��� ������ �ο��ް� ����Ϸ��� FROM�� KIM.���̺������ ǥ���ؾ���
--�׶� ������ KIM�� ��Ű����� �� 

GRANT CREATE SESSION, CREATE SYNONYM TO TEST;

--���̺� ��Ī�� �༭ ����� �� �ְ��ϴ� ��ɾ�
--CREATE SYNONYM KIMDIV FOR KIM.DIVISION;
--SELECT * FROM KIMDIV; �� ��� ���� 
------------------------------------------------------------------------------------------------
--ROLE(����)
--CONNECT,RESOURCE

SELECT * FROM ROLE_SYS_PRIVS WHERE ROLE IN('CONNECT','RESOURCE','MANAGER');

CREATE ROLE MANAGER;

SELECT * FROM DBA_ROLES;

GRANT CREATE SESSION,CREATE TABLE,CREATE USER TO MANAGER;

GRANT MANAGER TO INSA;
REVOKE MANAGER FROM INSA;

GRANT CREATE VIEW TO kim;