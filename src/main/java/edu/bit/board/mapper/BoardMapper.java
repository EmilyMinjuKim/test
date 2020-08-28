package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> getList();//자손이 구현
	
	BoardVO read(int bno);
	void upHit(int bno);
	
	@Delete("Delete from mvc_board where bId = #{bno}")//direct로 interface 위에 @주고 쿼리를 입력함
	int delete(int bno);
	void insertBoard(BoardVO boardVO);
	//이렇게만 써도 가능한 이유 mapper.xml에서 변수 이름을 VO랑 통일 해줬어
	//내부적으로 각 변수들의 getter함수를 호출하기 때문에 BoardVO boardVO 이렇게만 써도 알아서 찾아준다.
	
	void updateShape(@Param("boardVO")BoardVO boardVO);
	//솔직히 파라미터 하나에는 @Param 의미 없음
	//객체가 2개 이상 들어가야 할 때가 생겨(board2 같은...)그럴 때 효과적이야.
	
	void insertReply(BoardVO boardVO);
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
}
