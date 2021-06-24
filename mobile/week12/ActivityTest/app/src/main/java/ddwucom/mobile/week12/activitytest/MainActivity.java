package ddwucom.mobile.week12.activitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final static int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-1234-5678"));
                startActivity(intent);

//                Intent intent = new Intent(MainActivity.this, SubActivity2.class);

//                String id = "dongduk";
//                intent.putExtra("id", id);
//
//                ArrayList<String> foods = new ArrayList<String>();
//                foods.add("사과");
//                foods.add("배");
//                foods.add("수박");
//
//                intent.putExtra("foods", foods);

//                startActivityForResult(intent, REQ_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    String result = data.getStringExtra("result_data");
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}