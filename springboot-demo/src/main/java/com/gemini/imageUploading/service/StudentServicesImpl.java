package com.gemini.imageUploading.service;

import com.gemini.imageUploading.entity.Student;
import com.gemini.imageUploading.repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class StudentServicesImpl implements studentServies {

    @Autowired
   private studentRepo studentRepo;

    @Override
    public Student store(MultipartFile file) throws IOException {
        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        Student student =new Student(fileName,file.getContentType(),file.getBytes());
        return studentRepo.save(student) ;
    }

    @Override
    public Student getFile(UUID id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public Stream<Student> getAllFiles() {
        return studentRepo.findAll().stream();
    }
}
