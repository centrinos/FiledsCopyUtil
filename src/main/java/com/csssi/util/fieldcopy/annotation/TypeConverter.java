package com.csssi.util.fieldcopy.annotation;

public interface TypeConverter<S,T> {
	
	 T convertToTgt(S src);
	
	 S convertToSrc(T tgt);

}
