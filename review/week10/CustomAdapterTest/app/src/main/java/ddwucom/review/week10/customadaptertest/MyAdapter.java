package ddwucom.review.week10.customadaptertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<MyData> myDataList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList) {
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return myDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myDataList.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layout, parent, false);

            holder = new ViewHolder();

            holder.tvNo = convertView.findViewById(R.id.tvNo);
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvPhone = convertView.findViewById(R.id.tvPhone);
            holder.btnCheck = convertView.findViewById(R.id.btnCheck);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.btnCheck.setFocusable(false);

        holder.tvNo.setText(String.valueOf(myDataList.get(pos).get_id()));
        holder.tvNo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(context,  "번호: " + myDataList.get(pos).get_id(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        holder.tvName.setText(String.valueOf(myDataList.get(pos).getName()));
        holder.tvName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(context, "이름: " + myDataList.get(pos).getName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        holder.tvPhone.setText(String.valueOf(myDataList.get(pos).getPhone()));
        holder.tvPhone.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(context, "핸드폰: " + myDataList.get(pos).getPhone(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        holder.btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, myDataList.get(pos).getPhone() + "선택", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView tvNo;
        TextView tvName;
        TextView tvPhone;
        Button btnCheck;
    }
}
