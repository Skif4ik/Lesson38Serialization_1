package _02_standart;

import java.io.*;

public class Main2 {

    public static final String PATH_TO_OUTPUT = "src/resources/output.txt";

    public static void main(String[] args) {
        System.out.println("Creation: ");
        Child child = new Child(1);
        try (FileOutputStream os = new FileOutputStream(PATH_TO_OUTPUT);
             ObjectOutputStream oos = new ObjectOutputStream(os);
             FileInputStream is = new FileInputStream(PATH_TO_OUTPUT);
             ObjectInputStream ois = new ObjectInputStream(is)){

            System.out.println("Serialization: ");
            oos.writeObject(child); //превращаем объект в поток байт

            System.out.println("DeSerialization: ");
            Child child1 = (Child) ois.readObject();

            System.out.println(child1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
