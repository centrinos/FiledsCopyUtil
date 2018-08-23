package com.csssi.util.fieldcopy.adapter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csssi.util.fieldcopy.annotation.TypeConverter;
import com.csssi.util.fieldcopy.mapper.DefaultFieldMapper;
import com.csssi.util.fieldcopy.matcher.DefaultFieldMatcher;

public class ReverseFieldAdapter extends AbstractFieldAdapter {

	private static final Logger logger = LoggerFactory.getLogger(ReverseFieldAdapter.class);
	
	public ReverseFieldAdapter() {
		super.fieldMatcher = new DefaultFieldMatcher();
		super.fieldMapper = new DefaultFieldMapper();
	}

	@Override
	public boolean doConvert(Field srcField, Field tgtField, Object src, Object tgt) throws FieldsCopyException {

		String name = fieldMapper.getMappedName(srcField);
		if (name == null) {
			name = srcField.getName();
		}
		if (fieldMatcher.nameMatch(tgtField.getName(), name)
				&& fieldMatcher.typeMatch(srcField.getType(), tgtField.getType())) {
			logger.info("convert directly");
			try {
				tgtField.set(tgt, srcField.get(src));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				logger.error(e.toString());
				throw new FieldsCopyException(e.toString());
			}
			return true;
		}
		@SuppressWarnings("rawtypes")
		TypeConverter converter = fieldMapper.getTypeConverter(srcField);
		if (converter != null && fieldMatcher.nameMatch(tgtField.getName(), name)) {
			logger.info("convert by converter");
			Method[] methods = converter.getClass().getMethods();
			for (int i = 0; i < methods.length; ++i) {
				Class<?>[] params = methods[i].getParameterTypes();
				if (methods[i].getReturnType() == tgtField.getType() && params.length == 1 && params[0] == srcField.getType()) {
					try {
						tgtField.set(tgt, methods[i].invoke(converter, srcField.get(src)));
					} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
						logger.error(e.toString());
						throw new FieldsCopyException(e.toString());
					}	
					return true;
				}
			}
		}
		logger.info("no field related");
		return false;
	}

}
