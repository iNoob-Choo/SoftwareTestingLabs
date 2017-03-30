package my.edu.utar.test;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import my.edu.utar.program.VariousMethodClass;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class VariousMethodsClassTest {
	
	@Test
	@Parameters({"The dog is a very funny dog if it is here, dog, 2",
			"I like cats very much, dog, 0",
			"UTAR is better than UTAR or UTAR, UTAR, 3"})
	public void paramTestCountWordInStringV1(String words, String strFind, int expectedResult) {
		VariousMethodClass vmc = new VariousMethodClass();
		int result = vmc.countWordInString(words, strFind);
		assertEquals(expectedResult, result);
	}
	
	@SuppressWarnings("unused")
	private Object[] getParamsForTestCountWordInString() {
		
		return new Object[] {
			new Object[] {"The dog is a very funny dog if it is here", "dog", 2},
			new Object[] {"I like cats very much", "dog", 0},
			new Object[] {"UTAR is better than UTAR or UTAR", "UTAR", 3}
		};
	}
	
	@Test
	@Parameters(method = "getParamsForTestCountWordInString")	
	public void paramTestCountWordInStringV2(String words, String strFind, int expectedResult) {
		VariousMethodClass vmc = new VariousMethodClass();
		int result = vmc.countWordInString(words, strFind);
		assertEquals(expectedResult, result);
	}	

	
	
	@Test
	@Parameters({"dog elephant cat mouse horse, 4, elephant mouse horse",
			"large boat floating nearby, 2, large boat floating nearby",
			"dog elephant cat mouse horse,10,"})
	public void paramTestCombineStringsV1(String words, int x, String expectedResult) {
		VariousMethodClass vmc = new VariousMethodClass();
		String result = vmc.combineStrings(words, x);
		assertEquals(expectedResult, result);
	}
	
	@SuppressWarnings("unused")
	private Object[] getParamsForTestCombineStrings() {
		
		return new Object[] {
			new Object[] {"dog elephant cat mouse horse", 4, "elephant mouse horse"},
			new Object[] {"large boat floating nearby", 2, "large boat floating nearby"},
			new Object[] {"dog elephant cat mouse horse", 10, ""}
		};
	}
	
	@Test
	@Parameters(method = "getParamsForTestCombineStrings")
	public void paramTestCombineStringsV2(String words, int x, String expectedResult) {
		VariousMethodClass vmc = new VariousMethodClass();
		String result = vmc.combineStrings(words, x);
		assertEquals(expectedResult, result);
	}
	
	
	@SuppressWarnings("unused")
	private Object[] getParamsForTestFindLargestNumberInArray() {
		
		return new Object[] {
			new Object[] {new int[]{10, 100, 3, 5, 30}, 100},
			new Object[] {new int[]{-20, -100, -40, -20}, -20},
			new Object[] {new int[]{5}, 5}
		};
	}
	
	@Test
	@Parameters(method = "getParamsForTestFindLargestNumberInArray")	
	public void paramTestFindLargestNumberInArrayV2(int[] numArray, int expectedResult) {
		VariousMethodClass vmc = new VariousMethodClass();
		int result = vmc.findLargestNumberInArray(numArray);
		assertEquals(expectedResult, result);
	}	

	
	@SuppressWarnings("unused")
	private Object[] getParamsForTestAverageStringLength() {

		return new Object[] {
			new Object[] {new String[]{"cats", "12", "dog", "45", "rat"}, 2, 3.33, 0.005},
			new Object[] {new String[]{"pet", "house", "mouse", "sky", "floss"}, 4, 5.0, 0},
			new Object[] {new String[]{"stuff", "cars", "jelly"}, 10, 0, 0}
		};
	}
	
	@Test
	@Parameters(method = "getParamsForTestAverageStringLength")	
	public void paramTestAverageStringLengthV2(String[] strArray, int x, double expectedResult, double delta) {
		VariousMethodClass vmc = new VariousMethodClass();
		double result = vmc.averageStringLength(strArray, x);
		assertEquals(expectedResult, result, delta);
	}	
	

}	


