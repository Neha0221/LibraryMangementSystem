/* Book: Represents a book with attributes like title, author, ISBN, and availability. */
/* Implement methods to get the details of the book and check availability. */
import java.util.*;
import java.time.LocalDateTime;
class Book{
    private String title;
    private String author;
    private int ISBN;
    private boolean availability;
    private LocalDateTime borrowTime;

    public Book(String title,String author,int ISBN){
        this.title=title;
        this.author=author;
        this.ISBN=ISBN;
        this.availability=true; /*Intially all book are available*/
        this.borrowTime=null;
    }

    public String getTitle(){
        /*Getter allows access to private member variables from other classes*/
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getISBN(){
        return ISBN;
    }

    public boolean isAvailable(){
        return availability;
    }

    public LocalDateTime getBorrowTime(){
        return borrowTime;
    }

    public void borrowBook(){
        /* method check availablilty of book*/
        if(availability){
            availability=false;
            borrowTime=LocalDateTime.now();
        }
        else{
            System.out.println("Book is not available");
        }
    }

    public void returnBook(){
        availability=true;
        borrowTime=null;
    }

}