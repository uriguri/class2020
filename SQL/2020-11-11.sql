-- 2020.11.11

-- JOIN

-- CROSS JOIN : 조건 없이 테이블과 테이블을 붙여준다

SELECT *
FROM emp, dept
;

-- ANSI JOIN : CROSS JOIN
SELECT *
FROM emp CROSS JOIN dept
;

-- Equi Join
select *
from emp, dept
where emp.deptno=dept.deptno
;

-- ANSI ->T1 Inner Join T2 ON 조인의 조건
SELECT *
FROM emp INNER JOIN dept
ON emp.deptno = dept.deptno
;

-- USING 사용하기
SELECT *
FROM emp JOIN dept
-- ON emp.deptno = dept.deptno
USING(deptno) -- 공통 컬럼은 하나만 가지게 해준다. 공통컬럼을 구별할 필요가 없다.
;

-- NATURAL JOIN : 동일 컬럼 조인의 조건을 생략 , 같은 이름의 컬럼은 하나씩
SELECT ename, deptno, dname
FROM emp NATURAL JOIN dept
;

-- ANSI Outer Join
-- T1[LEFT | RIGHT | FULL] OUTER JOIN T2

SELECT *
FROM emp m RIGHT OUTER JOIN emp e
ON e.mgr = m.empno
;

-- 회원 , 구매
-- customer , orders
select * from customer;
select * from orders order by custid;

select *
from customer c, orders o
where c.custid = o.custid(+)
;

-- 회원별 구매 횟수
select c.name, count(o.orderid), sum(o.saleprice), avg(o.saleprice)
from customer c, orders o
where c.custid = o.custid(+)
group by c.name
;

-- SCOTT의 사원번호와 이름, 부서이름, 지역을 출력
select *
from emp, dept
where emp.deptno=dept.deptno AND ename='SCOTT'
;

-- 별칭 붙여보기
select emp.empno, emp.ename, emp.deptno, dept.dname, dept.loc
from emp, dept
where emp.deptno=dept.deptno AND ename='SCOTT'
;

select e.empno, e.ename, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno=d.deptno AND ename='SCOTT'
;

-- Non Equi Join : 동등 비교가 아닌 비교연산이 가능

-- 급여 등급을 5개로 나누어 놓은 salgrade에서 정보를 얻어 와서 
-- 각 사원의 급여 등급을 지정해보도록 합시다. 
-- 이를 위해서 사원(emp) 테이블과 급여 등급(salgrade) 테이블을 조인하도록 합시다. 
-- 사원의 급여가 몇 등급인지 살펴보자

-- 1. Cross Join
SELECT  *
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal
;

SELECT * FROM salgrade;

-- Self Join : 자신의 테이블을 조인
-- SMITH 매니저 이름이 무엇인지?

SELECT ename FROM emp WHERE empno=7902;

SELECT e.ename, e.mgr, m.ename
FROM emp e, emp m
WHERE e.mgr=m.empno
AND e.ename='SMITH'
;


SELECT e.ename, e.mgr, m.ename
FROM emp e, emp m
WHERE e.mgr=m.empno(+)
;


--=====================================서브쿼리================

-- 서브 쿼리

-- 스칼라 부속질의 - SELECT 부속질의, 단일 행 단일열
-- 인라인 뷰      - FROM 부속질의, 복합 행 복합 열
-- 중첩 질의      - WHERE 부속질의, 단일 열, 단순비교 -> 단일 행, 집합 비교 -> 복합 행

-- 중첩 질의 : 단순 비교

-- 평균 급여(sub query)보다 더 많은 급여를 받는 사원을 검색해보자

SELECT avg(sal) FROM emp;
-- 2073.214285714285714285714285714285714286

SELECT *
FROM emp
WHERE sal > 2073.214285714285714285714285714285714286 -- 평균 급여
;

SELECT *
FROM emp
WHERE sal > (SELECT avg(sal) FROM emp) -- 평균 급여
;

-- SCOTT 사원의 같은 부서에 근무하는 사원의 리스트를 출력
SELECT deptno FROM emp WHERE ename = 'SCOTT';

SELECT ename
FROM emp
WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'SCOTT')
;

-- sal 3000 이상 받는 사원이 소속된 부서 
SELECT DISTINCT deptno FROM emp WHERE sal >= 3000;

SELECT *
FROM emp
--WHERE deptno=10 or deptno=20
WHERE deptno IN (SELECT DISTINCT deptno FROM emp WHERE sal >= 3000)
;

-- 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 
-- 더 많은 급여를 받는
-- 사람의 이름, 급여를 출력하는 쿼리문을 작성해보자.
SELECT sal FROM emp WHERE deptno = 30;

--SELECT max(sal) FROM emp WHERE deptno = 30;

SELECT ename, sal
FROM emp
-- WHERE sal > 2850
-- WHERE sal > ALL (SELECT sal FROM emp WHERE deptno = 30) -- AND
WHERE sal > ANY (SELECT sal FROM emp WHERE deptno = 30) -- OR
;

-- ROWNUM
SELECT rownum, empno, ename, hiredate
FROM emp
WHERE ROWNUM < 4
ORDER BY hiredate
;

SELECT ROWNUM, empno, ename, hiredate FROM emp ORDER BY hiredate;

