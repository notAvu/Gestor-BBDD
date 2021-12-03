package Main;

import Manager.DBManager;
import Manager.QueryManager;
import Menu.Menu;

import java.util.Scanner;
//opciones:
//    Ejecutar cconsulta
//      ---dar opciones de mostrar to', el siguiente, el anterior, o el ultimo
//    Ejecutar DML
//    Ejecutar DDL
//    Configuracion de la conexion
//    Salir del programa


public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        DBManager.iniProperties();
        mainMenu(sc);
    }
    private static void mainMenu(Scanner sc) {
        boolean exit=false;
        String menuOption;
        while (!exit) {
            initialConfig(sc);
            menuOption= sc.next();
            switch (menuOption) {
                case "1" -> executeQuery(sc);
                case "3" -> executeDML(sc);
                case "2" -> executeDDL(sc);
                case "4" -> configMain(sc);
                case "5" -> exeQueryFromFile();
                case "6" -> exit=true;
            }
        }
    }
    private static void exeQueryFromFile() {
        QueryManager manager= new QueryManager("sqlQuery");
        DBManager.executeQuery(manager.readQuery());
    }
    private static void initialConfig(Scanner sc) {
        if(DBManager.createConnection()!=null) Menu.mainMenu();
        else configMain(sc);
    }
    private static void executeQuery(Scanner sc) {
        Menu.askQuery();
        String query=sc.next();
        query+= sc.nextLine();
        System.out.println(DBManager.executeQuery(query));
    }
    private static void executeDDL(Scanner sc) {
        Menu.askSqlSentence();
        String query=sc.next();
        query+= sc.nextLine();
        DBManager.executeDDL(query);
    }
    private static void executeDML(Scanner sc) {
        Menu.askSqlSentence();
        String query=sc.next();
        query+= sc.nextLine();
        DBManager.executeDML(query);
    }
    private static void configMain(Scanner sc) {
        String userChoice="";
        while (!userChoice.equals("6")){
            Menu.configMenu();
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
