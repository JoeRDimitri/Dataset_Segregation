// ----------------------------------------------------- 
//Assignment 4
// Part: 1
// Written by: Joseph Rady Dimitri 40133609 
// ----------------------------------------------------- 

/**
 * BookList class which has an inner Node class and where the main methods are defined
 */

package a4_249;

import java.io.*;
import java.util.ArrayList;

public class BookList {
	
	private class Node{



		private Book b;
		private Node next;
		
		public Node() {
			this.b = null;
			this.next = null;
		}
		
		public Node(Book b) {
			this.b = b;
			this.next = null;
		}
		
		public Node(Book b,Node xt) {
			this.b = b;
			this.next = xt;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		public String getTitle() {
			return this.b.getTitle();
		}

		public String getAuthor() {
			return this.b.getAuthor();
		}
		
		public double getPrice() {
			return this.b.getPrice();
		}
		
		public long getISBN() {
			return this.b.getISBN();
		}
		
		public String getGenre() {
			return this.b.getGenre();
		}
		
		public int getYear() {
			return this.b.getYear();
		}
		
		public String toString() {
			return this.b.toString();

		}
		public void setNext(Node n) {
			this.next = n;
		}
		
	
		
	}
	
	private Node head;
	
	public BookList() {

		head = null;
	}
	
	public Node getHead() {
		return head;
	}
	
	public void addToStart(Book b) {
		Node newnode;
		if(head == null) {
			 newnode = new Node(b);
			 head = newnode;
			 newnode.next = head;
			 newnode = null;
			 
		}
		else {
			newnode = new Node(b,head);
			Node tempnode = head;

			while(tempnode.next != head)
				tempnode = tempnode.next;
			tempnode.next = newnode;
			head = newnode;

		}
	}
	
