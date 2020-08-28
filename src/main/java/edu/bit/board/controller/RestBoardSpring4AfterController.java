package edu.bit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@RestController//spring v4.0 이후 버전 Controller +@ResponseBody
@AllArgsConstructor//controller에게 생성자를 만들어 줘야, 파라미터로 service가 불러낸 list의 내용을 호출할 수가 있다.
/*
 * 의존관계 주입을 하지 않은 경우에는 Controller 객체를 생성할 수 없다. 즉, 의존관계에 대한 내용을 외부로 노출시킴으로써 컴파일 타임에 오류를 잡아낼 수 있다.
 * @ 어노테이션을 스캔하고 그 요소들을 IoC container에 넣는다.
 */
//이게 없어버리면 private BoardService service;여기에 뭐를 담아야 하는건지를 알수 없게 되버려서 생성자가 있어야 한다.
public class RestBoardSpring4AfterController {

	 private BoardService service;
	 
	   //@CrossOrigin
	   //@ResponseBody
	   @RequestMapping("/restful/after")
	   public List<BoardVO> before() {
	      log.info("/restful/after");
	      List<BoardVO> list = service.getList();
	      
	      return list;
	   }
	   
		@RequestMapping(value = "/rest/delete/{bId}", method = RequestMethod.DELETE)
		 public int restDelete(@PathVariable("bId") int bId){
			log.info("restDelete");
		 
		 return service.remove(bId);//content_view에서 result로 받는다.
		}
		 
}


