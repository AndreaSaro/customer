package it.piksel.censa.exception;

public class ErrorResponse {

	private int reasonCode;
	private String errorMessage;
	private String exceptionClass;

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getExceptionClass() {
		return exceptionClass;
	}

	public int getReasonCode() {
		return reasonCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setExceptionClass(String exceptionClass) {
		this.exceptionClass = exceptionClass;
	}

	public void setReasonCode(int reasonCode) {
		this.reasonCode = reasonCode;
	}

}
