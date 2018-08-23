package com.csssi.util.fieldcopy.mapper;

import java.lang.reflect.Field;

import com.csssi.util.fieldcopy.annotation.TypeConverter;

public interface FieldMapper {

	<S, T> TypeConverter<S, T> getTypeConverter(Field field);

	String getMappedName(Field field);
	
	
}
