package cc.tanjin.wuliu.com.tanjin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanjin on 2019/11/18.
 */
public class ThreeFragment extends Fragment {
    TextView tv;
    List<Shop3> list = new ArrayList<Shop3>();
    String[] name = {"我的相册","切换主题","我的收藏","我的钱包","我的文件","我的个性装扮"};
    int[] img = {R.mipmap.img_62,R.mipmap.img_zt,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.
            ic_launcher,R.mipmap.ic_launcher};
    ListView listView;
    Myadpter3 adf;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, null);
        tv = (TextView) view.findViewById(R.id.tv);
        listView = (ListView) view.findViewById(R.id.list1);
        //构造数据源
        for (int i = 0;i < name.length;i++){
            Shop3 hot = new Shop3();//新建实例类对象
            hot.setName(name[i]);
            hot.setImg(img[i]);
            list.add(hot);//添加数据到集合
        }
        //创建适配器
        adf = new Myadpter3(getActivity(),list);
        //绑定适配器
        listView.setAdapter(adf);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(getActivity(),Three_xc.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(),Three_qhzt.class);
                        startActivity(intent1);
                }
            }
        });
        return view;
    }
}
