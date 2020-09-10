package bit.it.into.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BondDto {
	
	private String bond_symbols;
	private String member_num;
	private double total_interest;
	private String bond_company;
	private int bond_price;
	private Timestamp bond_date;
	private double coupon_interest_rate;
	private double discount_rate;
	private int gross_price;
	private Timestamp maturity_date;
	private String grade;
	
	
	public String getBond_symbols() {
		return bond_symbols;
	}
	public void setBond_symbols(String bond_symbols) {
		this.bond_symbols = bond_symbols;
	}
	public String getMember_num() {
		return member_num;
	}
	public void setMember_num(String member_num) {
		this.member_num = member_num;
	}
	public double getTotal_interest() {
		return total_interest;
	}
	public void setTotal_interest(double total_interest) {
		this.total_interest = total_interest;
	}
	public String getBond_company() {
		return bond_company;
	}
	public void setBond_company(String bond_company) {
		this.bond_company = bond_company;
	}
	public int getBond_price() {
		return bond_price;
	}
	public void setBond_price(int bond_price) {
		this.bond_price = bond_price;
	}
	public Timestamp getBond_date() {
		return bond_date;
	}
	public void setBond_date(Timestamp bond_date) {
		this.bond_date = bond_date;
	}
	public double getCoupon_interest_rate() {
		return coupon_interest_rate;
	}
	public void setCoupon_interest_rate(double coupon_interest_rate) {
		this.coupon_interest_rate = coupon_interest_rate;
	}
	public double getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(double discount_rate) {
		this.discount_rate = discount_rate;
	}
	public int getGross_price() {
		return gross_price;
	}
	public void setGross_price(int gross_price) {
		this.gross_price = gross_price;
	}
	public Timestamp getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(Timestamp maturity_date) {
		this.maturity_date = maturity_date;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

	
}
