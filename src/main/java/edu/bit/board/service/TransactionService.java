package edu.bit.board.service;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class TransactionService {

	private BoardMapper boardMapper;
	
	public void transactionTest1() {
		log.info("transactionTest1()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션1");
		boardVO.setbName("트랜잭션1");
		boardVO.setbTitle("트랜잭션1");
		
		boardMapper.insertBoard(boardVO);
		
		boardVO.setbContent("트랜잭션2");
		boardVO.setbName("트랜잭션2");
		boardVO.setbTitle("트랜잭션2");
		
		boardMapper.insertBoard(boardVO);
		
	}
	
	public void transactionTest2() {
		log.info("transactionTest2()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션1");
		boardVO.setbName("트랜잭션1");
		boardVO.setbTitle("트랜잭션1");
		
		boardMapper.insertBoard(boardVO);
		
		boardVO.setbContent("트랜잭션2");
		boardVO.setbName("트랜잭션2");
		boardVO.setbTitle("트랜잭션2");
		
		boardVO = null;
		
		boardMapper.insertBoard(boardVO);
		
	}
	
	@Transactional
	public void transactionTest3() {
		log.info("transactionTest3()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션1");
		boardVO.setbName("트랜잭션1");
		boardVO.setbTitle("트랜잭션1");
		
		boardMapper.insertBoard(boardVO);
		
		boardVO.setbContent("트랜잭션2");
		boardVO.setbName("트랜잭션2");
		boardVO.setbTitle("트랜잭션2");
		
		boardVO = null;
		
		boardMapper.insertBoard(boardVO);
		
	}
	
	@Transactional
	public void transactionTest4() {
		log.info("transactionTest4()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션1");
		boardVO.setbName("트랜잭션1");
		boardVO.setbTitle("트랜잭션1");
		
		boardMapper.insertBoard(boardVO);
		
		//의도적으로 에러 발생시키기.
		throw new RuntimeException("RuntimeException for rollback");
	}
	
	@Transactional
	public void transactionTest5() throws IOException {
		log.info("transactionTest5()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션1");
		boardVO.setbName("트랜잭션1");
		boardVO.setbTitle("트랜잭션1");
		
		boardMapper.insertBoard(boardVO);
		
		//의도적으로 에러 발생시키기.
		throw new IOException("IOException for rollback");
	}
	
	//IOException 롤백 설정
	@Transactional(rollbackFor = Exception.class)
	public void transactionTest6() throws IOException {
		log.info("transactionTest6()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션1");
		boardVO.setbName("트랜잭션1");
		boardVO.setbTitle("트랜잭션1");
		
		boardMapper.insertBoard(boardVO);
		
		//의도적으로 에러 발생시키기.
		throw new IOException("IOException for rollback");
	}
	
}
