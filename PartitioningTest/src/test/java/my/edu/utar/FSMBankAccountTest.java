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
public class FSMBankAccountTest {
	
	@Test
	@Parameters({
		"addMoney,200,present,400", // transition 12
		"withdrawMoney,50,present,150", // transition 13
		"withdrawMoney,200,empty,0", // transition 3
		"withdrawMoney,300,overdrawn,-100", // transition 6
		"withdrawMoney,700,overdraft,-500", // transition 4
		"withdrawMoney,1000,overdraft,-500" // transition 4
	}) 	
	public void testPresentState(AccountEvents eventToDo, int amount, 
			AccountStates expectedState, int expectedBalance) {
		FSMBankAccount fba = new FSMBankAccount(-500, 200,AccountStates.present);
		fba.processEvent(eventToDo, amount);
		assertEquals(expectedState, fba.getCurrentState());
		assertEquals(expectedBalance, fba.getCurrentBalance());
	}
	
	@Test
	@Parameters({
		"withdrawMoney,200,overdraft,-500", // transition 1
		"addMoney,300,overdrawn,-200", // transition 11
		"addMoney,800,present,300" // transition 7
	}) 	
	
	public void testOverdraftState(AccountEvents eventToDo, int amount, 
			AccountStates expectedState, int expectedBalance) {
		FSMBankAccount fba = new FSMBankAccount(-500, -500,AccountStates.overdraft);
		fba.processEvent(eventToDo, amount);
		assertEquals(expectedState, fba.getCurrentState());
		assertEquals(expectedBalance, fba.getCurrentBalance());
	}
	
	@Test
	@Parameters({
		"withdrawMoney,300,overdraft,-500", // transition 2
		"withdrawMoney,900,overdraft,-500", // transition 2
		"withdrawMoney,100,overdrawn,-300", // transition 14
		"addMoney,200,empty,0", // transition 9
		"addMoney,300,present,100" // transition 10
	}) 	
	
	public void testOverdrawnState(AccountEvents eventToDo, int amount, 
			AccountStates expectedState, int expectedBalance) {
		FSMBankAccount fba = new FSMBankAccount(-500, -200, AccountStates.overdrawn);
		fba.processEvent(eventToDo, amount);
		assertEquals(expectedState, fba.getCurrentState());
		assertEquals(expectedBalance, fba.getCurrentBalance());
	}	

	@Test
	@Parameters({
		"withdrawMoney,300,overdrawn,-300", // transition 5
		"addMoney,300,present,300" // transition 8
	}) 	
	
	public void testEmptyState(AccountEvents eventToDo, int amount, 
			AccountStates expectedState, int expectedBalance) {
		FSMBankAccount fba = new FSMBankAccount(-500, 0, AccountStates.empty);
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
