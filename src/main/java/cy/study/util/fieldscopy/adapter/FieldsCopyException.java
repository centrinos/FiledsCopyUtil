package cy.study.util.fieldscopy.adapter;

public class FieldsCopyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8882794736698350084L;

	public FieldsCopyException() {
		super();
	}
	
	public FieldsCopyException(String message) {
		super(message);

	}
	
	public FieldsCopyException(String message, Throwable cause) {
		super(message, cause);
	}

	public FieldsCopyException(Throwable cause) {
		super(cause);
	}

}
