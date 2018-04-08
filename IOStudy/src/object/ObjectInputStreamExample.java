package object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

public class ObjectInputStreamExample {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String path = "sample6.ser";
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		
		System.out.println(ois.readObject());
		System.out.println(ois.readObject());
		System.out.println(ois.readObject());
		
		ois.close();
	}
}
