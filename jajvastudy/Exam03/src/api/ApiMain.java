package api;

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
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class ApiMain {

	public static void main(String[] args) {
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
		String key = "cGhe1YJiUgrQHpux0Vc2ShuF7mDJ7Ih5I9Rtw/qvtMLxl/wgYkSaXiW5t65DXq/GxGluLeqcFhWo3Pu/Z3iTig==";
		
		try {
			urlBuilder.append("?ServiceKey=").append(URLEncoder.encode(key,"UTF-8"));
			urlBuilder.append("&type=xml");
			urlBuilder.append("&searchYear=2021");//2021년
			urlBuilder.append("&siDo=1100");//서울특별시
			urlBuilder.append("&guGun=1125");//금천구
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&pageNo=1");
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String apiURL = urlBuilder.toString();	
			
		URL url = null;
		HttpURLConnection con = null;	
		
		try {			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 접속 실패");
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
		
		
		File file = new File("accident.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		con.disconnect();
		
		
		
		
		List<Accident> accidents = new ArrayList<Accident>();
		
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder =  factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement(); // response
			
			
			NodeList items = root.getElementsByTagName("item");
			
			
			
			for(int i=0; i <items.getLength(); i++) {
				Element item = (Element)items.item(i);
				
				String occrrncDt = item.getElementsByTagName("occrrnc_dt").item(0).getTextContent();
				String occrrncDayCd = item.getElementsByTagName("occrrnc_day_cd").item(0).getTextContent();
				int dthDnvCnt = Integer.parseInt(item.getElementsByTagName("dth_dnv_cnt").item(0).getTextContent());
				int injpsnCnt = Integer.parseInt(item.getElementsByTagName("injpsn_cnt").item(0).getTextContent());
				
				
				
				
				Accident accident = Accident.builder()
							.occrrncDt(occrrncDt)
							.occrrncDayCd(occrrncDayCd)
							.dthDnvCnt(dthDnvCnt)
							.injpsnCnt(injpsnCnt)
							.build();
				
				accidents.add(accident);
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		for(Accident accident : accidents) {
			System.out.println(accident);
		}

	}

}
