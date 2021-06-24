package ddwucom.mobile.test08.adapterclicktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SubjectManager subjectManager;
    ArrayList<String> subjectList;
    ArrayAdapter<String> adapter; // 어댑터
    ListView listView; // 어댑터 뷰

    EditText text;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.etItem);

        subjectManager = new SubjectManager(); // 데이터매니저 객체 생성
        subjectList = subjectManager.getSubjectList(); // 데이터 받아옴

        // 어댑터
        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, subjectList
        );

        // 어댑터 뷰
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // 항목 클릭
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        pos = position;
                        text.setText(subjectList.get(position));
                    }
                };
        listView.setOnItemClickListener(itemClickListener);

        // 항목 롱 클릭
        AdapterView.OnItemLongClickListener itemLongClickListener =
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                        subjectManager.removeData(position);
                        adapter.notifyDataSetChanged();
                        return true;
                    }
                };
        listView.setOnItemLongClickListener(itemLongClickListener);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInsert:
                subjectManager.addData(text.getText().toString());
                break;
            case R.id.btnUpdate:
                subjectManager.updateData(pos, text.getText().toString());
                break;
        }
        adapter.notifyDataSetChanged();
    }

}
