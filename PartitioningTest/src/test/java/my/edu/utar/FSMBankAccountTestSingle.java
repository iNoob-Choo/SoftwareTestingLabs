package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import my.edu.utar.AccountEvents;
import my.edu.utar.AccountStates;
import my.edu.utar.FSMBankAccount;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FSMBankAccountTestSingle {

	@Test
	@Parameters({
		"200,present,addMoney,200,present,400", // transition 12
		"200,present,withdrawMoney,50,present,150", // transition 13
		"200,present,withdrawMoney,200,empty,0", // transition 3
		"200,present,withdrawMoney,300,overdrawn,-100", // transition 6
		"200,present,withdrawMoney,700,overdraft,-500", // transition 4
		"200,present,withdrawMoney,1000,overdraft,-500", // transition 4
		
		"-500,overdraft,withdrawMoney,200,overdraft,-500", // transition 1
		"-500,overdraft,addMoney,300,overdrawn,-200", // transition 11
		"-500,overdraft,addMoney,800,present,300", // transition 7
		
		"-200,overdrawn,withdrawMoney,300,overdraft,-500", // transition 2
		"-200,overdrawn,withdrawMoney,900,overdraft,-500", // transition 2
		"-200,overdrawn,withdrawMoney,100,overdrawn,-300", // transition 14
		"-200,overdrawn,addMoney,200,empty,0", // transition 9
		"-200,overdrawn,addMoney,300,present,100", // transition 10
		
		"0,empty,withdrawMoney,300,overdrawn,-300", // transition 5
		"0,empty,addMoney,300,present,300" // transition 8
	}) 	
	
	public void testAllEvents(int currentBalance, 
			AccountStates currentState, AccountEvents eventToDo, int amount,
			AccountStates expectedState, int expectedBalance) {
			
		FSMBankAccount fba = new FSMBankAccount(-500, currentBalance, currentState);
		fba.processEvent(eventToDo, amount);
		assertEquals(expectedState, fba.getCurrentState());
		assertEquals(expectedBalance, fba.getCurrentBalance());		
	}
	
	
	@Test(expected=IllegalArgumentException.class)	
	@Parameters({
		"-500,0,empty,withdrawMoney,500", // transition from empty to overdraft
		"-500,-500,overdraft,addMoney,500" // transition from overdraft to empty
	}) 	
	
	public void testIllegalEvents(int overdraftLimit, int currentBalance, 
			AccountStates currentState, AccountEvents eventToDo, int amount) {
		FSMBankAccount fba = new FSMBankAccount(overdraftLimit, currentBalance, currentState);
		fba.processEvent(eventToDo, amount);
	}
}
