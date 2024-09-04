package com.fmt.Umd.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fmt.Umd.model.LoadServey;
@Repository
public interface LoadServeyRepository extends JpaRepository<LoadServey, Long>{
    List<LoadServey> findByProcessedFalse();
    @Query("SELECT l FROM LoadServey l WHERE l.sequence_number = :sequenceNumber")
    LoadServey getBySequence(@Param("sequenceNumber") String sequenceNumber);   
}
