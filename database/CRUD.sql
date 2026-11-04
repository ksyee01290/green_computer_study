--CRUD 중 데이터 추가 수정 삭제부분
-- 여기에서의 AS는 열이름을 지정해주는 게 아니라 새로만든 테이블에
--기존 테이블을 복사하는 의미를 가진다 꼭기억하자
CREATE TABLE DEPT_TEMP
AS SELECT * FROM DEPT;

SELECT * FROM DEPT_TEMP;

INSERT INTO DEPT_TEMP(DEPTNO, DNAME, LOC)
VALUES (50,'DATABASE','SEOUL');

-- 열이름을 따로 지정해주지 않아도 VALUES에 처음부터 순서대로 들어간다
INSERT INTO DEPT_TEMP
VALUES (60, 'NETWORK', 'BUSAN');
--DEPT_TEMP테이블은 기존 테이블을 복사한 테이블이라 제약조건까지는 복사가 안된다
--그러므로 NULL값이 들어갈수있다 만약 제약조건에 프라이머리 키를 설정했을경우
--NULL값을 넣으려는순간 들어갈수없다고 실행 오류를 말해준다
INSERT INTO DEPT_TEMP(DEPTNO, DNAME, LOC)
VALUES (70, 'WEB', NULL);
--아래와 같이 빈칸도 널값으로 들어가버린다.
INSERT INTO DEPT_TEMP(DEPTNO, DNAME, LOC)
VALUES (80,'MOBILE','');
--아래와 같이 열이름이 순서대로가 아니어도 열이름에 맞춰서 순서대로 들어간다
INSERT INTO DEPT_TEMP(DEPTNO, LOC)
VALUES (90,'INCHEON');

--이번엔 EMP_TEMP를 만든다 AS 를 이용해 EMP 테이블을 복사해오지만
--여기에 WHERE 1<>1이 들어온다 이것은 EMP테이블을 복사해오지만 데이터는 
--가져오지 않는다 대신 NULL값이 들어간다 그렇다고해서 기존에 있던 데이터
--수만큼 데이터에 NULL을 집어 넣는다는 소리는 아니다 아마도...
-- 제약조건은 복사해오지 않는다
CREATE TABLE EMP_TEMP
AS SELECT * FROM EMP WHERE 1<>1;

SELECT * FROM EMP_TEMP;

-- 데이터 입력할때 날짜데이터 같은 경우는 오류가 날경우 ''까지 전부 지우고 다시
--써야한다 안지우면 계속 오류가 날 가능성이 있다.
INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES(9999, '홍길동', 'PRESIDENT', NULL, '2001/01/01', 5000, 1000, 10);
INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES(1111, '성춘향','MANAGER', 9999, '2001-01-05', 4000, NULL, 20);
INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES(2111, '이순신', 'MANAGER', 9999, '2001/02/19', 4000, NULL, 20);

--임의로 지정한 날짜 형식을 원하는 날짜데이터 형식으로 바꾸는 게 TO_DATE로 가능하다
INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES(2111, '이순신', 'MANAGER', 9999,
    TO_DATE('07/01/2001','DD/MM/YYYY'), 4000, NULL, 20);
INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES(3111, '심청이', 'MANAGER', 9999, SYSDATE, 4000, NULL, 30);

SELECT * FROM EMP_TEMP;

--서브쿼리를 사용하여 한번에 여러데이터를 추가할수있다. 아래와같은경우는
--EMP_TEMP테이블의 특정 필드에대한 자료를 찾아서 업데이트
--두개의 테이블에서 데이터를 가져온다
-- E.SAL 이 S.LOSAL 과 S.HISAL 의조건이 맞을때 S.GRADE = 1이라는 조건 가져와서
--보여준다 여기부분은 데이터를 추가하는것이지 수정하는 부분은 아니다
INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, E.DEPTNO
FROM EMP E, SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL AND S.GRADE = 1;

SELECT * FROM EMP E, SALGRADE S;
SELECT * FROM EMP_TEMP;

--이건 DEPT_TEMP2 테이블을 생성하는거다 예시를보면 DEPT의 데이터를
--전부 긁어오는 작업이다.
CREATE TABLE DEPT_TEMP2
AS SELECT * FROM DEPT;
SELECT * FROM DEPT_TEMP2;

-- ========================데이터 수정=========================
-- 이부분같은경우는 제한조건이 없으므로 DEPT_TEMP2에 있는 LOC의 모든걸
--'SEOUL'로 변환한다는 거다 이렇게 쓰면 안된다
UPDATE DEPT_TEMP2
SET LOC = 'SEOUL';
SELECT * FROM DEPT_TEMP2;
-- 실수를 했을경우 롤백을 쓰면 가장 최근에 업데이트한 내용을 되돌릴수있다.
-- 롤백은 DCL언어라한다.
ROLLBACK;

-- WHERE로 조건을 넣어서 수정할수있다 
UPDATE DEPT_TEMP2
SET DNAME = 'DATABASE', LOC = 'SEOUL'
WHERE DEPTNO = 40;
SELECT * FROM DEPT_TEMP2;

--서브쿼리를 사용하여 데이터수정이 가능하다 가독성 좋게 똑같은 조건이라면
--()모아서 조건을 넣으면 된다.
UPDATE DEPT_TEMP2
SET(DNAME, LOC) = (SELECT DNAME, LOC 
                    FROM DEPT 
                    WHERE DEPTNO = 40)
WHERE DEPTNO = 40;
SELECT * FROM DEPT_TEMP2;

--각 각의 필드를 수정 조건을 걸수 있지만 가독성이 떨어져서 위쪽 예시를 주로
--사용 할거같다.
UPDATE DEPT_TEMP2
SET DNAME = (SELECT DNAME
                FROM DEPT
                WHERE DEPTNO = 40),
    LOC = (SELECT LOC
            FROM DEPT
            WHERE DEPTNO = 40)
WHERE DEPTNO = 40;
SELECT * FROM DEPT_TEMP2;

--WHERE 절 검증예시인대 만약 LOC 를 전부 SEOUL로 바꿀건데
--조건으로 DEPT_TEMP2 테이블에 DNAME 가 'OPERATIONS'일 경우에
--LOC = 'SEOUL' 로 바꾸는 걸 허락한다 라는 의미가 된다
-- DEPTNO를 검증대상으로 삼은이유는 기본키로 사용할수있어서 인거같다
UPDATE DEPT_TEMP2
SET LOC = 'SEOUL'
WHERE DEPTNO = (SELECT DEPTNO
                FROM DEPT_TEMP2
                WHERE DNAME='OPERATIONS');
SELECT * FROM DEPT_TEMP2;
ROLLBACK;

-- ========================데이터 삭제=========================
CREATE TABLE EMP_TEMP2
AS SELECT * FROM EMP;

SELECT * FROM EMP_TEMP2;

--
DELETE FROM EMP_TEMP2
WHERE JOB = 'MANAGER';
SELECT * FROM EMP_TEMP2;

DELETE FROM EMP_TEMP2
WHERE EMPNO IN (SELECT E.EMPNO
                FROM EMP_TEMP2 E, SALGRADE S
                WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL
                AND S.GRADE = 3
                AND DEPTNO = 30);
                ROLLBACK;

SELECT E.EMPNO
    FROM EMP_TEMP2 E, SALGRADE S
    WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL
    AND S.GRADE = 3
    AND DEPTNO = 30;
                
SELECT * FROM EMP_TEMP2;