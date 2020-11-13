-- 2020.11.13

-- Transaction
-- 여러개의 SQL을 하나의 단위로 처리하는 것
-- 트랜잭션이 가지는 모든 작업이 모두 정상 처리되어야 트랜잭션이 완료되었다고 하는것.
-- 처리과정에서 오류가 발생하면 처음으로 돌아가 다시 트랜잭션을 시작

SELECT * FROM emp10;
desc emp10;

SELECT * FROM dept02;

-- 부서 테이블에 데이터 하나를 저장 - 정상 COMMIT
-- 사원 테이블에 새로운 사원을 입력 - 오류 ROLLBACK

-- Transation의 시작
INSERT INTO dept02 VALUES (50, 'RD', 'SEOUL');
INSERT INTO emp10 (empno, ename, job, sal) VALUES ('ten', 'TEN', 'MANAGER', 2500);
ROLLBACK; -- 오류가 발생해서 초기화 (마지막 commit 단계)
SELECT * FROM dept02;

-- 새로운 Transation 시작
INSERT INTO dept02 VALUES (50, 'RD', 'SEOUL');
INSERT INTO emp10 (empno, ename, job, sal) VALUES (7777, 'SEVEN', 'MANAGER', 2500);
SELECT * FROM dept02;
SELECT * FROM emp10;
COMMIT;

-- 새로운 Transation 시작
UPDATE emp10
SET mgr=(SELECT empno FROM emp10 WHERE ename = 'KING')
;
SELECT * FROM emp10;
-- 잘못 처리된 작업이다~_~ ROLLBACK
ROLLBACK;

-- 가상테이블 VIEW
-- 실제 테이블을 기반으로 논리적인 가상 테이블을 -> VIEW 라고 한다.
-- CREATE [OR REPLACE] VIEW view_name AS subquery

-- 자주 사용되는 30번 부서에 속한 사원들의 사번과 이름과 부서번호를 출력
CREATE VIEW view_emp30 
AS SELECT empno, ename, deptno FROM emp WHERE deptno = 30
;

SELECT * FROM view_emp30;

-- 전사 정보 출력 ( 사원 정보, 부서 정보 )
SELECT * 
FROM emp, dept
WHERE emp.deptno=dept.deptno
;

CREATE OR REPLACE VIEW view_emp_dept
AS SELECT empno, ename, job, mgr, hiredate, sal, comm, emp.deptno, dname, loc
FROM emp, dept
WHERE emp.deptno=dept.deptno
;

SELECT * FROM view_emp_dept
WHERE deptno = 10;

-- view 정보 확인 : user_views 테이블 을 통해 확인이 가능
-- 로그인한 사용자의 view 인스턴스의 정보
SELECT * FROM user_views;

-- view_emp30 를 통해 INSERT
INSERT INTO view_emp30 VALUES (9999, 'tester', 40);

SELECT * FROM emp;

ROLLBACK;

-- VIEW의 삭제 : 객체를 삭제하는 방식과 동일하다
-- drop { TABLE | VIEW } view_name

DROP VIEW view_emp_dept;

SELECT * FROM user_views;


-- view_hire : 입사일 기준으로 오름차순으로 정렬된 결과를 가상테이블로 출력
SELECT rownum, empno, ename, hiredate 
FROM emp
order by hiredate
;

CREATE OR REPLACE VIEW view_emp_hire
AS
SELECT empno, ename, hiredate 
FROM emp
order by hiredate
;

SELECT rownum, empno, ename, hiredate
FROM view_emp_hire;

SELECT * FROM view_emp_hire WHERE ROWNUM <= 5;

-- 인라인 뷰를 이용해서 가장 최근 입사한 사원 5명을 추출
SELECT *
FROM (SELECT * FROM emp ORDER BY hiredate DESC)
WHERE rownum <= 5
;

-- SEQUENCE : 숫자 자동 생성기 (오라클만 가능)
-- 시작값, 증가값, 최대값, 최소값, 반환여부

