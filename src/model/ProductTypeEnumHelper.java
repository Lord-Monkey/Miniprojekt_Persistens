package model;
/**
 * Helper class for creating {@link ProductTypeEnum} values from strings.
 * 
 * @author Mathias
 * @version 11-3-2026
 */
public class ProductTypeEnumHelper {

	public ProductTypeEnum buildEnum(String enumString) {
		ProductTypeEnum ptEnum = ProductTypeEnum.NOTSET;
		if(enumString != null) {
			String upperEnumString = enumString.toUpperCase();
			try {
				ptEnum = ProductTypeEnum.valueOf(upperEnumString);
			} catch (IllegalArgumentException e) {
				ptEnum = ProductTypeEnum.NOTSET;
			}
		}
		return ptEnum;
	}
}
