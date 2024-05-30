package in.Ashokit.exception;

import java.time.LocalDate;

public class Exinfo {

	private String exCode;
	private String exMsg;
	private LocalDate exDate;
	public void setExCode(String exCode) {
		this.exCode = exCode;
	}
	public void setExMsg(String exMsg) {
		this.exMsg = exMsg;
	}
	public void setExDate(LocalDate exDate) {
		this.exDate = exDate;
	}
	public String getExCode() {
		return exCode;
	}
	public String getExMsg() {
		return exMsg;
	}
	public LocalDate getExDate() {
		return exDate;
	}
	
}
