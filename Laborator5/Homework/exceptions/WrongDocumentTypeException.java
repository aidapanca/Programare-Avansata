package Homework.exceptions;

public class WrongDocumentTypeException extends RuntimeException
{
    public WrongDocumentTypeException() {}
    public WrongDocumentTypeException(String message)
    {
        super(message);
    }
    public WrongDocumentTypeException(String message, Throwable err)
    {
        super(message, err);
    }
}