package ddwucom.review.week9.adapterviewtest;

import java.util.ArrayList;

public class DataManager {

    ArrayList<String> subjectList;

    public DataManager() {
        subjectList = new ArrayList<String>();
        subjectList.add("모바일 소프트웨어");
        subjectList.add("웹서비스");
        subjectList.add("컴퓨터 구조");
        subjectList.add("인터넷 프로그래밍");
        subjectList.add("정보보호개론");
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }
}
