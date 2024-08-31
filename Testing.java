class Testing{
    static void testBorrowBook(Book book,User user,Library library){
        library.borrowBook(book.getISBN(),user.getUserId());
        if(book.isAvailable()==true){
            System.out.println("Borrow book failed,");
            return;
        }
        if(user.getBorrowedBook().contains(book)==false){
            System.out.println("Borrow book failed, book is not present in userBorrowed Book");
            return;
        }
        System.out.println("Borrow book Successfull");
    }
    public static void main(String[] args){
        Library library=new Library();
        
        Book book1=new Book("abc","Krishna",123);
        Book book2=new Book("def","Radha",456);
        Book book3=new Book("def","Radha",234);
        Book book4=new Book("def","Radha",789);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        User user1=new User("Neha",21,UserRoll.LIBRARIAN);
        User user2=new User("Abhi",23,UserRoll.ADMIN);

        library.addUser(user1);
        library.addUser(user2);

        // library.borrowBook(123,21);
        // library.borrowBook(456,23);
        // library.borrowBook(789,23);

        // library.returnBook(123,21);
        // library.returnBook(456,23);
        // library.returnBook(234,23);
        testBorrowBook(book1,user2,library);
   }
}

// borrowed book=123,456,789
// returned = 456
// returned = 234