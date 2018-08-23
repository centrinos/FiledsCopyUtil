package cy.study.util.fieldscopy.adapter;

import java.lang.reflect.Field;

import cy.study.util.fieldscopy.mapper.FieldMapper;
import cy.study.util.fieldscopy.matcher.FieldMatcher;

public abstract class AbstractFieldAdapter {
	
	protected FieldMatcher fieldMatcher;
	
	protected FieldMapper fieldMapper;

	abstract public boolean doConvert(Field srcField, Field tgtField ,Object src,Object tgt) throws FieldsCopyException;
	
}
