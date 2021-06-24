package ddwucom.mobile.test06.exam02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = (MyView) findViewById(R.id.myView);

        myView.setOnTouchListener(myTouchListener);
        myView.setOnLongClickListener(myLongClickListener);
    }

    View.OnTouchListener myTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            myView.setPosX(motionEvent.getX());
            myView.setPosY(motionEvent.getY());
            myView.invalidate();
            return false;
        }
    };

    View.OnLongClickListener myLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            myView.setPaintColor(Color.RED);
            myView.invalidate();
            return true;
        }
    };
}
