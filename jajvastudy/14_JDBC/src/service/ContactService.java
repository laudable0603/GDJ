package service;

import domain.ContactDTO;


//ContactDAO를 부르는 역할

public interface ContactService {
	public void addContact(ContactDTO contact);    // 추가할 정보 -여러가지 저장할 정보 
	public void modifyContact(ContactDTO contact); // 수정할 정보
	public void deleteContact(int contact_no);     // 삭제할 정보 - 번호만 저장
	public void findContactByNo(int contact_no);   // 검색할 정보 - 번호로 검색
	public void findAllContacts();                 // 전체 목록
	public void createContactFile();               // 파일만들기
	
}
