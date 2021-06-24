package ddwucom.mobile.week09.adapterviewtest;

import java.util.ArrayList;

public class SubjectManager {
    private ArrayList<String> subjectList;

    public SubjectManager() {
        subjectList = new ArrayList();
        subjectList.add("모바일소프트웨어");
        subjectList.add("네트워크");
        subjectList.add("웹서비스");
        subjectList.add("운영체제");
        subjectList.add("웹프로그래밍2");
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }

    public String getSubjectByPosition(int pos) {
        return subjectList.get(pos);
    }

//    추가
    public void addSubject(String subject) {
        subjectList.add(subject);
    }

//    삭제
    public void removeSubject(int pos) {
//        ArrayList에는 remove 메소드가 있음
        subjectList.remove(pos);
    }

//    수정
    public void updateSubject(int pos, String subject) {
        subjectList.set(pos, subject);
    }

}

