package ddwucom.mobile.week06.eventtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        3. 뷰 클래스 생성 후 리스너를 구현하는 방법
//        MyView view = new MyView(this);
//        view.setOnTouchListener(view);
//        setContentView(view);

        setContentView(R.layout.activity_main);

        ConstraintLayout layout = findViewById(R.id.layout);

        final TextView textView = findViewById(R.id.textView);

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                Toast.makeText(MainActivity.this, "layout touch", Toast.LENGTH_SHORT).show();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    textView.setText("Layout Touch Down!!");
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    textView.setText("Layout Touch Up!!");
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    textView.setText("Layout Touch Move!!");
                }
                return true;
            }
        });


        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        // 1. 기본 방법 - 클래스 생성 후 적용
        MyClick myClick = new MyClick();
        button1.setOnClickListener(myClick);

        // 2. 액티비티가 리스너를 구현
        button2.setOnClickListener(this);

        //  4. 익명 클래스의 객체 사용
        button3.setOnClickListener(myClickListener);

        // 5. 익명 클래스의 임시 객체 사용
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "다섯 번째 익명 클래스 임시 객체 방식!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onMyClick(View v) {
        Toast.makeText(MainActivity.this, "위젯 방식!", Toast.LENGTH_SHORT).show();
    }

    // 2. 액티비티가 리스너를 구현
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "두 번째 activity 방식!", Toast.LENGTH_SHORT).show();

    }

    // 1. 기본 방법 - 클래스 생성 후 적용
    class MyClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "첫 번째 방식!", Toast.LENGTH_SHORT).show();
        }
    }

    //  4. 익명 클래스의 객체 사용
    View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "네 번째 익명 클래스 방식!", Toast.LENGTH_SHORT).show();
        }
    };

    //  3. 뷰 클래스 생성 후 리스너를 구현하는 방법
    class MyView extends View implements View.OnTouchListener {

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(Color.YELLOW);
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Toast.makeText(MainActivity.this, "세 번째 View 자체 구현 방식!", Toast.LENGTH_SHORT).show();
            return true; // 이벤트 처리 완료 시 true, 처리를 계속해야 할 경우 false (상위로 전달)
        }
    }

//    // 메소드 선언 <- 운영체제(시스템) 호출 method callback
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Toast.makeText(this, "Touch Event!!!", Toast.LENGTH_SHORT).show();
//        return true;
//    }
}