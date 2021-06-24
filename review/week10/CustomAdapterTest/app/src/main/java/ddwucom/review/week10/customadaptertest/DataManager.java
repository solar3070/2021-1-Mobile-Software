package ddwucom.review.week10.customadaptertest;

import java.util.ArrayList;

public class DataManager {
    ArrayList<MyData> myDataList;

    public DataManager() {
        myDataList = new ArrayList<MyData>();

        myDataList.add(new MyData(1, "홍길동", "012345"));
        myDataList.add(new MyData(2, "전우치", "123456"));
        myDataList.add(new MyData(3, "일지매", "234567"));
        myDataList.add(new MyData(4, "홍길동", "012345"));
        myDataList.add(new MyData(5, "전우치", "123456"));
        myDataList.add(new MyData(6, "일지매", "234567"));
        myDataList.add(new MyData(7, "홍길동", "012345"));
        myDataList.add(new MyData(8, "전우치", "123456"));
        myDataList.add(new MyData(9, "일지매", "234567"));
        myDataList.add(new MyData(10, "홍길동", "012345"));
        myDataList.add(new MyData(11, "전우치", "123456"));
        myDataList.add(new MyData(12, "일지매", "234567"));
        myDataList.add(new MyData(13, "홍길동", "012345"));
        myDataList.add(new MyData(14, "전우치", "123456"));
        myDataList.add(new MyData(15, "일지매", "234567"));
    }

    public ArrayList<MyData> getMyDataList() {
        return myDataList;
    }

    public void removeData(int pos) {
        myDataList.remove(pos);
    }
}
