package com.example.soundplay;

import java.util.ArrayList;

public class Playlist extends ArrayList<Song> {
    private final String mPlaylistTitle;
    private int mPlaylistPicture;
    private int mNumberOfSongs;

    public Playlist(String playlistTitle, int drawableID, int numberOfSongs) {
        mPlaylistTitle = playlistTitle;
        mPlaylistPicture = drawableID;
        mNumberOfSongs = numberOfSongs;
    }

    /**
     * Get a title of a playlist.
     */
    public String getPlaylistTitle() {
        return mPlaylistTitle;
    }

    /**
     * Get an image for album art.
     */
    public int getPlaylistPicture() {
        return mPlaylistPicture;
    }

    /**
     * Set a number of songs in a playlist.
     */
    public void setNumberOfSongs(int numberOfSongs) {
        mNumberOfSongs = numberOfSongs;
    }

    /**
     * Get a number of songs in a playlist.
     */
    public String getNumberOfSongs() {
        return String.valueOf(mNumberOfSongs);
    }

}
