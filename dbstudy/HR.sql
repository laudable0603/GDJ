

--EMPLOYEES 테이블에서 JOB_ID 조회하기
--단, 동일한 JOB_ID는 한 번만 출력하기
SELECT DISTINCT JOB_ID
    FROM EMPLOYEES;

--EMPLOYEES 테이블에서 EMPLOYEE_ID 가 120인 사원 조회하기
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID = 120;


--EMPLOYEE 테이블에서 SALARY가 10000 이상인 사원 조회하기
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE SALARY >= 10000;


--EMPLOYEE 테이블에서 EMPLOYEE_ID가 151~ 200인 사원 조회하기
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID BETWEEN 151 AND 200;

--EMPLOYEE 테이블에서 FIRST_NAME이 'Steven', LAST_NAME이 'King'인 사원 조회하기
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE FIRST_NAME = 'Steven'
   AND LAST_NAME = 'King';

--EMPLOYEE 테이블에서 JOB_ID가 'IT_PROG', 'ST_MAN'인 사원 조회하기? 
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE JOB_ID = 'IT_PROG'
    OR JOB_ID = 'ST_MAN';

--EMPLOYEE 테이블에서 HIRE_DATE가 2005년인 사원 조회하기---------------------------------
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE TO_DATE(HIRE_DATE, 'YY/MM/DD') BETWEEN TO_DATE('05/01/01', 'YY/MM/DD') AND TO_DATE('05/12/31', 'YY/MM/DD');

--EMPLOYEE 테이블에서 MANAGER_ID가 없는 사원 조회하기
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE MANAGER_ID IS NULL;
  
--EMPLOYEE 테이블에서 COMMISSION_PCT ? 가 있는 사원 조회하기
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL;
--EMPLOYEE 테이블에서 FIRST_NAME이 'J'로 시작하는 사원  조회하기
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE 'J%';
-- 테이블에서 JOB_ID가 'MAN'으로 끝나는 사원들의 MANAGER_ID 조회하기
SELECT JOB_ID,MANAGER_ID
  FROM EMPLOYEES
 WHERE JOB_ID LIKE '%MAN';
--EMPLOYEE 테이블에서 높은 SALRY 순으로 조회하기
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID
  FROM EMPLOYEES
 ORDER BY SALARY DESC;
-- 테이블에서 DEPARTMENT_ID의 오름차순으로 조회하되, 동일한 DEPARTMENT_ID 내에서는 HIRE_DATE의 오름차순으로 조회하기
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE, JOB_ID, MANAGER_ID, DEPARTMENT_ID
  FROM EMPLOYEES
 ORDER BY DEPARTMENT_ID, HIRE_DATE;
--EMPLOYEE 테이블에서 COMMISSION_PCT를 받는 사원들의 커미션(칼럼명:COMISSION) 조회하기
--커미션은 SALARY * COMMISSION_PCT를 의미함
SELECT
       FIRST_NAME
     , SALARY * COMMISSION_PCT AS COMMISSION
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL
 ORDER BY COMMISSION DESC;
 

--EMPLOYEE 테이블에서 DEPARTMENT_ID가 80인 사원들의 FIST_NAME과 SALARY을 높은 SALARY순으로 조회하기
--단, SALARY는 9,000처럼 전 단위 구분기호를 표기해서 출력하기
SELECT FIRST_NAME, TO_CHAR(SALARY, '99,999')
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 80
 ORDER BY SALARY DESC;











