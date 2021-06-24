package ddwucom.mobile.test13.exam02;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    FoodDBHelper helper;

    EditText etId;
    EditText etFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        helper = new FoodDBHelper(this);

        etId = findViewById(R.id.etUpdateId);
        etFood = findViewById(R.id.etUpdateFood);
    }

    public void onClick(View v) {
        SQLiteDatabase myDB = helper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.btnUpdateFood:
                ContentValues row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, etFood.getText().toString());

                String whereClause = FoodDBHelper.COL_ID + "=?";
                String[] whereArgs = new String[] { etId.getText().toString() };

                myDB.update(FoodDBHelper.TABLE_NAME, row, whereClause, whereArgs);

                setResult(RESULT_OK);
                break;
            case R.id.btnUpdateCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
