package ddwucom.mobile.test13.exam02;

import android.content.ContentValues;
import android.content.Intent;
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
                Intent addIntent = new Intent(this, AddActivity.class);
                startActivity(addIntent);
                break;
            case R.id.btnUpdate:
                Intent updateIntent = new Intent(this, UpdateActivity.class);
                startActivity(updateIntent);
                break;
            case R.id.btnRemove:
                Intent removeIntent = new Intent(this, RemoveActivity.class);
                startActivity(removeIntent);
                break;
        }
        myDbHelper.close();
    }

}