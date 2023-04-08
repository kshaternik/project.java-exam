package ru.rra;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        Gson gson = new Gson();
        Type founderListType = new TypeToken<ArrayList<ToysShop>>(){}.getType();
        List<ToysShop> list = gson.fromJson(readToysFormJsonFile(), founderListType);

        System.out.println("------  используется override compareTo in class ToysShop implements Compareble------");
        PriorityQueue<ToysShop> pQ = new PriorityQueue<>(list);

        getToysFromPriorityQueue(pQ);

        System.out.println("------ Используется паблик класс Comparator или Lambda ----------");
        PriorityQueue<ToysShop> priorityQueue = new PriorityQueue<>(10, (t1,t2)-> t2.getChance()-t1.getChance());
//        PriorityQueue<ToysShop> priorityQueue = new PriorityQueue<>(10, (t1,t2)-> Integer.valueOf(t2.getId())-Integer.valueOf(t1.getId()));
//        PriorityQueue<ToysShop> priorityQueue = new PriorityQueue<>(10, new ToysComparator());
        priorityQueue.addAll(list);

        getToysFromPriorityQueue(priorityQueue);

    }


    private static String readToysFormJsonFile() {
        String data = "";
        try {
            File myObj = new File("ToysShop.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = data.concat(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }

    public static void getToysFromPriorityQueue(PriorityQueue<ToysShop> pQ){
        String result;
        int pQSize = pQ.size();
        try {
            FileWriter fw = new FileWriter("result.txt");
            for (int i = 0; i < pQSize; i++) {
                result = pQ.poll().getId();
                System.out.println(result);
                fw.write(result);
            }
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}





