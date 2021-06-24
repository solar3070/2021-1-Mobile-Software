package ddwucom.review.week12.exam01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        editText = findViewById(R.id.editText2);

        Intent intent = getIntent();
        String txt = intent.getStringExtra("txt");

        editText.setText(txt);
    }

    public void onClick(View v) {
        finish();
    }
}
