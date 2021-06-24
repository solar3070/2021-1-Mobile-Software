package ddwucom.mobile.week04.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.linear_layout);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_vertical:
                layout.setOrientation(LinearLayout.VERTICAL);
                break;
            case R.id.btn_horizontal:
                layout.setOrientation(LinearLayout.HORIZONTAL);
                break;
        }
    }
}