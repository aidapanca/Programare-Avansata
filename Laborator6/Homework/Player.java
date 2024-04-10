/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import java.awt.*;


public class Player {
    private Color color;

    private String name;

    public Player(Color color, String name){
        this.color = color; //culoarea jucatorului
        this.name = name; //nume (player 1 player 2)
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }


}
