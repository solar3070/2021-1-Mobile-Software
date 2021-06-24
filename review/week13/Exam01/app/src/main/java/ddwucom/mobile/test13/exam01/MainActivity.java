package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);

        myDbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v) {
        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();

        switch(v.getId()) {
            case R.id.btnSelect:
                Cursor cursor = myDB.rawQuery("SELECT * FROM " + FoodDBHelper.TABLE_NAME, null);

                String result = "";
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID));
                    String food = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD));
                    String nation = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION));

                    result += id + ". " + food + " (" + nation + ")\n";
                }

                tvDisplay.setText(result);
                cursor.close();
                break;
            case R.id.btnAdd:
                ContentValues addRow = new ContentValues();
                addRow.put(FoodDBHelper.COL_FOOD, "치킨");
                addRow.put(FoodDBHelper.COL_NATION, "한국");

                myDB.insert(FoodDBHelper.TABLE_NAME, null, addRow);
                break;
            case R.id.btnUpdate:
                ContentValues updateRow = new ContentValues();
                updateRow.put(FoodDBHelper.COL_FOOD, "돈카츠");
                updateRow.put(FoodDBHelper.COL_NATION, "일본");

                String updateWhereClause = FoodDBHelper.COL_ID + "=?";
                String[] updateWhereArgs = new String[] { "1" };

                myDB.update(FoodDBHelper.TABLE_NAME, updateRow, updateWhereClause, updateWhereArgs);
                break;
            case R.id.btnRemove:
                String removeWhereClause = FoodDBHelper.COL_ID + "=?";
                String[] removeWhereArgs = new String[] { "2" };

                myDB.delete(FoodDBHelper.TABLE_NAME, removeWhereClause, removeWhereArgs);
                break;
        }
        myDbHelper.close();
    }

}