DESC EMP;
DESC DEPT;
DESC SALGRADE;
-- select 는 찾고자하는 튜플 을 지정하는것 *같은 경우는 모든 튜플을 가리킨다
-- from 같은경우는 테이블을 가르키는데 원하는 테이블 하나를 가르킨다
select * from emp;

select empno, ename, job 
from emp;

select * from dept;

--distinct 같은경우는 열중복을 제거한다
select distinct deptno from emp;
select deptno from emp;

--만약 sal*12+comm as annsal 이러한 구문에서 as annsal 의 뜻은
--sal*12+comm 이러한 계산식을 as annsal 로 바꿔준다는 뜻이다
--as annsal을 작성하지 않을경우 튜플로 sal*12+comm 이런 이름그대로 들어간다
select ename, sal, sal*12+comm as annsal, comm from emp;

--order by 는 정렬방식이다 기본적으로 쓰면 asc(오름차순)으로 자동으로 정렬되고
--desc(내림차순) 는 직접 써야 적용이 된다. 쓸때는 꼭 열 이름 뒤에 써야한다
select * from emp order by sal;
select * from emp order by sal desc;

--where 는 조건식이다 기본적으로 참거짓을 판별하는데 조건이 맞다면 참 아니면 거짓이다
--and 같은경우는 조건 두개가 전부 같을 경우 or 같은경우는 조건 두개중 하나만 맞아도 참이다
SELECT * FROM emp WHERE DEPTNO = 30;
SELECT * FROM emp WHERE DEPTNO = 30 AND JOB = 'SALESMAN';
SELECT * FROM emp WHERE DEPTNO = 30 OR JOB = 'SALESMAN';

--비교연산자 같은경우는 설명안하겠다 <>이거는 같지 않다라는 뜻이다
SELECT * FROM emp WHERE SAL >=3000;
SELECT * FROM emp WHERE ENAME >= 'F';

SELECT * FROM emp WHERE SAL != 3000;
SELECT * FROM emp WHERE SAL <> 3000;

-- not 같은 경우는 아래의 예시에서 3000을 제외한 나머지를 출력하라는 뜻이다
SELECT * FROM emp WHERE NOT SAL = 3000;

-- in 같은 경우는 or을 여러번 쓸것을 한번에 모아서 사용할수있다.
SELECT * FROM emp WHERE JOB IN ('MANAGER','SALESMAN','CLERK');
SELECT * FROM emp WHERE JOB = 'MANAGER' OR JOB = 'SALESMAN' OR JOB = 'CLERK';

-- between 같은 경우는 ~에서 ~까지 라는뜻이다 참고로 or은 못쓴다
SELECT * FROM emp WHERE SAL BETWEEN 2000 AND 3000;
SELECT * FROM emp WHERE SAL NOT BETWEEN 2000 AND 3000;

-- LIKE 같은 경우는 아래와 같이 쓰인다 
-- S%는 이름에 S가 들어있을경우 길이와 상관없이 모든 문자데이터를 의미
SELECT * FROM emp WHERE ENAME LIKE 'S%';
-- _L%는 어떤 값이든 상관없이 한개의 문자 데이터
SELECT * FROM emp WHERE ENAME LIKE '_L%';
-- %AM% AM을 포함한 데이터
SELECT * FROM emp WHERE ENAME LIKE '%AM%';
SELECT * FROM emp WHERE ENAME NOT LIKE '%AM%';

-- NULL 같은경우는 데이터가 존재하지 않는다는 뜻이다
-- IS NULL 은 데이터가 NULL일때 참
-- IS NOT NULL 은 데이터가 NULL이 아닐때 참
SELECT * FROM emp WHERE COMM = NULL;
SELECT * FROM emp WHERE COMM IS NULL;
SELECT * FROM emp WHERE MGR IS NULL;
SELECT * FROM emp WHERE SAL > NULL AND COMM IS NULL;
SELECT * FROM emp WHERE SAL > NULL OR COMM IS NULL;

SELECT * FROM EMP;
-- UNION 중복이 제거되는 합집합
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO = 10
UNION
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM emp 
WHERE DEPTNO = 20;

-- 아래 예시처럼 집합연산자를 활용할때 SELECT이름이 틀리면 오류가 난다.
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM emp
WHERE DEPTNO = 10
UNION 
SELECT EMPNO, ENAME, SAL
FROM emp 
WHERE DEPTNO = 20;

-- UNION ALL 은 중복을 허용하는 합집합이다
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM emp
WHERE DEPTNO = 10
UNION ALL
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM emp 
WHERE DEPTNO = 10;

-- MINUS 는 차집합
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM emp
MINUS
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM emp 
WHERE DEPTNO = 10;

--INTERSECT 는 교집합이다
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM emp
INTERSECT
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM emp 
WHERE DEPTNO = 10;