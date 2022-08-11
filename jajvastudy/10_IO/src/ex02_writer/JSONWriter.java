package ex02_writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONWriter {
	
	public static void m1() {
		//JSON
		// 1. JavaScript Object Notation
		// 2. 자바스크립트 객체 표기법
		// 3. 객체 : { }
		// 4. 배열 : [ ]
		
		// JSON-Java(JSON in Java)라이브러리
		// 1. 객체 : JSONObject 클래스(Map 기반)
		// 2. 배열 : JSONArray 클래스(List 기반)
		
		JSONObject obj = new JSONObject();
		obj.put("name", "조용선");
		obj.put("age", 26);
		obj.put("man", true);
		obj.put("height", 180);
		
		System.out.println(obj.toString());
		System.out.println();
		
		
		
	}

	public static void m2() {
		
		JSONObject obj1 = new JSONObject();
		obj1.put("name", "제임스");
		obj1.put("age", 30);
		
		
		
		JSONObject obj2 = new JSONObject();
		obj2.put("name", "에밀리");
		obj2.put("age", 40 );
		
		JSONArray arr = new JSONArray();
		arr.put(obj1);
		arr.put(obj2);
		System.out.println(arr.toString());
		
	}
	
	public static void m3() {
		
		String str = "{\"name\":\"조용선\",\"man\":true,\"age\":26,\"height\":180}";
		
		JSONObject obj = new JSONObject(str);
		String name = obj.getString("name");
		boolean man = obj.getBoolean("man");
		int age = obj.getInt("age");
		double height = obj.getDouble("height");
		System.out.println(name);
		System.out.println(man);
		System.out.println(age);
		System.out.println(height);
		
		
		
	}
	
	public static void m4() {
		String str = "[{\"name\":\"제임스\",\"age\":30},{\"name\":\"에밀리\",\"age\":40}]";
		
		JSONArray arr = new JSONArray(str);
		
		//일반 for문
		for(int i = 0, length= arr.length(); i < length; i++) {
			JSONObject obj = arr.getJSONObject(i);
			String name = obj.getString("name");
			int age = obj.getInt("age");			
			System.out.println(name + ", " + age);
			
			//String name = arr.get(i).toString();
			//System.out.println(name);
		}
		
		//향상 for문, get() 메소드로 동작. get()메소드는 Object를 반환
		for(Object o: arr) {
			JSONObject obj = (JSONObject)o;
			String name = obj.getString("name");
			int age = obj.getInt("age");
			System.out.println(name + ", " + age);
		}
			
		
		
		
	}
	
	public static void main(String[] args) {
		
		List<String> product1 = Arrays.asList("100","새우깡","1500");
		List<String> product2 = Arrays.asList("101","양파링","2000");
		List<String> product3 = Arrays.asList("102","홈런볼","3000");

		List<List<String>> list = Arrays.asList(product1, product2, product3);
		
		// list를 jsonString으로 만들어서
		// c:\\storage \\product.json 파일에 write();
		
		/*
		 * JSONArray arr = new JSONArray(list);
		 * 
		 * File file = new File("C:\\storage", "product.json");
		 * 
		 * FileWriter fw = null; BufferedWriter bw = null;
		 * 
		 * try { fw = new FileWriter(file); bw = new BufferedWriter(fw); for(int i = 0,
		 * length = arr.length(); i < length; i++) { String a = arr.get(i).toString();
		 * bw.write(a); System.out.println(a); }
		 * 
		 * }catch(IOException e) { e.printStackTrace(); } finally { try { //메인 스트림은 닫을
		 * 필요가 없음(자동으로 닫힘) if(bw != null) { bw.close(); } } catch (IOException e) {
		 * e.printStackTrace(); } }
		 */
		System.out.println("선생님 풀이 ㅡㅡ ");
		
		JSONArray arr2 = new JSONArray();
		
		for(List<String> line : list) {
			JSONObject obj = new JSONObject();
			obj.put("number", line.get(0));
			obj.put("name", line.get(1));
			obj.put("price", line.get(2));
			arr2.put(obj);
		}
		File file2 = new File("c:\\storage", "product_1.json");
		FileWriter fw2 = null;
		BufferedWriter bw2 = null;

		try {
			fw2 = new FileWriter(file2);
			bw2 = new BufferedWriter(fw2);
			bw2.write(arr2.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw2 != null ) {
					bw2.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		
		
		
		
		
		
		
		
		
		
	}

}
