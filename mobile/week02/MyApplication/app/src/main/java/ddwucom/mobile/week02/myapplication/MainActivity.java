package ddwucom.mobile.week02.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

//    public void onClick (View v) {
//        EditText myEdit = findViewById(R.id.myEditText);
//
//        String msg = myEdit.getText().toString();
//
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//
//        myEdit.setText("Mobile!!");
//    }
}