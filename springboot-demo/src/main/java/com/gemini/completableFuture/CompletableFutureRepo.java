package com.gemini.completableFuture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletableFutureRepo extends JpaRepository<CompletableFutureEntity,Integer> {
}
