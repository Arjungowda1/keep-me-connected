/**
 * 
 */
package com.clarivate.stayconnectedservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clarivate.stayconnectedservice.entity.UserEvent;

/**
 * @author Vidyashree Muralidhara
 *
 */

@Repository
public interface UserEventRepo extends JpaRepository<UserEvent, Long>{

	@Query(value ="select * from user_event_mapping where user_id=:userId", nativeQuery=true)
	List<UserEvent> findByUserId(@Param("userId")Long userId);
	
	@Query(value ="select * from user_event_mapping where event_id=:eventId", nativeQuery=true)
	List<UserEvent> findByEventId(@Param("eventId")Long eventId);
	
}
