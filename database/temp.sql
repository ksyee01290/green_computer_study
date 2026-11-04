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

--UPPER 와 LOWER은 대소문자 변환해주는 함수이다
SELECT *
FROM EMP
WHERE UPPER(ENAME) = UPPER('scott');

SELECT *
FROM EMP
WHERE UPPER(ENAME) LIKE UPPER('%scott');

SELECT *
FROM emp
WHERE LOWER(ENAME) = LOWER('scott');

--LENGTH는 상당히 중요한 함수다 길이를 재주는 함수인데 쓰임세가 무궁무진하다
SELECT ENAME, LENGTH(ENAME)
FROM emp;

SELECT ENAME, LENGTH(ENAME)
FROM emp
WHERE LENGTH(ENAME) >= 5;

--문자열의 일부분 범위를 지정해서 추출한다
SELECT job, SUBSTR(job, 1, 2), SUBSTR(job, 3, 2), SUBSTR(job, 5)
FROM emp;

--INSTR 같은경우는 특정 문자를 찾는 역할을한다.
SELECT * FROM emp
WHERE INSTR(ENAME, 'S') > 0;

-- REPLACE는 스페이스바나 특정문자를 없애주는 역할을 한다.
SELECT '010-1234-5678' AS REPLACE_BEFORE,
REPLACE('010-1234-5678','-',' ') AS REPLACE_1,
REPLACE('010-1234-5678','-') AS REPLACE_2
FROM DUAL;

--L,RPAD 같은경우는 문자열에 스페이스바를 삽입하거나 특정문자를 삽입할때
--사용한다 각각 왼쪽과 오른쪽이다 예시는 아래와 같다
SELECT 'Oracle',
LPAD('Oracle',10,'#') AS LPAD_1,
RPAD('Oracle',10,'*') AS LPAD_1,
LPAD('Oracle',10) AS LPAD_2,
RPAD('Oracle',10) AS LPAD_2
FROM DUAL;

--concat 는 두 문자열 데이터를 합치는 경우에 사용한다 아래와같이 중첩으로 사용 가능하다.
--테이블에있는 데이터와 입의의 데이터를 합친 concat 데이터를 합칠수 있다.
SELECT CONCAT(empno, ename),
CONCAT(empno, CONCAT(' : ',ENAME))
FROM emp
WHERE ENAME = 'SCOTT';

--TRIM 은 스페이스바와 같은 데이터를 지워주는 역할을 한다.
--LEADING FROM 같은경우는 오른쪽 스페이스바는 남기고 왼쪽만 지운다
--TRAILING FROM 같은경우는 왼쪽 스페이바는 남기고 오른쪽만 지운다
--BOTH FROM 같은 경우는 양쪽모두의 스페이스바를 지운다
--단 위 4개의 모든경우에 문자와 문자간의 스페이스바는 지우지 않는다.
SELECT '[' || TRIM('  Oracle  SAS  AAA  ') || ']' AS TRIM,
'[' || TRIM(LEADING FROM '  Oracle     ') || ']' AS TRIM_LEADING,
'[' || TRIM(TRAILING FROM '  Oracle     ') || ']' AS TRIM_TRAILING,
'[' || TRIM(BOTH FROM '  Oracl  e     ') || ']' AS TRIM_BOTH
FROM DUAL;

--ROUND는 소수점을 어디까지 반올림을 표현할지에대한 함수다
SELECT ROUND(1234.5678) AS ROUND,
ROUND(1234.5678,0) AS ROUND_0,
ROUND(1234.5678,1) AS ROUND_1,
ROUND(1234.5678,2) AS ROUND_2,
ROUND(1234.5678,-1) AS ROUND_MINUS1,
ROUND(1234.5678,-2) AS ROUND_MINUS2
FROM DUAL;

--TRUNC는 소수점을 반올림하지 않고 표현을 한다.
SELECT TRUNC(1234.5678) AS TRUNC,
TRUNC(1234.5678, 0) AS TRUNC_0,
TRUNC(1234.5678, 1) AS TRUNC_1,
TRUNC(1234.5678, 2) AS TRUNC_2,
TRUNC(1234.5678, -1) AS TRUNC_MINUS1,
TRUNC(1234.5678, -2) AS TRUNC_MINUS2
FROM DUAL;

