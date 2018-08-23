package com.csssi.util.fieldconverter.adapter;

public class FieldConvertException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8882794736698350084L;

	public FieldConvertException() {
		super();
	}
	
	public FieldConvertException(String message) {
		super(message);

	}
	
	public FieldConvertException(String message, Throwable cause) {
		super(message, cause);
	}

	public FieldConvertException(Throwable cause) {
		super(cause);
	}

}
