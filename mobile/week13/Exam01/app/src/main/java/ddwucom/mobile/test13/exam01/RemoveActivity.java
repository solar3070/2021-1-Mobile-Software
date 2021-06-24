package ddwucom.mobile.test13.exam01;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class RemoveActivity extends AppCompatActivity {

    EditText food;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        food = findViewById(R.id.etRemoveFood);
        myDbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v) {
        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.btnRemoveFood:
                String whereClause = "food=?";
                String[] whereArgs = new String[] { food.getText().toString() };
                myDB.delete(FoodDBHelper.TABLE_NAME, whereClause, whereArgs);
                break;
            case R.id.btnRemoveCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        myDbHelper.close();
        finish();
    }
}
