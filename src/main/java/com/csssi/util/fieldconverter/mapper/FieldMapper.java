package com.csssi.util.fieldconverter.mapper;

import java.lang.reflect.Field;

import com.csssi.util.fieldconverter.annotation.TypeConverter;

public interface FieldMapper {

	<S, T> TypeConverter<S, T> getTypeConverter(Field field);

	String getMappedName(Field field);
	
	
}
