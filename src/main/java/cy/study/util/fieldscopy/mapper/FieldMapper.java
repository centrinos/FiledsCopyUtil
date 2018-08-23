package cy.study.util.fieldscopy.mapper;

import java.lang.reflect.Field;

import cy.study.util.fieldscopy.annotation.TypeConverter;

public interface FieldMapper {

	<S, T> TypeConverter<S, T> getTypeConverter(Field field);

	String getMappedName(Field field);
	
	
}
