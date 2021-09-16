package com.libary.repository;

import com.libary.model.Libary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibaryRepository extends JpaRepository<Libary, Long> {

}
