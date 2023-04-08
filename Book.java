// Create a class Book with below attributes

// id - int

// pages - int

// title - String

// author - String

// price - double

// The above attributes should be private, write getters and setters and parameterized constructor as required.

// Create a class Solution with main method
// --------------------------------------------
// Implement two static methods - findBookWithMaximumPrice and searchBookByTitle in Solution class.

// findBookWithMaximumPrice :
// =============================
// Create a static method findBookWithMaximumPrice in the Solution class. This method will take array of Book objects and 
// returns the Book object having the maximum Price if found else return null if not found.

// searchBookByTitle :
// =============================
// Create a static method searchBookByTitle in the Solution class. This method will take array of Book objects and Title as 
// input and returns the Book object having the mentioned Title if found else return null if not found.

// These methods should be called from the main method.

// write code to perform the following tasks.

// 1. Take necessary input variable and call findBookWithMaximumPrice. For this method - The main method should print the Book
//  object with the maximum of mentioned attribute as it is if the returned value is not null, or it should print 
//  "No Book found with mentioned attribute."
-------------------------------------------------------------------------------------------------------------------------------------------
  import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        Book[] book = new Book[4];
        for(int i = 0; i < 4; i++){
            int a = sc.nextInt();sc.nextLine();
            int b = sc.nextInt();sc.nextLine();
            String c = sc.nextLine();
            String d = sc.nextLine();
            double e = sc.nextDouble();sc.nextLine();
            book[i] = new Book(a,b,c,d,e);
        }
        
        String input1 = sc.nextLine();
        
        Book[] ans = findBookWithMaximumPrice(book);
        if(ans!=null)
        {
            for (int i = 0; i < ans.length; i++) {
                System.out.println(ans[i].id+" "+ans[i].title);
            }
        }
        else
        {
            System.out.println("No Book found with mentioned attribute.");
        }
        
        Book ans2 = searchBookByTitle(book,input1);
         if(ans2!=null)
        {
            System.out.println(ans2.id);
            System.out.println(ans2.pages);
        }
    }
    public static Book searchBookByTitle(Book[] book,String title){
        for(int i = 0; i < book.length; i++){
            if(book[i].title.equalsIgnoreCase(title)){
                return book[i];
            }
        }
        return null;
    } 
    
    public static Book[] findBookWithMaximumPrice(Book[] book){
        Book[] temp = new Book[0];
        double max = 0;
        for(int i = 0; i < 4; i++){
            if(book[i].price > max){
                max = book[i].price;
            }
        }
        for(int i = 0; i < 4; i++){
            if(book[i].price == max){
                temp =  Arrays.copyOf(temp,temp.length + 1);
                temp[temp.length - 1] = book[i];
            }
        }
        
        if(temp.length>0)
        {
            return temp;
        }
        return null;
    }
}

class Book{
    int id,pages;
    String title,author;
    double price;
    
    Book(int id,int pages,String title,String author, double price){
        this.id = id;
        this.pages = pages;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

// 2. Take necessary input variable and call searchBookByTitle. For this method - The main method should print the Book object 
// details as it is, if the returned value is not null or it should print "No Book found with mentioned attribute."

// The above mentioned static methods should be called from the main method. Also write the code for accepting the inputs and 
// printing the outputs. Don't use any static test or formatting for printing the result. Just invoke the method and print the
// result.

// All String comparison needs to be in case sensitive.

// Input:

// 1
// 845
// Bengali
// Arijit
// 525.50
// 2
// 456
// English
// Raju
// 412.30
// 3
// 1022
// History
// Kaka
// 525.50
// 4
// 125
// geography
// MN
// 524
// English

// Output:

// 1 Bengali
// 3 History
// 2
// 456
