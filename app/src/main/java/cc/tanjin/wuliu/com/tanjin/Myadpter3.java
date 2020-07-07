package cc.tanjin.wuliu.com.tanjin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanjin on 2019/11/12.
 */
public class Myadpter3 extends BaseAdapter {
    List<Shop3> mlist = new ArrayList<Shop3>();
    Context mcontext;

    public Myadpter3(Context context, List<Shop3> list) {
        this.mcontext = context;
        this.mlist = list;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    //得到item的内容
    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    //得到item的位置
    @Override
    public long getItemId(int position) {
        return position;
    }

    //得到item的布局
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.item3,null);
        }
//        convertView = LayoutInflater.from(mcontext).inflate(R.layout.item,null);
        ImageView img = (ImageView) convertView.findViewById(R.id.img);
        img.setImageResource(mlist.get(position).getImg());
        TextView tv_name = (TextView) convertView.findViewById(R.id.text1);
        tv_name.setText(mlist.get(position).getName());
        return convertView;
    }
}
