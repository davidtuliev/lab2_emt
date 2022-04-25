package mk.ukim.finki.emt.eshop.model.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(){
        super("The book has not been found");
    }
}