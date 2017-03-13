package LabATest;

import LabA.*;
import static org.junit.Assert.*;
import org.junit.*;

public class ProgramTests {
	
	@Test
	public void testCombineStringProgram(){
		CombineStringProgram object=new CombineStringProgram();
		String combinedwords=object.combineStrings("Hello World, i am Mr.X. Testing this function", 4);
		//correct testing answer
		assertEquals("Hello World, Mr.X. Testing function",combinedwords);
	}
	
	@Test
	public void testCountStringProgram(){
		CountStringProgram object=new CountStringProgram();
		String TestingSentence="Hello World!,how are you?";
		String WordToFind="o";
		int times_that_the_word_occur=object.countWordInString(TestingSentence, WordToFind);
		assertEquals(4,times_that_the_word_occur);
	}
	
	@Test
	public void testFindLargestNumber(){
		FindLargestNumberProgram object=new FindLargestNumberProgram();
		int[] integerArray={1,2,3,4,5,6,7,8,9};
		int biggest_number=object.findLargestNumberInArray(integerArray);
		assertEquals(9,biggest_number);
		
	}

}
