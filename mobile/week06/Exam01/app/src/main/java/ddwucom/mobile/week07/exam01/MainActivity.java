package ddwucom.mobile.week07.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnDisplay);

        /* 2.1 리스너 인터페이스 구현 클래스
        MyClick myClick = new MyClick();
        btn.setOnClickListener(myClick);*/

        /* 2.4 익명 내부 클래스 구현
        btn.setOnClickListener(myClickListener);*/

        // 2.5 익명 내부 클래스의 임시 객체 구현
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.editText);
                String msg = editText.getText().toString();

                TextView textView = findViewById(R.id.tvDisplay);
                textView.setText(msg);
            }
        });
    }

    // 3. 위젯 이벤트 처리
    /* public void onClick(View v) {
        EditText editText = findViewById(R.id.editText);
        String msg = editText.getText().toString();

        TextView textView = findViewById(R.id.tvDisplay);
        textView.setText(msg);
    }*/

    // 2.1 리스너 인터페이스 구현 클래스
    /*class MyClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText editText = findViewById(R.id.editText);
            String msg = editText.getText().toString();

            TextView textView = findViewById(R.id.tvDisplay);
            textView.setText(msg);
        }
    }*/

    // 2.4 익명 내부 클래스 구현
    /*View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText editText = findViewById(R.id.editText);
            String msg = editText.getText().toString();

            TextView textView = findViewById(R.id.tvDisplay);
            textView.setText(msg);
        }
    };*/
}