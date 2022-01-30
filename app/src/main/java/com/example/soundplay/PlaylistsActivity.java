package com.example.soundplay;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.soundplay.databinding.ActivityPlaylistsBinding;
import com.example.soundstore.databinding.ActivityPlaylistsBinding;

public class PlaylistsActivity extends AppCompatActivity {

    private ActivityPlaylistsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlaylistsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
    }
}