package ddwucom.mobile.test13.exam02;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    FoodDBHelper helper;

    EditText etFood;
    EditText etNation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        helper = new FoodDBHelper(this);

        etFood = findViewById(R.id.etAddFood);
        etNation = findViewById(R.id.etAddNation);
    }

    public void onClick(View v) {
        SQLiteDatabase myDB = helper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.btnAddFood:
                ContentValues row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, etFood.getText().toString());
                row.put(FoodDBHelper.COL_NATION, etNation.getText().toString());

                myDB.insert(FoodDBHelper.TABLE_NAME, null, row);

                setResult(RESULT_OK);
                break;
            case R.id.btnAddCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
