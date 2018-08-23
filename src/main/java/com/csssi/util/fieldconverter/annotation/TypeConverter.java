package com.csssi.util.fieldconverter.annotation;

public interface TypeConverter<S,T> {
	
	 T convertToTgt(S src);
	
	 S convertToSrc(T tgt);

}
