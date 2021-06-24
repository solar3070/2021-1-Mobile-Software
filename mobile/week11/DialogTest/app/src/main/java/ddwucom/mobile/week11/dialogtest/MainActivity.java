package ddwucom.mobile.week11.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int selectedIndex = 0;
    boolean[] selectedItems = { false, false, false, false };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {

//        final String[] foodArray = {"라면", "김밥", "떡볶이", "오뎅"};

        final ConstraintLayout orderLayout = (ConstraintLayout) View.inflate(this, R.layout.order_layout, null);

        switch (v.getId()) {
            case R.id.button:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("대화상자 제목")
//                       .setMessage("대화상자 메시지")
//                        .setItems(R.array.foods, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                String[] foods = getResources().getStringArray(R.array.food);
//                                Toast.makeText(MainActivity.this, foods[which], Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setSingleChoiceItems(R.array.foods, selectedIndex, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                selectedIndex = which;
//                            }
//                        })
//                        .setMultiChoiceItems(R.array.foods, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                                selectedItems[which] = isChecked;
//                            }
//                        })
                        .setView(orderLayout)
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("확인버튼", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                String[] foods = getResources().getStringArray(R.array.foods);
//                                String result = "선택: ";
//                                for (int i = 0; i < selectedItems.length; i++) {
//                                    if (selectedItems[i]) {
//                                        result += foods[i] + " ";
//                                    }
//                                }

                                EditText etProduct = orderLayout.findViewById(R.id.etProduct);
                                EditText etQuantity = orderLayout.findViewById(R.id.etQuantity);
                                CheckBox cbPayment = orderLayout.findViewById(R.id.cbPayment);

                                String result = etProduct.getText() + " : " + etQuantity.getText() + " : " + cbPayment.isChecked();

//                                Toast.makeText(MainActivity.this, foods[selectedIndex] + "을(를) 선택", Toast.LENGTH_SHORT).show();
                                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("대기버튼", null)
                        .setNegativeButton("취소버튼", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setCancelable(false)
                        .show();

//                Dialog dlg = builder.create();
//                dlg.setCanceledOnTouchOutside(false);
//                dlg.show();

//                builder.show();

                break;
        }
//        finish();
    }
}