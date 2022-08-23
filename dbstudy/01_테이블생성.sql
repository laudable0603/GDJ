-- 주석
/*  주석 */
--하나의 쿼리문안에 대문자나 소문자 섞어쓰지 말아야한다.
 
/*
    오라클 데이터 타입
    1. CHAR(size) : 고정 길이 문자 타입 (1 ~ 2000 바이트) 예) 남/여
    2. VARCHAR2(size) : 가변 길이 문자 타입 (1 ~ 4000 바이트) 예) 주소등
    3. NUMBER(P, S) 정밀도(P), 스케일(S)로 표현되는 숫자 타입
        -정밀도(P) : 정수 + 소수점 모두 포함하는 전체 유효 숫자 (0은 제외)
        -스케일(S) : 소수점 자리 수 
        예시)
        NUMBER : 최대 38자리 숫자(22바이트)
        NUMBER(3) : 최대 3자리 정수 
        NUMBER(5, 2) : 최대 전체 5자리, 소수점 2자리 실수(123.45)
        : 1 미만의 소수점 2자리 실수
        NUMBER(2,2) : (0.12)
*/
 
 /*
    테이블 생성
    1. 제약조건의 이름을 지정하지 않는 방법(SYS로 시작하는 임의의 제약조건이름이 지정)
    2. 제약조건의 이름을 지정하는 방법
 */
 
 /*
    제약조건 생성
    1. 테이블 생성할 때 함께 지정
    2. 테이블 생성한 뒤 테이블 수정하면서 지정 
 */
 
 /*
    제약조건 - 데이터 사전
    1. DBA_CONSTRAINTS 테이블
    2. USER_CONSTRAINTS 테이블
    3. ALL_CONSTRAINTS 테이블
  */
  --USER_CONSTRAINTS 테이블의 구조 확인
DESCRIBE SYS.USER_CONSTRAINTS;
  
  --USER_CONSTRAINTS 테이블의 CONSTRAINTS_NAME 칼럼 확인
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS;
  
  -- 1. 제약조건이름 없이 테이블 만들기
DROP TABLE USER_TBL; --한 번 테이블 생성 후엔 항상 해당 테이블을 지우는 쿼리문을 생성문 전에 작성해준다.
CREATE TABLE USER_TBL(
    USER_ID VARCHAR2(30 BYTE) NOT NULL PRIMARY KEY,
    USER_PW VARCHAR2(30 BYTE) NOT NULL,
    USER_NAME VARCHAR2(30 BYTE)NULL, -- NULL = 빈칸을 입력해도 문제없다
    USER_AGE NUMBER(3) NULL CHECK(USER_AGE BETWEEN 0 AND 100),-- 유저의 나이는 0부터 100 사이다라는 제약조건(체크문)을 넣었다.
    USER_ADDR VARCHAR2(30 BYTE) NULL,
    USER_TEL CHAR(13 BYTE) NULL UNIQUE,
    USER_GEN CHAR(1 BYTE) NULL
);
  -- 2. 제약조건이름 없이 테이블 만들기
DROP TABLE USER_TBL; --한 번 테이블 생성 후엔 항상 해당 테이블을 지우는 쿼리문을 생성문 전에 작성해준다.
CREATE TABLE USER_TBL(
    USER_ID VARCHAR2(30 BYTE) NOT NULL,
    USER_PW VARCHAR2(30 BYTE) NOT NULL,
    USER_NAME VARCHAR2(30 BYTE)NULL, -- NULL 빈칸을 입력해도 문제없다
    USER_AGE NUMBER(3) NULL,
    USER_ADDR VARCHAR2(30 BYTE) NULL,
    USER_TEL CHAR(13 BYTE) NULL,
    USER_GEN CHAR(1 BYTE) NULL,
    PRIMARY KEY (USER_ID), -- NULL 유, 무를 제외한 제약조건을 한 번에 몰아 적을 수 있다.
    CHECK(USER_AGE BETWEEN 0 AND 100),
    UNIQUE(USER_TEL)
);
 -- 3. 제약조건이름 지정하며 테이블 만들기
DROP TABLE USER_TBL; --한 번 테이블 생성 후엔 항상 해당 테이블을 지우는 쿼리문을 생성문 전에 작성해준다.
CREATE TABLE USER_TBL(
    USER_ID VARCHAR2(30 BYTE) NOT NULL CONSTRAINT PK_USER_TBL PRIMARY KEY,
    USER_PW VARCHAR2(30 BYTE) NOT NULL,
    USER_NAME VARCHAR2(30 BYTE)NULL, -- NULL = 빈칸을 입력해도 문제없다
    USER_AGE NUMBER(3) NULL CONSTRAINT CK_USER_AGE CHECK(USER_AGE BETWEEN 0 AND 100),-- 유저의 나이는 0부터 100 사이다라는 제약조건(체크문)을 넣었다.
    USER_ADDR VARCHAR2(30 BYTE) NULL,
    USER_TEL CHAR(13 BYTE) NULL CONSTRAINT UQ_USER_TEL UNIQUE,
    USER_GEN CHAR(1 BYTE) NULL
); 

  -- 4. 제약조건이름 지정하며 테이블 만들기 -- 이방법 강추
DROP TABLE USER_TBL; --한 번 테이블 생성 후엔 항상 해당 테이블을 지우는 쿼리문을 생성문 전에 작성해준다.
CREATE TABLE USER_TBL(
    USER_ID VARCHAR2(30 BYTE) NOT NULL,
    USER_PW VARCHAR2(30 BYTE) NOT NULL,
    USER_NAME VARCHAR2(30 BYTE)NULL, -- NULL 빈칸을 입력해도 문제없다
    USER_AGE NUMBER(3) NULL,
    USER_ADDR VARCHAR2(30 BYTE) NULL,
    USER_TEL CHAR(13 BYTE) NULL,
    USER_GEN CHAR(1 BYTE) NULL,
    
    CONSTRAINT PK_USER_TBL PRIMARY KEY (USER_ID), -- NULL 유, 무를 제외한 제약조건을 한 번에 몰아 적을 수 있다.
    CONSTRAINT CK_USER_AGE CHECK(USER_AGE BETWEEN 0 AND 100),
    CONSTRAINT UQ_USER_TEL UNIQUE(USER_TEL)
);

  
  
  
  
  
  
  
  
  