/*
    프로시저
    
    1. PROCEDURE
    2. 여러 개의 쿼리문을 한 번에 실행
       (이체 : UPDATE문 2개)
    3. 작성된 프로시저는 EXECUTE문으로 실행
       EXECUTE 프로시저();
    4. 형식
       CREATE [OR REPLACE] 프로시저_이름[(매개변수)]  --* OR REPLACE 는 기존에 프로시저가 있을 경우, 리플레이스 / 매게변수 생략 가능
       IS    --AS 가능
             변수선언
       BEGIN
             프로시저본문
       [EXCEPTION
             예외처리] 
       END [프로시저_이름]; --* 프로시저_이름 생략 가능
       
*/

-- 프로시저 PROC1 정의 (만들기)
CREATE OR REPLACE PROCEDURE PROC1
IS
    NAME VARCHAR2 (10 BYTE);
BEGIN
    NAME := '민경태';
    DBMS_OUTPUT.PUT_LINE(NAME);
END PROC1;

-- 프로시저 PROC1 호출 (실행)
EXECUTE PROC1();  -- 호출 시, () 괄호 필요
--