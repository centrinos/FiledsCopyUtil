package cy.study.util.fieldscopy;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import cy.study.util.fieldscopy.adapter.AbstractFieldAdapter;
import cy.study.util.fieldscopy.adapter.DefaultFieldAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cy.study.util.fieldscopy.adapter.FieldsCopyException;

public abstract class AbstractCopyUtil implements CopyFields {

	private static final Logger logger = LoggerFactory.getLogger(AbstractCopyUtil.class);

	protected AbstractFieldAdapter adapter = new DefaultFieldAdapter();

	public <T> T convert(Object src, Class<T> tgtClazz) throws FieldsCopyException {
		T retVal = null;	
			try {
				retVal = tgtClazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				throw new FieldsCopyException(e.toString());
			}
		doConverts(src, retVal, tgtClazz);
		return retVal;
	}

	protected void doConverts(Object src, Object tgt, Class<?> tgtClazz) throws FieldsCopyException {
		Class<? extends Object> srcClszz = src.getClass();
		Field[] tgtFields = tgtClazz.getDeclaredFields();
		List<Field> srcFields = Arrays.asList(srcClszz.getDeclaredFields());
		for (int i = 0; i < tgtFields.length; i++) {
			Field tgtField = tgtFields[i];
			if(Modifier.isFinal(tgtField.getModifiers())) {
				logger.info("exclude final field in tgt: " + tgtField.getName());
				continue;
			}	
			logger.info("target: " + tgtField.getName());
			tgtField.setAccessible(true);
			for (int j = 0; j < srcFields.size(); j++) {
				Field srcField = srcFields.get(j);
				if(Modifier.isFinal(srcField.getModifiers())) {
					logger.info("exclude final field in src: " + srcField.getName());
					continue;
				}
				logger.info("src: " + srcField.getName());
				srcField.setAccessible(true);
				if(adapter.doConvert(srcField, tgtField, src, tgt)) {
					logger.info("target: " + tgtField.getName() + " convert successfully");
					break;	
				} else {
					logger.info("target: " + tgtField.getName() + " convert failed");
				}	
			}
		}
	}

}
