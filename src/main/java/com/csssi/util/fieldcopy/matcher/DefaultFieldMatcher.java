package com.csssi.util.fieldcopy.matcher;


public class DefaultFieldMatcher implements FieldMatcher {

	@Override
	public boolean nameMatch(String src , String tgt) {
		if(src == null || tgt == null) {
			return false;
		}
		return src.equals(tgt);
	}

	@Override
	public boolean typeMatch(Class<?> src, Class<?> tgt) {
		if(src == null || tgt == null) {
			return false;
		}	
		return src == tgt;
	}

}
