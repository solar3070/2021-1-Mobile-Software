package ddwucom.mobile.week03.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMyNumberButtonClick(View v) {
        EditText text = findViewById(R.id.editText);
        String num = text.getText().toString();

        switch (v.getId()) {
            case R.id.btnOne:
                num += "1";
                break;
            case R.id.btnTwo:
                num += "2";
                break;
            case R.id.btnThree:
                num += "3";
                break;
        }

        text.setText(num);
    }

    public void onMyClearButtonClick(View v) {
        EditText text = findViewById(R.id.editText);
        text.setText("");
    }
}