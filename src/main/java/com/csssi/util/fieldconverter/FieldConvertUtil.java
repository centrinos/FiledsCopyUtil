package com.csssi.util.fieldconverter;

import com.csssi.util.fieldconverter.adapter.AbstractFieldAdapter;

public class FieldConvertUtil extends AbstractConvertUtil {

	@Override
	public void setFieldAdapter(AbstractFieldAdapter adapter) {
		super.adapter= adapter;
	}

}
