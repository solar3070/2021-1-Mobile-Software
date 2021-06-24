package ddwucom.mobile.week03.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMyButtonClick(View v) {
        EditText editName = findViewById(R.id.etName);
        String name = editName.getText().toString();

        EditText editPhone = findViewById(R.id.etPhone);
        String phone = editPhone.getText().toString();

        String msg = "안녕하세요, 저는 " + name + "입니다. 전화번호는 " + phone + "입니다.";

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void onMyExitButtonClick(View v) {
        finish();
    }
}