 package cy.study.util.fieldscopy.matcher;


public interface FieldMatcher {
	
	boolean nameMatch(String src,String tgt);
	
	boolean typeMatch(Class<?> src , Class<?> tgt);

}
