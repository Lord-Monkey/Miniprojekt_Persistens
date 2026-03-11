package model;

public class ProductTypeEnumHelper {

	public ProductTypeEnum buildEnum(String enumString) {
		ProductTypeEnum ptEnum = ProductTypeEnum.NotSet;
		if(enumString != null) {
			String upperEnumString = enumString.toUpperCase();
			try {
				ptEnum = ProductTypeEnum.valueOf(upperEnumString);
			} catch (IllegalArgumentException e) {
				ptEnum = ProductTypeEnum.NotSet;
			}
		}
		return ptEnum;
	}
}
