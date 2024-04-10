/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import javax.swing.*;
import java.io.*;

public class GameSave implements Serializable {
    private int[][] saveMatrix;

    private int lastX;

    private int lastY;

    //salvez jocu (salvez matricea)
    public GameSave(int[][] saveMatrix, int lastX, int lastY){
        this.saveMatrix = saveMatrix;
        this.lastX = lastX;
        this.lastY = lastY;
    }

    public int[][] getSaveMatrix() {
        return saveMatrix;
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }

    //serializarea
    public void serialize(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) { //serializes the output flow
            oos.writeObject(this); //scrie - flow associated with the object
            System.out.println("Game saved successfully");
            JOptionPane.showMessageDialog(null, "The Game was saved with success!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "There was an error in saving the game!");
            e.printStackTrace();
        }
    }

    //convertirea din binary dates din matrice si last thing placed
    public GameSave deserialize(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) { //it deserializes the datas in an Output Flow
            GameSave gameData = (GameSave) ois.readObject(); //obiectul deserialized e salvat in variabila asta
            System.out.println("Game Loaded successfully");
            JOptionPane.showMessageDialog(null, "The Game was loaded with success!");
            return gameData;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "There was an error in loading the game!");
            e.printStackTrace();
            return null;
        }
    }
}
