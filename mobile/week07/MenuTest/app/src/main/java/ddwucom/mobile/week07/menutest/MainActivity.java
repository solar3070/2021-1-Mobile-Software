package ddwucom.mobile.week07.menutest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    final static int MENU_FIRST = 100;
    final static int MENU_SECOND = 200;

    PopupMenu popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. 컨텍스트 메뉴, 3. 팝업 메뉴
        //TextView textView = findViewById(R.id.textView);

        /* 3. 팝업 메뉴
        popup = new PopupMenu(this, textView);

        popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, "HI!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popup.show();
                return true;
            }
        });*/


       /* 2. 컨텍스트 메뉴
       registerForContextMenu(textView);*/
    }
    /* 2. 컨텍스트 메뉴
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch(v.getId()) {
            case R.id.textView:
                menu.setHeaderTitle("Context Menu!");
                menu.add(0, MENU_FIRST, 0, "FIRST");
                menu.add(0, MENU_SECOND, 0, "SECOND");

                getMenuInflater().inflate(R.menu.menu_context, menu);

                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case MENU_FIRST:
                Log.i(TAG, "context 1");
                break;
            case MENU_SECOND:
                Log.i(TAG, "context 2");
                break;
            case R.id.third:
                Log.i(TAG, "context 3");
                break;
            case R.id.fourth:
                Log.i(TAG, "context 4");
                break;
        }
        return super.onContextItemSelected(item);
    }*/

    //  1. 옵션 메뉴
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.group_menu, menu);
        return true;
    }

//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        if(true) {
//            menu.clear();
//            getMenuInflater().inflate(R.menu.menu_main, menu);
//        }
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.gItem01:
            case R.id.gItem02:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                break;
            case R.id.gItem03:
            case R.id.gItem04:
                item.setChecked(true);
                break;
        }
        return true;
    }

    public void onMenuItemClick (MenuItem item) {
        Log.i(TAG, "item01 is clicked!!!");
    }
}