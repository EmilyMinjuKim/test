package edu.bit.board.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class BoardControllerTest {
	
	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;
	//WebApplicationContext --> spring(IoC container) DispatcherServlet 생성될 때 생성된다.
	//2개의 객체를 받는다.
	private MockMvc mockMvc;
	
	 @Before
	   public void setup() {
	      this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	   }
	   
	   /*
	    @GetMapping("/list")
	    public void list(Model model) {   
	       log.info("list");
	       model.addAttribute("list", service.getList());   
	    }*/
	   
	   @Test
	   public void testList() throws Exception {
	       mockMvc.perform(get("/list"))
	       .andExpect(status().isOk())//응답 검증
	       .andDo(print())
	       .andExpect(forwardedUrl("/WEB-INF/views/list.jsp"));
	   }

}
