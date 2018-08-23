package com.csssi.util.fieldcopy;

import com.csssi.util.fieldcopy.adapter.AbstractFieldAdapter;

public class FieldsCopyUtil extends AbstractCopyUtil {

	@Override
	public void setFieldAdapter(AbstractFieldAdapter adapter) {
		super.adapter= adapter;
	}

}
