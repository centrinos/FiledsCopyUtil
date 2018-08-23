package cy.study.util.fieldscopy.annotation;

public interface TypeConverter<S,T> {
	
	 T convertToTgt(S src);
	
	 S convertToSrc(T tgt);

}
