package com.csssi.util.fieldconverter;

import com.csssi.util.fieldconverter.adapter.AbstractFieldAdapter;
import com.csssi.util.fieldconverter.adapter.FieldConvertException;

public interface ConvertFields {
	
	<T> T convert(Object src, Class<T> tgtClazz) throws FieldConvertException;

	void setFieldAdapter(AbstractFieldAdapter adapter);

}
