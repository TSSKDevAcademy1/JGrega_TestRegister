package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import static org.junit.Assert.*;

import org.junit.Test;

import register.Person;
import register.Register;
import register.ArrayRegister;

public class TestPerson {

	private Person person;
	private Register register = new ArrayRegister(20);
	int countPersons = 0;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test // test pre validitu cisla
	public void validNumber() {
		person = new Person("Janko", "123654789");
		String phoneNumber = "123654789";
		person.setPhoneNumber(phoneNumber);
		if (person.getPhoneNumber().equals(phoneNumber))
			assertEquals(person.getPhoneNumber(), phoneNumber);
		else {
			assertNotSame(person.getPhoneNumber(), phoneNumber);			
		}

	}
	
	@Test
	public void PersonAdd(){ //  test pre pridanie osoby na zaklade velkosit pola 
		//person = new Person("Michal", "4654");
		register.addPerson(new Person("Michal", "4654"));
		countPersons = register.getCount();
		for(int i = 0; i < 5; i++){
			register.addPerson(new Person("Michal", "4654"));
			countPersons++;
		}		
		assertEquals(countPersons,register.getCount());
	}

}
