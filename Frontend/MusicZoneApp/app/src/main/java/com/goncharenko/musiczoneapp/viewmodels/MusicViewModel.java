package com.goncharenko.musiczoneapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.goncharenko.musiczoneapp.models.AudioModel;

import java.util.ArrayList;

public class MusicViewModel extends ViewModel {
    private MutableLiveData<ArrayList<AudioModel>> songsList = new MutableLiveData<>();

    public LiveData<ArrayList<AudioModel>> getSongsList() {
        return songsList;
    }

    public void setSongsList(ArrayList<AudioModel> songsList) {
        this.songsList.setValue(songsList);
    }
}