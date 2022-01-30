package com.example.soundplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.soundplay.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final RelativeLayout playlists = binding.categoryPlaylists;
        final RelativeLayout songs = binding.categorySongs;
        final RelativeLayout albums = binding.categoryAlbums;
        final RelativeLayout downloads = binding.categoryDownloads;

        playlists.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, PlaylistsActivity.class)));

        songs.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SongsActivity.class)));

        albums.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AlbumsActivity.class)));

        downloads.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, DownloadsActivity.class)));
    }
}