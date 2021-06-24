package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    ImageView image;
    EditText etRestaurant;
    EditText etMenu;
    EditText etArea;
    EditText etTime;

    DatePicker datePicker;
    String date;

    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        image = findViewById(R.id.img);
        etRestaurant = findViewById(R.id.add_restaurant);
        etMenu = findViewById(R.id.add_menu);
        etArea = findViewById(R.id.add_area);
        etTime = findViewById(R.id.add_time);
        datePicker = findViewById(R.id.datePicker);

        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date = year + "/" + (monthOfYear + 1) + "/" + dayOfMonth;
                    }
                });

        image.setImageResource(R.mipmap.cherryblossom);

        dbManager = new DBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                boolean result = dbManager.addNewRecord(new MyData(
                        null,
                        "@mipmap/cherryblossom",
                        etRestaurant.getText().toString(),
                        etMenu.getText().toString(),
                        date,
                        etTime.getText().toString(),
                        etArea.getText().toString()
                ));

                if (result) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("data", etRestaurant.getText().toString());
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {
                    Toast.makeText(this, "새로운 기록 추가 실패!", Toast.LENGTH_SHORT).show();
                }

                if (etRestaurant.getText().toString().length() == 0) {
                    Toast.makeText(this,"가게를 입력해주세요!", Toast.LENGTH_LONG).show();
                } else if (etMenu.getText().toString().length() == 0) {
                    Toast.makeText(this,"메뉴를 입력해주세요!", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btn_add_cancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}