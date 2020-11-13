-- 2020.11.12

-- DDL

-- 테이블 생성 

-- create table table_name
-- (
--   column_name domain [constraint] ,
--   column_name domain [constraint] ,
--   column_name domain [constraint] 
--   ...
-- )

CREATE TABLE test_tbl (
        no NUMBER(4),
        user_name VARCHAR2(10),
        user_id VARCHAR2(16),
        user_password VARCHAR2(12),
        reg_date TIMESTAMP DEFAULT sysdate
);

desc test_tbl;

-- 실습에 사용했던 사원 테이블과 유사한 구조의 사원번호,사원이름, 급여 
-- 3개의 칼럼으로 구성된 EMP01 테이블을 생성해 봅시다
desc emp;

CREATE TABLE emp01 (
    empno number(4),
    ename varchar2(10),
    sal number(7,2)
);
desc emp01;

-- CREATE TABLE ~ as ~ : 테이블 복사, 제약조건은 복사되지 않는다.
-- CREATE TABLE 명령어 다음에 컬럼을 일일이 정의하는 대신 AS 절을 추가하여 
-- EMP 테이블과 동일한 내용과 구조를 갖는 EMP02 테이블을 생성해 봅시다.
CREATE TABLE emp02
AS
SELECT * FROM emp;

DESC emp02;

SELECT * FROM emp02;

-- 서브 쿼리문의 SELECT 절에 * 대신 원하는 컬럼명을 명시하면 
-- 기존 테이블에서 일부의 컬럼만 복사할 수 있습니다.
CREATE TABLE emp03
AS
SELECT empno, ename, sal FROM emp
;

DESC emp03;

--서브 쿼리문의 SELECT 문을 구성할 때 
-- WHERE 절을 추가하여 원하는 조건을 제시하면 
-- 기존 테이블에서 일부의 행만 복사합니다.
CREATE TABLE emp04
AS
SELECT * FROM emp WHERE deptno=10
;
SELECT * FROM emp04;

--WHERE 조건 절에 항상 거짓이 되는 조건을 지정하게 되면 
-- 테이블에서 얻어질 수 있는 로우가 없게 되므로 빈 테이블이 생성되게 됩니다.
CREATE TABLE emp05
AS
SELECT * FROM emp WHERE 1=2
;

SELECT * FROM emp05;

SELECT * FROM tab;

-- 테이블의 삭제 : 저장공간을 삭제 -> 저장되어 있는 데이터도 모두 삭제 
DROP TABLE test_tbl;

-- TRUNCATE :  테이블의 모든 행을 바로 삭제 물리적인 적용도 바로 진행 
CREATE TABLE emp06
AS
SELECT * FROM emp;
SELECT * FROM emp06;
TRUNCATE TABLE emp06;

--RENAME 현재 테이블 이름 TO 새이름
RENAME emp06 TO new_emp;
SELECT * FROM tab;
RENAME new_emp TO hot_emp;
SELECT * FROM hot_emp;

-- 테이블 구조의 변경
-- alter table table_name {add(컬럼의 추가) | modify(컬럼의 변경) | drop(컬럼의 삭제)}

-- 기존 테이블에 속성을 추가 : 각 행의 컬럼 데이터는 null 값으로 채워진다.
-- emp01에 job 컬럼을 추가 job varchar2(10)
DESC emp01;
ALTER TABLE emp01
add (deptno number(2))
;

-- 기존 테이블의 컬럼 변경 : 새롭게 정의된 컬럼으로 교체하는 것
ALTER TABLE emp01
MODIFY (deptno number(10))
;

-- 기존 테이블의 컬럼 삭제 : 데이터도 모두 삭제
ALTER TABLE emp01
DROP (deptno)
;

-- 제약 조건 정의
INSERT INTO dept values(10, 'test', 'seoul');

DESC emp01;
INSERT INTO emp01 values(null, null, 1000, 'tester');
SELECT * FROM emp01;

-- emp01 테이블 삭제
DROP TABLE emp01;

-- emp01 테이블 생성 : empno, ename에 null 값이 들어가지 않도록 제약
CREATE TABLE emp01(
    empno number(4) NOT NULL , -- 무결성 제약
    ename varchar2(10) NOT NULL , -- 무결성 제약
    job varchar(9),
    deptno number(2)
);

INSERT INTO emp01 values(null, null, 'tester', '10');

-- 데이터의 중복 금지 : UNIQUE
DROP TABLE emp02;

CREATE TABLE emp02(
    empno number(4) UNIQUE,
    ename varchar2(10) NOT NULL
);

