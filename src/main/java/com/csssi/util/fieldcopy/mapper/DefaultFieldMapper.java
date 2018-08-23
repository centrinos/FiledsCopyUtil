package com.csssi.util.fieldcopy.mapper;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csssi.util.fieldcopy.annotation.Convert;
import com.csssi.util.fieldcopy.annotation.Mapper;
import com.csssi.util.fieldcopy.annotation.TypeConverter;

public class DefaultFieldMapper implements FieldMapper {

	private static final Logger logger = LoggerFactory.getLogger(DefaultFieldMapper.class);

	@Override
	public String getMappedName(Field field) {
		Mapper mapper = field.getDeclaredAnnotation(Mapper.class);
		if (mapper == null) {
			return null;
		}
		return mapper.mapped();
	}

	@SuppressWarnings("unchecked")
	public <S, T> TypeConverter<S, T> getTypeConverter(Field field) {
		TypeConverter<S, T> converter = null;
		Convert convert = field.getDeclaredAnnotation(Convert.class);
		if (convert == null) {
			return null;
		}
		String className = convert.converterName();
		if (!className.equals("")) {
			Object o = null;
			try {
				o = Class.forName(className).newInstance();
				if (o instanceof TypeConverter) {
					converter = (TypeConverter<S, T>) o;
				}
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				logger.error(e.toString());
			}
		}
		if (converter == null) {
			Class<?> clazz = convert.converterClass();
			if (TypeConverter.class.isAssignableFrom(clazz)) {
				try {
					converter = (TypeConverter<S, T>) clazz.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					logger.error(e.toString());
				}
			}
		}
		return converter;
	}

}
