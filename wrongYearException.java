// ----------------------------------------------------- 
//Assignment 4
// Part: 1
// Written by: Joseph Rady Dimitri 40133609 
// ----------------------------------------------------- 

/**
 * wrong year exception which is thrown to detect wrong years and write to a txt file if needed.
 */
package a4_249;

import java.io.*;

public class wrongYearException extends Exception {
	
	private static PrintWriter printWriterObject;

	wrongYearException(Book b){
		try {
			printWriterObject = new PrintWriter(new FileOutputStream("YearErr.txt",true));
		} 
		
		
		catch (FileNotFoundException e) {
			 File yearerrorfile = new File("YearErr.txt");
			 try {
				yearerrorfile.createNewFile();
				printWriterObject.println(b);
				printWriterObject.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		
		
		printWriterObject.println(b);
		printWriterObject.close();
		
	}
}