INSERT INTO emp01 values(1, 'test1', 'tester', 10);

SELECT * FROM emp01;

INSERT INTO emp02 values(1, 'test1');
INSERT INTO emp02 values(1, 'test2');
SELECT * FROM emp02;

-- empno NOT NULL, UNIQUE 제약을 동시에 적용해보자
DROP TABLE emp03;
CREATE TABLE emp03(
    empno number(4) NOT NULL UNIQUE,
    ename varchar2(10) NOT NULL
);

INSERT INTO emp03 values(null, 'test1');

-- 기본키 제약 : 기본키 설정 -> NOT NULL, UNIQUE
DROP TABLE emp04;

CREATE TABLE emp04(
    empno number(4) PRIMARY KEY,
    ename varchar2(10) NOT NULL
);

INSERT INTO emp04 values (null, 'test');
INSERT INTO emp04 values (1, 'test');

-- 외래키 제약 : 참조하는 테이블과 컬럼을 정의
DROP TABLE emp05;

CREATE TABLE emp05(
    empno number(4) PRIMARY KEY, 
    ename varchar2(10) NOT NULL,
    deptno number(2) REFERENCES dept(deptno)
);

INSERT INTO emp05 values(1, 'test', 10);
INSERT INTO emp05 values(1, 'test', 60);
INSERT INTO emp05 values(2, 'test', null);

SELECT * FROM dept;

-- CHECK : 특정 범위 제한
DROP TABLE emp06;
CREATE TABLE emp06(
        empno number(4) PRIMARY KEY,
        ename varchar2(10) NOT NULL,
        sal number(7,2) CHECK (sal>=800)
);

INSERT INTO emp06 values(1, 'test', 1000);
INSERT INTO emp06 values(1, 'test', 300);

-- default : INSERT 시에 데이터가 입력되지 않을 때 자동으로 등록되는 데이터 정의
DROP TABLE emp07;

CREATE TABLE emp07(
    empno number(4) PRIMARY KEY,
    ename varchar2(10) NOT NULL,
    sal number(7,2) check (sal>=500),
    comm number(7,2) ,
    hiredate date 
);

INSERT INTO emp07 (empno, ename, sal) values (1, 'test', 3000);

SELECT * FROM emp07;

DROP TABLE emp07;

-- 제약 조건에 이름을 부여
CREATE TABLE emp08(
    empno number(4) CONSTRAINT emp08_empno_pk PRIMARY KEY,
    ename varchar2(10) CONSTRAINT emp08_ename_nn NOT NULL,
    sal number(7,2) CONSTRAINT emp08_sal_CK check (sal>=500),
    comm number(7,2) default 0,
    hiredate date default sysdate
);

INSERT INTO emp08 (empno, ename, sal) values (1, 'test', 3000);
SELECT * FROM emp08;


-- [테이블 레벨] 에서 제약조건 정의 성능차이 없음.
CREATE TABLE emp09(
    empno number(4),
    ename varchar2(10) NOT NULL,
    job varchar2(9),
    deptno number(10), -- 칼럼 정의 끝
    CONSTRAINT emp09_empno_pk PRIMARY KEY (empno),
    CONSTRAINT emp09_job_uk UNIQUE (job),
    CONSTRAINT emp09_deptno_fk FOREIGN KEY (deptno) REFERENCES dept(deptno)
    -- 제약조건의 정의 끝
);

INSERT INTO emp09 values (null,null,'job1',50);
INSERT INTO emp09 values (1, 'tester', 'job1', 40);
INSERT INTO emp09 values (2, 'tester', 'job1', 40);

------------------------------------------------------------------------------

-- DML 데이터의 삽입, 수정, 삭제
-- DML의 대상은 행이다. 행단위 입력, 행단위 수정, 행단위 삭제
-- INSERT INTO table_name (데이터 저장할 컬럼들) VALUES(저장할 데이터들)

-- dept01 테이블 생성
CREATE TABLE dept01
AS
SELECT * FROM dept WHERE 1=2
;

INSERT INTO dept01 (deptno, dname, loc)
         VALUES (10, '마케팅', '서울')
;
SELECT * FROM dept01;

-- NULL 값의 입력
INSERT INTO dept01 (deptno, dname) values (30, 'QC');
INSERT INTO dept01 values (40, 'DEV', NULL);

-- 서브쿼리를 이용해서 데이터를 입력
DROP TABLE dept02;

CREATE TABLE dept02
AS
SELECT * FROM dept WHERE 1=2
;

SELECT * FROM dept02;

