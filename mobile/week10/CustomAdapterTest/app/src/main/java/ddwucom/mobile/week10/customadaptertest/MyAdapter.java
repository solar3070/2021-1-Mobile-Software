package ddwucom.mobile.week10.customadaptertest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    final static String TAG = "MyAdapter";

    int count;
    private Context context;
    private int layout;
    private ArrayList<MyData> myDataList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList) {
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        count = 0;

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
        return myDataList.get(position).get_id ();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        ViewHolder viewHolder;

        Log.d(TAG, "call getView()");

        if (convertView == null) {
            convertView = layoutInflater.inflate(layout, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.tvNo = convertView.findViewById(R.id.tvNo);
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvPhone = convertView.findViewById(R.id.tvPhone);
            viewHolder.button = convertView.findViewById(R.id.button);

            convertView.setTag(viewHolder);

            Log.d(TAG, "count: " + count++);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

//        button.setFocusable(false);

        viewHolder.tvNo.setText(String.valueOf(myDataList.get(position).get_id()));
        viewHolder.tvName.setText(myDataList.get(position).getName());
        viewHolder.tvPhone.setText(myDataList.get(position).getPhone());

        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, myDataList.get(pos).getPhone() + " 선택", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView tvNo;
        TextView tvName;
        TextView tvPhone;
        Button button;
    }
}
