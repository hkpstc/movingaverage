package mainservice;

public class ArrayUtil {
	public static double[] getsubArray_5(double[] array) {
		double[] returnarray = new double[5];
		for (int i = 0; i < array.length - 4; i++) {
			returnarray[0] = array[i];
			returnarray[1] = array[i + 1];
			returnarray[2] = array[i + 2];
			returnarray[3] = array[i + 3];
			returnarray[4] = array[i + 4];
		}
		return returnarray;

	}

	public static double[] splitStringToDoubleArray(String number_comma_string) {
		String[] stringArray = number_comma_string.split(",");
		double[] numberArray = new double[stringArray.length];
		for (int i = 0; i < numberArray.length; i++) {
			numberArray[i] = Double.parseDouble(stringArray[i]);
		}
		return numberArray;
	}
}
