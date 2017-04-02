package my.edu.utar;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import my.edu.utar.DummyWork;
import my.edu.utar.NewWorkingWithStrings;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class NewWorkingWithStringsTest {
	
	@Test
	public void testCheckStringLength() {
	
		String [] strArray = {"cat", "houses", "dog", "elephant", "rat"};
		
		DummyWork dw = new DummyWork();
		NewWorkingWithStrings nww2 = new NewWorkingWithStrings(dw);
		nww2.checkStringLength(strArray, 4);
		
		String [] results = dw.getStrList();
		String [] expectedResults = {"houses", "elephant"};
		assertArrayEquals(expectedResults, results);
	}		
	
	private Object[] getParamsForTestCheckStringLengthV2() {

		return new Object[] {
			new Object[] {new String[]{"cat", "houses", "dog", "elephant", "rat"}, 4, new String[]{"houses", "elephant"}},
			new Object[] {new String[]{"11", "Peter", "22"}, 3, new String[] {"Peter"}},
			new Object[] {new String[]{"11", "22"}, 10, new String[] {}}
		};
	}
	
	
	@Test
	@Parameters(method = "getParamsForTestCheckStringLengthV2")	
	public void testCheckStringLengthV2(String[] strArray, int strLimit, String[] expectedResults) {
		
		DummyWork dw = new DummyWork();
		NewWorkingWithStrings nww2 = new NewWorkingWithStrings(dw);
		
		nww2.checkStringLength(strArray, strLimit);
		String [] results = dw.getStrList();
		assertArrayEquals(expectedResults, results);
	}		

}
