package edu.bit.board.aop;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.bit.board.controller.BoardControllerTest;
import edu.bit.board.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/aop-context.xml" })
public class AopTest {
	
	@Inject
	private BoardService service;
	
	@Test
	public void testServiceAop() {
		
		log.info("리스트 시작");
		long st = System.currentTimeMillis();
		log.info("시작시간: " + st);
		log.info(service.getList());
		
		long et = System.currentTimeMillis();
		log.info("리스트 끝");
		log.info("끝난 시간: " + et);
		
		log.info("경과시간: " + (et-st));
	}
}
