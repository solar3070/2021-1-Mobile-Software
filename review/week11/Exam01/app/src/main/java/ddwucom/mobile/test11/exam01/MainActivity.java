package ddwucom.mobile.test11.exam01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    DataManager dataManager;
    ArrayList<Food> foodList;

    AlertDialog.Builder builder;

//    int selectedIndex = 0;
//    boolean[] selectedIndex = { false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataManager = new DataManager();
        foodList = dataManager.getFoodList();

        listView = findViewById(R.id.listView);

        // Food 객체의 toString() 메소드가 호출되어 하나의 문자열로 처리됨
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList);

        listView.setAdapter(adapter);

        builder = new AlertDialog.Builder(MainActivity.this);

        // listView 롱클릭 이벤트 추가 (삭제)
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                final int pos = position;

                builder.setTitle("음식 삭제")
                        .setMessage(foodList.get(pos).getFood() + "을(를) 삭제하시겠습니까?")
//                        .setItems(R.array.foods, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                String[] foods = getResources().getStringArray(R.array.foods);
//                                Toast.makeText(MainActivity.this, foods[i] + "선택", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setSingleChoiceItems(R.array.foods, selectedIndex, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                selectedIndex = i;
//                            }
//                        })
//                        .setMultiChoiceItems(R.array.foods, selectedIndex, new DialogInterface.OnMultiChoiceClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
//                                selectedIndex[i] = b;
//                            }
//                        })
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dataManager.removeData(pos);
                                adapter.notifyDataSetChanged();
                            }
                        })
//                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                String[] foods = getResources().getStringArray(R.array.foods);
//                                Toast.makeText(MainActivity.this, foods[selectedIndex] + "선택", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int whichButton) {
//                                String[] foods = getResources().getStringArray(R.array.foods);
//                                String result = "";
//                                for (int i = 0; i < selectedIndex.length; i++) {
//                                    if (selectedIndex[i]) {
//                                        result += foods[i] + " ";
//                                    }
//                                }
//                                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
//                            }
//                        })
                        .setNegativeButton("취소", null)
                        .show();

                return true;
            }
        });
    }

    // 음식 추가 대화 상자
    public void onClick(View v) {
        final ConstraintLayout add_food_layout =
                (ConstraintLayout) View.inflate(this, R.layout.add_food_layout, null);

        builder.setTitle("음식 추가")
                .setView(add_food_layout)
                .setPositiveButton("추가", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText etFood = add_food_layout.findViewById(R.id.etFood);
                        EditText etNation = add_food_layout.findViewById(R.id.etNation);

                        Food food = new Food(etFood.getText().toString(), etNation.getText().toString());
                        dataManager.addData(food);

                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("취소", null)
                .show();
    }

}
