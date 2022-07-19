package com.informations24h.informations24h.service;

import com.informations24h.informations24h.model.Photo;
import com.informations24h.informations24h.repository.PhotoRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PhotoService implements IPhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public void savePostPhoto(Photo photo, MultipartFile imageFile) throws Exception {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        photo.setPath(absolutePath + "/src/main/resources/static/postphoto/");
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(photo.getPath() + photo.getFileName());
        Files.write(path, bytes);
    }

    public void removePhotoImage(Photo photo) throws Exception {
        Path path = Paths.get(photo.getPath() + photo.getFileName());
        Files.delete(path);
    }

    @Override
    public List<Photo> listAll() {
        return photoRepository.findAll();
    }

    @Override
    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public Photo get(long id) {
        return photoRepository.getById(id);
    }

    @Override
    public void update(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public void delete(long id) {
        photoRepository.deleteById(id);
    }

    public Photo getPhotoByFileName(String fileName) {
        return photoRepository.getPhotoByFileName(fileName);
    }
}
