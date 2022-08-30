-- EMPLOYEES 테이블 연습.

-- 1. 급여평균이 10000 이상인 부서의 부서번호와 급여평균을 조회하기
SELECT
       DEPARTMENT_ID
     , FLOOR(AVG(SALARY))
  FROM 
       EMPLOYEES
 GROUP BY 
       DEPARTMENT_ID
HAVING 
       FLOOR(AVG(SALARY)) >= 10000;



-- 2. 동일한 부서번호(DEPARTMENT_ID)로 그룹화하기
--    동일한 부서번호를 가진 사원들을 직업아이디(JOB_ID)로 다시 그룹화하기
--    즉, 부서별 직업아이디별로 그룹화하기
--    부서별 직업아이디별로 그룹화하여 각 그룹의 사원수 조회하기
--    부서번호가 없는 사원은 제외하기
SELECT DEPARTMENT_ID, JOB_ID, COUNT(*) AS 사원수
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY DEPARTMENT_ID, JOB_ID  -- 부서별, 직업아이디별로 그룹화
 ORDER BY 사원수;
  

-- DEPARTMENTS 테이블 연습.

-- 1. 동일한 지역(LOCATION_ID)으로 그룹화하여 조회하기
SELECT LOCATION_ID
  FROM DEPARTMENTS
 GROUP BY LOCATION_ID;

-- 2. 동일한 지역(LOCATION_ID)으로 그룹화하여 각 지역별 존재하는 부서수 조회하기
--    부서수가 2 이상인 지역만 조회하기
SELECT LOCATION_ID, COUNT(*) AS 부서수
  FROM DEPARTMENTS
  GROUP BY LOCATION_ID
HAVING COUNT(*) >= 2;
-- 3. 동일한 지역(LOCATION_ID)으로 그룹화하여 각 지역별 존재하는 부서수 조회하기
--    MANAGER_ID가 없는 지역은 제외하고 조회하기
SELECT LOCATION_ID, COUNT(*)
  FROM DEPARTMENTS
 WHERE MANAGER_ID IS NOT NULL
 GROUP BY LOCATION_ID;
 

-- 4. 부서명(DEPARTMENT_NAME)의 첫 2글자로 그룹화하여 해당 그룹의 개수 조회하기
SELECT SUBSTR(DEPARTMENT_NAME, 1, 2), COUNT(*)
  FROM DEPARTMENTS
 GROUP BY SUBSTR(DEPARTMENT_NAME, 1, 2);--GROUP BY절에 함수가 사용되면 그대로 SELECT절에 보낸다.


-- 5. 부서명(DEPARTMENT_NAME)의 첫 2글자로 그룹화하여 해당 그룹의 개수 조회하기
--    부서명의 첫 2글자가 'It', 'Co'인 부서만 조회하기
SELECT SUBSTR(DEPARTMENT_NAME, 1, 2), COUNT(*)
  FROM DEPARTMENTS
 WHERE SUBSTR(DEPARTMENT_NAME, 1, 2) IN ('IT', 'Co') --IT% 같은 경우는 OR연산 써야한다.
 GROUP BY SUBSTR(DEPARTMENT_NAME, 1, 2); --GROUP BY절에 함수가 사용되면 그대로 SELECT절에 보낸다.

