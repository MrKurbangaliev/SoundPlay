package com.example.soundplay;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.soundplay.databinding.ListUniversalBinding;
import com.example.soundplay.Song;
import com.example.soundplay.SongAdapter;
import com.example.soundplay.databinding.ListUniversalBinding;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    private ListUniversalBinding binding;
    private ListView listView;

    ArrayList<Song> songs;
    int songPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ListUniversalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        songs = new ArrayList<>();
        songs.add(new Song("The Spin", "Greg Haines", "Moments Eluding", R.drawable.album_art_example));
        songs.add(new Song("While You Wait", "Chad Hewitt", "Whitespace", R.drawable.album_art_example));
        songs.add(new Song("The Mountain", "Ludovico Einaudi", "No album", R.drawable.album_art_example));
        songs.add(new Song("Naval", "Yann Tiersen", "Tabarly", R.drawable.album_art_example));
        songs.add(new Song("Reprise", "John Williams", "Schindler's List", R.drawable.album_art_example));
        songs.add(new Song("Rest", "Elijah Bossenbroek", "Carpe Lumen", R.drawable.album_art_example));
        songs.add(new Song("Reverie", "Claude Debussy", "Plays His Finest Works", R.drawable.album_art_example));
        songs.add(new Song("Ambre", "Nils Frahm", "No album", R.drawable.album_art_example));
        songs.add(new Song("Awake", "Megan Wofford", "Awake", R.drawable.album_art_example));
        songs.add(new Song("Leicester", "Lambert", "No album", R.drawable.album_art_example));
        songs.add(new Song("Plus tôt", "Alexandra Stréliski", "No album", R.drawable.album_art_example));

        SongAdapter itemsAdapter = new SongAdapter(this, songs);
        listView = binding.getRoot();
        listView.setAdapter(itemsAdapter);
        registerForContextMenu(listView);

        //Set an onClickListener for each item in the list which opens NowPlayingActivity.
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(SongsActivity.this, NowPlayingActivity.class);
            intent.putExtra("song_position", i);
            intent.putParcelableArrayListExtra("songs_list", songs);
            startActivity(intent);
        });

        // A long clickListener for capturing a position of an item for a context menu.
        listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            songPosition = i;
            return false;
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.songs_context_menu, menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_to_playlist:
                openPlaylistChooser();
                return true;
            case R.id.delete:
                removeItem();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    //TODO: finish add to playlist function.
    private void openPlaylistChooser() {
        Intent playlistIntent = new Intent(SongsActivity.this, PlaylistsActivity.class);
        playlistIntent.putExtra("song_to_be_added", songs.get(songPosition));
        startActivity(playlistIntent);
    }

    //TODO: finish remove option.
    private void removeItem() {
        Toast.makeText(SongsActivity.this, "Removes a song from the list", Toast.LENGTH_SHORT).show();
    }
}