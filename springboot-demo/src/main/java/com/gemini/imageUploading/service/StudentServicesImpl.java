package com.gemini.imageUploading.service;

import com.gemini.SpringbootDemoApplication;
import com.gemini.imageUploading.entity.Student;
import com.gemini.imageUploading.repo.studentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class StudentServicesImpl implements studentServies {

    public static final Logger logger= LoggerFactory.getLogger(StudentServicesImpl.class);

//    boolean flag=false;

    @Autowired
   private studentRepo studentRepo;


    @Override
    public Student store(MultipartFile file) throws IOException {
        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        Student student =new Student(fileName,file.getContentType(),file.getBytes());
        return studentRepo.save(student) ;
    }

    @Override
    @Cacheable(cacheNames = "Students",key = "#id")
    public Student getFile(UUID id) {
        logger.info("Fetch From the db");
        try {
            return studentRepo.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Stream<Student> getAllFiles() {
        return studentRepo.findAll().stream();
    }

    @Override
    @CacheEvict(cacheNames = "Students",key="#id",allEntries = true)
    public void deleteById(UUID id) {
        studentRepo.deleteById(id);
    }

    @Override
    @CachePut(cacheNames = "Students",key = "#id")
    public Student updateTheData(MultipartFile file,UUID id) throws IOException {
        Student s1 = studentRepo.findById(id).get();
        s1.setName(file.getOriginalFilename());
        s1.setType(file.getContentType());
        s1.setData(file.getBytes());
        return studentRepo.save(s1);
    }

//    @Scheduled(fixedDelay = 120000,initialDelay =60000)
//    @CacheEvict(cacheNames = "Students",allEntries = true)
//    public void evictDatabase(){
//        logger.info("Cache is clear");
//    }



}
