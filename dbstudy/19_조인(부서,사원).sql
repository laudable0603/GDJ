DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

CREATE TABLE DEPARTMENT(
    DEPT_NO NUMBER NOT NULL, --PK, 부서번호
    DEPT_NAME VARCHAR2(15 BYTE) NOT NULL, -- 부서이름
    LOCATION VARCHAR2(15 BYTE) NOT NULL -- 부서위치
);
CREATE TABLE EMPLOYEE(
    EMP_NO NUMBER NOT NULL,-- PK
    NAME VARCHAR2(20 BYTE) NOT NULL, --이름
    DEPART NUMBER NULL,  --FK 부서번호DEPARTMENT(DEPT_NO)
    POSITION VARCHAR2(20 BYTE) NULL, --직급
    GENDER CHAR(2) NULL, --성별
    HIRE_DATE DATE NULL, --고용날짜
    SALARY NUMBER NULL-- 급여
);

--기본키
ALTER TABLE DEPARTMENT
    ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY (DEPT_NO);
ALTER TABLE EMPLOYEE
    ADD CONSTRAINT PK_EMPLOYEE PRIMARY KEY (EMP_NO);
    --외래키
ALTER TABLE EMPLOYEE
    ADD CONSTRAINT FK_EMP_DEPARTMENT FOREIGN KEY (DEPART)
        REFERENCES DEPARTMENT(DEPT_NO)
         ON DELETE SET NULL;

-- 부서 테이블에서 사용할 부서_시퀀스
DROP SEQUENCE DEPARTMENT_SEQ;
CREATE SEQUENCE DEPARTMENT_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 100
    NOCACHE
    NOCYCLE;
    
-- 부서 테이블에 행(ROW) 삽입
-- 부모 테이블(관계에서 PK를 가진 테이블)에 먼저 삽입을 해야 함
-- ROLLBACK 시 모든 명령이 다 취소됨
INSERT INTO DEPARTMENT (DEPT_NO, DEPT_NAME, LOCATION) VALUES (DEPARTMENT_SEQ.NEXTVAL, '영업부', '대구'); --DEPARTMENT_SEQ.NEXTVAL 번호 뽑아주기
INSERT INTO DEPARTMENT (DEPT_NO, DEPT_NAME, LOCATION) VALUES (DEPARTMENT_SEQ.NEXTVAL, '인사부', '서울');
INSERT INTO DEPARTMENT (DEPT_NO, DEPT_NAME, LOCATION) VALUES (DEPARTMENT_SEQ.NEXTVAL, '총무부', '대구');
INSERT INTO DEPARTMENT (DEPT_NO, DEPT_NAME, LOCATION) VALUES (DEPARTMENT_SEQ.NEXTVAL, '기획부', '서울');
COMMIT;

--사원 테이블에서 사용할 사원_시퀀스
DROP SEQUENCE EMPLOYEE_SEQ;
CREATE SEQUENCE EMPLOYEE_SEQ
    START WITH 1001
    NOCACHE;

--사원 테이블에 행(ROW) 삽입
--자식 테이블(관계에서 FK를 가진 테이블)은 참조 무결성에 위배되지 않는 데이터만 삽입 가능
-- 부서(부서번호) - 사원 (소속부서)
--PK             -FK
--1,2,3,4        -1,2,3,4,중 하나만 가능
INSERT INTO EMPLOYEE VALUES(EMPLOYEE_SEQ.NEXTVAL, '구창민', 1, '과장', 'M', '95/05/01', 5000000);
INSERT INTO EMPLOYEE VALUES(EMPLOYEE_SEQ.NEXTVAL, '김민서', 1, '사원', 'F', '17/09/01', 2000000);
INSERT INTO EMPLOYEE VALUES(EMPLOYEE_SEQ.NEXTVAL, '이은서', 2, '부장', NULL, '90-09-01', 5500000);
INSERT INTO EMPLOYEE VALUES(EMPLOYEE_SEQ.NEXTVAL, '한성일', 2, '과장', 'M', '93-04-01', 5000000);
COMMIT;
-- 참조무결성 위배 데이터 삽입을 위해서 외래키 일시중지
ALTER TABLE EMPLOYEE
    DISABLE CONSTRAINT FK_EMP_DEPARTMENT;
    
