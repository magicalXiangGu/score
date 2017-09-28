package com.score.repository;

import com.score.entries.TeachingClassEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingClassRepository extends JpaRepository<TeachingClassEntry,String>{
}
