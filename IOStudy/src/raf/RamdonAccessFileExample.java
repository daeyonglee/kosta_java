package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RamdonAccessFileExample {
	public static void main(String[] args) throws IOException {
		String path = "raf.dat";
		RandomAccessFile raf = new RandomAccessFile(path, "rw");
		System.out.println(raf.length());
		
		int age = 40;
		double weight = 78.34;
		char gender = '≥≤';
		String profile = "»…πŸ»…πŸ √„¿ª √‰¥œ¥Ÿ.";
		
		System.out.println(raf.getFilePointer());
		raf.writeInt(age);
		System.out.println(raf.getFilePointer());
		raf.writeDouble(weight);
		System.out.println(raf.getFilePointer());
		raf.writeChar(gender);
		System.out.println(raf.getFilePointer());
		raf.writeUTF(profile);
		System.out.println(raf.getFilePointer());
		
		raf.seek(0);
		
		System.out.println(raf.readInt());
		
		raf.close();
	}
}
