package Manager;

import java.io.*;

public class QueryManager {
    File sqlFile;
    FileReader fr;
    BufferedReader br;

    public QueryManager(File sqlFile, BufferedReader br, FileReader fr) {
        this.sqlFile = sqlFile;
        this.br = br;
        this.fr = fr;
    }
    public QueryManager(String filename) {
        this.sqlFile = new File(filename);
        iniReader();
    }

    public String readQuery()
    {
        String query = "";
        while(query!=null) {
            try {
                query=br.readLine().replace("GO",";");
            } catch (IOException e) {
                e.printStackTrace();
                query=null;
            }
        }
        return query;
    }

    private void iniReader() {
        try {
            fr = new FileReader(sqlFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(fr);
    }
}
