/*
    일(1)대다(M) 관계의 테이블 생성
    
    1. 명칭
        1) 부모 테이블 : 일(1), PK를 가진 테이블
        2) 자식 테이블 : 다(M), FK를 가진 테이블
    2. 생성    
        부모 테이블을 먼저 생성하고, 자식 테이블을 나중에 생성
    3. 삭제
        자식 테이블을 먼저 삭제하고, 부모 테이블을 나중에 삭제

*/


-- 학교 테이블 
-- 부모 테이블 : 관계를 맺을 때 PK를 가진 테이블
 -- 1. 제약조건이름 없이 테이블 만들기
DROP TABLE SCHOOL; --운영할 때는 수정하는게 맞다. 하지만 지금은 삭제하고 실행한다.
CREATE TABLE SCHOOL(
    SCH_CODE NUMBER(1) NOT NULL PRIMARY KEY,
    SCH_NAME VARCHAR2(20 BYTE) NOT NULL
);    
  -- 2. 제약조건이름 없이 테이블 만들기
DROP TABLE SCHOOL;
CREATE TABLE SCHOOL(
    SCH_CODE NUMBER(1) NOT NULL,
    SCH_NAME VARCHAR2(20 BYTE) NOT NULL,
    PRIMARY KEY(SCH_CODE)
);
 -- 3. 제약조건이름 지정하며 테이블 만들기
DROP TABLE SCHOOL;
CREATE TABLE SCHOOL(
    SCH_CODE NUMBER(1) NOT NULL CONSTRAINT PK_SCHOOL PRIMARY KEY,
    SCH_NAME VARCHAR2(20 BYTE) NOT NULL
);
  -- 4. 제약조건이름 지정하며 테이블 만들기 -- 이방법 강추
DROP TABLE SCHOOL;
CREATE TABLE SCHOOL(
    SCH_CODE NUMBER(1) NOT NULL,
    SCH_NAME VARCHAR2(20 BYTE) NOT NULL,
    CONSTRAINT PK_SCHOOL PRIMARY KEY (SCH_CODE)
);    
-- 학생 테이블
-- 자식 테이블  : FK를 가진 테이블
 -- 1. 제약조건이름 없이 테이블 만들기
DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    STU_NO CHAR(5 BYTE) NOT NULL PRIMARY KEY,
    SCH_CODE NUMBER(1) NOT NULL REFERENCES SCHOOL(SCH_CODE),--REFERENCES(참초할 PK)
    STU_NAME VARCHAR2(20 BYTE) NULL
) 
  -- 2. 제약조건이름 없이 테이블 만들기
DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    STU_NO CHAR(5 BYTE) NOT NULL,
    SCH_CODE NUMBER(1) NOT NULL,
    STU_NAME VARCHAR2(20 BYTE) NULL,
    PRIMARY KEY(STU_NO),
    FOREIGN KEY(SCH_CODE) REFERENCES SCHOOL(SCH_CODE)
) 
  -- 3. 제약조건이름 지정하며 테이블 만들기 -- 이방법 강추
DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    STU_NO CHAR(5 BYTE) NOT NULL,
    SCH_CODE NUMBER(1) NOT NULL,
    STU_NAME VARCHAR2(20 BYTE) NULL,
    CONSTRAINT PK_STUDENT PRIMARY KEY(STU_NO),
    CONSTRAINT FK_STUDENT_SCHOOL FOREIGN KEY(SCH_CODE) REFERENCES SCHOOL(SCH_CODE)
    --CONSTRAINT FK_현재테이블_참조테이블 FOREIGN KEY(현재테이블 칼럼) REFERENCES 참조테이블(현재테이블 칼럼) 
) 


-- 최종 정리--




    



