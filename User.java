/* Define attributes like userId, name, and a list of borrowed books. */
/* Implement methods to borrow and return books.*/
import java.util.*;
class User{
    private List<Book> borrowedBook;
    private String userName;
    private int userId;
    private UserRoll userType;
    public User(String userName, int userId,UserRoll userType){
        this.borrowedBook=new ArrayList<>();
        this.userName=userName;
        this.userId=userId;
        this.userType=userType;
    }

    public List<Book> getBorrowedBook(){
        return borrowedBook;
    }

    public String getUserName(){
        return userName;
    }

    public int getUserId(){
        return userId;
    }

     public UserRoll getUserRoll(){
        return userType;
     }

    public void borrowBook(Book book){
        if(book.isAvailable()){
            book.borrowBook();
            borrowedBook.add(book);
        }
        else{
            System.out.println("Cannot Borrow book it is already borrow"+book.getAuthor());
        }
    }

    public void returnBook(Book book){
        if(borrowedBook.contains(book)){
            book.returnBook();
            borrowedBook.remove(book);
        }
        else{
           System.out.println("can borrow book"+book.getAuthor()); 
        }
    }

}