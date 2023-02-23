package addressManagement;

import java.io.*;
import java.util.Hashtable;
import java.util.Map;

public class AddressList  {
    private static Map<String ,Student> mainList = null;
    private AddressList() {
    }
    public static Map<String,Student> getInstance() throws IOException {
        if(mainList == null){
            mainList = new Hashtable<>();
            mainList = textFileToMap();
        }
        return mainList;
    }
    static Map<String,Student> textFileToMap() throws IOException {
        Map<String,Student> map = new Hashtable<>();
        String fname = "src/data/juso.txt";
        BufferedReader br = new BufferedReader((new FileReader(fname)));
        for(int i=0;;i++){
            if(!br.ready())break;
            else{
                String str = br.readLine();
                String[] personal = new String[5];
                personal = str.split("\t");
                Student student = new Student(personal[0],personal[1],personal[2],personal[3],personal[4]);
                map.put(student.getName(),student);
            }
        }
        br.close();
        return map;

    }

}