	public void storeRecordsByYear(int yr) {


		String filename = String.valueOf(yr);
		filename = filename+".txt";
		PrintWriter pw =null;
		Node currentnode = head;
		
		do {
			
			if(currentnode.b.getYear()==yr) {
				
				try {
					pw = new PrintWriter(new FileOutputStream(filename,true));	
				} 
				catch (FileNotFoundException e) {
					File currentyearfile = new File(filename);
					try {
						currentyearfile.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					pw.println(currentnode.b);
					pw.close();
					continue;
				}
				
				pw.println(currentnode.b);
				pw.close();
				currentnode=currentnode.next;


				}
			else if(currentnode.next!=null)
			currentnode=currentnode.next;
			}while(currentnode.getNext() !=head );
		
		pw.close();
	}

	public boolean insertBefore(long isbn, Book b) {

		
		//check if the isbn is the head in this case we use addtostart()
		
		if(isbn == head.getISBN()) {
			this.addToStart(b);
			return true;
		}
		
		
		//if it is not the head we want to keep checking the next isbn so that we do not overshoot the index
		else {
			Node currentnode = head;
			Node tempnode = new Node(b);
			while(currentnode != null) {
				if(currentnode.next.getISBN()==isbn) {
					tempnode.setNext(currentnode.next);
					currentnode.setNext(tempnode);
					return true;
				}
			
			else {
				currentnode = currentnode.next;
				if(currentnode == head) {
					System.out.println("There is no ISBN in this list which matches your input.");
				return false;}
			}
			}
			
		}
		
		
			return false;
	}
		
	public void displayContent() {


		Node currentnode = head;
		if (currentnode == null)
			System.out.println("There is nothing to display; list is empty." );
		else
			System.out.println("Here are the contents of the list: " );
		while(currentnode.getNext() != head)
		{
			System.out.println(currentnode.toString() + " ===> ");
			currentnode = currentnode.getNext(); // Move to the next node

		}
		System.out.println(currentnode+" ===>");
		System.out.println("===> Head");	

		
	}

	public boolean insertBetween (long isbn1, long isbn2, Book b) {
		Node tempnode1 = head;
		Node tempnode2;
		
		if(tempnode1.getISBN() == isbn1)
			addToStart(b);
		else
			
		while(tempnode1.getNext()!=head) {
			tempnode1 = tempnode1.getNext();
			if(tempnode1.getISBN()==isbn1) {
				tempnode2 = tempnode1.getNext();
				if(tempnode2.getISBN()==isbn2) {
					tempnode1.setNext(new Node(b,tempnode2));
					return true;
					}
				else
					continue;
			}
		}
		return false;
	}
	
	public boolean delConsecutiveRepeatedRecords() {

		

		Node currentnode = head.next;
		Node nextnode = currentnode.next;
		Node runningnode = nextnode;
		Book currentbook = currentnode.b;
		Book nextbook = nextnode.b;
		Book runningbook = nextbook;	
			
		while(nextnode.getNext()!=head.getNext()) {
		if(currentbook.equals(nextbook)) {
			while(currentbook.equals(runningbook)) {
				currentnode.setNext(runningnode.getNext());
				runningbook = runningnode.getNext().b;
				runningnode = runningnode.getNext();
				if(currentnode.next == head) {
					if(currentbook.equals(runningbook)) {
						head = head.next;
						currentnode.setNext(runningnode.getNext());
						runningbook = runningnode.getNext().b;
						runningnode = runningnode.getNext();
						return true;
						}
					return true;
					}
				}
			}
		currentnode = currentnode.getNext();
		nextnode = currentnode.getNext();
		runningnode = nextnode;
		currentbook = currentnode.b;
		nextbook = nextnode.b;
		runningbook = nextbook;
		
		}
		return false;
	}
			
	public BookList extractAuthList(String aut) {


		BookList authorbooklist = new BookList();
		Node tempnode = head;
		ArrayList<Book> authorarraylist = new ArrayList<Book> (1);
		while(tempnode.getNext()!= head) {
			if(tempnode.getAuthor().equals(aut))
				authorarraylist.add(new Book(tempnode.b));
			tempnode = tempnode.getNext();
				
		}
		
		for(int i = authorarraylist.size()-1; i >=0;i--)
			authorbooklist.addToStart(authorarraylist.get(i));
		
		return authorbooklist;
			
	}

	public boolean swap(long isbn1, long isbn2) {
		Node node1= null;
		Node node2 = null;
		Node tempnode1 = null;
		Node tempnode2;
	
		//if one of the nodes we want to swap is the head: this is covered by the first two cases
		if(isbn1 == head.getISBN()) {
			node1 = head;
			tempnode1 = node2 = head.next;

			while(tempnode1.next!= head)
				tempnode1 = tempnode1.next;
			
			while(node2.getISBN() != isbn2)
				node2 = node2.next;
			
			if(node2.getISBN() == isbn2) {
				tempnode2 = new Node(node2.b);
				tempnode1.next = tempnode2;
				tempnode2.next = node1;
				node1.next = node2.next;
				head = tempnode2;
				return true;
			}
			
		}
		else if(isbn2==head.getISBN()) {
			node1 = head;
			tempnode1 = node2 = head.next;

			while(tempnode1.next!= head)
				tempnode1 = tempnode1.next;
			
			while(node2.getISBN() != isbn1)
				node2 = node2.next;
			
			if(node2.getISBN() == isbn1) {
				tempnode2 = new Node(node2.b);
				tempnode1.next = tempnode2;
				tempnode2.next = node1;
				node1.next = node2.next;
				head = tempnode2;
				return true;
			}
			
		}
			
		// now we consider if neither of the nodes are a head
		else {
			System.out.println("Is the code reaching here 1 ?");
		node1 = head.next;
		while(node1 != head && !(node1.getISBN() == isbn1 || node1.getISBN() == isbn2)) {
			System.out.println("Is the code reaching here 2 ?");

			node1 = node1.next;
		}
		
		node2 = node1.next;
		
		while(node2 != head && !(node2.getISBN() == isbn1 || node2.getISBN() == isbn2)) {
			System.out.println("Is the code reaching here 3 ?");

			node2 = node2.next;
		}
		
		if((node1.getISBN() == isbn1 || node1.getISBN() == isbn2)&& (node2.getISBN() == isbn1 || node2.getISBN() == isbn2)){
			
			System.out.println("Is the code reaching here?");

			tempnode1 = head;
			while(tempnode1.next != node1)
				tempnode1 = tempnode1.next;
			
			tempnode2 = new Node(node2.b);
			Node tempnode3 = new Node(node1.b);
			tempnode2.next = node1.next;
			tempnode1.next = tempnode2;
			
			while(tempnode1.next != node2)
				tempnode1 = tempnode1.next;
			tempnode3.next = node2.next;
			tempnode1.next = tempnode3;
			
			node1.next = null;
			node1 = null;
			node2.next = node2 = null;
			
			return true;
					
					
			}
		}
		
		System.out.println("There was an issue with swapping these 2 ISBNs, try a different pair.");

		return false;
	}
 	
	
	public void commit() {
		
		Node tempnode = head;
		PrintWriter printWriterObject = null;
		try {
			printWriterObject = new PrintWriter(new FileOutputStream("Update_Books.txt"));
			do {
				printWriterObject.println(tempnode);
				tempnode = tempnode.getNext();

				}while(tempnode!= head);
		} 
		
		catch (FileNotFoundException e) {
			 File filename = new File("Update_Books.txt");
			 try {
				 filename.createNewFile();
				 do {
						printWriterObject.println(tempnode);
						tempnode = tempnode.getNext();
						printWriterObject.close();
						
					}while(tempnode!= head);
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
			 }
		printWriterObject.close();

	}
	
	public String toString() {
		return this.head.toString();
	}

	
	
}
