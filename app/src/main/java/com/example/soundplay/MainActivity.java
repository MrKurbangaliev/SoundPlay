package com.example.soundplay;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.soundplay.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("  Sound Play");
            actionBar.setIcon(R.drawable.outline_headphones_24);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        final RelativeLayout playlists = binding.categoryPlaylists;
        final RelativeLayout songs = binding.categorySongs;
        final RelativeLayout albums = binding.categoryAlbums;
        final RelativeLayout downloads = binding.categoryDownloads;

        playlists.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, PlaylistsActivity.class)));

        songs.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SongsActivity.class)));

        albums.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AlbumsActivity.class)));

        downloads.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, DownloadsActivity.class)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_settings)
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        return super.onOptionsItemSelected(item);
    }
}