package addressManagement;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class Student {
    private String name;
    private String age;
    private String birthDay;
    private String studentNum;
    private String phoneNum;
    private Map<String,Student> list = new Hashtable<>();


    public Student(String name, String age, String birthDay, String studentNum, String phoneNum) throws IOException {
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
        this.studentNum = studentNum;
        this.phoneNum = phoneNum;
        this.list = AddressList.getInstance();
        list.put(name,this);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
