package my.edu.utar;

import org.junit.Test;
import org.mockito.InOrder;

import my.edu.utar.FileReaderClass;
import my.edu.utar.FileWriterClass;
import my.edu.utar.NewSampleClass;
import my.edu.utar.ReadFunctionality;
import my.edu.utar.SampleClass;
import my.edu.utar.WriteFunctionality;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

public class NewSampleClassTest {
	
	@Test
	public void testSampleMethodMockito() {

		// setup code
		ReadFunctionality rfMock = mock(ReadFunctionality.class);
		WriteFunctionality wfMock = mock(WriteFunctionality.class);		
		InOrder inOrder = inOrder(wfMock);
		
		when(rfMock.getNumberFromFile()).thenReturn(10, 15, 20, 30, 35);	
		
		NewSampleClass nsc = new NewSampleClass(rfMock, wfMock);
		nsc.sampleMethod();
		
		int [] expectedResults = {10, 15, 20, 30, 35};
		for (int i = 0; i < expectedResults.length; i++)
			inOrder.verify(wfMock).writeDataToFile(expectedResults[i]);
	}
	
	@Test
	public void testSampleMethodMockitoWithoutInterface() {

		// setup code
		FileReaderClass rfMock = mock(FileReaderClass.class);
		FileWriterClass wfMock = mock(FileWriterClass.class);		
		InOrder inOrder = inOrder(wfMock);
		
		when(rfMock.getNumberFromFile()).thenReturn(10, 15, 20, 30, 35);	
		
		SampleClass nsc = new SampleClass(rfMock, wfMock);
		nsc.sampleMethod();
		
		int [] expectedResults = {10, 15, 20, 30, 35};
		for (int i = 0; i < expectedResults.length; i++)
			inOrder.verify(wfMock).writeDataToFile(expectedResults[i]);
	}
	

}
