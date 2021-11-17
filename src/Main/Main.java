package Main;

import Manager.DBManager;
import Menu.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        DBManager.iniValues();
        if(DBManager.createConnection()!=null)
            Menu.mainMenu();
        else{
            Menu.configMenu();
            String userChoice="";
            while (!userChoice.equals("6")){
                userChoice=sc.next();
                switch (userChoice) {
                    case "1" -> changeUser(sc);
                    case "2" -> changePass(sc);
                    case "3" -> changeDB(sc);
                    case "4" -> changePort(sc);
                    case "5" -> changeHost(sc);
                }
            DBManager.setUrl();
            }
        }
    }

    private static void changeHost(Scanner sc) {
        Menu.askHost();
        String input = sc.next();
        DBManager.setHost(input);
    }

    private static void changePort(Scanner sc) {
        Menu.askPort();
        String input = sc.next();
        DBManager.setPort(input);
    }

    private static void changeDB(Scanner sc) {
        Menu.askDB();
        String input = sc.next();
        DBManager.setDataBase(input);
    }

    private static void changePass(Scanner sc) {
        Menu.askPassword();
        String input = sc.next();
        DBManager.setPass(input);
    }

    private static void changeUser(Scanner sc) {
        Menu.askUser();
        String input = sc.next();
        DBManager.setUser(input);
    }
}
