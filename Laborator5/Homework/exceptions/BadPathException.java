/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework.exceptions;

public class BadPathException extends RuntimeException
{
    public BadPathException() {}
    public BadPathException(String message)
    {
        super(message);
    }
}