package LabA;

public class FindLargestNumberProgram {
	// method functionality:
	// Given an integer array, find the largest number
	// contained in that array
	public int findLargestNumberInArray(int[] numArray) {
	int bigNum = numArray[0];
	for (int i = 0; i < numArray.length; i++)
		if (bigNum < numArray[i])
			bigNum = numArray[i];
			return bigNum;
		}
	}
