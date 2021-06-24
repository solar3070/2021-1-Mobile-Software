package ddwucom.mobile.week04.calculatorsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    EditText text;
    int no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.etDisplay);
    }

    public void onClick(View v) {
        String number = text.getText().toString();

        switch (v.getId()) {
            case R.id.btn_1:
                number += "1";
                text.setText(number);
                break;
            case R.id.btn_2:
                number += "2";
                text.setText(number);
                break;
            case R.id.btn_plus:
                no = Integer.parseInt(number);
                text.setText("");
                break;
            case R.id.btn_equal:
                no += Integer.parseInt(number);
                text.setText(Integer.toString(no));
                break;
        }
    }
}