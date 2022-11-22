package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            String stro4ka;
            String text = "";
        Scanner in = new Scanner(System.in); //сканер для ввода путя к файлу
            System.out.print("Укажите расположение файла ");
            String path = in.nextLine(); //вызываем сканер и просим пользователя ввести путь
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            //создаем поток и записываем с файла иинформацию в переменную

            while ((stro4ka = br.readLine()) != null) {
                text += stro4ka;
            }
            //вывод информации о тексте
            String symbols = "Всего : " + text.length();
            String space = "Всего без пробелов " + text.replaceAll(" ", "").length();
            String words = "Всего слов в тексте " + text.split(" ").length;
            System.out.println(symbols + "\t" + space + "\t" + words);
                FileWriter fileWriter = new FileWriter("информация.txt"); //создания файла куда записывается информация
                fileWriter.write(symbols + "\n");
                fileWriter.write(space + "\n");
                fileWriter.write(words + "\n");
                //запись на прямую на диск без потери информации
                fileWriter.flush();
            }
        //обработка ошибок try catch
            catch (Exception ex){
                ex.getMessage();
            }
        }
    }
