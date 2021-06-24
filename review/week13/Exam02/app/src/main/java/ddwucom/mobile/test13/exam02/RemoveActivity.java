package ddwucom.mobile.test13.exam02;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RemoveActivity extends AppCompatActivity {

    FoodDBHelper helper;

    EditText etFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        helper = new FoodDBHelper(this);

        etFood = findViewById(R.id.etRemoveFood);
    }

    public void onClick(View v) {
        SQLiteDatabase myDB = helper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.btnRemoveFood:
                String whereClause = FoodDBHelper.COL_FOOD + "=?";
                String[] whereArgs = new String[] { etFood.getText().toString() };

                myDB.delete(FoodDBHelper.TABLE_NAME, whereClause, whereArgs);

                setResult(RESULT_OK);
                break;
            case R.id.btnRemoveCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
