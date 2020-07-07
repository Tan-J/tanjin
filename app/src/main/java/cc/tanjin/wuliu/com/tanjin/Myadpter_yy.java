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
public class Myadpter_yy extends BaseAdapter {
    List<Shop_yy> mlist = new ArrayList<Shop_yy>();
    Context mcontext;

    public Myadpter_yy(Context context, List<Shop_yy> list) {
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
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.item_yy,null);
        }
//        convertView = LayoutInflater.from(mcontext).inflate(R.layout.item,null);
        ImageView img = (ImageView) convertView.findViewById(R.id.img);
        img.setImageResource(mlist.get(position).getImg());
        TextView tv_name = (TextView) convertView.findViewById(R.id.text1);
        tv_name.setText(mlist.get(position).getName());
        TextView tv_size = (TextView) convertView.findViewById(R.id.text2);
        tv_size.setText(mlist.get(position).getSize());
        TextView tv_author = (TextView) convertView.findViewById(R.id.text3);
        tv_author.setText(mlist.get(position).getPrice());
        return convertView;
    }
}
