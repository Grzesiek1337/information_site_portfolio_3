package com.informations24h.informations24h.service;

import com.informations24h.informations24h.model.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPhotoService {

    List<Photo> listAll();

    void save(Photo photo);

    Photo get(long id);

    void update(Photo photo);

    void delete(long id);

    void savePostPhoto(Photo photoDTO, MultipartFile imageFile) throws Exception;
}
