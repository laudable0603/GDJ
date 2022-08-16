package ex02_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Main {

	// 요청 (어떤 데이터를 (처리)달라고 요청하는것)
	// 1. Request
	// 클라이언트 -> 서버

	// 파라미터
	// 1.Parameter //요청할 주소 : apiURL
	// 2. 보내는 데이터(변수개념)
	// 필수 / 선택

	// 응답
	// 1. Response
	// 2. 서버 -> 클라이언트

	// apiURL?파라미터=값&파라미터=값...

	public static void m1() {
		// 전국 종량제 봉투가격 표준 데이터

		// API 주소(주소 + 요청 파라미터)
		// 회원가입등 로그인 방식은 해당방식인 get이 아니라 post방식을 사용한다.

		String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";
		
		try {
			String serviceKey = "cGhe1YJiUgrQHpux0Vc2ShuF7mDJ7Ih5I9Rtw/qvtMLxl/wgYkSaXiW5t65DXq/GxGluLeqcFhWo3Pu/Z3iTig==";
			apiURL += "?pageNo=0";
			apiURL += "&numOfRows=100";
			apiURL += "&type=xml";
//			apiURL += "&CTPRVN_NM=" + URLEncoder.encode("인천광역시", "UTF-8");
//			apiURL += "&SIGNGU_NM=" + URLEncoder.encode("계양구", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_TYPE=" + URLEncoder.encode("규격봉투", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_MTHD=" + URLEncoder.encode("소각용", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_PRPOS=" + URLEncoder.encode("생활쓰레기", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_TRGET=" + URLEncoder.encode("기타", "UTF-8");
			apiURL += "&serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");

		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}

		// API 주소 접속
		URL url = null;
		HttpURLConnection con = null;
		try {

			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");//GET방식을 사용하겠다라는 의미
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");

		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 주소 접속 실패");
		}

		// 입력 스트림(응답) 생성
		// 1. 응답 성공 시 정상 스트림, 실패시 에러 스트림
		// 2. 응답 데이터는 StringBuilder에 저장
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();

		try {

			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			// 스트림 종료
			reader.close();

		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}

		String response = sb.toString();
		System.out.println(response);

		// 접속 종료

		con.disconnect();

	}

	public static void m2() {

	}

	public static void m3() {

	}

	public static void m4() {

	}

	public static void main(String[] args) {
		m1();

	}

}
