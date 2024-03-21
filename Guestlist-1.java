/*
  Author: Zainab Alfredji
  Id: ma8171
  Study program: DT
*/
import java.util.Scanner;

public class Guestlist{
    static Scanner sc = new Scanner(System.in);
    static int guestCount = 3;
    static String[][] guestList = {{"Adam Ason", "35"},
                                   {"Berta Bson", "70"},
                                   {"Ceasar Cson", "12"},
                                   {"",""},
                                   {"",""},
                                   {"",""},
                                   {"",""},
                                   {"",""},
                                   {"",""},
                                   {"",""},
    };

public static boolean isNumeric(String string) {
    int intValue;

    if(string == null || string.equals("")) {
        return false;
    }

    try {
        intValue = Integer.parseInt(string);
        return true;
    } catch (NumberFormatException e) {
        System.out.println("Input string cannot be parsed to Integer.");
    }
    return false;
}

//the main menu
public static void menu() {
    System.out.println(
        "\n - type 'menu' to return to the main page"
        + "\n - type 'guestNames' to get the names of the guest"
        + "\n - type 'stats' to get information about the guests"
        + "\n - type 'addGuest' to add a new guest"
        + "\n - type 'changeName' to change a guest's name"
        + "\n - type 'changeAge' to change a guest's age"
        + "\n - type 'remove' to remove a guest from the list"
        + "\n - type 'changePlace' switch place of 2 guests or 1 guest to an empty space"
        + "\n - type 'exit' to close the program"
    );
}

//get names of the guests
public static void guestNames() {
    String names = "";
    for (int i = 0; i < guestList.length; i++){
        if (guestList[i][0].isEmpty()) {
            continue;
        }

        if (names.isEmpty()) {
            names = guestList[i][0];
        } else {
            names = names + ", " + guestList[i][0];
        }
    }

    if (names.isEmpty()) {
        System.out.println("There are no guests");
    } else {
        System.out.println("Guest names: " + names);
    }
}

//get stats on the guests
public static void stats() {
    System.out.println("Your chose to see the statistics");
    int kidsMaxAge = 13;
    int oldest = 0;
    int youngest = 0;
    int adults = 0;
    int kids = 0;

    for (int i = 0; i < guestList.length; i++){
        int age;
        try {
            age = Integer.parseInt(guestList[i][1]);
        } catch (Exception e) {
            continue;
        }

        //count adults
        if (age > kidsMaxAge) {
            adults = adults + 1;
        }

        //count kids
        if (age <= kidsMaxAge){
            kids = kids + 1;
        }

        //count oldest
        if (oldest < age) {
            oldest = age;
        }

        //count youngest
        if (youngest == 0) {
            youngest = age;
        } else if (youngest > age) {
            youngest = age;
        }
    }

    System.out.println("- There are " + guestCount + " guests");
    System.out.println("- There are " + adults + " adult guests");
    System.out.println("- There are " + kids + " kids guests");
    System.out.println("- The oldest guest is  " + oldest + " year old");
    System.out.println("- The youngest guest is " + youngest + " years old");
}

// add a new guest
public static void addGuest() {
    if (guestCount >= guestList.length) {
        System.out.println("You can't add more guests");
        return;
    }

    System.out.println("Enter guest name: ");
    String guestName = sc.nextLine();
    if (guestName.isEmpty()) {
        System.out.println("No information, invalid. Type 'addGuest' and try again.");
        return;
    } 

    System.out.println("Enter guest age: ");
    String guestAge = sc.nextLine();
    if (!isNumeric(guestAge)) {
        System.out.println("The age need to be numeric. Type 'addGuest' and try again");
        return;
    }

    for (int i = 0; i < guestList.length; i++){
        if (guestList[i][0].isEmpty()) {
            guestList[i][0] = guestName;
            guestList[i][1] = guestAge;
            guestCount = guestCount + 1;
            System.out.println("New guest added: " + guestName);
            break;
        }
    }
}

// change name 
public static void changeName(){

    System.out.println("Enter name of guest you want to change");
    String guestName = sc.nextLine();

    if (guestName.isEmpty()) {
        System.out.println("Guest name can't be empty. Type 'changeName' and try again");
        return;
    }

    System.out.println("Enter NEW name of the guest: ");
    String guestNameNew = sc.nextLine();

    if (guestNameNew.isEmpty()) {
        System.out.println("NEW guest name can't be empty. Type 'changeName' and try again");
        return;
    } 

    boolean didChange = false;
    for (int i = 0; i < guestList.length; i++){
        if (guestList[i][0].equals(guestName)) {
            guestList [i][0] = guestNameNew;
            didChange = true;
            System.out.println("Guest " + guestName + " is now changed to " + guestNameNew);
            break;
        }
    } 

    if (!didChange) {
        System.out.println("Guest " + guestName + " was not found");
    }
}

// change age 
public static void changeAge(){
    System.out.println("Enter name of the guest you want to change:");
    String guestName = sc.nextLine();

    if (guestName.isEmpty()) {
        System.out.println("Guest name can't be empty. Type 'changeAge' and try again.");
        return;
    }

    System.out.println("Enter NEW age of the guest: ");
    String guestAgeNew = sc.nextLine();

    if (guestAgeNew.isEmpty()) {
        System.out.println("NEW guest age can't be empty. Type 'changeAge' and try again.");
        return;
    }

    boolean didChange = false;
    for (int i = 0; i < guestList.length; i++) {
      if (guestList[i][0].equals(guestName)) {
        guestList[i][1] = guestAgeNew;
        didChange = true;
        System.out.println("Age of guest " + guestName + " was changed to " + guestAgeNew);
        break;
      }
    }

    if (!didChange) {
      System.out.println("Guest " + guestName + " was not found");
    }
}

