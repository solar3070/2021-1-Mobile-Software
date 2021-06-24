package ddwu.com.mobile.exam.mycircletest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyCircle myCircle;
    private int color = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Custom View 객체*/
        myCircle = findViewById(R.id.myCircle);

        registerForContextMenu(myCircle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.memu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.bigger:
                myCircle.setR(myCircle.getR() + 50);
                break;
            case R.id.smaller:
                myCircle.setR(myCircle.getR() - 50);
                break;
        }
        myCircle.invalidate();
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch(v.getId()) {
            case R.id.myCircle:
                menu.setHeaderTitle("Change Color");
                getMenuInflater().inflate(R.menu.context_menu, menu);

                menu.getItem(color).setChecked(true);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.red:
                item.setChecked(true);
                myCircle.setPaintColor(Color.RED);
                color = 0;
                break;
            case R.id.green:
                item.setChecked(true);
                myCircle.setPaintColor(Color.GREEN);
                color = 1;
                break;
            case R.id.blue:
                item.setChecked(true);
                myCircle.setPaintColor(Color.BLUE);
                color = 2;
                break;
        }
        myCircle.invalidate();
        return super.onContextItemSelected(item);
    }
}
