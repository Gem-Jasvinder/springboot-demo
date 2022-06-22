package com.gemini.imageUploading.service;

import com.gemini.imageUploading.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public interface studentServies {
    Student store(MultipartFile file) throws IOException;
    Student getFile(UUID id);
    Stream<Student> getAllFiles();
}
