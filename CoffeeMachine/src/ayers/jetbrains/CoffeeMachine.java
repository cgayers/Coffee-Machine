package ayers.jetbrains;

import java.util.*;

public class CoffeeMachine {
        static int water = 400;
        static int milk = 540;
        static int beans = 120;
        static int cups = 9;
        static int money = 550;
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action;
        
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.nextLine();
            System.out.println();
            
            switch (action) {
                case "buy" : {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffee = scanner.nextLine();
                    if (coffee.equals("back")) {
                        continue;
                    }
                    buyCoffee(coffee);
                    break;
                }
                case "fill" : {
                    fillMaker();
                    break;
                }
                case "take" : {
                    takeMoney();
                    break;
                }
                case "remaining" : {
                    System.out.println("The coffee machine has:");
                    System.out.println(water + " of water");
                    System.out.println(milk + " of milk");
                    System.out.println(beans + " of coffee beans");
                    System.out.println(cups + " of disposable cups");
                    System.out.println("$" + money + " of money");
                    System.out.println();
                    break;
                }
            }
        } while (!action.equals("exit"));
        scanner.close();
    }
    
    static void buyCoffee(String coffee) {
        if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
            return;
        }
        switch (coffee) {
            case "1": {
                if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if (beans < 16) {
                    System.out.println("Sorry, not enough beans!");
                    return;
                }
                water -= 250;
                beans -= 16;
                money += 4;
                cups -= 1;
                break;
            }
            case "2": {
                if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                    return;
                }
                if (beans < 20) {
                    System.out.println("Sorry, not enough beans!");
                    return;
                }
                water -= 350;
                milk -= 75;
                beans -=20;
                money += 7;
                cups -= 1;
                break;
            }
            case "3": {
                if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                    return;
                }
                if (beans < 12) {
                    System.out.println("Sorry, not enough beans!");
                    return;
                }
                water -= 200;
                milk -= 100;
                beans -= 12;
                money += 6;
                cups -= 1;
                break;
            }
        }
        System.out.println("I have enough resources, making you a coffee!");
        System.out.println();
    }
    
    static void fillMaker() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Write how many ml of water do you want to add: ");
        water += scanner.nextInt();
        
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        beans += scanner.nextInt();
        
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += scanner.nextInt();
        
        scanner.close();
    }
    
    static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
}

