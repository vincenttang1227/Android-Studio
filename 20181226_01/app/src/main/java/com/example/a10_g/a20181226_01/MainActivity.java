package com.example.a10_g.a20181226_01;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivFront, ivStop, ivPlay, ivPause, ivNext, ivEnd;
    private ListView lvMusic;
    private TextView tvMusic;
    public MediaPlayer mediaPlayer;
    //歌曲名稱
    String[] songName = new String[]{"greensleeves", "mario", "songbird", "summersong", "tradewinds"};
    //歌曲資源
    int[] songFile = new int[]{R.raw.greensleeves, R.raw.mario, R.raw.songbird, R.raw.summersong,
            R.raw.tradewinds};
    private int cListItem = 0; //目前播放歌曲
    private Boolean flagPause = false; //暫停、播放flag

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivFront = findViewById(R.id.iv_front);
        ivStop = findViewById(R.id.iv_stop);
        ivPlay = findViewById(R.id.iv_play);
        ivPause = findViewById(R.id.iv_pause);
        ivNext = findViewById(R.id.iv_next);
        ivEnd = findViewById(R.id.iv_end);
        lvMusic = findViewById(R.id.lv_music);
        tvMusic = findViewById(R.id.tv_music);
        ivFront.setOnClickListener(Listener);
        ivStop.setOnClickListener(Listener);
        ivPlay.setOnClickListener(Listener);
        ivPause.setOnClickListener(Listener);
        ivNext.setOnClickListener(Listener);
        ivEnd.setOnClickListener(Listener);
        lvMusic.setOnItemClickListener(lvListener);

        mediaPlayer = new MediaPlayer();
        ArrayAdapter<String> adapSong = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songName);
        lvMusic.setAdapter(adapSong);
    }

    private ImageView.OnClickListener Listener = new ImageView.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_front:
                    frontSong();
                    break;
                case R.id.iv_stop:
                    if (mediaPlayer.isPlaying()) //是否正在播放
                        mediaPlayer.reset(); //重置MediaPlayer
                    break;
                case R.id.iv_play:
                    if (flagPause) {
                        mediaPlayer.start();
                        flagPause = false;
                    } else
                        playSong(songFile[cListItem]);
                    break;
                case R.id.iv_pause:
                    mediaPlayer.pause();
                    flagPause = true;
                    break;
                case R.id.iv_next:
                    nextSong();
                    break;
                case R.id.iv_end:
                    mediaPlayer.release();
                    finish();
                    break;
            }
        }
    };

    private ListView.OnItemClickListener lvListener = new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            cListItem = position; //取得點選位置
            playSong(songFile[cListItem]); //播放
        }
    };

    private void playSong(int song) {
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(MainActivity.this,song); //建立歌曲源
        mediaPlayer.start();
        tvMusic.setText("歌名："+songName[cListItem]); //更新歌名
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                nextSong(); //播放完後播下一首
            }
        });
        flagPause = false;
    }

    //下一首歌
    private void nextSong() {
        cListItem++;
        if (cListItem>= lvMusic.getCount()) //若到最後就移到第一首
            cListItem = 0;
        playSong(songFile[cListItem]);
    }

    //上一首歌
    private void frontSong() {
        cListItem--;
        if (cListItem < 0)
            cListItem = lvMusic.getCount() - 1; //若到第一首就移到最後
        playSong(songFile[cListItem]);
    }
}
