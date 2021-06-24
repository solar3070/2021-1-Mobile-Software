package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Integer.parseInt;

public class UpdateActivity extends AppCompatActivity {

    MyData myData;

    ImageView foodImage;
    EditText etRestaurant;
    EditText etMenu;
    EditText etArea;
    EditText etTime;

    DatePicker datePicker;
    String date_str;

    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        myData = (MyData) getIntent().getSerializableExtra("data");

        foodImage = findViewById(R.id.foodImage);
        etRestaurant = findViewById(R.id.et_restaurant);
        etMenu = findViewById(R.id.et_menu);
        etArea = findViewById(R.id.et_area);
        etTime = findViewById(R.id.et_time);
        datePicker = findViewById(R.id.datePicker);

        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date_str = year + "/" + (monthOfYear + 1) + "/" + dayOfMonth;
            }
        });

        DatePicker.OnDateChangedListener listener = new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date_str = year + "/" + (monthOfYear + 1) + "/" + dayOfMonth;
            }
        };

        foodImage.setImageResource(getResources().getIdentifier(myData.getImgName(), "mipmap", getPackageName()));
        etRestaurant.setText(myData.getRestaurant());
        etMenu.setText(myData.getMenu());
        etArea.setText(myData.getArea());
        etTime.setText(myData.getTime());

        String[] date = myData.getDate().split("/");
        int year = parseInt(date[0]);
        int month = parseInt(date[1]);
        int day = parseInt(date[2]);
        datePicker.init(year, month - 1, day, listener);

        dbManager = new DBManager(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_update:
                myData.setRestaurant(etRestaurant.getText().toString());
                myData.setMenu(etMenu.getText().toString());
                myData.setArea(etArea.getText().toString());
                myData.setTime(etTime.getText().toString());
                myData.setDate(date_str);

                if (dbManager.updateRecord(myData)) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("myData", myData);
                    setResult(RESULT_OK, resultIntent);
                } else {
                    setResult(RESULT_CANCELED);
                }

                if (etRestaurant.getText().toString().length() == 0) {
                    Toast.makeText(this,"가게를 입력해주세요!", Toast.LENGTH_LONG).show();
                } else if (etMenu.getText().toString().length() == 0) {
                    Toast.makeText(this,"메뉴를 입력해주세요!", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}