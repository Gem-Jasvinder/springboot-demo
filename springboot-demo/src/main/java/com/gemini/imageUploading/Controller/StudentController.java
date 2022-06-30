package com.gemini.imageUploading.Controller;

import com.gemini.imageUploading.entity.Student;
import com.gemini.imageUploading.entity.responseMessage;
import com.gemini.imageUploading.service.studentServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @Autowired
    private studentServies studentServies;

    @PostMapping("/upload")
    public ResponseEntity uploadFile(@RequestParam("file")MultipartFile file){
        String mess="";
        try {
            studentServies.store(file);
            mess = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(mess);

        }catch (Exception e){
            mess = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(mess);
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<responseMessage>> getListFiles(){
        List<responseMessage> files= studentServies.getAllFiles().map(dbFile ->{
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/").path((dbFile.getId()).toString()).toUriString();
            return new responseMessage(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateData(@RequestParam("file") MultipartFile file,@PathVariable UUID id) throws IOException {
        Student studentUpdate= studentServies.updateTheData(file, id);
        return ResponseEntity.accepted().contentType(MediaType.parseMediaType(studentUpdate.getType())).body(studentUpdate.getData());

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteData(@PathVariable UUID id){
        studentServies.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable UUID id) {
       Student student = studentServies.getFile(id);

    if (student == null){
        return ResponseEntity.notFound().build();
    }
       return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(student.getType())).body(student.getData());


//       if(student.getType().equals("text/plain")){
//           return ResponseEntity.ok()
//                   .contentType(st).body(student.getData());
//       }
//           return ResponseEntity.ok()
//                   .contentType(MediaType.IMAGE_JPEG).body(student.getData());


    }




}
