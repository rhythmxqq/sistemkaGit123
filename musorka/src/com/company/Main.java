package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        //создаем аррауЛист
        ArrayList<Integer> arrayList = new ArrayList<>();
        //добавление значений в лист
        arrayList.add(51);
        arrayList.add(51);
        arrayList.add(51);
        arrayList.add(670);
        arrayList.add(670);
        //вывод листа с помощью фо рич с введенными повторяющимися значениям
        for (int item : arrayList
        ) {
            System.out.print(item + " ");
        }
        System.out.print("\n");
        //установка уникальных значений и вывод через фо рич
        HashSet<Integer> set = new HashSet<>(arrayList);
        for (int item : set
        ) {
            System.out.print(item + " ");
        }
    }
}
