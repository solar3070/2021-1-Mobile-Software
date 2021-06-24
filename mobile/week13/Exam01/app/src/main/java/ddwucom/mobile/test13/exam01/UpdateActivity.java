package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText id, food;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        id = findViewById(R.id.etUpdateId);
        food = findViewById(R.id.etUpdateFood);

        myDbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v) {
        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.btnUpdateFood:
                ContentValues row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, food.getText().toString());
                myDB.update(FoodDBHelper.TABLE_NAME, row, "_id=?", new String[] { id.getText().toString() });
                break;
            case R.id.btnUpdateCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        myDbHelper.close();
        finish();
    }
}
