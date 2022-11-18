package com.gdu.app13.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.app13.domain.SleepUserDTO;
import com.gdu.app13.domain.UserDTO;

public interface UserService {
	// map을 반환하면 jackson이 JSON으로 잘 반환해준다 !
	public Map<String, Object> isReduceId(String id);
	public Map<String, Object> isReduceEmail(String email);
	public Map<String, Object> sendAuthCode(String email);
	
	// 반환 타입이 void인 경우는 jsp로 이동이 필요없을 때 사용한다.
	public void join(HttpServletRequest request, HttpServletResponse response);
	public void retire(HttpServletRequest request, HttpServletResponse response);
	public void login(HttpServletRequest request, HttpServletResponse response);
	public void keepLogin(HttpServletRequest request, HttpServletResponse response);
	public void logout(HttpServletRequest request, HttpServletResponse response);
	public UserDTO getUserBySessionId(Map<String, Object> map); // keepLoginInterceptor에서 호출
	public Map<String, Object> confirmPassword(HttpServletRequest request);
	public void modifyPassword(HttpServletRequest request, HttpServletResponse response);
	public void sleepUserHandle(); // SleepUserScheduler 에서 호출
	public SleepUserDTO getSleepUserById(String id);// SleepUserInterceptor 에서 호출
	public void restoreUser(HttpServletRequest request, HttpServletResponse response);
	
	public String getNvaerLoginApiURL(HttpServletRequest request); //-네이버 로그인 1
	public UserDTO getNaverLoginTokenProfile(HttpServletRequest request); //-네이버 로그인 2
}
