package edu.bit.board.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GradeVO {
	private double kor;
	private double eng;
	private double math;
	
	public double getGrade() {
		return (kor + eng + math)/3;
	}
}
