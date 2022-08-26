/*
    DQL
    
    1. Data Query Language
    2. 데이터 질의어
    3. 테이블의 데이터를 조회/검색
    4. 데이터베이스에 변화가 없으므로 COMMIT 없음
        (트랜잭션의 대상이 아님)
    5. 형식
        SELECT 칼럼1, 칼럼2, ...
            FROM 테이블
          [WHERE 조건식]
          [GROUP BY 그룹화]
          [HAVING 그룹화_조건식]
          [ORDER BY 정렬]
    6. 실행 순서
        ⑤  SELECT 칼럼
        ①    FROM 테이블
        ②   WHERE 조건식
        ③   GROUP BY 그룹화
        ④  HAVING 그룹화_조건식
        ⑥ORDER BY 정렬기준
*/

-- 1. 사원 테이블에서 사원이름 조회하기
SELECT NAME
    FROM EMPLOYEE;
    
-- 1) 테이블에 오너(OWNER) 명시
SELECT NAME
    FROM SCOTT.EMPLOYEE;
    
-- 2) 칼럼에 테이블 명시
SELECT EMPLOYEE.NAME
    FROM EMPLOYEE;
    
-- 3) 테이블에 별명 지정
SELECT EMP.NAME
    FROM EMPLOYEE EMP; --병명 EMP 지정
    
-- 4) 칼럼에 별명(ALIAS) 지정
SELECT NAME AS 사원명 -- 별명 사원명 지정
    FROM EMPLOYEE;
-- 2. 사원 테이블의 모든 칼럼 조회하기
--      모든 칼럼을 의미하는 키워드: *
--      중요 : 실무에서 * 사용 금지(성능문제있음)
SELECT
    *
FROM EMPLOYEE;

-- 모든 칼럼이 필요하면 모두 명시
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
    FROM EMPLOYEE;

--3. 부서 테이블에서 지역명 조회하기
-- 단, 동일한 지역은 한 번만 조회하기
-- 중복 제거 : DISTINCT
SELECT DISTINCT LOCATION 
  FROM DEPARTMENT;
  
--SELECT DISTINCT DEPT_NAME, LOCATION -- 두 개의 칼럼을 조회 했는데 중복이 많이 있다면 DB 설계를 잘못한것이다.
 -- FROM DEPARTMENT;

 -- 4. 사원 테이블에서 직급이 '과장'인 사원 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE POSITION = '과장';
 
-- 5. 사원테이블에서 급여가 2000000~5000000인 사원 조회
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY >= 2000000
   AND SALARY <= 5000000;
-- BETWEEN 연산
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY BETWEEN 2000000 AND 5000000;  
 
-- 6. 사원 테이블에서 소속부서가 1,2인 사원 조회
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE DEPART = 1
    OR DEPART = 2;
    
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE DEPART IN(1, 2);


-- 7. 사원 테이블에서 성별이 없는 사원 조회
--      NULL 유무
--      1) NULL이다  : IS NULL
--      2) NULL아니다: IS NOT NULL

--GENDER가 널인 값만 보여주기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE GENDER IS NULL;
 
--GENDER가 널이 아닌값만 보여주기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE GENDER IS NOT NULL;
 
-- 8. 사원 테이블에서 김씨 조회
--      1) 만능문자(WILD CARD)
--          (1) %: 모든 문자, 글자수 제한 없음
--          (2) _: 모든 문자, 한 글자로 제한
--      2) 예시
--          (1)김으로 시작하는 이름 찾기 : 김%
--          (2)김으로 끝나는 이름 찾기   : %김
--          (3)김을 포함하는 이름 찾기   : %김%
--      3) 만능문자 연산자
--          LIKE, NOT LIKE

-- 일부 일치하면 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE NAME LIKE '%김%';
 
 --일치한것 제외하고 조회하기
 SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE NAME NOT LIKE '%김%';
 
 
-- 9. 사원 테이블에서 사원번호가 1로 시작하는 사원 조회하기
-- 오라클은 문자와 숫자를 자동 캐스팅한다(추천X)
-- 1000번대 숫자를 뽑으라 할 경우 1, 10 ,100 , 1000 이 다 조회가 되어버리니
-- 숫자 조회같은경우는 BTEWEEN 연산자를 사용하자
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE EMP_NO LIKE '1%';
 
 
 
 /* ORDER BY 절 */
 -- ASC : 오름차순 정렬, 생략 가능
 -- DESC : 내림차순 정렬
 
 -- 10. 사원테이블에서 사원명의 가나다순으로 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY NAME;
 
-- 11. 사원테이블에서 급여가 높은순으로 먼저 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY SALARY DESC;
 
-- 12. 사원 테이블에서 성별의 가나다순으로 조회하기
--     오름차순 정렬에서 NULL 값은 마지막에 배치
--     내림차순 정렬에서 NULL 값은 처음에 배치
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY GENDER;
 
-- 13. 사원테이블에서 먼저 고용된 순서로 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY HIRE_DATE;  

-- 14. 사원테이블에서 소속 부서의 오름차순 정렬로 조회하되,
--     같은 소속부서 내에서는 먼저 고용된 순으로 조회하기
--     1차 정렬 기준 : 소속부서
--     2차 정렬 기준 : 고용일자
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY DEPART ASC, HIRE_DATE ASC;
 
/* WHERE 절과 ORDER BY절 함께 사용*/
-- WHERE 절을 먼저, ORDER BY절을 마지막에

-- 15. 사원테이블에서 급여가 5000000이상인 사원들을 고용된순으로 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY >= 5000000
 ORDER BY HIRE_DATE;
 
/* SELECT문 처리 순서 */
/*3*/SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE AS HD, SALARY
/*1*/  FROM EMPLOYEE
/*2*/ WHERE SALARY >= 5000000
/*4*/ ORDER BY HD;

--처리 순서 상 실행되지 않는다.
/*3*/SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY AS S
/*1*/  FROM EMPLOYEE
/*2*/ WHERE S >= 5000000
/*4*/ ORDER BY HIRE_DATE;
 
 
 