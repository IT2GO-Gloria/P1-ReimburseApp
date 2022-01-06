package exception;

public class ApplicationException extends Exception{
	
	String applicationExceptionMessage;
	
	public ApplicationException(String appExceptionMsg) {
		this.applicationExceptionMessage = appExceptionMsg;
	}
	@Override
	public String getMessage() {
		return this.applicationExceptionMessage;
	}

}
