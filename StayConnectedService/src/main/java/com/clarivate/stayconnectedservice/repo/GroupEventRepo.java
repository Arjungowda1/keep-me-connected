/**
 * 
 */
package com.clarivate.stayconnectedservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clarivate.stayconnectedservice.entity.GroupEvent;

/**
 * @author Vidyashree Muralidhara
 *
 */

@Repository
public interface GroupEventRepo extends JpaRepository<GroupEvent, Long>{

	@Query(value="select * from group_event_mapping where group_id=:groupId",nativeQuery=true)
	List<GroupEvent> findByGroupId(@Param("groupId") Long groupId);
	
	
}
