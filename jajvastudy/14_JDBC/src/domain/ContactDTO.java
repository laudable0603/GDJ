package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data  //@Getter, @Setter, @ToString 등 들어있음
@NoArgsConstructor
@AllArgsConstructor
@Builder

/*
 DTO : Data Transfer Object, 데이터 전송객체, DB로 전송할 데이터는 하나로 모아서 처리
       , 클래스를 이용해 객체로 만들어서 전달하는 형태
       , 데이터 저장 객체를 처리하는 영역으로 도메인(domain) 패키지로 처리
 */
public class ContactDTO {
	private int contact_no;
	private String name;
	private String tel;
	private String email;
	private Date reg_date;
}
