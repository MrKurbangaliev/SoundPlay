package com.example.soundplay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    public PlaylistAdapter(@NonNull Context context, ArrayList<Playlist> playlist) {
        super(context, 0, playlist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.playlist_list_item, parent, false);
        }

        Playlist currentPlaylist = getItem(position);

        // Find the TextView in the playlist_list_item.xml layout with the ID playlist_title
        TextView playlistTitle = listItemView.findViewById(R.id.playlist_title);
        //Assign a song to a view
        playlistTitle.setText(currentPlaylist.getPlaylistTitle());

        // Find the ImageView in the playlist_list_item.xml layout with the ID playlist_picture
        ImageView playlistPicture = listItemView.findViewById(R.id.playlist_picture);
        //Assign an album art picture to a view
        playlistPicture.setImageResource(currentPlaylist.getPlaylistPicture());

        // Find the TextView in the playlist_list_item.xml layout with the ID playlist_picture
        TextView numberOfSongs = listItemView.findViewById(R.id.number_of_songs);
        //Assign an album art picture to a view
        numberOfSongs.setText(currentPlaylist.getNumberOfSongs());

        return listItemView;
    }
}
