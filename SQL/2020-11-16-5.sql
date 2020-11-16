-- 2020-11-16

-- PhoneBook DDL : 테이블 정의서를 참고해서 DDL 작성한다.

CREATE TABLE phoneInfo_basic(
             idx NUMBER(6) CONSTRAINT pi_basic_idx_PK PRIMARY KEY,
             fr_name VARCHAR2(20) NOT NULL,
             fr_phonenumber VARCHAR2(20) NOT NULL,
             fr_email VARCHAR2(20),
             fr_address VARCHAR2(20),
             fr_regdate DATE DEFAULT sysdate
);

desc phoneINfo_basic;

-- 제약 조건 확인 user_constraints
desc user_constraints;

SELECT constraint_name, constraint_type
FROM user_constraints
WHERE table_name = 'PHONEINFO_BASIC'
;

INSERT INTO PHONEINFO_BASIC
VALUES (1, 'SCOTT', '010-000-0000', 'SCOTT@GMAIL.COM', '서울', SYSDATE);

SELECT * FROM PHONEINFO_BASIC;

-- 시퀀스 : 숫자 재생기

CREATE SEQUENCE SEQ_PIBASIC_IDX
MINVALUE 0
START WITH 0
INCREMENT BY 1
;

INSERT INTO PHONEINFO_BASIC
VALUES (SEQ_PIBASIC_IDX.nextval, 'SCOTT', '010-0000-0000', 'SCOTT@GMAIL.COM', '서울', SYSDATE);

INSERT INTO PHONEINFO_BASIC (idx, fr_name, fr_phonenumber)
VALUES (SEQ_PIBASIC_IDX.nextval, 'KING', '010-9999-9999');

-- 질의 : READ
SELECT * FROM phoneInfo_basic;

-- 데이터 삭제 : DELECTE
DELETE FROM phoneInfo_basic;

-- 데이터 업데이트 : UPDATE
UPDATE phoneInfo_basic
SET FR_EMAIL='KING@NAVER.com', FR_ADDRESS='부산'
WHERE IDX = 2
;

--CRUD C(CRATE) ,R(READ), U(UPDATE), D(DELETE)
-- INSERT, SELECT, UPDATE, DELETE

DROP TABLE phoneinfo_univ;

CREATE TABLE phoneInfo_univ(
             idx NUMBER(6),
             fr_u_major VARCHAR2(20) DEFAULT 'N',
             fr_u_year NUMBER(1) DEFAULT 1 CHECK (fr_u_year BETWEEN 1 AND 4),
             fr_ref NUMBER(6) NOT NULL,
             CONSTRAINT pi_univ_idx_PK PRIMARY KEY (idx),
             CONSTRAINT pi_univ_ref_FK FOREIGN KEY (fr_ref) REFERENCES phoneInfo_basic(idx)
);

DESC phoneinfo_univ;
SELECT * FROM user_constraints where table_name='PHONEINFO_UNIV';
 
-- CRUD

-- CREATE : 대학친구 입력
-- 기본 정보
INSERT INTO PHONEINFO_BASIC (idx, fr_name, fr_phonenumber)
VALUES (SEQ_PIBASIC_IDX.nextval, 'KING', '010-9999-9999');
-- 대학 정보
INSERT INTO phoneInfo_univ VALUES (3, 'computer', 2, SEQ_PIBASIC_IDX.currval);

-- READ
SELECT * FROM phoneInfo_univ;

-- 만든 테이블 조인
SELECT *
FROM phoneInfo_basic pb, phoneInfo_univ pu
WHERE pb.idx = pu.fr_ref
;

-- UPDATE : phoneInfo_univ where idx = 3;
UPDATE phoneInfo_univ
SET fr_u_major='체육', fr_u_year=4
WHERE idx=3
;

-- DELETE : idx=1 행을 삭제 하고싶으면 자식키부터 지워줘야함
DELETE phoneInfo_univ WHERE fr_ref=4;
DELETE phoneInfo_basic WHERE idx =1;


CREATE TABLE phoneInfo_com(
             idx NUMBER(6) CONSTRAINT pi_com_idx_PK PRIMARY KEY,
             fr_c_company VARCHAR2(20) DEFAULT 'N',
             fr_ref NUMBER(6) NOT NULL CONSTRAINT pi_com_ref_FK REFERENCES phoneInfo_basic (idx)
);

-- 회사 친구 정보 입력
INSERT INTO PHONEINFO_BASIC (idx, fr_name, fr_phonenumber)
VALUES (SEQ_PIBASIC_IDX.nextval, '손흥민', '010-1111-1111');

-- 회사 정보 입력
INSERT INTO PHONEINFO_COM VALUES (2, '토트넘', SEQ_PIBASIC_IDX.currval);

-- READ
-- 회사 친구 
SELECT *
FROM phoneInfo_basic pb, phoneInfo_com pc
WHERE pb.idx=pc.fr_ref
AND pb.fr_name='손흥민'
;

-- UPDATE
UPDATE phoneInfo_com
SET fr_c_company='레알'
WHERE idx=2
;

-- DELETE
-- 자식테이블의 행부터 삭제 하고 부모 테이블 행을 삭제
DELETE FROM phoneInfo_com WHERE fr_ref=4;
DELETE FROM phoneInfo_basic WHERE idx=4;