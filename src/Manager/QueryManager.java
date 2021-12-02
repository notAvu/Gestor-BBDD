package Manager;

import java.io.*;

public class QueryManager {
    File sqlFile;
    FileWriter fw;
    FileReader fr;
    BufferedWriter bw;
    BufferedReader br;

    public QueryManager(File sqlFile, FileWriter fw, BufferedWriter bw, BufferedReader br, FileReader fr) {
        this.sqlFile = sqlFile;
        this.fw = fw;
        this.bw = bw;
        this.br = br;
        this.fr = fr;
    }

    public void readQuery()
    {
        String query;

    }
    public QueryManager(String filename) {
        this.sqlFile = new File(filename);
        iniReader();
    }

    private void iniReader() {
//        try {
//            fw = new FileWriter(sqlFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        bw = new BufferedWriter(fw);
        try {
            fr = new FileReader(sqlFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(fr);
    }
}
