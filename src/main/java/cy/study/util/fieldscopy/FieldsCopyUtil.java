package cy.study.util.fieldscopy;

import cy.study.util.fieldscopy.adapter.AbstractFieldAdapter;

public class FieldsCopyUtil extends AbstractCopyUtil {

	@Override
	public void setFieldAdapter(AbstractFieldAdapter adapter) {
		super.adapter= adapter;
	}

}
