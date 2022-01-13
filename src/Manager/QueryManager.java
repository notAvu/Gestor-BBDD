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
        boolean exit=false;
        StringBuilder query = new StringBuilder();
        while(!exit) {
            try {
                String placeholder=br.readLine();
                if(placeholder!=null)
                query.append(placeholder.replace("GO", ";"));
                else exit=true;
            } catch (IOException e) {
                e.printStackTrace();
                exit=true;
            }
        }
        return query.toString();
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
