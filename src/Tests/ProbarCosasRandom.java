package Tests;

import Manager.DBManager;

public class ProbarCosasRandom {
    public static void main(String[] args) {
        DBManager.iniProperties();
        System.out.println(DBManager.executeTestQuery("SELECT * FROM ErrorTest"));
    }
}