INSERT INTO dept02
SELECT * FROM dept
;


-- 데이터의 수정
-- UPDATE table_name SET culumn_name = VALUE, ... , WHERE 행을 찾기위한 조건

-- 모든 사원의 부서번호를 30번으로 수정합시다.
DROP TABLE emp10;

CREATE TABLE emp10
AS
SELECT * FROM emp
;
SELECT * FROM emp10;

-- 모든 사원의 부서번호를 30번으로 수정합시다.
UPDATE emp10 SET deptno=30;

-- 이번엔 모든 사원의 급여를 10% 인상 시킨다.
UPDATE emp10
SET sal = sal*1.1
;

-- 모든 사원의 입사일을 오늘로 수정하려면 다음과 같이 합니다.
UPDATE emp10
SET hiredate = sysdate
;

-- 급여가 3000 이상인 사원만
-- 급여를 10% 인상하사
UPDATE emp10
SET sal = sal*1.1
WHERE sal >= 3000
;

-- 1987년에 입사한 사원의
-- 입사일을 오늘로 수정하자
UPDATE emp10
SET hiredate = sysdate
-- WHERE hiredate BETWEEN '87/01/01' AND '87/12/31'
WHERE SUBSTR(hiredate,1,2) = '87'
;
SELECT * FROM emp10;


SELECT * FROM emp10 WHERE SUBSTR(hiredate,1,2) = '87';

-- 데이터 삭제 
TRUNCATE TABLE emp10;

INSERT INTO emp10
SELECT * FROM emp
;

-- SCOTT 사원의 부서번호는 20번으로, 직급은 MANAGER로 한꺼번에 수정하도록 합시다.
UPDATE emp10
SET deptno = 20, job = 'MANAGER'
WHERE ename = 'SCOTT'
;

-- SCOTT 사원의 입사일자는 오늘로, 급여를 50으로 커미션을 4000으로 수정합시다.
UPDATE emp10
SET sal=50, comm=4000
WHERE ename='SCOTT'
;

-- 20번 부서의 지역명을
-- 40번 부서의 지역명으로
-- 변경하기 위해 서브쿼리를 사용해보자
DROP TABLE dept01;
CREATE TABLE dept01 
AS
SELECT * FROM dept
;


UPDATE dept01
SET loc = (SELECT loc FROM dept01 WHERE deptno=40)
WHERE deptno = 20
;

SELECT *
FROM dept01
;

-- 부서 번호가 20번인 부서의 부서명과 지역명을
-- 부서번호가 40번인 부서와 동일하게 변경하기위한 UPDATE 명령문

UPDATE dept01
SET dname=(SELECT dname FROM dept01 WHERE deptno=40), loc=(SELECT loc FROM dept01 WHERE deptno=40)
WHERE deptno = 20
;

UPDATE dept01
SET (dname, loc) = (SELECT dname,loc FROM dept01 WHERE deptno = 40)
WHERE deptno = 20
;

SELECT * FROM dept01;


-- 테이블의 행 삭제 
-- DELETE FROM table_name : 행단위 삭제, WHERE가 없으면 전체 행이 대상

-- dept01 테이블의 모든 데이터를 삭제
SELECT * FROM dept01;
DELETE FROM dept01;

-- emp10
SELECT * FROM emp10;

-- emp10 테이블의 데이터중 부서번호가 10번 부서의 사원을 삭제
DELETE FROM emp10 WHERE deptno=10;

-- 사원 테이블에서 부서명이 SALES인 사원을 모두 삭제해봅시다.
DELETE FROM emp10
WHERE deptno=(
            SELECT deptno FROM dept WHERE dname = 'SALES'
)
;

SELECT job, AVG(sal)
FROM emp
GROUP BY job
HAVING AVG(sal) = (SELECT MIN(AVG(sal)) FROM emp GROUP BY job)
;

SELECT deptno, MIN(sal) FROM emp GROUP BY deptno ;


SELECT e.ename, e.sal, e.deptno
FROM emp e, (SELECT MIN(sal)as MINsal FROM emp GROUP BY deptno ORDER BY deptno) m
WHERE e.sal = m.MINsal
;

SELECT * FROM emp ;

SELECT empno, ename, job, sal
FROM emp
WHERE sal < ALL (SELECT sal FROM emp WHERE job = 'ANALYST')
ORDER BY empno 
;

SELECT ename
FROM emp
WHERE empno IN(SELECT NVL(mgr,0) FROM emp)
;

SELECT ename, NVL(mgr,0)
FROM emp
;


