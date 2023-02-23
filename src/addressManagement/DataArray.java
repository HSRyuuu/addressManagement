package addressManagement;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class DataArray {
    private static String[][] data = null;
    private DataArray(){}

    public static String[][] getInstance() throws IOException {
        if(data==null){
            data = new String[50][5];
            data = dataArrayRefresh();
        }
        data = dataArrayRefresh();
        return data;
    }
    static String[][] dataArrayRefresh() throws IOException {
        String data[][] = new String[50][5];
        Map<String ,Student> map = new Hashtable<>();
        map = AddressList.getInstance();
        int first = 0;
        for(String s : map.keySet()){
            Student std = map.get(s);
            for(int i=0;i<5;i++){
                data[first][0] = std.getName();
                data[first][1] = std.getAge();
                data[first][2] = std.getBirthDay();
                data[first][3] = std.getStudentNum();
                data[first][4] = std.getPhoneNum();
            }
            first++;
        }
        return data;
    }

}
