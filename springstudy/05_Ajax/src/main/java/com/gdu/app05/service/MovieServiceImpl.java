package com.gdu.app05.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MovieServiceImpl implements MovieService {

	
	@Override
	public String getBoxOffice(String targetDt) {
		
		//API 요청 및 응답.
		String key = "d810e9b0372617f180269da03170ec5f";
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
		apiURL += "?key=" + key + "&targetDt=" + targetDt;
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL); //MalformedURLException
			con = (HttpURLConnection)url.openConnection(); //IOException
					
			con.setRequestMethod("GET");
			
			//con.setRequestProperty("key", key);
			//con.setRequestProperty("targetDt", targetDt);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//api 응답
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) { // try-catch-resources문은 자원의 close를 생략할 수 있다.
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// con 닫기
		con.disconnect();
		
		// 반환 (API로부터 가져온 모든 텍스트 정보)
		return sb.toString();
		
		
	}

}
