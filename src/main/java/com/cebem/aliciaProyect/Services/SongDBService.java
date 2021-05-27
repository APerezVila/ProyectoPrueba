package com.cebem.aliciaProyect.Services;

import com.cebem.aliciaProyect.Repositories.SongRepository;
import com.cebem.aliciaProyect.Models.SongModel;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongDBService {
    @Autowired
    SongRepository soRepository;

    public ArrayList<SongModel> getSongs(){
        return (ArrayList<SongModel>) soRepository.findAll();
    }

    public SongModel saveSong(SongModel song){
        return soRepository.save(song);
    }
}
