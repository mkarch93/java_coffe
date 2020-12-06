package machine;

import java.util.Scanner;

class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);


    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    static boolean cont = true;

    public static void setWater(int water) {
        CoffeeMachine.water = water;
    }

    public static void setMilk(int milk) {
        CoffeeMachine.milk = milk;
    }

    public static void setBeans(int beans) {
        CoffeeMachine.beans = beans;
    }

    public static void setCups(int cups) {
        CoffeeMachine.cups = cups;
    }

    public static void setMoney(int money) {
        CoffeeMachine.money = money;
    }

    public static int getWater() {
        return water;
    }

    public static int getMilk() {
        return milk;
    }

    public static int getBeans() {
        return beans;
    }

    public static int getCups() {
        return cups;
    }

    public static int getMoney() {
        return money;
    }


    public static void main(String[] args) {
        while (cont) {
            Option();
        }
    }

    private static void Option() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String input1 = scanner.nextLine();

        switch (input1) {
            case "buy":
                Buy();

                break;
            case "fill":
                Fill();

                break;
            case "take":
                Take();

                break;
            case "remaining":
                Print();

                break;
            case "exit":
                Stop();

                break;

            default:
                System.out.println("incorrect input");
                System.out.println();
                break;
        }
    }

    public static void Print() {
        System.out.println("The coffee machine has:\n" +
                getWater() + " of water\n" +
                getMilk() + " of milk\n" +
                getBeans() + " of coffee beans\n" +
                getCups() + " of disposable cups\n" +
                getMoney() + " of money");
        System.out.println();


    }

    public static void Buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String tmp = scanner.nextLine();
        if (tmp.equals("back")) {
            System.out.println();
            return;
        }
        if (Integer.parseInt(tmp) == 1) /*  espresso: water - 250ml  beans - 16g cost - 4$ */ {

            if (getWater() >= 250 && getBeans() >= 16 && getCups() > 0) {
                setWater(getWater() - 250);
                setBeans(getBeans() - 16);
                setCups(getCups() - 1);
                setMoney(getMoney() + 4);
                System.out.println("I have enough resources, making you a coffee!");
                System.out.println();

            } else {
                if (getWater() < 250) {
                    System.out.println("Sorry, not enough water!");
                    System.out.println();
                }
                if (getBeans() < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    System.out.println();
                }
                if (getCups() < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    System.out.println();
                }
            }
        } else if (Integer.parseInt(tmp) == 2)  /*  latte:  water - 350gml milk - 75ml beans - 20g cost - 7$ */ {

            if (getWater() >= 350 && getBeans() >= 20 && getMilk() >= 75 && getCups() > 0) {
                setWater(getWater() - 350);
                setMilk(getMilk() - 75);
                setBeans(getBeans() - 20);
                setCups(getCups() - 1);
                setMoney(getMoney() + 7);
                System.out.println("I have enough resources, making you a coffee!");
                System.out.println();

            } else {
                if (getWater() < 350) {
                    System.out.println("Sorry, not enough water!");
                    System.out.println();
                }
                if (getBeans() < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                    System.out.println();
                }
                if (getMilk() < 75) {
                    System.out.println("Sorry, not enough milk!");
                    System.out.println();
                }
                if (getCups() < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    System.out.println();
                }
            }

        } else if (Integer.parseInt(tmp) == 3) /* cappuccino:  water - 200ml milk - 100ml beans - 12g cost - 6$ */ {

            if (getWater() >= 200 && getBeans() >= 12 && getMilk() >= 100 && getCups() > 0) {
                setWater(getWater() - 200);
                setMilk(getMilk() - 100);
                setBeans(getBeans() - 12);
                setCups(getCups() - 1);
                setMoney(getMoney() + 6);
                System.out.println("I have enough resources, making you a coffee!");
                System.out.println();

            } else {
                if (getWater() < 200) {
                    System.out.println("Sorry, not enough water!");
                    System.out.println();
                }
                if (getBeans() < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                    System.out.println();
                }
                if (getMilk() < 100) {
                    System.out.println("Sorry, not enough milk!");
                    System.out.println();
                }
                if (getCups() < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    System.out.println();
                }
            }
        } else {
            System.out.println("incorrect input");
            System.out.println();
        }

    }

    private static void Fill() {
        System.out.println("Write how many ml of water do you want to add:");
        setWater(getWater() + scanner.nextInt());

        System.out.println("Write how many ml of milk do you want to add:");
        setMilk(getMilk() + scanner.nextInt());

        System.out.println("Write how many grams of coffee beans do you want to add:");
        setBeans(getBeans() + scanner.nextInt());

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        setCups(getCups() + scanner.nextInt());
        System.out.println();
    }

    private static void Take() {
        System.out.println("I gave you $" + getMoney());
        System.out.println();
        setMoney(0);
    }

    public static void Stop() {
        CoffeeMachine.cont = false;
    }


}
