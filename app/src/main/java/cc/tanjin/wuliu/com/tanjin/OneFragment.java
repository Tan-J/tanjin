package cc.tanjin.wuliu.com.tanjin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanjin on 2019/11/18.
 */
public class OneFragment extends Fragment {
    private RollPagerView mRollViewPager;
    List<Shop3> list = new ArrayList<Shop3>();
    String[] name = {"计时器","计算器","计步器","电话","闹钟"," 相机","录像","百度地图"};
    int[] img = {R.mipmap.img_59,R.mipmap.img_61,R.mipmap.img_56,R.mipmap.img_60,R.mipmap.img_54,R.mipmap.
            img_photo,R.mipmap.img_video,R.mipmap.ic_launcher};
    ListView listView;
    Myadpter3 adf;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        mRollViewPager = (RollPagerView) view.findViewById(R.id.roll_view_pager);
        //设置播放时间间隔
        mRollViewPager.setPlayDelay(1000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW, Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);

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
                        Intent intent = new Intent(getActivity(),One_jsq.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(),One_jsq1.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(),One_jbq.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(),One_txl.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getActivity(),One_nz.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getActivity(),One_pz.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getActivity(),One_lx.class);
                        startActivity(intent6);
                        break;
                    /*case 7:
                        Intent intent7 = new Intent(getActivity(),One_map.class);
                        startActivity(intent7);
                        break;*/
                }
            }
        });
        return view;
    }

    //轮播图
    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.mipmap.img_68,
                R.mipmap.img_69,
                R.mipmap.img_70,
                R.mipmap.img_71,
                R.mipmap.img_72,
        };
        /*public static String[] URL = {
                "http://cdn-l.llsapp.com/connett/c3115411-3669-466d-8ef2-e6c42c690303",
                "http://7xjww9.com1.z0.glb.clouddn.com/Hopetoun_falls.jpg",
                "http://cdn.llsapp.com/crm_test_1449051526097.jpg",
        };*/
        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}
