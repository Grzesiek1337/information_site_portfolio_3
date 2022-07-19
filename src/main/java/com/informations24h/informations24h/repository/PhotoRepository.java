package com.informations24h.informations24h.repository;

import com.informations24h.informations24h.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Query("SELECT p FROM Photo p WHERE p.fileName = :fileName")
    Photo getPhotoByFileName(@Param("fileName") String fileName);
}
