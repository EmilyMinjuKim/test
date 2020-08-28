package edu.bit.board.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bit.board.vo.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	
	/*
	 * 주입 3가지 방식
	 * 1.생성자  2.setter 3.필드에 다이렉트
	 * 
	 * 3번은
	 * @Autowired
	 * private BoardMapper boardMapper 이렇게 생김
	 * 
	 * 왠만하면 생성자나 setter 함수로 넣는다.
	 */
	
	
	@Setter(onMethod_ = @Autowired)//lombok ---> board mapper에 대한 setter함수를 만들어
	private BoardMapper boardMapper;//얘를 테스트 하기 위해서는 뭐를 생성해야하냐... dao 테스트 --> 커넥션 풀 ~> db접속
	//setBoardMapper BoardMapper boardMapper 이렇게 만드는 것
	
	@Test
	public void testBoardMapper() {
		log.info(boardMapper);
	}
	
	
	@Test public void testBoardMapperList() {//함수도 테스트를 해야지 getList()
		List<BoardVO> list = boardMapper.getList();
	  
	    for(BoardVO boardVO : list) { 
	    	log.info(boardVO.getbContent());
	    	log.info(boardVO.getbId());
	    	} 
	    }
	 
}
