package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText food, nation;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        food = findViewById(R.id.etAddFood);
        nation = findViewById(R.id.etAddNation);

        myDbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v) {
        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.btnAddFood:
                ContentValues row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, food.getText().toString());
                row.put(FoodDBHelper.COL_NATION, nation.getText().toString());
                myDB.insert(FoodDBHelper.TABLE_NAME, null, row);
                break;
            case R.id.btnAddCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        myDbHelper.close();
        finish();
    }
}
