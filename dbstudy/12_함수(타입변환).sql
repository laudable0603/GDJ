/*
    DUAL 테이블
    
    1. DUMMY 칼럼에 'X'값을 하나 가지고 있는 테이블
    2. 아무 의미 없는 테이블
    3. 오라클에서는 FROM절이 필수이기 때문에,
       테이블이 필요없는 조회문에서 DUAL 테이블을 사용함

*/

DESCRIBE DUAL;

SELECT DUMMY
    FROM DUAL;
    
    
/*
    타입 변환 함수
    1. TO_NUMBER('문자열') : 문자열 형식의 숫자를 숫자 형식으로 변환
    2. TO_CHAR(데이터, ['형식']) : 지정된 데이터(주로 숫자나 날짜)를 형식에 맞는 문자열로 변환 ([형식] 생략가능)
    3. TO_DATE('문자열','형식') : 지정된 문자열을 날짜 형식으로 변환
*/

-- 1. 숫자로 변환(TO_NUMBER)
SELECT '100', TO_NUMBER('100')
  FROM DUAL;
SELECT '1.5', TO_NUMBER('1.5')
  FROM DUAL;
  
-- 숫자와 '문자' 연산은 오라클에 의해서
-- 숫자와 숫자 연산으로 수정된 뒤 처리됨
--'문자'-> TO NUMBER('문자') 방식으로 자동으로 처리함
SELECT 1 + '1'--SELECT 1 + SELECT TO_NUMBER('1')
  FROM DUAL;
  
--'문자'와 '문자' 연산도 모두 숫자로 바꿔서 처리
SELECT '1' + '1' --SELECT TO_NUMBER('1') + TO_NUMBER('1')
  FROM DUAL;
  
  
-- 2. 문자로 변환 (TO_CHAR)
-- 1) 숫자 -> 문자로 변경
SELECT
        TO_CHAR(1234)
      , TO_CHAR(1234,'999999') --999999 뜻 6자리 중 빈칸을 공백으로 처리
      , TO_CHAR(1234,'000000') --000000 뜻 6자리 중 빈칸을 0으로 처리
      , TO_CHAR(1234, '9,999') -- 4자리 표시 및 세자리 끝나면 , 처리
      , TO_CHAR(12345, '9,999') --형식 자리수에 비해 숫자자리가 더 크면 #처리
      , TO_CHAR(12345, '99,999')
      , TO_CHAR(1.4, '9') --형식은 정수 1자리 표시(소수 이하 반올림)
      , TO_CHAR(1.5, '9')--형식은 정수 1자리 표시(소수 이하 반올림)
      , TO_CHAR(0.123, '0.00') --0.12, 소수 이하 2자리 표기(반올림)
       , TO_CHAR(0.129, '0.00') -- 0.13, 소수 이하 2자리 표기(반올림)
    FROM
        DUAL;

-- 2) 날짜-> 문자로 변환
-- 현재 날짜와 시간
-- DATE 타입의 SYSDATE 
-- TIMESTAMP 타입의 SYSTIMESTAMP
SELECT 
       SYSDATE      -- YY/MM/DD 형식으로 표현하지만 시간 데이터도 가지고 있음
     , SYSTIMESTAMP
  FROM DUAL;
  
SELECT
        TO_CHAR(SYSDATE, 'YYYY-MM-DD')
      , TO_CHAR(SYSDATE, 'HH:MI:SS')
   FROM 
        DUAL;

-- 3. 날짜로 변환(TO_DATE)

--'05/06/07' 날짜는 언제인가? 알려주기 전에는 모름
-- 지정된 형식으로 해석
-- 예시1) 'YY/MM/DD' : 05년 06월 07일
-- 예시2) 'MM/DD/YY' : 07년 05월 06일
-- 어떤 날짜를 어떻게 해석해야 하는지 알려주는 함수

SELECT
        TO_DATE('05/06/07','YY/MM/DD')
      , TO_DATE('05/06/07','MM/DD/YY')
   FROM 
        DUAL;
        
-- 현재 날짜를 YYYY-MM-DD형식으로 조회
SELECT
        TO_CHAR(SYSDATE,'YYYY/MM/DD')
   FROM
        DUAL;

-- 사원 테이블에서 90/01/01 ~ 99/12/31 사이에 입사한 사원 조회하기
-- 날짜를 문자타입으로 저장하면 DATE로 저장하는 것보다 성능이 좋기때문에
-- 날짜데이터가 필요할 떄 TO_DATE 를 사용해서 가져온다
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE TO_DATE(HIRE_DATE, 'YY/MM/DD') BETWEEN TO_DATE('90/01/01','YY/MM/DD') AND TO_DATE ('31/12/99','DD/MM/YY');

CREATE TABLE SAMPLE(
    DT1 DATE,
    DT2 TIMESTAMP,
    DT3 VARCHAR2(10 BYTE) --YYYY-MM-DD
);
-- DT1, DT2, DT3 칼럼에 현재 날짜 넣기
INSERT INTO SAMPLE(DT1, DT2, DT3)
    VALUES(SYSDATE, SYSTIMESTAMP, TO_CHAR(SYSDATE,'YYYY/MM/DD'));

SELECT DT1,DT2,DT3 FROM SAMPLE;

SELECT DT1,DT2,DT3
  FROM SAMPLE
 WHERE TO_DATE(DT1, 'YY/MM/DD') = TO_DATE('22/08/26','YY/MM/DD');
--연산 비교할때는 타입을 맞추어주자.         ^오늘날짜