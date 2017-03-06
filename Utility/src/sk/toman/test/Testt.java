package sk.toman.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Testt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("A1");
		File f = new File("asdfsa");
		try {
			//System.out.println("A2");
			FileInputStream fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--- "+ e);
			
		}
		
		System.out.println("A3");

	}

}