-- 참조무결성 위배 데이터 삽입
INSERT INTO EMPLOYEE VALUES(EMPLOYEE_SEQ.NEXTVAL, '신현준', 5, '대리', 'M', '98-12-01', 3500000);
COMMIT;


/*****************************************************************************/
/*
    조인
    
    1. JOIN
    2. 2개 이상의 테이블을 조회하는 방법
    3. 조회할 테이블들은 관계를 줄 수 있어야 함
    4. 종류
        1) 크로스 조인 : 카테젼 곱, 각 테이블의 모든 행을 조인
            - CROSS JOIN
            - 조인 조건이 없으면 됨
            - 많은 행을 순식간에 만들 수 있음 (기초데이터 작성용)
            - 조인 조건을 잘못 지정한 경우
        2) 내부 조인
            - INNER JOIN
            - 각 테이블에서 일치하는 모든 행을 조인
        3) 외부 조인
            - OUTER JOIN
            - 한 테이블은 일치하는 행을 조인, 한 테이블은 일치하지 않아도 조인
            - 왼쪽 외부 조인(LEFT OUTER JOIN) , 오른쪽 외부 조인(RIGHT OUTER JOIN)
        4) 셀프 조인
            - SELF JOIN
            - 한 테이블에 참조 관계가 있는 경우
            -한 테이블의 특정 칼럼과 다른 특정 칼럼을 조인
    5. 형식
        1) JOIN 문법
            SELECT 칼럼
              FROM 테이블1 JOIN 테이블2
                ON 조인조건
                
        2) 콤마(,) 문법
            SELECT 칼럼
              FROM 테이블1, 테이블2
             WHERE 조인조건
        
    
*/
/*
    드라이브(DRIVE) 테이블과 드리븐(DRIVEN) 테이블
    
    1. 드라이브 테이블 
        1) 조인에서 검색할 때 사용하는테이블
        2) 관계에서 PK를 가진 테이블
        3) 대부분 행(ROW) 개수가 적은 테이블
    
    2. 드리븐 테이블
        1) 관계에서 FK를 가진 테이블
        2) 대부분 행(ROW) 개수가 많은 테이블 
    3. 조인할 때 드라이브 테이블을 드리븐 테이블보다 먼저 작성
    
    예) FROM PK테이블 RIGHT OUTER JOIN FK테이블
          ON PK.참조칼럼 = FK.참조칼럼;

*/

-- 1. 크로스 조인 확인
SELECT E.EMP_NO, E.NAME, E.SALARY, D.DEPT_NO, D.DEPT_NAME
  FROM  DEPARTMENT D CROSS JOIN EMPLOYEE E; -- 어느 테이블의 칼럼이다라는걸 E와 D로 명시해줬다.
  
-- 2. 내부 조인 확인
--  사원번호, 사원명, 부서명을 조회하기
SELECT E.EMP_NO, E.NAME, D.DEPT_NAME
  FROM DEPARTMENT D INNER JOIN EMPLOYEE E 
    ON D.DEPT_NO = E.DEPART;
    
-- 3. 외부 조인 확인
--  사원번호, 사원명, 부서명을 조회하기
--  모든 사원을 반드시 조회하기
--   사원   -     부서
-- 모두포함 - 일치하는부서만포함

--  모두포함시킬 사원테이블을 OUTER JOIN의 왼쪽/오른쪽에 두느냐에 따라
--  왼쪽 외부 조인/ 오른쪽 외부 조인으로 구분함

-- DRIVE/DRIVEN 테이블이 잘못 지정된 조인
SELECT E.EMP_NO, E.NAME, D.DEPT_NAME
  FROM EMPLOYEE E LEFT OUTER JOIN DEPARTMENT D --왼쪽의 EMPLOYEE 테이블은 모두조회
    ON E.DEPART = D.DEPT_NO;

-- DRIVE/DRIVEN 테이블이 잘 지정된 조인
SELECT E.EMP_NO, E.NAME, D.DEPT_NAME
  FROM DEPARTMENT D RIGHT OUTER JOIN  EMPLOYEE E -- 오른쪽의 EMPLOYEE 테이블은 모두조회 
  --성능상 LEFT보다 RIGHT가 우위에 있다.
    ON  D.DEPT_NO = E.DEPART;    
    
    
    
    
    
    
    
    


SELECT EMP_NO, NAME, DEPT_NAME
  FROM EMPLOYEE INNER JOIN DEPARTMENT
    ON DEPART = DEPT_NO;

