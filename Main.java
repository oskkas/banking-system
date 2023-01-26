package banking;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static HashMap<String, String> cards = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    public static void menu() {
        int op;
        do {
            System.out.println("""
                    1. Create an account
                    2. Log into account
                    0. Exit
                    """);
            op = scanner.nextInt();
            switch (op) {
                case 1 -> menuCreateAccount();
                case 2 -> {
                    if (loginIntoAccount()) {
                        successfulLogin();
                    } else {
                        System.out.println("Wrong card number or PIN!");
                    }
                }
                case 0 -> System.out.println("Bye!");
            }
        } while (op != 0);
    }
    public static void successfulLogin() {
        int op;
        do {
            System.out.println("""
                    You have successfully logged in!
                                    
                    1. Balance
                    2. Log out
                    0. Exit
                    """);
            op = scanner.nextInt();
            switch (op) {
                case 1 -> System.out.println("Balance: 0");
                case 2 -> System.out.println("You have successfully logged out!");
                case 0 -> System.exit(0);
            }
        } while (op != 2);
    }
    public static void menuCreateAccount() {
        String cardNum = createNumber();
        String pin = createPin();
        cards.put(cardNum, pin);
        System.out.printf("""
                Your card has been created
                Your card number:
                %s
                Your card PIN:
                %s
                
                """, cardNum, pin);
    }
    public static boolean loginIntoAccount() {
        scanner.nextLine();
        System.out.println("Enter your card number:");
        String card = scanner.nextLine();
        System.out.println("Enter your PIN:");
        String pin = scanner.nextLine();

        if (cards != null) {
            if (cards.containsKey(card)) {
                return cards.get(card).equals(pin);
            }
        }
        return false;
    }
    public static String createNumber() {
        Random random = new Random();
        StringBuilder cardNum = new StringBuilder("400000");
        int num;
        while (cardNum.length() != 16) {
            num = random.nextInt( 10);
            cardNum.append(num);
        }
        return cardNum.toString();
    }
    public static String createPin() {
        Random random = new Random();
        StringBuilder pin = new StringBuilder();
        int num;
        while (pin.length() != 4) {
            num = random.nextInt(10);
            pin.append(num);
        }
        return pin.toString();
    }
    public static void main(String[] args) {
        menu();
    }
}