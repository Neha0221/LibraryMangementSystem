/* Define attributes like a collection of books and users.*/
/* Implement methods to add books, register users, and manage borrowing and returning of books.*/
import java.util.*;
import java.time.LocalDateTime;
import java.time.Duration;
public class Library{
    private HashMap<Integer,Book> books;
    private HashMap<Integer,User> users;
    private HashMap<UserRoll,Integer> borrowLimit;
    public Library(){
        books = new HashMap<>();
        users = new HashMap<>();
        borrowLimit=new HashMap<>();
        initBorrowLimit();
    }

    public void addBook(Book book){
        books.put(book.getISBN(),book);
    }

    public void addUser(User user){
        users.put(user.getUserId(),user);
    }
    
    public void initBorrowLimit(){
        borrowLimit.put(UserRoll.LIBRARIAN,0);
        borrowLimit.put(UserRoll.MEMBER,3);
        borrowLimit.put(UserRoll.ADMIN,5);
    }

    public void borrowBook(int ISBN,int userId){
        Book book=books.get(ISBN);
        User user=users.get(userId);
        
        if(book==null){
            System.out.println("book is not available");
        }
        if(user==null){
            System.out.println("User is not register");
        }

        if(book!=null && user!=null){
            /*how many borrow 
            *limit
            */
            int borrowedCnt=user.getBorrowedBook().size();
            if(borrowLimit.get(user.getUserRoll())>borrowedCnt){
                user.borrowBook(book);
                System.out.println("Book is borrow by "+user.getUserName()+" Book Name is "+book.getAuthor());
            }
            else{
                System.out.println("User limit execeed of:"+user.getUserName());
            }
        }
    }

    public void returnBook(int ISBN,int userId){
        Book book=books.get(ISBN);
        User user=users.get(userId);

        if(book==null){
            System.out.println("This book's ISBN is not equal our library's book ISBN");
            return;
        }
        if(user==null){
            System.out.println("User is not register");
            return;
        }
                if(user.getBorrowedBook().contains(book)){
                    LocalDateTime currentTime=LocalDateTime.now();
                    Duration duration = Duration.between(book.getBorrowTime(), currentTime);
                    user.returnBook(book);
                    System.out.println("Book is return by "+user.getUserName()+" Book Name is "+book.getAuthor()+" Return Time : "+currentTime);
                    
                    long hours = duration.toHours();
                    long minutes = duration.toMinutes() % 60;

                    System.out.println("Difference: " + hours + " hours and " + minutes + " minutes.");
                }
                else{
                    System.out.println("Can not return by "+user.getUserName()+" it is not borrowed");  
                }
        

        
    }
}



