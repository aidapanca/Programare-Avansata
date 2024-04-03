/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework.exceptions;

public class IllegalIDException extends RuntimeException
{
    public IllegalIDException() {}
    public IllegalIDException(String message)
    {
        super(message);
    }
    public IllegalIDException(String message, Throwable err)
    {
        super(message, err);
    }
}
