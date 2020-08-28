package edu.bit.board.datasource;


import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bit.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)//이것 만으로도 IoC container를 만드는 거야
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//IoC container에서 이걸 읽어들여라
@Log4j

public class DatasourceTest {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void testMapper() {
		System.out.println(mapper.getList());
	}
	
	@Test
	public void testDatasource() {
		System.out.println(dataSource);
	}
	
	
}
