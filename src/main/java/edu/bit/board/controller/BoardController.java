package edu.bit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageDTO;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor//controller에게 생성자를 만들어 줘야, 파라미터로 service가 불러낸 list의 내용을 호출할 수가 있다.
/*
 * 의존관계 주입을 하지 않은 경우에는 Controller 객체를 생성할 수 없다. 즉, 의존관계에 대한 내용을 외부로 노출시킴으로써 컴파일 타임에 오류를 잡아낼 수 있다.
 * @ 어노테이션을 스캔하고 그 요소들을 IoC container에 넣는다.
 */
//이게 없어버리면 private BoardService service;여기에 뭐를 담아야 하는건지를 알수 없게 되버려서 생성자가 있어야 한다.
public class BoardController {

	/*
	 * spring5 생성자가 있으면 자동으로 넣어줌
	 * 생성자가 있으면 BoardService를 자동으로 넣어줌
	 */
	private BoardService service;//서비스에는 business logic이 들어가 생성자를 만들어 주니까
	
	/*
	 * @Inject
	 * public BoardController(BoardService service){ 
	 * 		this.service = service; 
	 * }
	 */
	
	 @GetMapping("/list3")
	 public void list2(Criteria cri, Model model) {	
		 log.info("list3");
		 log.info(cri);
		 model.addAttribute("list", service.getList(cri));	
		 
		 int total = service.getTotal(cri);
		 log.info("total" + total);
		 
		 model.addAttribute("pageMaker", new PageDTO(cri,total));	
	 }
	
	@GetMapping("/list")//이전에는 @RequestMapping 이였음 상관은 없음 get방식이니까
	public void list(Model model) {
		
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) {
		log.info("content_view");
		
		model.addAttribute("content_view", service.get(boardVO.getbId()));
		
		return "content_view";
	}
	
	@GetMapping("/delete")
	public String delete(BoardVO boardVO) {
		log.info("delete");
		
		service.remove(boardVO.getbId());
		
		return "redirect:list";
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(BoardVO boardVO) throws Exception {
		log.info("write()");
		
		service.writeBoard(boardVO);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model) {
		log.info("reply_view()");
		
		model.addAttribute("reply_view", service.get(boardVO.getbId()));
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO) throws Exception {
		log.info("reply()");
		
		service.writeReply(boardVO);
		
		return "redirect:list";
	}
	
	//ajax 통신
	@RequestMapping("/ajaxList")//여기에 우리가 붙인 경로가 붙어
	public String ajaxList() {
		log.info("ajaxList()");
		
		return "ajaxList";
	}

}


