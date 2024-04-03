/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework.model;

import Homework.exceptions.IllegalIDException;
public record Person(int id, String name)
{
    public Person
    {
        if(id<0)
            throw new IllegalIDException("ID value must be a positive number!");
    }
}