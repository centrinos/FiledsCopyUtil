package com.csssi.util.fieldcopy.adapter;

import java.lang.reflect.Field;

import com.csssi.util.fieldcopy.mapper.FieldMapper;
import com.csssi.util.fieldcopy.matcher.FieldMatcher;

public abstract class AbstractFieldAdapter {
	
	protected FieldMatcher fieldMatcher;
	
	protected FieldMapper fieldMapper;

	abstract public boolean doConvert(Field srcField, Field tgtField ,Object src,Object tgt) throws FieldsCopyException;
	
}
