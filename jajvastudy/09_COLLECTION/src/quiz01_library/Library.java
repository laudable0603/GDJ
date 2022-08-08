	package quiz01_library;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class Library {
	//private void addBook 풀첵필요없음
	
	//private void removeBook empty체크 필요함 (예외처리로 변경)
		//removeBookbyIndex 인덱스 정보를 이용해서 제거
		//removeBookByObject() 객체(Book) 정보를 이용해서 제거	
	
	//private void findBook() - empty체크 필요함
	//private void printAllBooks - empty체크 필요함
	
	private Scanner sc;
	private List<Book> books;
	
	
	public Library() {
		sc = new Scanner(System.in);
		books = new ArrayList<Book>();
	}
	
	private void addBook() {
			System.out.println("+++++책등록+++++");
			System.out.println("책 번호 입력 >>> ");			
			int bookNo = sc.nextInt();
			 
			
				System.out.print("등록하실 책을 입력해주세요 >>> ");
				 String title = sc.next();
				 System.out.print("저자 입력 >>> ");
				 String author = sc.next();
				 Book book = new Book(bookNo, title, author);					 
				 books.add(book);
				 
		
					
					
				
			
			
			
	 	}
	
	private void removeBookByIndex() {
		// Book remove(int index) 메소드 이용
		if(books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		System.out.println("-----책삭제-----");
		System.out.print("삭제할 책의 번호 >>>  ");
		int bookNo = sc.nextInt();//책번호는 1~100사이지만 배열은 0~99이기에 -1을 붙여준다.
		for (int i = 0, length = books.size(); i < length; i++) {
			if(books.get(i).getBookNo() == bookNo) {
				Book removeBook = books.remove(i);											//배열을 옮기고 뒷쪽에 남아있는 배열들을 null값 초기값으로 바꾸어주기.
				System.out.println(removeBook + " 책을 삭제했습니다.");
				
				
			}
		}
		throw new RuntimeException("책 번호가 " + bookNo + "인 책이 없습니다.");
	}
	
	private void removeBookByObject() {
		// boolean remove(Object obj)
		if(books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		System.out.println("+++++책등록+++++");
		 System.out.println("책 번호 입력 >>> ");
		 int bookNo = sc.nextInt();
		 System.out.print("등록하실 책을 입력해주세요 >>> ");
		 String title = sc.next();
		 System.out.print("저자 입력 >>> ");
		 String author = sc.next();
		 //책 배열에 등록하기
		 Book book = new Book(bookNo, title, author); 
		 if (books.remove(book)) {
			 System.out.println(book + "책을 삭제했습니다.");
			 return;
		 } 
		 throw new RuntimeException(book +"책이 없습니다.");
		 
		
		
		
		
		
	}

	private void findBook() {
		if(books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		System.out.println("☆☆☆☆☆☆책조회☆☆☆☆☆☆");
		System.out.print("조회할 책 제목 입력 >>> ");
		String title = sc.next();
		for (int i = 0, length = books.size(); i < length; i++) {
			//저장된 책 제목 : 배열속 배열번호에 해당 배열에 들어가있는 getTitle
			// 조회할 책 제목 : title
			if(books.get(i).getTitle().equals(title)) {
				System.out.println(books.get(i));
				return;  //findBook()메소드 종료				
			}			
		}
		throw new RuntimeException("제목이" + title + "인 책은 없습니다.");
	}
	
	private void printAllBooks() {
		if(books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		System.out.println("※※※※※※※전체목록※※※※※※※");
		for(Book book : books) {
			System.out.println(book);
		}
		}
	
public void manage() {
	
	while(true) {	
		try {
			
				System.out.print("1. 추가 2. 삭제 3. 조회 4. 전체목록 0. 프로그램종료 >>>  ");
				int choice = sc.nextInt();  //숫자먹어주는 역할
				sc.nextLine();  //엔터먹어주는 역할 *불필요한 엔터 제거*
				switch(choice){ //스캐너에서 들어온 초이스 번호로 위쪽 메소드를 실행시키는 법
				
				case 1: addBook(); break;
				case 2: removeBookByIndex(); break;
				case 3: findBook(); break;
				case 4: printAllBooks();break;
				case 0: System.out.println("Library 프로그램을 종료합니다. 감사합니다."); 
						return; //magage 메소드 종료를 위한 리턴
				default : System.out.println("알 수 없는 명령입니다. 다시 시도하세요");
				
				
			}
		} catch (InputMismatchException e) {
			sc.next();
			System.out.println("명령은 정수입니다.");
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}
	
}
