package com.example.admin.mvcproject.activity;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.admin.mvcproject.R;

public class VideoPlayer extends AppCompatActivity {
    private Button b1;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        b1 = (Button) findViewById(R.id.playbttn);
        videoView = (VideoView) findViewById(R.id.videoView);

    }

    public void videoplay(View view){
        String videopath = "android.resource://com.example.admin.mvcproject/"+ R.raw.yellow;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
