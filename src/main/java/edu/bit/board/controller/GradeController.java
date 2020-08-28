package edu.bit.board.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bit.board.vo.GradeVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class GradeController {

	@RequestMapping("/restful/gradeAvg")
	public String gradeAvg() {
		log.info("gradeAvg");
		
		return "gradeAjax";
	}
	
	@ResponseBody
	@RequestMapping("/restful/gradeAjax")
	public Double gradeAjax(GradeVO grd) {
		log.info("gradeAjax");
		
		return grd.getGrade();
	}
}