-- dept 테이블의 deptno -> pk 10 -> 20 -> 30....
-- deptno에 사용 할 SEQUENCE 생성
DROP SEQUENCE seq_dept_deptno;

CREATE SEQUENCE seq_dept_deptno
MINVALUE 10
MAXVALUE 90
START WITH 10
INCREMENT BY 10
;

-- emp 테이블의 empno 기본키에 사용할 SEQUENCE 를 생성
CREATE SEQUENCE seq_emp_empno
MINVALUE 0
START WITH 0
INCREMENT BY 1
;

-- SEQUENCE 객체로 숫자를 생성, 현재 숫자 읽어오는 명령
-- 숫자 생성 : nextval -> 새로운 숫자를 생성하고 숫자를 반환
-- 현재 숫자 반환 : currval -> 현재 값을 반환

-- 새롭게 생성하는 숫자를 확인
SELECT seq_dept_deptno.nextval -- dept deptno
FROM dual;

-- 현재 숫자 확인
SELECT seq_dept_deptno.currval
FRom dual;

INSERT INTO dept01 VALUES (seq_dept_deptno.nextval, 'test', 'test');

SELECT * FROM dept01;

-- index : 검색을 빠르게 하기위한 객체
-- CREATE INDEX index_name ON TARGET table_name (culumn_name)

-- index 확인을 하는 user_ind_column
DESC user_ind_columns;

SELECT index_name, table_name, column_name
FROM user_ind_columns
;

-- PRIMARY KEY 또는 UNIQUE 속성은 자동으로 INDEX가 생성된다.

SELECT * FROM emp10;
INSERT INTO emp10 SELECT * FROM emp10;

INSERT INTO emp10 (empno, ename) VALUES (2222, 'COOL');

SELECT empno, ename FROM emp10 WHERE empno='2222';

-- ename을 인덱스로 정의
CREATE INDEX index_emp10_ename
ON emp10(ename);

-- empno를 인덱스로 정의
CREATE INDEX index_emp10_empno
ON emp10(empno);


SELECT * FROM orders;
SELECT * FROM book;
SELECT * FROM customer;

SELECT COUNT(publisher)
FROM book b, orders o
WHERE o.bookid = b.bookid AND o.custid = 1
;

SELECT b.price - o.saleprice as PRICEGAP
FROM book b, orders o
WHERE b.bookid = o.bookid
;

SELECT b.bookname, b.price - o.saleprice as PRICEGAP                
FROM book b, orders o
WHERE b.bookid = o.bookid AND o.custid = 1
;

SELECT bookname
FROM book 
WHERE bookid NOT IN (SELECT o.bookid 
                     FROM customer c, orders o 
                     WHERE c.custid = o.custid AND c.name = '박지성')
;


SELECT name
FROM customer
WHERE custid NOT IN (SELECT custid FROM orders)
;

SELECT SUM(saleprice) as TOTAL , AVG(saleprice) as AVGSALEPRICE
FROM orders
;

SELECT c.name, SUM(o.saleprice)
FROM customer c, orders o
WHERE c.custid = o.custid
GROUP BY name
;

SELECT name, bookname
FROM book b, (SELECT c.name, o.bookid FROM customer c, orders o WHERE c.custid=o.custid) o
WHERE b.bookid = o.bookid
ORDER BY name
;

SELECT MAX(b.price - o.saleprice)
FROM book b, orders o
WHERE b.bookid = o.bookid 
;

SELECT *
FROM book b, orders o
WHERE b.bookid = o.bookid AND (b.price-o.saleprice)=(SELECT MAX(b.price - o.saleprice)
                                                     FROM book b, orders o 
                                                     WHERE b.bookid = o.bookid)
;

SELECT AVG(saleprice)
FROM orders
;

SELECT avg(saleprice)
FROM orders o, customer c
WHERE o.custid = c.custid
GROUP BY name
;

