 package com.csssi.util.fieldconverter.matcher;


public interface FieldMatcher {
	
	boolean nameMatch(String src,String tgt);
	
	boolean typeMatch(Class<?> src , Class<?> tgt);

}