--CEIL은 ()안에 지정된 숫자와 가장 가까운 큰 정수를 표현할때
--FLOOR은 ()안의 지정 된 숫자와 가장가까운 작은정수를 표현할때
-- 위의 숫자 모드 소수점일때 반올림이나 이런건 신경안써도 된다
-- 음수의 표현일때도 소수점 신경 안쓰고 3.14 중간에서 가장 가까운 작은수 가장가까운 큰수
--를 표현해 주면 된다
SELECT CEIL(3.14) AS PI,
FLOOR(3.84) AS PI1,
CEIL(-3.14) AS PI3,
FLOOR(-3.14) AS PI4
FROM DUAL;

--다른 언어에서 %가 나머지를 구하는 단어이지만 SQL에서는 MOD가 나머지를 구하는 단어이다
-- 계산할때는 (기준값, 나눈값) 으로 계산이된다
SELECT MOD(15,6) AS MOOD,
MOD(10,2) AS MOOOOD,
MOD(11,2) AS MOOOOOOOD
FROM DUAL;

--SYSDATE 는 날짜데이터를 사용할때 쓰지만 -1 +1 처럼 계산해서 사용가능하다
SELECT SYSDATE AS NOW,
SYSDATE-1 AS YESTERDAY,
SYSDATE+1 AS TOMORROW
FROM DUAL;

--ADD_MONTHS 같은경우는 (날짜데이터, 이후의 달) 이런식으로 지정해서 사용한다 
SELECT SYSDATE,
ADD_MONTHS(SYSDATE, 3)
FROM DUAL;
-- 아래와같이 현재 날짜데이터가 아닌 테이블에 있는 날짜데이터를 지정해서 사용도 가능하다
-- 기본 1은 1개월이다 120은 10년으로 계산 가능하다.
SELECT EMPNO, ENAME, HIREDATE,
ADD_MONTHS(HIREDATE, 384) AS WORK10YEAR
FROM EMP;

-- 아래와 같이 조건문으로 사용도 가능하다
--아래 문제는 기존 날짜 데이터에 32년을 더한것이 현재 시간대보다 크면 표시를 하는 문제이다
SELECT EMPNO, ENAME, HIREDATE, SYSDATE
FROM EMP
WHERE ADD_MONTHS(HIREDATE, 384) > SYSDATE;

--MONTHS_BETWEEN 은 두 날짜간의 개월수 차이를 나타내는 형식이다 마지막 부분에 TRUNC같은경우는
--소수점을 제거한 보기편한거라고 보면된다.
SELECT EMPNO, ENAME, HIREDATE, SYSDATE,
MONTHS_BETWEEN(HIREDATE, SYSDATE) AS MONTHS1,
MONTHS_BETWEEN(SYSDATE, HIREDATE) AS MONTHS2,
TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) AS MONTHS3
FROM EMP;

--NEXT_DAY 같은경우 (현재날짜 데이터, 지정한 요일) 로 사용가능한대7일을 넘기는 것은 안된다
--딱 다음주의 날짜까지만 계산 () 안의 지정한요일에 숫자를 써도 무관하다 7까지만
SELECT SYSDATE,
NEXT_DAY(SYSDATE, '월요일') AS NEXT_WEEK,
LAST_DAY(SYSDATE) AS LAST_DAY
FROM DUAL;

--TO_CHAR은 숫자 또는 날짜데이터를 문자형태로 변환해주는 역할을한다.
SELECT SYSDATE,
TO_CHAR(SYSDATE,'HH24:MI:SS') AS HH24MISS,
TO_CHAR(SYSDATE,'HH12:MI:SS AM') AS HHMISS_AM,
TO_CHAR(SYSDATE,'HH:MI:SS P.M.') AS HHMISS_PM
FROM DUAL;

