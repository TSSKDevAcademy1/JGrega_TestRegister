package register;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * User interface of the application.
 */
public class ConsoleUI {
	/** register.Register of persons. */
	private ArrayRegister register;

	// private RegisterLoader registerLoader = new FileRegisterLoader();
	private RegisterLoader registerLoader = new DatabaseRegisterLoader();
	/**
	 * In JDK 6 use Console class instead.
	 * 
	 * @see readLine()
	 */
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Menu options.
	 */
	private enum Option {
		PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
	};

	public ConsoleUI(final ArrayRegister register) {
		this.register = register;

		System.out.println("Tu som dosiele");
		this.register = registerLoader.load(); // nacita hodnoty zo suboru

	}

	public void run() {

		while (true) {
			switch (showMenu()) {
			case PRINT:
				printRegister();
				break;
			case ADD:
				addToRegister();
				break;
			case UPDATE:
				updateRegister();
				break;
			case REMOVE:
				removeFromRegister();
				break;
			case FIND:
				findInRegister();
				break;
			case EXIT:
				registerLoader.save(register);
				return;
			}
		}
	}

	private String readLine() {

		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	private Option showMenu() {
		System.out.println("Menu.");
		for (Option option : Option.values()) {
			System.out.printf("%d. %s%n", option.ordinal() + 1, option);
		}
		System.out.println("-----------------------------------------------");

		int selection = -1;
		do {
			System.out.println("Option: ");
			selection = Integer.parseInt(readLine());
		} while (selection <= 0 || selection > Option.values().length);

		return Option.values()[selection - 1];
	}

	// Metoda sluziaca pre kompletne vypisanie registra osob
	private void printRegister() {

		for (int i = 0; i < register.getSize(); i++) {
			if (register.getPerson(i) != null) // Ak prvok pola je nenulovy
				System.out.println(i + 1 + ". " + register.getPerson(i));
		}
	}	
	
	private void addToRegister() {
		boolean helper = false;
		System.out.println("Enter Name: ");
		String name = readLine();
		System.out.println("Enter Phone Number: ");
		String phoneNumber = readLine();
		for(int i = 0; i < register.getCount(); i++){ //  kontrola ci zadane meno/cislo sa uz nenachadza v registri
			helper = ((register.getPerson(i).getName().equals(name) || register.getPerson(i).getPhoneNumber().equals(phoneNumber))
						?  true : false);			
		}
		if(!helper){
		register.addPerson(new Person(name, phoneNumber));	
		}else{
			System.out.println("Zadane Meno/Cislo sa uz v registri nachadza!!!");			
		}
	}

	private void updateRegister() {

		System.out.println("Enter item which you want to change:");
		String item = readLine();
		int itemNum = Integer.parseInt(item);
		System.out.println("Enter new name of person:");
		String nameReplace = readLine();
		System.out.println("Enter new number of person:");
		String numberReplace = readLine();
		register.setPerson(new Person(nameReplace, numberReplace), (itemNum - 1));
	}

	// TODO: Implement the method findInRegister
	private void findInRegister() {

		System.out.println("(1. Find by name 2. Find by phoneNumber)Enter your choice:");
		int choice = Integer.parseInt(readLine());
		switch(choice){
		case 1:
			System.out.println("Enter name of person:");
			String nameFind = readLine();
			String elementStr = register.findPersonByName(nameFind).toString();
			System.out.println(elementStr);
			break;
		case 2:
			System.out.println("Enter phoneNumber of person:");
			String numberFind = readLine();			
			Person foundPerson = register.findPersonByPhoneNumber(numberFind);
			System.out.println(foundPerson);
			break;
		default:
			System.out.println("This choice is not supported");
		}
	}

	private void removeFromRegister() {
		System.out.println("Enter index: ");
		int index = Integer.parseInt(readLine());
		Person person = register.getPerson(index - 1);
		register.removePerson(person);
	}
}
