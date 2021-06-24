package ddwucom.mobile.week05.exam02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.myView);
    }

    public void onClick(View v) {
        Random random = new Random();

        int x = random.nextInt(myView.getWidth());
        int y = random.nextInt(myView.getHeight());
        int r = (random.nextInt(3) + 1) * 100;

        switch (v.getId()) {
            case R.id.button:
                myView.setCircleX(x);
                myView.setCircleY(y);
                myView.setCircleR(r);
                myView.invalidate();
                break;
        }
    }
}