--TO_NUMBER은 문자데이터를 숫자 데이터로 바꿔주는 역할을한다 주의해야할점은 
--('1000','9999')이런식으로 문자 뒤에 자릿수를 써줘야한다 
--('1000','99999')이렇게 초과해서 써주는건 상관없지만
--('1000','000')이렇게 적게써주면 오류가난다 참고로 0을 사용해도 괜찮다.
SELECT TO_NUMBER('1300','0000')- TO_NUMBER('1500','999999')
FROM DUAL;

--TO_DATE는 문자열을 날짜 데이터로 변환하는 역할을 한다.
SELECT TO_DATE('2018-07-14','YYYY-MM-DD') AS TODATE1,
TO_DATE('20180714','YYYY-MM-DD') AS TODATE2
FROM DUAL;

SELECT * FROM EMP
WHERE HIREDATE > TO_DATE('1981/06/01','YYYY/MM/DD');

--NVL 같은 경우는 NULL이 있을경우 0을 대입한다 NULL이 아닐경우는 넘어간다.
SELECT EMPNO, ENAME, SAL, COMM, SAL+COMM,
NVL(COMM,0),
SAL+NVL(COMM,0)
FROM EMP;

--NVL2는 튜플에 NULL이 있을경우와 없을경우에 원하는 문자를 집어 넣거나 원하는 계산을 넣을수있다.
SELECT EMPNO, ENAME, COMM,
NVL2(COMM,'O','X'),
NVL2(COMM, SAL*12+COMM, SAL*12) AS ANNSAL
FROM EMP;

--DECODE는 기준데이터를 꼭 정해야만한다 꼭정해서 원하는 튜플에 값을 수정하거나
--계산하는 작업을 할수있다.
SELECT EMPNO, ENAME, JOB, SAL,
DECODE(JOB,
'MANAGER', SAL*1.1,
'SALESMAN', SAL*1.05,
'ANALYST', SAL,
SAL*1.03) AS UPSAL
FROM EMP;

--CASE 구문인데 CASE 옆에 기준데이터를 정해도 되고 안정해도 작동한다.
SELECT EMPNO, ENAME, JOB, SAL,
CASE JOB
WHEN 'MANAGER' THEN SAL*1.1
WHEN 'SALESMAN' THEN SAL*1.05
WHEN 'ANALYST' THEN SAL
ELSE SAL*1.03
END AS UPSAL
FROM EMP;

SELECT EMPNO, ENAME, COMM,
CASE
WHEN COMM IS NULL THEN '해당사항 없음'
WHEN COMM = 0 THEN '수당 없음'
WHEN COMM > 0 THEN '수당 : ' || COMM
END AS COMM_TEXT
FROM EMP;

-- AS 사용할때에는 띄어쓰기랑 숫자를 쓰면 실행 오류난다
SELECT SUM(SAL) AS 총합
FROM EMP;

SELECT SUM(DISTINCT SAL) AS 중복제거한사람,
SUM(ALL SAL) AS 총합,
SUM(SAL) AS 총합
FROM EMP;

--숫자를 카운팅 하는 함수 나중에 조건으로 중복된 사람을 카운트하는 일도 생긴다
SELECT COUNT(*) AS 피플
FROM EMP;

SELECT COUNT(*) AS 사람들
FROM EMP
WHERE DEPTNO = 30;

SELECT COUNT(SAL) AS 기준값
FROM EMP;

--최대값을 찾는 함수다
SELECT MAX(SAL) AS 최대값
FROM EMP
WHERE DEPTNO = 10;

SELECT MAX(HIREDATE) AS 가장 최근 날짜
FROM EMP
WHERE DEPTNO = 20;

--최솟값을 찾는 함수다
SELECT MIN(SAL) AS 최솟값
FROM EMP
WHERE DEPTNO = 10;

SELECT MIN(HIREDATE) AS 가장오래된 날짜
FROM EMP
WHERE DEPTNO = 20;

--조건에 맞는 평균값을 구하는 함수
SELECT AVG(SAL) AS 평균
FROM EMP
WHERE DEPTNO = 30;

SELECT AVG(DISTINCT SAL) AS 평균
FROM EMP
WHERE DEPTNO = 30;

