package ddwucom.mobile.week09.adapterviewtest01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataManager dataManager;
    ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataManager = new DataManager();

        ArrayList<String> catList = dataManager.getCatList();

        adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_multiple_choice, catList);

        listView = findViewById(R.id.listView);

        listView.setAdapter(adapter);
    }
}