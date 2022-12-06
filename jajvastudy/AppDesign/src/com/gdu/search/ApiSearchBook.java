package com.gdu.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiSearchBook {
	
	public static void main(String[] args) {
		String clientId ="MfHKZlNOIPwPkhpvP42V";
		String clientSecret ="i1ZAky8pkC";
		
		try {
			
			System.out.println("검색어를 입력해주세요>>");
			Scanner sc = new Scanner(System.in);
			String result = sc.nextLine();
			String search = URLEncoder.encode(result, "UTF-8");
					
			String apiURL = "https://openapi.naver.com/v1/search/book?query=" + search;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			BufferedReader br = null;
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			con.disconnect();
			
			JSONObject obj = new JSONObject(sb.toString());
			JSONArray items = obj.getJSONArray("items");
			File dir = new File("C:/download");
			
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			
			File file = new File(dir, result + ".html");
			PrintWriter out = new PrintWriter(file);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>검색결과</title>");
			out.println("</head>");
			out.println("<body>");
			for(int i = 0; i < items.length(); i++) {
				String title = items.getJSONObject(i).getString("title");
				title = title.replaceAll(result, "<b>"+result +"</b>");
				out.println("<a href=\""+items.getJSONObject(i).getString("link")+"\">"+title+"</a>");
				out.println("<br>");
				out.println("<img src=\""+items.getJSONObject(i).getString("image")+"\" height=\"130\" width=\"90\">");
				out.println("<hr>");
			}
			
			
			
			out.println("</body>");
			out.println("</html>");
			sc.close();
			out.close();
		}catch (Exception e) {
			try {
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd aa hh:mm:ss");
				File dir = new File("C:/download/log");
				if(dir.exists() == false) {
					dir.mkdirs();
				}
				File file = new File(dir, "error_log.txt");
				PrintWriter out = new PrintWriter(file);
				out.println("예외메시지      " + e.getMessage());
				out.println("예외발생시간    " + formatter.format(date));
				out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
