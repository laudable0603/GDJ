package com.gdu.app07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app07.domain.BoardDTO;
import com.gdu.app07.service.BoardService;

import lombok.AllArgsConstructor;

@Controller

// 필드를 이용한 생성자를 만들어 두면,
// 생성자의 매개변수로 컨테이너의 Bean이 자동 주입(@Autowired) 되므로
// 필드에 @Autowired 처리할 필요가 없다.
@AllArgsConstructor
public class BoardController {
	
	// @Autowired가 없음에 주의!
	private BoardService boardService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("brd/list") //폴더와 매핑은 구분하자.
	public String list(Model model) { //Model은 forward할 속성(Attribute)을 저장할 때 사용한다.
		model.addAttribute("boards", boardService.findAllBoards());
		return "board/list"; //board 폴더의 list.jsp로 forward
	}
	
	@GetMapping("brd/write")
	public String write() {
		return "board/write"; //board 폴더의 write.jsp - forward
	}
	
	
	@PostMapping("brd/add")
	public String add(BoardDTO board) {
		boardService.saveBoard(board); // saveBoard()로 부터 0/1이 반환되지만 처리하지 않았다.
		return "redirect:/brd/list"; //redirect뒤에는 jsp가 아닌 매핑값을 적어준다(작성후 목록으로 이동)
	}
	
	@GetMapping("brd/detail")//상세보기는 무조건 get			//값이 널이면 0이다
	public String detail(@RequestParam(value="board_no", required=false, defaultValue="0") int board_no
						, Model model) {
		model.addAttribute("board", boardService.findBoardByNo(board_no));
		return "board/detail";
	}
	
	@PostMapping("brd/edit")
	public String edit(int board_no
			         , Model model) {
		model.addAttribute("board", boardService.findBoardByNo(board_no));
		return "board/edit";
	}
	
	@PostMapping("brd/modify")
	public String modify(BoardDTO board) {
		boardService.modifyBoard(board);// modifyBoard()로 부터 0/1이 반환되지만 처리하지 않았다.
		return "redirect:/brd/detail?board_no=" + board.getBoard_no();
	}
	
	@PostMapping("brd/remove")
	public String remove(int board_no) {
		boardService.removeBoard(board_no);// modifyBoard()로 부터 0/1이 반환되지만 처리하지 않았다.
		return "redirect:/brd/list";
	}
	
	
	
}
