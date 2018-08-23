package com.csssi.util.fieldconverter.adapter;

import java.lang.reflect.Field;

import com.csssi.util.fieldconverter.mapper.FieldMapper;
import com.csssi.util.fieldconverter.matcher.FieldMatcher;

public abstract class AbstractFieldAdapter {
	
	protected FieldMatcher fieldMatcher;
	
	protected FieldMapper fieldMapper;

	abstract public boolean doConvert(Field srcField, Field tgtField ,Object src,Object tgt) throws FieldConvertException;
	
}
