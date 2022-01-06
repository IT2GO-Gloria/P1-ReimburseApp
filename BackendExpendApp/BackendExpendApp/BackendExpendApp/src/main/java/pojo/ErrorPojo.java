package pojo;

import java.time.LocalDate;

public class ErrorPojo {
	private String errorMessage;
	private LocalDate data;
	
	public ErrorPojo() {
		super();
	}

	public ErrorPojo(String errorMessage, LocalDate date) {
		super();
		this.errorMessage = errorMessage;
		//this.date = date;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ErrorPojo [errorMessage=" + errorMessage + ", data=" + data + "]";
	}


		
}
