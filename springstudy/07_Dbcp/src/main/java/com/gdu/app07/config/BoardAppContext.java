package com.gdu.app07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app07.repository.BoardDAO;
import com.gdu.app07.service.BoardService;
import com.gdu.app07.service.BoardServiceImpl;

@Configuration
public class BoardAppContext {
	
	@Bean
	public BoardDAO dao() {
		return new BoardDAO();
	}
	
	@Bean
	public BoardService boardService() {
		//보드 서비스 임플은 다오를 만들어준다. 따라서 생성자에 다오를 넣어준다.
		return new BoardServiceImpl(dao());
	}
	
	
}
