package oneday;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Xml {

	public static void main(String[] args) {
		
		StringBuilder apiURL = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson");
		try {
			String serviceKey = "cGhe1YJiUgrQHpux0Vc2ShuF7mDJ7Ih5I9Rtw/qvtMLxl/wgYkSaXiW5t65DXq/GxGluLeqcFhWo3Pu/Z3iTig==";
			
			apiURL.append("?serviceKey=" + URLEncoder.encode(serviceKey,"UTF-8") );
			apiURL.append("&startCreateDt=20220808");
			apiURL.append("&endCreateDt=20220812");
			
		} catch(UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL.toString());
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");//생략가능
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 주소 접속 실패");
		}
		
		
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		
		String response = sb.toString();
		
		File file = new File("c:\\storage", "api2.xml");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.append(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			NodeList items = root.getElementsByTagName("item");
			
			for(int i = 0; i < items.getLength(); i++) {
				Element item = (Element)items.item(i); //Node > Element 타입으로 다운캐스팅
				Node category = item.getElementsByTagName("category").item(0);
				Node obsrValue = item.getElementsByTagName("obsrValue").item(0);
				String strCategory = null;
				switch(category.getTextContent()) {
				case "PTY" : strCategory = "강수형태"; break;
				case "REH" : strCategory = "습도"; break;
				case "RN1" : strCategory = "강수량(1시간)"; break;
				case "T1H" : strCategory = "기온"; break;
				case "UUU" : strCategory = "동서바람성분"; break;
				case "VEC" : strCategory = "풍향"; break;
				case "VVV" : strCategory = "남북바람성분"; break;
				case "WSD" : strCategory = "풍속"; break;
				}
				System.out.println(strCategory + " : " + obsrValue.getTextContent());
					 
				}
				
			
			
			
			
			
			
			
			
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	

}
