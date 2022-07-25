package ex03_string;

public class Ex01_String {

	public static void main(String[] args) {
		
		/* str1 0x123
		   str2 0x123
		   
		  		hello 0x123
		 
		 */ //서로 같은값에 저장되는 방식
		//참조값을 비교
		String str1 = "hello";
		String str2 = "hello";
		
		System.out.println(str1 == str2);//true
		
		/* str3 0x123
		   str4 0x456
		   
		   		hi 0x123
		   		hi 0x456
		 
		 */ //서로 다른값에 저장되는 방식
		
		String str3 = new String ("hi");
		String str4 = new String ("hi");
		
		System.out.println(str3 == str4);//false
		
		// 1.문자열 동등 비교
		// 참조값이 아닌 문자열을 비교하는방법
		boolean result1 = str1.equals(str2);
		boolean result2 = str3.equals(str4);
		
		System.out.println(result1);
		System.out.println(result2);
		
		if(str1.equals(str2)) {
			System.out.println("str1, str2는 같아요");
		} else {
			System.out.println("str1, str2는 달라요");
		}
		if(! str3.equals(str4)) { //! 연산은 가급적 사용하지 않는다.
			System.out.println("str3, str4는 달라요");
		} else {
			System.out.println("str3, str4는 같아요");
		}
		
		// 2. 대소문자를 무시한 문자열 동등비교
		String str5 = "Hello World";
		String str6 = "hELLO wORLD";
		
		boolean result3 = str5.equalsIgnoreCase(str6); //equals(객체)의 Case(대소문자)를 Ignore(무시)해라
		
		System.out.println(result3);
		
		//3. 문자열 길이 반환
		String name = "조용선";
		int length = name.length();
		System.out.println("글자수: " + length);
		
		//4. 특정 위치의 문자(char)만 반환
		//특정 위치 == 인덱스 (Indes)
		//글자마다 부여된 정수값
		// 0으로 시작
		System.out.println("-----------------문자-------------------");
		System.out.println(name.charAt(0));
		System.out.println(name.charAt(1));
		System.out.println(name.charAt(2));
		
		
		//5. 문자열의 일부 문자열 (String)을 반환
		// 1)substring(begin) : 인덱스 begin(포함)부터 끝까지 반환
		// 2)substring(begin, end) : 인덱스 begin(포함)부터 인덱스 end (불포함)까지 반환
		
		System.out.println("----------------문자열-----------------");
		System.out.println(name.substring(0));
		System.out.println(name.substring(0,1));
		System.out.println(name.substring(1,2));
		System.out.println(name.substring(2,3));
		
		// 6.특정 문자열(String)을 찾아서 해당 인덱스(int)를 반환
		
		//
		// 		1)indexOf
		//			(1) 발견된 첫 번째 문자열의 인덱스를 반환
		//			(2) 발견된 문자열이 없는 경우 -1을 반환
		//	// exe > '우'영우 의 우를 찾을 경우 0를 반환
		//		2)lastIndexOf
		//			(1) 발견된 마지막 문자열의 인덱스를 반환
		//			(2) 발견된 문자열이 없는 경우 -1을 반환
		// exe > 우영'우' 의 우를 찾을 경우 2를 반환
		int idx1 = name.indexOf("조");
		int idx2 = name.indexOf("용선");
		int idx3 = name.lastIndexOf("용선");
		int idx4 = name.lastIndexOf("선");
		
		System.out.println(idx1);
		System.out.println(idx2);
		System.out.println(idx3);
		System.out.println(idx4);
		
		// 7. 문자열이 특정 패턴으로 시작하는지 여부를 boolean(true, false) 반환
		
		//	startWith(문자열)
		
		if(name.startsWith("민")) {
			System.out.println("민씨입니다.");
		} else {
			System.out.println("민씨가 아닙니다.");
		}
		
		// 8. 문자열이 특정 패턴으로 끝나는지 여부를 boolean(true, false) 반환
		//		endWith(문자열)
		String filename = "image.jpg"; //jpg, png 등등으로 끝나면 이미지로 가정
		if(filename.endsWith("jpg") || filename.endsWith("png")) {
			System.out.println("이미지입니다.");
		} else {
			System.out.println("이미지가 아닙니다.");
		}
		
		
		// 9.문자열이 특정 패턴을 포함하는지 여부를 boolean(true, false) 반환
		String email = "laudable0603@gmail.com";
		if(email.contains("@") && email.contains(".")) {
			System.out.println("이메일 형식입니다.");
		} else {
			System.out.println("이메일 형식이 아닙니다.");
		}
		
		
		// 10.불필요한 공백 제거 (좌우 공백)
		String message = "  안녕  하세요  ";//맨 앞쪽, 맨 뒷쪽 공백이다.
		
		System.out.println(message.trim());
		System.out.println(message.trim().length());
		
		// 11. 대소문자 변환하기
		// toUpperCase : 대문자로 변환하기
		// toLowerCase : 소문자로 변환하기
		String source = "Best of best";
		System.out.println(source.toUpperCase());
		System.out.println(source.toLowerCase());
		
		// 12. 찾아 바꾸기
		// replace(old, new) : old를 찾아서 new로 변환하기
		// 소스는 출력값에서만 표현되며 대입하진 않으니, 새로 변수 생성후 등록한다.
		String replaced = source.replace("best", "worst");
		System.out.println(source);
		System.out.println(replaced);
		
		//주의. replaceAll() 메소드는 특정 문자열을 찾아서 변환하는 것이 아님.
		String ip = "192.168.101.91";
		String replacedIp = ip.replaceAll(".", "_"); // 192_198_101_91를 기대
		System.out.println(replacedIp); //"."은 문자열이 아님. \\. 을 활용
		
		//13. 빈 문자열인지 여부를 검사한 뒤 boolean(true, false) 반환
		String id =" ";
		if(id.trim().isEmpty()) {
			System.out.println("빈 문자열");
		} else {
			System.out.println("빈 문자열 아님");
		}
		
		if(id.isBlank()) { // 11버전 기능이라 이하버전에서 돌아가지 않을 수 있으니 사용x
			System.out.println("빈 문자열");
		} else {
			System.out.println("빈 문자열 아님");
		}
		
		//연습. 파일이름을 파일명과 확장자로 분리
		//단, jpg, git, png 이미지인 경우에만 작업을 진행한다.
		String fullName = "apple.jpg";
		int idxOfDot = fullName.lastIndexOf(".");
		String fileName = "";//apple
		String extName = ""; //.jpg
		
		fileName = fullName.substring(0, idxOfDot);
		extName = fullName.substring(idxOfDot + 1);
		System.out.println(fileName);
		System.out.println(extName);
		
		//연습. 문자열 "abc12345def67890ghijk"에서
		//아라비아 숫자 1234567890을 제외하고 한글자씩 화면에 출력하시오.
		String str = "abc12345def67890ghijk";
		//String num = str.replaceAll("[0-9]", "");
		//for (int n = 0; n < num.length(); n++) {
			//System.out.println(num.charAt(n));
		//}
		//풀이
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >= '0' && ch <='9') {
				continue;
			}
			System.out.println(ch);
		}
	}

}
