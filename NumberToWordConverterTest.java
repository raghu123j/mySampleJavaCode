package com.raghu.java.intv.pgms.test;

import org.junit.Test;

import com.raghu.java.intv.pgms.NumberToWordConverter;

import junit.framework.Assert;

public class NumberToWordConverterTest {

	
	@Test
	public void testResults() throws Exception {
		Assert.assertEquals("Zero Success","Zero", NumberToWordConverter.getConverter().convert(0));
		Assert.assertEquals(" Success"," nine million  one thousand ", NumberToWordConverter.getConverter().convert(9001000));
		Assert.assertEquals(" Success"," one hundred twenty three million  four hundred fifty six thousand  seven hundred eighty nine", NumberToWordConverter.getConverter().convert(123456789));
		Assert.assertEquals(" Success"," one hundred million  seven hundred forty eight thousand  three hundred sixty four", NumberToWordConverter.getConverter().convert(1007483647));
		Assert.assertEquals(" Success"," three hundred million  one", NumberToWordConverter.getConverter().convert(300000001));
	
	}
	
	@Test
	public void testPositive1() throws Exception {
	
		Assert.assertEquals(" Success"," nine million  one thousand ", NumberToWordConverter.getConverter().convert(9001000));
		
	}
		

}
