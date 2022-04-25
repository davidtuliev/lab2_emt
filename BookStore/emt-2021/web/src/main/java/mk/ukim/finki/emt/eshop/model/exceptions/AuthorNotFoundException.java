package mk.ukim.finki.emt.eshop.model.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(){
        super("The author has not been found");
    }
}