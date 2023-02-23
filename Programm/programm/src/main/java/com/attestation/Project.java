package com.attestation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Project {

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */


    static List<cat> cats = new ArrayList<>();
    static List<dog> dogs = new ArrayList<>();
    static List<humster> humsters = new ArrayList<>();
    static List<horse> horses = new ArrayList<>();
    static List<camel> camels = new ArrayList<>();
    static List<donkey> donkeys = new ArrayList<>();
    static counter count = new counter();


    public static class counter{
        int counter;
        public counter(){
            this.counter = 0;
        }
        public void add(){
            counter++;
        }
        public void show(){
            System.out.println(counter);
        }
    }

    public static class beasts {
        private String name;
        private Date birthday; 
        private String group; // pets or pack animals
        private String type;  // dog,cat.....
        private SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
        public beasts(String name, Date birtDate, String group, String type){
            this.name = name;
            this.birthday = birtDate;
            this.group = group;
            this.type = type;
        }

        public String getBeast() {
            return this.name + " " + formater.format(this.birthday) + " " + this.group + " " + this.type;
        }
    }

    public static class pets extends beasts{
        private String commands;
        public pets(String name, Date birtDate, String type,String commands) {
            super(name, birtDate, "pets", type);
            this.commands = commands;
        }

        public void getCommands()
        {
            System.out.println(this.commands);
        }
        public void setCommands(String newCommands){
            this.commands = newCommands;
        }
        public String getAnimal() {
            return getBeast() + " " + this.commands;
        }
    }

    public static class pack_animals extends beasts{
        private String commands;
        private int weight; // transpotraton
        public pack_animals(String name, Date birtDate, String type, String commands, int weight) {
            super(name, birtDate, "pack animal", type);
            this.commands = commands;
            this.weight = weight;
        }
        public void getCommands()
        {
            System.out.println(this.commands);
        }
        public void setCommands(String newCommands){
            this.commands = newCommands;
        }
        public String getAnimal() {
            return getBeast() + " " + this.commands;
        }
    }

    public static class cat extends pets{

        public cat(String name, Date birtDate, String commands) {
            super(name, birtDate, "cat", commands);
        }
        
        @Override
        public String toString() {
            return getAnimal();
        }
    }

    public static class dog extends pets{

        public dog(String name, Date birtDate, String commands) {
            super(name, birtDate, "dog", commands);
        }
        @Override
        public String toString() {
            return getAnimal();
        }
    }
    public static class humster extends pets{

        public humster(String name, Date birtDate, String commands) {
            super(name, birtDate, "humster", commands);
        }
        @Override
        public String toString() {
            return getAnimal();
        }
    }
    public static class horse extends pack_animals{

        public horse(String name, Date birtDate, String commands, int weight) {
            super(name, birtDate, "horse", commands,weight);
        }
        @Override
        public String toString() {
            return getAnimal();
        }
    }
    public static class camel extends pack_animals{

        public camel(String name, Date birtDate, String commands, int weight) {
            super(name, birtDate, "camel", commands,weight);
        }
        @Override
        public String toString() {
            return getAnimal();
        }
    }
    public static class donkey extends pack_animals{

        public donkey(String name, Date birtDate, String commands, int weight) {
            super(name, birtDate, "donkey", commands,weight);
        }
        @Override
        public String toString() {
            return getAnimal();
        }
    }

    public static void menu (){
        System.out.println();
        System.out.println("Добро пожаловать в меню реестра домашних животных");
        System.out.println("1. Вывести список всех животных");
        System.out.println("2. Добавить животное");
        System.out.println("3. Изменить список команд животного(Данное действие заменяет текущий список)");
        System.out.println("0. Выход");
        System.out.println();
        System.out.print("Выберите необходимое действие:");
    }



    public static void showAnimals(){
        int i = 1;
        for (cat cat : cats) {
            System.out.println(i + " : " + cat);
        }
        i = 1;
        for (dog dog : dogs) {
            System.out.println(i + " : " + dog);
        }
        i = 1;
        for (humster humster : humsters) {
            System.out.println(i + " : " + humster);
        }
        i = 1;
        for (horse horse : horses) {
            System.out.println(i + " : " + horse);
        }
        i = 1;
        for (camel camel : camels) {
            System.out.println(i + " : " + camel);
        }
        i = 1;
        for (donkey donkey : donkeys) {
            System.out.println(i + " : " + donkey);
        }
        System.out.println();
    }


    public static class NoFullData extends RuntimeException {
        public NoFullData(String errorMessage, Throwable err) {
            super(errorMessage, err);
        }
    }

    /**
     * 
     */
    public static void addBeast(){
        try{
            Scanner in = new Scanner(System.in);
            System.out.print("Введите имя животного: ");
            String name = in.nextLine();
            System.out.print("Введите дату рождения животного (Формат dd.MM.yyyy): ");
            SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
            Date birthday = new Date(0);
            String commands;
            try {
                birthday = formater.parse(in.nextLine());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.print("Введите номер группы животного (1. pets, 2. pack animals): ");
            int i = 0;
            i = Integer.parseInt(in.nextLine());
            if(i==1) {
                i = 0;
                System.out.print("Введите номер вида животного (1. cat, 2. dog, 3. humster): ");
                i = Integer.parseInt(in.nextLine());
                System.out.print("Введите список команд которые знает питомец (В одну строку): ");
                commands = in.nextLine();
                switch (i){
                    case 1:cats.add(new cat(name, birthday, commands)); break;
                    case 2:dogs.add(new dog(name, birthday, commands)); break;
                    case 3:humsters.add(new humster(name, birthday, commands)); break;
                    default: break;
                }
            }
            else {
                i = 0;
                System.out.print("Введите номер вида животного (1. horse, 2. camel, 3. donkey): ");
                i = Integer.parseInt(in.nextLine());
                System.out.print("Введите список команд которые знает животное (В одну строку): ");
                String comm = in.nextLine();
                commands = comm;
                System.out.print("Введите вес которые может перевозить животное: ");
                int weight = Integer.parseInt(in.nextLine());
                switch (i){
                    case 1: horses.add(new horse(name, birthday, commands, weight)); break;
                    case 2: camels.add(new camel(name, birthday, commands, weight)); break;
                    case 3: donkeys.add(new donkey(name, birthday, commands, weight)); break;
                    default: break;
                }
            }
            if ((name=="")||(birthday == new Date(0))||(i>2))
            {
                throw new NoFullData("Не достаточно данных о животном", null);
            }
            else{
                count.add();
            }
        }
        catch (NoFullData e){
        }
    }

    public static void correctCommand(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер группы животного (1. pets, 2. pack animals): ");
        int i = 0;
        i = Integer.parseInt(in.nextLine());
        switch (i){
            case 1:{
                System.out.print("Введите номер вида животного (1. cat, 2. dog, 3. humster): ");
                i = Integer.parseInt(in.nextLine());
                int n = 1;
                switch (i){
                    case 1:
                        for (cat cat : cats) {
                            System.out.println(n + ":" + cat);
                        }
                        System.out.print("Введите номер животного из списка ");
                        n = Integer.parseInt(in.nextLine());
                        System.out.print("Введите новый список команд животного ");
                        cats.get(n-1).setCommands(in.nextLine());
                        break;
                    case 2:
                        for (dog dog : dogs) {
                            System.out.println(n + ":" + dog);
                        }
                        System.out.print("Введите номер животного из списка ");
                        n = Integer.parseInt(in.nextLine());
                        System.out.print("Введите новый список команд животного ");
                        dogs.get(n-1).setCommands(in.nextLine());
                        break;
                    case 3:
                        for (humster humster : humsters) {
                            System.out.println(n + ":" + humster);
                        }
                        System.out.print("Введите номер животного из списка ");
                        n = Integer.parseInt(in.nextLine());
                        System.out.print("Введите новый список команд животного ");
                        humsters.get(n-1).setCommands(in.nextLine());
                        break;
                    default: break;
                }
                break;
            }
            case 2:{
                System.out.print("Введите номер вида животного (1. horse, 2. camel, 3. donkey): ");
                i = Integer.parseInt(in.nextLine());
                int n = 1;
                switch (i){
                    case 1:
                        for (horse horse : horses) {
                            System.out.println(n + ":" + horse);
                        }
                        System.out.print("Введите номер животного из списка ");
                        n = Integer.parseInt(in.nextLine());
                        System.out.print("Введите новый список команд животного ");
                        horses.get(n-1).setCommands(in.nextLine());
                        break;
                    case 2:
                        for (camel camel : camels) {
                            System.out.println(n + ":" + camel);
                        }
                        System.out.print("Введите номер животного из списка ");
                        n = Integer.parseInt(in.nextLine());
                        System.out.print("Введите новый список команд животного ");
                        camels.get(n-1).setCommands(in.nextLine());
                        break;
                    case 3:
                        for (donkey donkey : donkeys) {
                            System.out.println(n + ":" + donkey);
                        }
                        System.out.print("Введите номер животного из списка ");
                        n = Integer.parseInt(in.nextLine());
                        System.out.print("Введите новый список команд животного ");
                        donkeys.get(n-1).setCommands(in.nextLine());
                        break;
                    default: break;
                }
                break;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = -1;
        while(i != 0){
            menu();
            i = Integer.parseInt(scanner.nextLine());
            switch(i){
                case 1: showAnimals(); break;
                case 2: addBeast(); break;
                case 3: correctCommand(); break;
                case 0: break;
                default: System.out.println("Такого пункта нет");
            }
        }
        scanner.close();
    }
}
