package com.karlmarxindustries.grindripsum.dao;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Repository
public class DaoImpl {
    private final String PHRASE_LIST = "list.txt";

    public List<String> getStringList(){
        List<String> curseList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(PHRASE_LIST)));
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                if (!(currentLine.equals("")) && !(currentLine.equals(" ")) ){
                    curseList.add(currentLine);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        return curseList;
    }
}
