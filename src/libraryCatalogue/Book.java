package libraryCatalogue;

public class Book {
	
	//properties
	String title;
	int pageCount;
	int ISBN;
	boolean isCheckedOut;// whether or not the book is checked out
	int dayCheckedOut;
	
	//Constructor
	public Book(String bookTitle, int bookPageCount, int bookISBN) {
		this.title = bookTitle;
		this.pageCount = bookPageCount;
		this.ISBN = bookISBN;
		isCheckedOut = false;
	}

	//Getters
	public String getTitle() {
		return this.title;
	}

	public int getPageCount() {
		return this.pageCount;
	}

	public int getISBN() {
		return this.ISBN;
	}

	public boolean isCheckedOut() {
		return this.isCheckedOut;
	}

	public int getDaycheckedOut() {
		return this.dayCheckedOut;
	}
	
	//Setters	
	public void setIsCheckedOut(boolean isCheckedOut, int dayCheckedOut) {
		this.isCheckedOut = isCheckedOut;
		setDayCheckedOut(dayCheckedOut);
		
	}
	
	private void setDayCheckedOut(int day){
		this.dayCheckedOut = day;
	}
		

}
