package edu.bit.board.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	//페이징 처리할 때 필요한 정보들 - 변수 7가지 기억!
	private int startPage;		//화면에 보여지는 페이지 시작번호
	private int endPage;		//화면에 보여지는 끝번호
	private boolean prev, next; //이전과 다음으로 이동가능한 링크 표시
	
	private int total;			//전체 게시글 수 
	private Criteria cri;		
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;		//전체 데이터 수
		
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0))*10;
		//getPageNum: 현제 페이지 번호 (ex. 3)
		//10.0 : 하단 페이징 바에 보여줄 페이징바 개수
		//연산: ceil(3 / 10.0) * 10 = 1 * 10 = 10
		//getPageNum이 11이 되는 순간 endPage는 20으로 바뀜.
		
		this.startPage = this.endPage - 9;
		
		//Total을 통한 endPage의 재계산
		//10개씩 보여주는 경우 전체 데이터 수가 80개라고 가정하면 끝번호는 10이 아닌 8이 됨.
		int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if(realEnd <= this.endPage) {
			this.endPage = realEnd;
		}
		
		//시작번호가 1보다 큰 경우
		this.prev = this.startPage > 1;
		
		//realEnd가 끝번호(endPage)보다 큰 경우
		this.next = this.endPage < realEnd;
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page) // pageNum = 3
				.queryParam("amount", cri.getAmount()) // pageNum=3&amount=10
				.build(); // ?pageNum=3&amount=10
		return uriComponentsBuilder.toUriString(); // ?pageNum=3&amount=10 리턴 
	}
	
}
