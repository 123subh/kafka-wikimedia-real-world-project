package com.kafkaproject.springboot.Repo;

import com.kafkaproject.springboot.Entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepo extends JpaRepository<WikimediaData,Long> {
}
