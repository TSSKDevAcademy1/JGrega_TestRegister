package register;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * register.Person register.
 */
public class ArrayRegister implements Serializable, Register {
	/** register.Person array. */
	private Person[] persons;

	/** Number of persons in this register. */
	private int count;

	/**
	 * Constructor creates an empty register with maximum size specified.
	 * 
	 * @param size
	 *            maximum size of the register
	 */

	public ArrayRegister(int size) {
		persons = new Person[size];
		count = 0;
	}

	/* (non-Javadoc)
	 * @see register.Register#getCount()
	 */
	@Override
	public int getCount() {
		return count;
	}

	/* (non-Javadoc)
	 * @see register.Register#getSize()
	 */
	@Override
	public int getSize() {
		return persons.length;
	}

	/* (non-Javadoc)
	 * @see register.Register#getPerson(int)
	 */
	@Override
	public Person getPerson(int index) {
		return persons[index];
	}

	/* (non-Javadoc)
	 * @see register.Register#addPerson(register.Person)
	 */
	@Override
	public void addPerson(Person person) {
		persons[count] = person;
		count++;
	}

	void setPerson(Person person, int a) {
		persons[a] = person;
	}

	// TODO: Implement the method findPersonByName
	/* (non-Javadoc)
	 * @see register.Register#findPersonByName(java.lang.String)
	 */
	@Override
	public Person findPersonByName(String name) {

//		int nameLength = name.length();
		String findStr = "";
		int j = 0;
		for (int i = 0; i < persons.length; i++) {
			if (persons[i] != null) {
				findStr = persons[i].getName();
				if (name.equals(findStr)) {
					return persons[i];
				}
			}
		}
		return null;
	}

	// TODO: Implement the method findPersonByPhoneNumber
	/* (non-Javadoc)
	 * @see register.Register#findPersonByPhoneNumber(java.lang.String)
	 */
	@Override
	public Person findPersonByPhoneNumber(String phoneNumber) {
//		int numberLength = phoneNumber.length();
		String findStr = "";

		for (int i = 0; i < persons.length; i++) {
			if (persons[i] != null) {
				findStr = persons[i].getPhoneNumber();				
				if (phoneNumber.equals(findStr)) {
					return persons[i];
				}
			}
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see register.Register#removePerson(register.Person)
	 */
	@Override
	public void removePerson(Person person) {

		for (int i = 0; i < persons.length; i++) {
			if (persons[i] != null) {
				if (persons[i].equals(person)) {
					persons[i] = null;
					count--;
					for (int j = i; j < persons.length - 1; j++) {
						if (persons[j + 1] != null) {
							persons[j] = persons[j + 1];
						} else {
							persons[j] = null;
						}
					}

				} else {

				}
			}
		}

	}
}
