package ddwucom.mobile.week07.exam01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item01:
                Toast.makeText(this, "짜장면이 아주 맛있습니다!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item02:
                Toast.makeText(this, "짬뽕이 조금 비립니다.", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public void onMenuItem03Click(MenuItem item) {
        Toast.makeText(this, "김치찌개가 아주 환상입니다!", Toast.LENGTH_SHORT).show();
    }

    public void onMenuItem04Click(MenuItem item) {
        Toast.makeText(this, "순두부찌개에 해물이 없으면 좋겠어요.", Toast.LENGTH_SHORT).show();
    }
}