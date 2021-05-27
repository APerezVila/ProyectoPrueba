package com.cebem.aliciaProyect.Repositories;
import com.cebem.aliciaProyect.Models.SongModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<SongModel,Long>{
    
}
