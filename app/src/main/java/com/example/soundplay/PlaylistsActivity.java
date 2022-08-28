package com.example.soundplay;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import com.example.soundplay.databinding.CreatePlaylistScreenBinding;
import com.example.soundplay.databinding.ListUniversalBinding;
import com.example.soundplay.databinding.PlaylistListItemBinding;

import java.util.ArrayList;

public class PlaylistsActivity extends AppCompatActivity {

    private ListUniversalBinding binding;
    private ListView listView;
    private CreatePlaylistScreenBinding createPlaylistBinding;
    private PlaylistListItemBinding playlistsBinding;
    ArrayList<Playlist> listOfPlaylists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ListUniversalBinding.inflate(getLayoutInflater());
        createPlaylistBinding = CreatePlaylistScreenBinding.inflate(getLayoutInflater());
        playlistsBinding = PlaylistListItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        listOfPlaylists = new ArrayList<>();

        PlaylistAdapter itemsAdapter = new PlaylistAdapter(this, listOfPlaylists);
        listView = binding.getRoot();
        listView.setAdapter(itemsAdapter);
        registerForContextMenu(listView);

        if (listOfPlaylists.size() == 0) {
            createNewPlaylist();
        } else if (listOfPlaylists.size() != 0) {
            displayPlaylists();
        }

        Intent intent = getIntent();

        createPlaylistBinding.saveButton.setOnClickListener(view -> {
            listOfPlaylists.add(new Playlist(createPlaylistBinding.playlistTitle.getText().toString(),
                    R.drawable.album_art_example,
                    1));
            displayPlaylists();
        });

    }
    private void createNewPlaylist() {
        setContentView(createPlaylistBinding.getRoot());
    }

    private void displayPlaylists() {
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_new_item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_add) {
            createNewPlaylist();
        }
        return super.onOptionsItemSelected(item);
    }
}