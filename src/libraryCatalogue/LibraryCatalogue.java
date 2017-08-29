package libraryCatalogue;

import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue {
	
	//Properties
	Map<String,Book> bookCollection = new HashMap<String,Book>();
	int currentDay =0;
	int lengthOfCheckOut = 7;
	double initialLateFee = 0.50;
	double feePerLateDay = 1.00;
	
	//constructors
	public LibraryCatalogue(Map<String,Book> collection){
		this.bookCollection = collection;
	}
	
	public LibraryCatalogue(Map<String,Book> collection, int lengthOfCheckoutPeriod,
			double initialLateFee,double feePerLateDay){
		this.bookCollection = collection;
		this.lengthOfCheckOut = lengthOfCheckoutPeriod;
		this.initialLateFee = initialLateFee;
		this.feePerLateDay = feePerLateDay;
	}
	
	//Getters
	public Map<String, Book> getBookCollection() {
		return this.bookCollection;
	}

	public Book getBook(String bookTitle){
		return bookCollection.get(bookTitle);
	}
	
	public int getCurrentDay() {
		return this.currentDay;
	}

	public int getLengthOfCheckoutPeriod() {
		return this.lengthOfCheckOut;
	}

	public double getInitialLateFee() {
		return this.initialLateFee;
	}

	public double getFeePerLateDay() {
		return this.feePerLateDay;
	}

	//Setters
	public void nextDay(){
		currentDay++;
	}
	
	public void setDay(int day){
		currentDay = day;
	}
	
	public void checkOutBook(String title){
		Book book = getBook(title);
		if(book.isCheckedOut){
			sorryBookAlreadyCheckedOut(book);
		}
		else{
			book.setIsCheckedOut(true, currentDay);
			System.out.println("You just checked out " + title + " . It is due on day " + 
			(getCurrentDay() + getLengthOfCheckoutPeriod()) + ".");
		}
	}
	
	public void returnBook(String title){
		Book book = getBook(title);
		int daysLate = currentDay - (book.getDaycheckedOut() + getLengthOfCheckoutPeriod());
		if(daysLate > 0){
			System.out.println("You owe the library $" + (getInitialLateFee() + daysLate * getFeePerLateDay()) + 
					" because your book is " + daysLate + " days overdue");
		}
		else{
			System.out.println("Book returned. Thank you");
		}
		book.setIsCheckedOut(false, -1);
		
	}

	public void sorryBookAlreadyCheckedOut(Book book){
		System.out.println("Sorry, " + book.getTitle() + " is already checked out. "
				+"It should be back on day " + (book.getDaycheckedOut() +
						getLengthOfCheckoutPeriod()) + ".");
	}
	
	public static void main(String[] args) {
		Map<String,Book> bookCollection = new HashMap<String,Book>();
		Book harry = new Book("HArry Potter", 827132, 999999);
		bookCollection.put("Harry Potter", harry);
		LibraryCatalogue lib = new LibraryCatalogue(bookCollection);
		lib.checkOutBook("Harry Potter");
		lib.nextDay();
		lib.nextDay();
		lib.checkOutBook("Harry Potter");
		lib.setDay(17);
		lib.returnBook("Harry Potter");
		lib.checkOutBook("Harry Potter");
		
		

	}

}
