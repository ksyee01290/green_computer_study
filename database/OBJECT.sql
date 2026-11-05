--객체 종류

--인덱스 생성
--
CREATE INDEX IDX_EMP_SAL
ON EMP(SAL);

SELECT * FROM USER_IND_COLUMNS;

--인덱스 삭제
DROP INDEX IDX_EMP_SAL;

--뷰의 생성
--GRANT 로 권한 부여를 해주고 권한 회수를 따로 진행 해줘야한다.
GRANT CREATE VIEW TO SYSTEM;

CREATE VIEW VW_EMP20
AS(SELECT EMPNO, ENAME, JOB, DEPTNO 
    FROM EMP
    WHERE DEPTNO = 20);

SELECT * FROM VW_EMP20;
--GRANT 로 권한 부여한걸 회수한다.
ROLLBACK;

--테이블처럼 조회가능
SELECT * FROM USER_VIEWS;

--시퀀스 생성 중요!!
--시퀀스란 번호 생성기
--ROWNUM은 기본키로 작업하기 좋다.
SELECT ROWNUM, E.* FROM EMP E;

SELECT ROWNUM, E.* FROM(SELECT *
                        FROM EMP E
                        ORDER BY SAL DESC) E;

--
WITH E AS (SELECT * FROM EMP
            ORDER BY SAL DESC)
SELECT ROWNUM, E. *
FROM E;

--
SELECT ROWNUM, E.*
FROM(SELECT *
    FROM EMP E
    ORDER BY SAL DESC) E
    WHERE ROWNUM <=3;
    
--시퀀스로 번호생성
CREATE TABLE DEPT_SEQUENCE
AS SELECT * FROM DEPT
WHERE 1<>1;

SELECT * FROM DEPT_SEQUENCE;

--시퀀스 형식을 처음 설정하는 단계
CREATE SEQUENCE SEQ_DEPT_SEQUENCE
-- 카운트를 10 단위로 하겠다.
INCREMENT BY 10
--
START WITH 10
--사이클 돌최대치와 사이클 시작지점을 표시한다.
MAXVALUE 99
MINVALUE 0
--NOCYCLE같은경우는 사이클을 한번 돌았을때 기존에 데이터를 삭제하면
--그삭제한 부분의 시퀀스는 채워지지않는다 하지만 CYCLE를 사용할경우
--삭제한 부분의 시퀀스는 채워진다. 그리고 MAXVALUE 지점에 도달했을경우
--NOCYCLE 같은경우는 더이상 채워지지않고 오류를 띄워준다.
--CYCLE 같은경우는 계속 MINVALUE로 돌아가 다시 MAXVALUE까지 무한으로 돌아간다.
NOCYCLE
CACHE 2;

--시퀀스 형식을 수정할수있다
ALTER SEQUENCE SEQ_DEPT_SEQUENCE
INCREMENT BY 1
MAXVALUE 10
NOCYCLE;

--시퀀스를 적용하여 인서트를 해주는 부분
INSERT INTO DEPT_SEQUENCE(DEPTNO, DNAME, LOC)
VALUES(SEQ_DEPT_SEQUENCE.NEXTVAL, 'DATABASE', 'SEOUL');

DELETE FROM DEPT_SEQUENCE 
WHERE DEPTNO >= 5;

SELECT * FROM DEPT_SEQUENCE ORDER BY DEPTNO DESC;

