// ----------------------------------------------------- 
//Assignment 4
// Part: 1
// Written by: Joseph Rady Dimitri 40133609 
// ----------------------------------------------------- 

/**
 * Book class which defines a book object
 */
package a4_249;

public class Book {
	private String title;
	private String author;
	private double price;
	private long ISBN;
	private String genre;
	private int year;
	
	public Book() {
		title = "";
		author = "";
		price = 0.0;
		ISBN = 0;
		genre = "";
		year = 0;
	}
	
	public Book(String title, String author, double price, long ISBN, String genre, int year) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.ISBN = ISBN;
		this.genre = genre;
		this.year = year;
	}
	
	public Book(Book b) {
		this.title = b.getTitle();
		this.author = b.getAuthor();
		this.price = b.getPrice();
		this.ISBN = b.getISBN();
		this.genre = b.getGenre();
		this.year = b.getYear();
	}
	
	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public long getISBN() {
		return this.ISBN;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public String toString() {
		return(this.title+", " + this.author+", " + this.price+", " + this.ISBN+", " + this.genre + ", " + this.year);
	}
	
	public boolean equals(Book b) {
		return(this.author.equals(b.author)&&this.genre.equals(b.genre)&& this.ISBN==(b.ISBN)&&this.price==b.price&&this.title.equals(b.title)&&this.year==b.year);
	}
	
	
	
}