  // remove a guest
public static void remove() {
    System.out.println("Enter guest name to remove:");
    String guestName = sc.nextLine();

    if (guestName.isEmpty()) {
      System.out.println("Guest name can't be empty, type 'remove' and try again");
      return;
    }

    boolean didRemove = false;
    for (int i = 0; i < guestList.length; i++) {
      if (guestList[i][0].equals(guestName)) {
        guestList[i][0] = "";
        guestList[i][1] = "";
        guestCount = guestCount - 1;
        didRemove = true;
        System.out.println("Guest " + guestName + " was removed");
        break;
      }
    }

    if (!didRemove) {
      System.out.println("Guest " + guestName + " was not found");
    }
  }

// change places of the guests
  public static void changePlace() {
    // define place 1
    System.out.println("Enter the first place to switch, number between 0-9:");
    String place1 = sc.nextLine();

    if (place1.isEmpty()) {
      System.out.println("place can't be empty, type 'changePlace' and try again");
      return;
    }

    int place1Num;
    try {
      place1Num = Integer.parseInt(place1);
    } catch (Exception e) {
      System.out.println("place need to be numeric, type 'changePlace' and try again");
      return;
    }

    if (place1Num > 9 || place1Num < 0) {
      System.out.println("place need a number between 0-9, type 'changePlace' and try again");
      return;
    }

    // define place 2
    System.out.println("Enter the second place to switch, number between 0-9:");
    String place2 = sc.nextLine();

    if (place2.isEmpty()) {
      System.out.println("place can't be empty, type 'changePlace' and try again");
      return;
    }

    int place2Num;
    try {
      place2Num = Integer.parseInt(place2);
    } catch (Exception e) {
      System.out.println("place need to be numeric, type 'changePlace' and try again");
      return;
    }

    if (place2Num > 9 || place2Num < 0) {
      System.out.println("place need a number between 0-9, type 'changePlace' and try again");
      return;
    }

    if (place1Num == place2Num) {
      System.out.println("places you defined are the same, type 'changePlace' and try again");
      return;
    }

    String[] guest1 = guestList[place1Num];
    String[] guest2 = guestList[place2Num];
    
    System.out.println("Will switch place between " + guest1[0] + " and " + guest2[0]);
    guestList[place1Num] = guest2;
    guestList[place2Num] = guest1;

    System.out.println("Succesfully switched places between " + guestList[place1Num][0] + " and " + guestList[place2Num][0]);
  }

public static void main(String[] args){
    System.out.println("Hello and welcome to the guest office");
    menu();

        String input = "";
        do {
            input = sc.nextLine();

            if(input.equals("menu")) {
                menu();
            }

            if(input.equals("guestNames")){
                guestNames();
                menu();
            }

            if(input.equals("stats")){
                stats();
                menu();
            }

            if(input.equals("addGuest")){
                addGuest();
                menu();
            }

            if(input.equals("changeName")){
                changeName();
                menu();
            }

            if(input.equals("changeAge")){
                changeAge();
                menu();
            }

            if(input.equals("remove")){
                remove();
                menu();
            }

            if(input.equals("changePlace")){
                changePlace();
                menu();
            }

        } while(!input.equals("exit"));
        sc.close();
    }
}