package ddwucom.review.week7.menutest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 컨텍스트 메뉴
        TextView text = (TextView) findViewById(R.id.text);
        registerForContextMenu(text);

        // 팝업 메뉴1 (텍스트뷰)
        TextView text2 = (TextView) findViewById(R.id.textView2);
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, v);

                popup.getMenuInflater().inflate(R.menu.menu_popup, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.hungry1:
                                Toast.makeText(MainActivity.this, "배고파", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.hungry2:
                                Toast.makeText(MainActivity.this, "배불러", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popup.show();
            }
        });

    }

    // 팝업 메뉴2 (버튼)
    public void onPopupMenuClick(View v) {
        PopupMenu popup = new PopupMenu(this, v);

        popup.getMenuInflater().inflate(R.menu.menu_popup, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.hungry1:
                        Toast.makeText(MainActivity.this, "배고파", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.hungry2:
                        Toast.makeText(MainActivity.this, "배불러", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        popup.show();
    }

    // 옵션 메뉴
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.chineseFood1:
                Toast.makeText(this, "짜장면 좋아!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.chineseFood2:
                Toast.makeText(this, "짬뽕 싫어!", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public void onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.koreanFood1:
                Toast.makeText(this, "김치찌개 좋아!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.koreanFood2:
                Toast.makeText(this, "순두부찌개 좋지!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // 컨텍스트 메뉴
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);

        menu.add(0, 3, 0, "비");
        menu.add(0, 4, 0, "눈");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.weather1:
                Toast.makeText(this, "오늘은 맑음", Toast.LENGTH_SHORT).show();
                break;
            case R.id.weather2:
                Toast.makeText(this, "오늘은 흐림", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}