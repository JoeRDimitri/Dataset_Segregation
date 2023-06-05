// ----------------------------------------------------- 
//Assignment 4
// Part: 1
// Written by: Joseph Rady Dimitri 40133609 
// ----------------------------------------------------- 

/**
 * A support class which is used in the creation of the BookLists
 */
package a4_249;

import java.io.*;
import java.util.ArrayList;

public class Support_class {
	
	private ArrayList<Book> goodBooksarr = new ArrayList<Book>(1);
	
	
	public ArrayList<Book> segregateErrorBooks() {
		BufferedReader readerObject = null;
		String nextline = "";
		String[] nextlinearray;
		Book tempbook;
		ArrayList<Book> wrongBooks = new ArrayList<Book>(1);
		try {
			readerObject = new BufferedReader(new FileReader("Books.txt"));
			while(readerObject.read() != -1) {
				nextline = readerObject.readLine();
				nextlinearray = nextline.split(",");
				String title = "\""+nextlinearray[0];
				String author = nextlinearray[1];
				double price = Double.parseDouble(nextlinearray[2]);
				long ISBN = Long.parseLong(nextlinearray[3]);
				String genre = nextlinearray[4];
				int year = Integer.parseInt(nextlinearray[5]);
				
				
				tempbook = new Book(title, author, price, ISBN, genre, year);
				
				if(tempbook.getYear()>=2024)
					try {
						wrongBooks.add(tempbook);
						throw new wrongYearException(tempbook);
					}
				catch (wrongYearException e) {
					continue;
				}
				
				goodBooksarr.add(tempbook);
				
			}
			readerObject.close();
		} 
		catch (IOException e) {
			System.out.println("File Not Found, error caught");
			e.printStackTrace();
		} 
		
		return wrongBooks;
	}
	
	public ArrayList<Book> getGoodBookList() {
		return this.goodBooksarr;
	}
	
	public BookList readBookfile(){

		BookList goodBookList = new BookList();
		if(goodBookList.getHead() == null)
			goodBookList.addToStart(goodBooksarr.get(0));
		
		
		
		return goodBookList;
			
		
		
	}
	
	
	
	
	
}
