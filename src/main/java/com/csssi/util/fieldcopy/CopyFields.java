package com.csssi.util.fieldcopy;

import com.csssi.util.fieldcopy.adapter.AbstractFieldAdapter;
import com.csssi.util.fieldcopy.adapter.FieldsCopyException;

public interface CopyFields {
	
	<T> T convert(Object src, Class<T> tgtClazz) throws FieldsCopyException;

	void setFieldAdapter(AbstractFieldAdapter adapter);

}
