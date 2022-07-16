package com.gemini.completableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompletableFutureService {

    @Autowired
    private CompletableFutureRepo completableFutureRepo;


    public List<CompletableFutureEntity> setUser(List<CompletableFutureEntity> completableFutureEntities) {
        return completableFutureRepo.saveAll(completableFutureEntities);
    }

    public  List<CompletableFutureEntity> getUser(){
        return this.completableFutureRepo.findAll();
    }
}
