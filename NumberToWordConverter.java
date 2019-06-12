package com.raghu.java.intv.pgms;

import java.text.DecimalFormat;

class UnsupportedConversionException extends Exception {

	public UnsupportedConversionException(String msg) {
		this.message = msg;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UnsupportedConversionException [message=" + message + "]";
	}

}

public class NumberToWordConverter {

	private static NumberToWordConverter converter;
	
	public static NumberToWordConverter getConverter() {
		if(converter==null) {
			converter= new NumberToWordConverter();
		}
		return converter;
	}
	
	private static final String[] tensPlace = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };

	private static final String[] unitsAndTeens = { "", " one", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };;

	private NumberToWordConverter() {

	}

	private String convertingThreePlaces(int number) {
		String soFar;

		if (number % 100 < 20) {
			soFar = unitsAndTeens[number % 100];
			number /= 100;
		} else {
			soFar = unitsAndTeens[number % 10];
			number /= 10;

			soFar = tensPlace[number % 10] + soFar;
			number /= 10;
		}
		if (number == 0)
			return soFar;
		return unitsAndTeens[number] + " hundred" + soFar;
	}

	public String convert(long number) throws UnsupportedConversionException {
		
		
		String result = "Zero";

		if (number < 0) {
			throw new UnsupportedConversionException(
					"The number conversion not supported for negative numbers:" + number);
		} else if (number > 0) {

			String snumber = getStringFromNumber(number);

			// XXXnnnnnn
			int millions = Integer.parseInt(snumber.substring(0, 3));
			// nnnXXXnnn
			int hundredThousands = Integer.parseInt(snumber.substring(3, 6));
			// nnnnnnXXX
			int thousands = Integer.parseInt(snumber.substring(6, 9));

			String britMillions;
			switch (millions) {
			case 0:
				britMillions = "";
				break;
			default:
				britMillions = convertingThreePlaces(millions) + " million ";
			}
			result = britMillions;

			String britHundredThousands;
			switch (hundredThousands) {
			case 0:
				britHundredThousands = "";
				break;
			default:
				britHundredThousands = convertingThreePlaces(hundredThousands) + " thousand ";
			}
			result = result + britHundredThousands;

			String britThousand;
			britThousand = convertingThreePlaces(thousands);
			result = result + britThousand;

		}

		return result;
	}

	private String getStringFromNumber(long number) {
		String snumber = Long.toString(number);

		String mask = "000000000";
		DecimalFormat df = new DecimalFormat(mask);
		snumber = df.format(number);
		return snumber;
	}

	
}
