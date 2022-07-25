package ex03_string;

public class Ex02_StringBuilder {

	public static void main(String[] args) {
		
		//String이 아닌 StringBuilder클래스인걸 인지해야됨.
		//java.lang.StringBuilder 클래스
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		sb.append(true);
		sb.append('T');
		sb.append(3.14);
		sb.append("hello");
		
		System.out.println(sb);
		
		
		//동등비교
		
		
		//StringBuilder로 만든 문자열은 반드시 마지막에 String으로 변환해야함
		String result = sb.toString();
		System.out.println(result.equals("1trueT3.14hello"));
		
		
		//String과 StringBuilder의 성능테스트 
		//StringBuilder가 더 빠르다.
		//abcdefghijklmnopqrstuvwxyz
		
		String alphabet1 = "";
		long begin1 = System.nanoTime();
		for(char ch = 'a'; ch <= 'z'; ch++) {
			alphabet1 += ch;
		}
		long end1= System.nanoTime();
		System.out.println((end1 - begin1) + alphabet1);
		
		
		
		long begin2 = System.nanoTime();
		StringBuilder sb2 = new StringBuilder();
		for(char ch = 'a'; ch <= 'z'; ch++) {
			sb2.append(ch);
		}
		long end2= System.nanoTime();
		String alphabet2 = sb2.toString();
		System.out.println((end2 - begin2) + alphabet2);
		
		//연습. 대문자 6자리로 구성된 인증코드 작성하기
		StringBuilder sbCode = new StringBuilder();
		for (int n = 0; n < 6; n++) {
			sbCode.append((char)((int)(Math.random() * 26) + 'A'));
		}
		String code = sbCode.toString();
		System.out.println("인증코드 : " + code);
		
		//연습 . 1 2 3 4 5 6 7 8 9 10 만들기
		StringBuilder sbPaging = new StringBuilder();
		for(int n = 1; n <= 10; n++) {
			sbPaging.append(n + " ");
		}
		String paging = sbPaging.toString();
		System.out.println(paging);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
