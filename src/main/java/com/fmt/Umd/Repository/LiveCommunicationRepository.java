package com.fmt.Umd.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmt.Umd.model.LiveCommunication;

@Repository
public interface LiveCommunicationRepository extends JpaRepository<LiveCommunication, Integer>{

	public List<LiveCommunication> findByLogtimestampLike(String logTimeStamp);
	
}
