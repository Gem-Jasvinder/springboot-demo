package com.gemini.completableFuture;

import org.apache.tomcat.jni.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@RestController
public class CompletableFutureController {

    public static final Logger logger= LoggerFactory.getLogger(CompletableFutureController.class);

    @Autowired
    private CompletableFutureService completableFutureService;

    @PostMapping("/user")
    public ResponseEntity setTheUser(@RequestBody List<CompletableFutureEntity> completableFutureEntities){
         List<CompletableFutureEntity> list =this.completableFutureService.setUser(completableFutureEntities);
         return  ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/getUser")
    public Object getTheUser(){
        ExecutorService excuetorServices= Executors.newFixedThreadPool(10);
           CompletableFuture<Object> future1= CompletableFuture.supplyAsync(()-> {
                        logger.info("Thread" +Thread.currentThread().getId());
                       return this.completableFutureService.getUser();
            },excuetorServices).thenApplyAsync((User)-> {
               logger.info("Thread" +Thread.currentThread().getId());
                       return User.stream().filter(user -> user.getRating().equals(5.0)).collect(Collectors.toList());
                   },excuetorServices).thenApplyAsync((User)->{
               logger.info("Thread" +Thread.currentThread().getId());
                       return User.stream().map(CompletableFutureEntity::getName).collect(Collectors.toList());
           },excuetorServices).handle((User,ex)->{
               if (ex!=null)return ex.getMessage();
               else return User;
           });
        CompletableFuture<Object> future2= CompletableFuture.supplyAsync(()-> {
            logger.info("Thread" +Thread.currentThread().getId());
            return this.completableFutureService.getUser();
        },excuetorServices).thenApplyAsync((User)-> {
            logger.info("Thread" +Thread.currentThread().getId());
            return User.stream().filter(user -> user.getAvailable().equals(true)).collect(Collectors.toList());
        },excuetorServices).thenApplyAsync((User)->{
            logger.info("Thread" +Thread.currentThread().getId());
            return User.stream().map(CompletableFutureEntity::getName).collect(Collectors.toList());
        },excuetorServices).handle((User,ex)->{
            if (ex!=null)return ex.getMessage();
            else return User;
        });
        CompletableFuture<Object> future3= CompletableFuture.supplyAsync(()-> {
            logger.info("Thread" +Thread.currentThread().getId());
            return this.completableFutureService.getUser();
        },excuetorServices).thenApplyAsync((User)-> {
            logger.info("Thread" +Thread.currentThread().getId());
            return User.stream().filter(user -> user.getTraining().equals(true)).collect(Collectors.toList());
        },excuetorServices).thenApplyAsync((User)->{
            logger.info("Thread" +Thread.currentThread().getId());
            return User.stream().map(CompletableFutureEntity::getName).collect(Collectors.toList());
        },excuetorServices).handle((User,ex)->{
            if (ex!=null)return ex.getMessage();
            else return User;
        });
        CompletableFuture<Object> listCompletableFuture=CompletableFuture.anyOf(future1,future2,future3);
        return listCompletableFuture.join();
    }


//    public CompletableFuture<List<CompletableFutureEntity>> getTheUser(){
//        CompletableFuture<List<CompletableFutureEntity>> list= CompletableFuture.supplyAsync(()-> {
//            return this.completableFutureService.getUser();
//        }).thenApplyAsync((User)-> {
//            return User.stream().filter(user -> user.getRating().equals(5.0)).collect(Collectors.toList());
//        }).thenApplyAsync((User)->{
//            return  User.stream().map(names ->{CompletableFutureEntity obj =new CompletableFutureEntity();
//                obj.setName(names.getName());
//                obj.setId(names.getId());
//                obj.setRating(names.getRating());
//                return obj;}).collect(Collectors.toList());
//        });
//        return list;
////    }





//    public CompletableFuture<List<CompletableFutureEntity>> getTheUser1(){
//        CompletableFuture<List<CompletableFutureEntity>> list= CompletableFuture.supplyAsync(()-> {
//            return getTheUser();
//        });
////            }).thenApplyAsync((User)-> {
////               return User.stream().filter(user -> "5.0".equals(user.getRating())).collect(Collectors.toList());
////            });
//        return list;
//    }
}