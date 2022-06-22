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

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable UUID id) {
       Student student = studentServies.getFile(id);

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
