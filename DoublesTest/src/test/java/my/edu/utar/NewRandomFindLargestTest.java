
package my.edu.utar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import my.edu.utar.ArrayGeneratorClass;
import my.edu.utar.NewRandomFindLargest;

public class NewRandomFindLargestTest {
	
	@Test
	public void testFindLargestNumberInRandomArrayOriginal() {
		System.out.println("doing test using original random functionality");
		// setup code
		NewRandomFindLargest nr = new NewRandomFindLargest();
		//create an array of length 5, and fill it with random
		// integers between 0 and 8
		int result = nr.findLargestNumberInRandomArray(5, 8);
		assertEquals(7, result);
	}	
	
	@Test
	public void testFindLargestNumberInRandomArrayDummy() {
		System.out.println("\ndoing test using dummy random functionality");
		
		// setup code
		ArrayGeneratorClass dgc = new ArrayGeneratorClass(new int[] {1,2,3,4,5,6,7,8});
		NewRandomFindLargest nr2 = new NewRandomFindLargest(dgc);
		
		//create an array of length 5, and fill it with predetermined
		// numbers from 1 to 8
		int result = nr2.findLargestNumberInRandomArray(5, 8);
		assertEquals(5, result);
	}	
	

}
