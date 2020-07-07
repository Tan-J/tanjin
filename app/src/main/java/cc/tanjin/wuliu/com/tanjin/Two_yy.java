package cc.tanjin.wuliu.com.tanjin;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Two_yy extends AppCompatActivity {
    List<Shop_yy> list = new ArrayList<Shop_yy>();
    String[] name = {"小小鸟","生来第一","喜欢你(Live)","只要有想见的人，就不是孤身一人","我选择的路","结束",};
    int[] img = {R.mipmap.img_wxy,R.mipmap.img_wsl,R.mipmap.img_tfboys,R.mipmap.
            img_wy,R.mipmap.img_wyf,R.mipmap.img_pause};
    String[] author = {"吴宣仪-小小鸟","汪苏泷-生来第一","王俊凯&王源&易烊千玺",
            "王源-嘻嘻","吴亦凡-我选择的路",""};
    String[] size = {"...","...","...","...","...","...",""};
    ListView listView;
    Myadpter_yy adf;
    MediaPlayer mediaPlayer;
    private boolean isPause = false;//定义是否暂停状态

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_yy);
        listView = (ListView) findViewById(R.id.lv);
        //构造数据源
        for (int i = 0;i < name.length;i++){
            Shop_yy hot = new Shop_yy();//新建实例类对象
            hot.setName(name[i]);
            hot.setImg(img[i]);
            hot.setPrice(author[i]);
            hot.setSize(size[i]);
            list.add(hot);//添加数据到集合
        }
        //创建适配器
        adf = new Myadpter_yy(this,list);
        //绑定适配器
        listView.setAdapter(adf);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this,list.get(position).getName(), Toast.LENGTH_LONG).show();
                switch (position){
                    case 0:
                        openrawMusic();
                        break;
                    case 1:
                        openrawMusic2();
                        break;
                    case 2:
                        openrawMusic3();
                        break;
                    case 3:
                        openrawMusic4();
                        break;
                    case 4:
                        openrawMusic5();
                        break;
                    case 5:
                        mediaPlayer.pause();
                        break;
                }
            }

            private void openrawMusic5() {
                mediaPlayer = MediaPlayer.create(Two_yy.this,R.raw.wyf);
                mediaPlayer.start();
            }

            private void openrawMusic4() {
                mediaPlayer = MediaPlayer.create(Two_yy.this,R.raw.wy_sp);
                mediaPlayer.start();
            }

            private void openrawMusic3() {
                mediaPlayer = MediaPlayer.create(Two_yy.this,R.raw.tfboys);
                mediaPlayer.start();
            }

            private void openrawMusic2() {
                mediaPlayer = MediaPlayer.create(Two_yy.this,R.raw.wsl);
                mediaPlayer.start();
            }

            private void openrawMusic() {
                mediaPlayer = MediaPlayer.create(Two_yy.this,R.raw.wxy);
                mediaPlayer.start();
            }
        });
    }
}
