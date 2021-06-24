package ddwucom.mobile.finalreport;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    final static String TAG = "MyAdapter";

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
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layout, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.foodImg = convertView.findViewById(R.id.foodImg);
            viewHolder.tvRestaurant = convertView.findViewById(R.id.tvRestaurant);
            viewHolder.tvMenu = convertView.findViewById(R.id.tvMenu);
            viewHolder.tvDate = convertView.findViewById(R.id.tvDate);
            viewHolder.tvTime = convertView.findViewById(R.id.tvTime);
            viewHolder.tvArea = convertView.findViewById(R.id.tvArea);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        int resId = context.getResources().getIdentifier(myDataList.get(position).getImgName(), "mipmap", context.getPackageName());

        viewHolder.foodImg.setImageResource(resId);
        viewHolder.tvRestaurant.setText(myDataList.get(position).getRestaurant());
        viewHolder.tvMenu.setText(myDataList.get(position).getMenu());
        viewHolder.tvDate.setText(myDataList.get(position).getDate());
        viewHolder.tvTime.setText(myDataList.get(position).getTime());
        viewHolder.tvArea.setText(myDataList.get(position).getArea());
        
        return convertView;
    }

    static class ViewHolder {
        ImageView foodImg;
        TextView tvRestaurant;
        TextView tvMenu;
        TextView tvDate;
        TextView tvTime;
        TextView tvArea;
    }
}
