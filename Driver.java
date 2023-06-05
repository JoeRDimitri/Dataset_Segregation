// ----------------------------------------------------- 
//Assignment 4
// Part: 1
// Written by: Joseph Rady Dimitri 40133609 
// ----------------------------------------------------- 

/**
 * The main drive which has ui and utilises the methodes from the BookList class
 */
package a4_249;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		ArrayList<Book>arrLst = new ArrayList<Book>(1);
		ArrayList<Book>temparrLst = new ArrayList<Book>(1);
		ArrayList<Book>tempbkarrLst = new ArrayList<Book>(1);
		BookList bkLst = new BookList();
		Support_class supportObject = new Support_class();
		
		
		// Here I create my arrLst of incorrect and copy the elemnts onto a proper array
		temparrLst = supportObject.segregateErrorBooks();
		for(Book b : temparrLst)
			arrLst.add(b);

		
		//first I make and arraylist of the correct books and then add them to the BookList
		temparrLst = supportObject.getGoodBookList();

		for(Book b : temparrLst)
			tempbkarrLst.add(b);
		


		for(int i = tempbkarrLst.size()-1; i >=0;i--)
			bkLst.addToStart(tempbkarrLst.get(i));


		bkLst.displayContent();
		
		int n;
		do {
		System.out.println("1) Give me a year # and I would extract all records of that year and store them in a file for that year: "
				+ "\n2) Ask me to delete all consecutive repeated records:"
				+ "\n3) Give me an AUTHOR name and I will create a new list with the records of this author and display them: "
				+ "\n4) Give me an ISBN number and a Book object, and I will insert Node with the book before the record with this ISBN:"
				+ "\n5) Give me 2 ISBN numbers and a Book object, and I will insrt a Node between them, if I find them:"
				+ "\n6) Give me 2 ISBN numbers and I will swap them in the list for rearrangement of records: of cours if they exist:"
				+ "\n7) Tell me to COMMIT! Your command is my wish. I will commit your list to a file called Updated_Books:"
				+ "\n8) Tell me to STOP TALKING. Remember, if you do not commit, I will not.");
			
		n = keyboard.nextInt();
		
	
	
	switch(n) {
	case 1: System.out.println("What YEAR would you like to me to store the records of?: ");
	int year = keyboard.nextInt();
	bkLst.storeRecordsByYear(year);
	break;
	
	case 2: bkLst.delConsecutiveRepeatedRecords();
	System.out.println("I've deleted the pesky consecutive records for you, here's what the bkLst looks like: ");
	bkLst.displayContent();
	break;
	
	case 3: System.out.println("What AUTHOR records shall we look at this time?: ");
	String junk = keyboard.nextLine();
	String authorname = keyboard.nextLine();
	BookList authorbooklist = bkLst.extractAuthList(authorname);
	authorbooklist.displayContent();
	break;
	case 4: System.out.print("Let's start by creating a book object:"
			+ "\nWe'll start with a TITLE:");
		String nottitle = keyboard.nextLine();
		String title = keyboard.nextLine();

		System.out.print("Now we need the name of the AUTHOR:");
		String author = keyboard.nextLine();

		System.out.print("Now, please enter the PRICE: ");
		double price = keyboard.nextDouble();

		System.out.print("We will also need the ISBN number: ");
		long isbn = keyboard.nextLong();

		System.out.print("The GENRE please: ");
		String notgenre = keyboard.nextLine();
		String genre = keyboard.nextLine();

		System.out.print("Finally, the YEAR: ");
		int yearx = keyboard.nextInt();


	Book book1 = new Book(title, author, price, isbn, genre, yearx);


		System.out.println("Next I will need the ISBN number of the book you wish to insert it before: ");
	long isbn1 = keyboard.nextLong();
	bkLst.insertBefore(isbn1, book1);
	
	bkLst.displayContent();
	break;
	
	case 5: System.out.print("Let's start by creating a book object:"
			+ "\nWe'll start with a TITLE:");
		String nottitlex = keyboard.nextLine();
		String titlex = keyboard.nextLine();

		System.out.print("Now we need the name of the AUTHOR:");
		String authorx = keyboard.nextLine();

		System.out.print("Now, please enter the PRICE: ");
		double pricex = keyboard.nextDouble();

		System.out.print("We will also need the ISBN number: ");
		long isbnx = keyboard.nextLong();

		System.out.print("The GENRE please: ");
		String notgenrex = keyboard.nextLine();
		String genrex = keyboard.nextLine();

		System.out.print("Finally, the YEAR: ");
		int yearxy = keyboard.nextInt();
	
	Book bookx = new Book(titlex, authorx, pricex, isbnx, genrex, yearxy);

	System.out.println("I will need the first ISBN of the book location please: ");
	long isbnfirst = keyboard.nextLong();
	System.out.println("The second ISBN of the book Location please: ");
	long isbnsecond = keyboard.nextLong();

	bkLst.insertBetween(isbnfirst, isbnsecond, bookx);
	
	bkLst.displayContent();
	break;
	
	case 6 : 	System.out.println("first ISBN please: ");
	long isbnz = keyboard.nextLong();	
	System.out.println("second ISBN please: ");
	long isbnt = keyboard.nextLong();
	
	bkLst.swap(isbnz, isbnt);
	System.out.print("Here is the current List: ");
	bkLst.displayContent();
	
	case 7: 
		bkLst.commit();
		System.out.println("List commited");
		break;
	case 8:
		bkLst.commit();
		System.out.println("Thank you for using my program, Au Revoir");
		System.exit(0);
		
		
	default: System.out.println("1) Give me a year # and I would extract all records of that year and store them in a file for that year: "
			+ "\n2) Ask me to delete all consecutive repeated records:"
			+ "\n3) Give me an AUTHOR name and I will creat a new list with the records of this author and display them: "
			+ "\n4) Give me an ISBN number and a Book object, and I will insert Node with the book before the record with this ISBM:"
			+ "\n5) Give me 2 ISBN numbers and a Book object, and I will insrt a Node between them, if I find them:"
			+ "\n6) Give me 2 ISBN numbers and I will swap them in the list for rearrangement of records: of cours if they exist:"
			+ "\n7) Tell me to COMMIT! Your command is my wish. I will commit your list to a file called Updated_Books:"
			+ "\n8) Tell me to STOP TALKING. Remember, if you do not commit, I will not.");
		
	 n = keyboard.nextInt();

	 System.out.println("1) Give me a year # and I would extract all records of that year and store them in a file for that year: "
				+ "\n2) Ask me to delete all consecutive repeated records:"
				+ "\n3) Give me an author name and I will create a new list with the records of this author and display them: "
				+ "\n4) Give me an ISBN number and a Book object, and I will insert Node with the book before the record with this ISBN:"
				+ "\n5) Give me 2 ISBN numbers and a Book object, and I will insrt a Node between them, if I find them:"
				+ "\n6) Give me 2 ISBN numbers and I will swap them in the list for rearrangement of records: of cours if they exist:"
				+ "\n7) Tell me to COMMIT! Your command is my wish. I will commit your list to a file called Updated_Books:"
				+ "\n8) Tell me to STOP TALKING. Remember, if you do not commit, I will not.");
			
		 n = keyboard.nextInt();
		

	
	}
		} while(n!= 8);
		
		System.out.println("Thank you for using my program, Au Revoir");
		System.exit(0);
		
		
		
	}

}
