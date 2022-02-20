package com.geekbrains.lesson4;

public class Comparator {

    public static int catToInt (String category){

        switch (category){
            case "fruit": return 1;
            case "vegetables": return 2;
            case "alcohol": return 3;
        }
        return 0;
    }
}
