package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {

        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen bir sayı(0,1,2) giriniz.");
        int secim = input.nextInt();
        input.nextLine();
        while (true) {
            if (secim == 0) {
                System.out.println("Uygulama Durduruldu.");
                break;
            } else if (secim == 1) {
                System.out.print("Eklenmesini istediğiniz elemanları giriniz(virgül ile ayırabilirsiniz).");
                String elemanlar = input.nextLine();
                addItems(elemanlar);
                printSorted();
                break;

                }else if (secim == 2) {
                System.out.print("Çıkarılmasını istediğiniz elemanları giriniz(virgül ile ayırabilirsiniz).");
                String elemanlar = input.nextLine();
                removeItems(elemanlar);
                printSorted();
                break;
            }
        }
        input.close();
    }

    public static void addItems(String input){
        String[] items = input.split(",");
        for (String item : items) {
            String product = item.trim().toLowerCase();
            if (!product.isEmpty() && !checkItemIsInList(product)) {
                groceryList.add(product);
            }
        }
        Collections.sort(groceryList);
    }
    public static void removeItems(String input){
        String[] items = input.split(",");
        for (String item : items) {
            String product = item.trim().toLowerCase();
            groceryList.remove(product);
        }
        Collections.sort(groceryList);
    }
    public static boolean checkItemIsInList(String product){
        return groceryList.contains(product.toLowerCase());
    }
    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println(groceryList);
            }
        }



