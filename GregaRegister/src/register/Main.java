package register;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

	// @SuppressWarnings("null")
	public static void main(String[] args) throws Exception {
		ArrayRegister register = null;

		ConsoleUI ui = new ConsoleUI(register);

		ui.run();
	}
}
