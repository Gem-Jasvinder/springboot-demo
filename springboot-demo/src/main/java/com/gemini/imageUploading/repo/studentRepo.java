package com.gemini.imageUploading.repo;

import com.gemini.imageUploading.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface studentRepo extends JpaRepository<Student, UUID> {
}
