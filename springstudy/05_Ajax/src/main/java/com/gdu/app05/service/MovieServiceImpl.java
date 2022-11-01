package com.gdu.app05.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MovieServiceImpl implements MovieService {

	private final String KEY = "d810e9b0372617f180269da03170ec5f";
	
	@Override
	public String getBoxOffice(String targetDt) {
		
		//API 요청 및 응답.
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");
			
			con.setRequestProperty("key", KEY);
			con.setRequestProperty("targetDt", targetDt);
			
			BufferedReader reader = null;
			
			if(con.getResponseCode() == 200) { // 200 : HttpURLConnection.HTTP_OK
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reader;
		
		
	}

}