SELECT ROWNUM, empno, ename, hiredate
FROM (SELECT rownum, empno, ename, hiredate FROM emp ORDER BY hiredate DESC)
WHERE ROWNUM < 4
;

-- 가장 급여를 많이 받는 사원 3명을 출력하자
SELECT ROWNUM, ename, sal FROM emp ORDER BY sal DESC;

SELECT ROWNUM, ename, sal
FROM (SELECT ROWNUM, ename, sal FROM emp ORDER BY sal DESC)
WHERE ROWNUM < 4
;

-- mySQL --> top select * from emp limit 0, 3;

-- 스칼라 부속질의 : SELECT절 프리젠테이션 영역에 쓸 수 있는 부속질의다.
--                 단일행, 단일열, 단일값의 결과만 나와야한다.

SELECT name FROM customer WHERE custid=1;

SELECT custid, (SELECT name FROM customer WHERE customer.custid=orders.custid),
        saleprice, orderdate
FROM orders
;

-- 마당서점의 고객별 GROUP BY
-- 판매액을 보이시오 orders
-- (결과는 고객이름과 고객별 판매액을 출력).

SELECT c.custid, c.name, sum(o.saleprice)
FROM customer c, orders o
WHERE c.custid = o.custid(+)
GROUP BY c.custid, c.name
ORDER BY sum(o.saleprice)
;

SELECT o.custid, (
        SELECT name FROM customer c WHERE o.custid = c.custid
        ), SUM(o.saleprice)
FROM orders o
GROUP BY o.custid
;


SELECT custid, name
FROM customer
WHERE custid <= 2
;

-- 인라인 뷰 : from 절 이후에 들어가는 서브쿼리, 가상 테이블, ROWNUM 이 새롭게 생성된다.
SELECT c.name, sum(o.saleprice), avg(o.saleprice)
FROM orders o, (SELECT custid, name
                FROM customer
                WHERE custid <= 2
                ) c
WHERE o.custid = c.custid
GROUP BY c.name
;

-- 평균 주문금액 이하의 
-- 주문에 대해서 주문번호와 금액을 보이시오.
SELECT avg(saleprice) FROM orders;

SELECT orderid, saleprice
FROM orders
WHERE saleprice <= 11800 -- 평균 주문 금액
;

-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 보이시오.
SELECT avg(saleprice) FROM orders WHERE custid=1;

SELECT orderid, custid, saleprice
FROM orders o1
WHERE saleprice > (SELECT avg(saleprice) FROM orders o2 WHERE o2.custid = o1.custid) -- custid=1이면 1번고객의 평균과 비교해서
;

SELECT * FROM customer WHERE address LIKE '%대한민국%';

-- 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
SELECT sum(saleprice)
FROM orders
WHERE custid IN (SELECT custid FROM customer WHERE address LIKE '%대한민국%')
;

-- 3번 고객이 주문한 도서의 최고 금액보다
-- 더 비싼 도서를 구입한
-- 주문의 주문번호와 금액을 보이시오.
SELECT MAX(saleprice) FROM orders WHERE custid=3;


SELECT orderid, saleprice
FROM orders
-- WHERE saleprice > (SELECT MAX(saleprice) FROM orders WHERE custid=3)
WHERE saleprice > ALL (SELECT saleprice FROM orders WHERE custid=3)
;

-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
SELECT * FROM customer WHERE address LIKE '%대한민국%';

SELECT *
FROM orders o
WHERE EXISTS (SELECT * FROM customer c WHERE address LIKE '%대한민국%' AND o.custid = c.custid)
;

SELECT ename, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno AND ename = 'SCOTT'
;

select ename, dname, loc
from emp INNER JOIN dept
ON emp.deptno = dept.deptno
;

select ename, dname
FROM emp INNER JOIN dept
ON emp.deptno = dept.deptno
WHERE ename LIKE '%A%'
;

SELECT ename, job, dept.deptno, dname
FROM emp INNER JOIN dept
ON emp.deptno = dept.deptno
WHERE loc = 'NEW YORK'
;

SELECT *
from emp
;

SELECT e.ename, e.empno, m.ename MANAGER
FROM emp e, emp m
WHERE e.mgr = m.empno
;

SELECT e.ename, e.empno, e.mgr
FROM emp e, emp m
WHERE e.mgr = m.empno(+)
ORDER BY e.empno DESC
;

SELECT e.ename, e.deptno
FROM emp e, emp m
WHERE e.deptno = m.deptno AND m.ename = 'SCOTT'
;

SELECT e.ename, e.hiredate
FROM emp e, emp m
WHERE e.hiredate > m.hiredate AND m.ename = 'WARD'
ORDER BY e.hiredate
;

SELECT ename, hiredate
FROM emp
;

SELECT e.ename, e.hiredate, m.ename as MANAGER, m.hiredate as Mhiredate
FROM emp e, emp m
WHERE e.mgr = m.empno
;

SELECT job FROM emp WHERE empno = 7788;

SELECT ename, job
FROM emp
WHERE job = (SELECT job FROM emp WHERE empno = 7788)
;

SELECT sal FROM emp WHERE empno = 7499;

SELECT ename, job
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE empno = 7499)
;

SELECT min(sal)
FROM emp
;

SELECT ename, job, sal
FROM emp
WHERE sal = (SELECT MIN(sal) FROM emp)
;