SELECT ROUND(AVG(SAL),1) AS 평균,'10' AS DEPTNO 
FROM EMP
WHERE DEPTNO = 10
UNION ALL
SELECT AVG(SAL), '20' AS DEPTNO 
FROM EMP
WHERE DEPTNO = 20
UNION ALL
SELECT ROUND(AVG(SAL),2), '30' AS DEPTNO 
FROM EMP
WHERE DEPTNO = 30;

--여기서보면 그룹바이로 DEPTNO를 했다 출력부분에 AVG(SAL)을 출력하라는데 DEPTNO의 중복된
--놈들끼리 평균값을 계산해줘야 하는거였다.
SELECT AVG(SAL), DEPTNO
FROM EMP
GROUP BY DEPTNO;

-- 이거 같은경우도 동일하다 DEPTNO와 JOB 각각의 중복되는 값의 평균을 구하는거다
SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;

-- 여기부터 HAVING 라는 조건식이들어간다 WHERE랑 다를거없다 하지만 그룹바이에서는
-- HAVING를 써야한다.
SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >= 2000
ORDER BY DEPTNO, JOB;

SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
WHERE SAL <= 3000
GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >= 2000
ORDER BY DEPTNO, JOB;

SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB DESC;

--테스트 였는 데 틀림 틀린이유 그룹바이로 잡을 그룹지었는데 HAVING AVG(SAL)조건에서
--AVG(SAL)을 계산하던중 중복된JOB를 평균계산해야하는데 계산안하고 나열해버렸다
-- 내가 생각했던 AVG(SAL)은 각각의 개인별의 평균인 줄알았다 그룹으로 묶으면 그룹기준
--으로 중복된 놈들끼리 계산해줘야한다는걸 알았다
SELECT JOB, AVG(SAL)
FROM EMP
WHERE DEPTNO <30
GROUP BY JOB
HAVING AVG(SAL) >= 2000
ORDER BY JOB;

--단일 조인 E.DEPTNO 같이 써도 괜찮다 다중 중첩조인일경우 문제가 발생
--FROM 에 테이블 두개를 EMP, DEPT를 붙여 놓는건 두테이블을 합친게 아니다 그냥 옆에 붙여논거다
SELECT *
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
ORDER BY EMPNO;

SELECT *
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
ORDER BY EMPNO;

SELECT *
FROM EMP E, SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL;

SELECT E.EMPNO, E.ENAME, E.SAL, D.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND SAL >= 3000;

SELECT E1.EMPNO, E1.ENAME, E1.MGR,
E2.EMPNO AS MGR_EMPNO,
E2.ENAME AS MGR_ENAME
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO;

--NATURAL JOIN 두테이블의 같은 열 기준 JOIN USING 와 달리 따로 명시할 필요없이
--테이블간에 비교를 해서 같은 열이 있으면 하나로 통합해주는 역할을한다.
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, DEPTNO, D.DNAME,D.LOC
FROM EMP E NATURAL JOIN DEPT D
ORDER BY DEPTNO, E.EMPNO;

--SELECT 구문에 있는 단일로 DEPTNO 가 있는데 이렇게 쓴 이유는 JOIN USING(DEPTNO) 자체에서 명시를 해줘야만
--DEPTNO를 두개의 태이블에서 알아서 찾아서 합쳐주는 역할을 한다. 그래서 SELECT 부분에
--DEPTNO를 단일로 써도 EMP테이블과 DEPT 테이블을 둘다 참조가 가능하다
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, DEPTNO, D.DNAME, D.LOC
FROM EMP E JOIN DEPT D USING(DEPTNO)
WHERE SAL >= 3000
ORDER BY E.EMPNO;

--
SELECT SAL
FROM EMP
WHERE ENAME = 'JONES';

SELECT *
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME='JONES');

--
SELECT *
FROM EMP
WHERE HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME ='SCOTT');

--
SELECT E.EMPNO, E.ENAME, E.JOB, E.SAL, D.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.DEPTNO = 20
AND E.SAL > (SELECT AVG(SAL) FROM EMP);

--
