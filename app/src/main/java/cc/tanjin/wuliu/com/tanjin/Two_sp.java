package cc.tanjin.wuliu.com.tanjin;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Two_sp extends AppCompatActivity {
    private VideoView videoView;
    private Button btn_start, btn_end;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_sp);
        initView();
    }

    private void initView() {
        videoView = (VideoView) findViewById(R.id.videoView);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_end = (Button) findViewById(R.id.btn_end);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }

            private void init() {
                videoView = (VideoView) findViewById(R.id.videoView);
                mediaController = new MediaController(Two_sp.this);
                //本地连接地址
                String uri = "android.resource://" + getPackageName() + "/" + R.raw.wy_sp;
                //网络连接地址
                //String uri = "https://gslb.miaopai.com/stream/P4DnrjGZ7PzC2LfQK9k2cAKEIw39GiixIBpIHA__.mp4";
                videoView.setVideoURI(Uri.parse(uri));
                videoView.setMediaController(mediaController);
                mediaController.setMediaPlayer(videoView);
                videoView.requestFocus();
                videoView.start();
            }
        });
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();
            }
        });
    }
}
