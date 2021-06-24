package ddwucom.mobile.week09.adapterviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SubjectManager subjectManager;
    ArrayAdapter<String> adapter;
    ListView listview;
    EditText editText;

    int selectedPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        데이터를 관리하는 별도의 클래스 사용
        subjectManager = new SubjectManager();

//        원본 데이터
        ArrayList<String> subjectList = subjectManager.getSubjectList();

//        일반 배열
//        String[] subjectList = {"모바일소프트웨어", "네트워크", "웹서비스", "운영체제", "웹프로그래밍2"};

//        xml에서 데이터를 가져와서 배열 생성
//        String[] subjectList = getResources().getStringArray(R.array.subjectList);

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, subjectList);

        listview = findViewById(R.id.listview);
        editText = findViewById(R.id.editText);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "pos:" + position, Toast.LENGTH_SHORT).show();
                editText.setText(subjectManager.getSubjectByPosition(position));
                selectedPos = position;
            }
        });

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                subjectManager.removeSubject(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnAdd:
                subjectManager.addSubject(editText.getText().toString());
                adapter.notifyDataSetChanged();
                break;
            case R.id.btnUpdate:
//                원본 데이터 수정(위치, 바꿀 값)
                subjectManager.updateSubject(selectedPos, editText.getText().toString());
//                원본 데이터 갱신 요청
                adapter.notifyDataSetChanged();
                break;
        }
    }



}