package my.edu.utar;

import org.junit.Test;

import my.edu.utar.DummyReaderClass;
import my.edu.utar.DummyWriterClass;
import my.edu.utar.NewSampleClass;

import static org.junit.Assert.*;

public class NewSampleClassTest {
	
	@Test
	public void testSampleMethod() {
		
		int[] sampleNumbers = {1,2,3,4,5};
		DummyReaderClass drc = new DummyReaderClass(sampleNumbers);
		DummyWriterClass dwc = new DummyWriterClass();
		
		NewSampleClass nsc = new NewSampleClass(drc,dwc);
		nsc.sampleMethod();
		
		int[] results = dwc.getIntList();
		assertArrayEquals(sampleNumbers, results);
	}
}
