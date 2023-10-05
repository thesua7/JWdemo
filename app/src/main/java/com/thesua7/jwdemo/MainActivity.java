package com.thesua7.jwdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.cast.framework.CastContext;
import com.jwplayer.pub.api.JWPlayer;
import com.jwplayer.pub.api.configuration.PlayerConfig;
import com.jwplayer.pub.api.events.EventType;
import com.jwplayer.pub.api.events.FullscreenEvent;
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents;
import com.jwplayer.pub.api.license.LicenseUtil;
import com.jwplayer.pub.api.media.playlists.PlaylistItem;
import com.jwplayer.pub.view.JWPlayerView;

public class MainActivity extends AppCompatActivity implements VideoPlayerEvents.OnFullscreenListener {

    JWPlayerView mplayerView;

    CastContext castContext;


    JWPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new LicenseUtil().setLicenseKey(this, "xxxxxxx");
        mplayerView = findViewById(R.id.jwplayerview);
        mPlayer = mplayerView.getPlayer();


        // Handle hiding/showing of ActionBar
        mPlayer.addListener(EventType.FULLSCREEN, this);

        // Keep the screen on during playback


        // Load a media source
        PlayerConfig config = new PlayerConfig.Builder()
                .playlistUrl("https://cdn.jwplayer.com/v2/playlists/zOaL63oR?format=json ")
                .build();

        mPlayer.setup(config);

        // Get a reference to the CastContext


    }

    @Override
    public void onFullscreen(FullscreenEvent fullscreenEvent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}