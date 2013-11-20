package common;

public class FormatConvertUtil {
	public static Double ifNullValueChangeZero(Double doubleInput) {
		if (doubleInput == null) {
			doubleInput = 0.0;
		}
		return doubleInput;
	}

	public static String doubleToString(Double doubleValue) {
		String stringValue = null;
		if (doubleValue != null) {
			stringValue = doubleValue.toString();
		}
		return stringValue; 
	}
}
