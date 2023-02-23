package addressManagement;

import java.util.regex.Pattern;

public class JudgeData {
    String errorString;
    public JudgeData(Student student) {
        this.errorString = judgeData(student);
    };

    public String judgeData(Student student){
        //에러뜨면 에러메시지에 추가할 문자열
        String msg1 = "", msg2 = "", msg3 = "", msg4 = "", msg5 = "", msg6 = "";
        String error = "";    //위의 문자열중에 해당하는것만 error에 추가해줄
        String wstr = "";
        String nameExp = "^[가-힣]*$|^[a-zA-Z]*$";    //이름 pattern (형식) 포맷
        String ageExp = "^[0-9]*$";
        String phoneExp = "(02|010)-\\d{3,4}-\\d{4}";    //폰번호 포맷
        String birthDayExp = "\\d{4}\\d{2}\\d{2}";    //생일 포맷

        // infos[0] = name
        if (!Pattern.matches(nameExp, student.getName())) {    //패턴이 맞는지 확인하는 메소드
            msg1 = "이름에는 한글 또는 영어만 입력 가능합니다.\n";
        }
        //infos[1] = age
        if(!Pattern.matches(ageExp, student.getAge())){
            msg2 ="나이는 숫자만 입력할 수 있습니다.\n";
        }
        else if(Integer.parseInt(student.getAge()) > 200) {
            msg2 = "나이는 200살을 넘을 수 없습니다.\n";
        }
        //infos[2] = birthDay
        if (!Pattern.matches(birthDayExp, student.getBirthDay())) {
            msg3 = "생일은 (ex.19980101)형식으로 입력해주세요.\n";
        }
        //infos[3] = studentNum  / infos[4] = phoneNum
        if (!Pattern.matches(phoneExp, student.getPhoneNum())) {
            msg5 = "전화번호는 (ex.010-1234-5678)형식으로 입력해주세요\n";
        }
        if (student.getName().trim().isEmpty()
                || student.getAge().trim().isEmpty()
                || student.getBirthDay().trim().isEmpty()
                || student.getStudentNum().trim().isEmpty()
                || student.getPhoneNum().trim().isEmpty()) {
            msg6 = "\n!!!!!!!빈칸이 있습니다.!!!!!!!\n";
        }    //공백이 하나라도 있으면 맨 아래에 빈칸있다고 알려줌

        if ((msg1 != "") || (msg2 != "") || (msg3 != "")
                || (msg4 != "") || (msg5 != "") || (msg6 != "")) {
            error = msg1 + msg2 + msg3 + msg4 + msg5 + msg6;    //에러 뜬 부분은 위에서 msg1~6에 저장했음. error 변수에 다 합쳐줌
            return error;
        }
        else return "";
    }

}

