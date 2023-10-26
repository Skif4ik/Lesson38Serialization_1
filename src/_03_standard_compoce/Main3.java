package _03_standard_compoce;

import _02_standart.Child;

import java.io.*;
import java.util.List;

//Серелизация сложного объекта со статическими полями


public class Main3 {

    public static final String PATH_TO_OUTPUT = "src/resources/output.txt";

    public static void main(String[] args) {
        StandardCat vaska = new StandardCat("Vaska", new StandardBox(List.of("Ball", "Mouse")));

        try (FileOutputStream os = new FileOutputStream(PATH_TO_OUTPUT);
             ObjectOutputStream oos = new ObjectOutputStream(os);
             FileInputStream is = new FileInputStream(PATH_TO_OUTPUT);
             ObjectInputStream ois = new ObjectInputStream(is)) {

            oos.writeObject(vaska);
            StandardCat.staticField = "New Value";

            StandardCat catFromFile = (StandardCat) ois.readObject();

            System.out.println(catFromFile);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
