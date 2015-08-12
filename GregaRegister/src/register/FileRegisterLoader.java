package register;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileRegisterLoader implements Serializable, RegisterLoader {

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.RegisterLoader#load()
	 */
	@Override
	public ArrayRegister load() {
		FileInputStream in = null;
		try {
			in = new FileInputStream("register.bin");
			// @SuppressWarnings("resource")
			ObjectInputStream s = new ObjectInputStream(in);
			// @SuppressWarnings("unused")
			ArrayRegister register = (ArrayRegister) s.readObject();
			s.close();
			System.out.println("zbehlo");
			return register;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			ArrayRegister register = new ArrayRegister(20); // create array
			register.addPerson(new Person("Janko Hrasko", "0900123456"));
			e.printStackTrace();
			return register;
		}
	}

	/////////////////////////////// FUNKCIA PRE ULOZENIE UDAJOV PO EXITE
	/////////////////////////////// ////////////////////////////
	/*
	 * (non-Javadoc)
	 * 
	 * @see register.RegisterLoader#save(register.Register)
	 */
	@Override
	public void save(Register register) {
		try {
			FileOutputStream out = new FileOutputStream("register.bin");
			ObjectOutputStream s = new ObjectOutputStream(out);
			s.writeObject(register);
			s.close();
			System.out.println("Ulozenie sa podarilo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}