package cy.study.util.fieldscopy;

import cy.study.util.fieldscopy.adapter.AbstractFieldAdapter;
import cy.study.util.fieldscopy.adapter.FieldsCopyException;

public interface CopyFields {
	
	<T> T convert(Object src, Class<T> tgtClazz) throws FieldsCopyException;

	void setFieldAdapter(AbstractFieldAdapter adapter);

}
