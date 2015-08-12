package register;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ListRegister implements Register,Iterable<Person>, Serializable {

	private List<Person> persons = new ArrayList<Person>();
	
	
	@Override
	public Iterator<Person> iterator() {
		// TODO Auto-generated method stub
		return persons.iterator();		
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return persons.size();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return persons.size();
	}

	@Override
	public Person getPerson(int index) {
		// TODO Auto-generated method stub
		return persons.get(index);
	}
	
	@Override
	public void setPerson(Person person, int a) {
		persons.set(a, person);
	}

	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		persons.add(person);
	}

	@Override
	public Person findPersonByName(String name) throws Exception {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < persons.size(); i++){
		    if(name.equals(persons.get(i).getName())){
		    	return persons.get(i);
		    }
		}
		throw new Exception("Person with this name NOT FOUND!!");
	}

	@Override
	public Person findPersonByPhoneNumber(String phoneNumber) throws Exception {
		for(int i = 0; i < persons.size(); i++){
		    if(phoneNumber.equals(persons.get(i).getPhoneNumber())){
		    	return persons.get(i);
		    }
		}
		throw new Exception("Person with this phone number NOT FOUND!!");
	}
	

	@Override
	public void removePerson(Person person) {
		// TODO Auto-generated method stub
		for(int i = 0; i < persons.size(); i++){
			if(person.equals(persons.get(i))){
				persons.remove(i);
			}
		}
	}



}
