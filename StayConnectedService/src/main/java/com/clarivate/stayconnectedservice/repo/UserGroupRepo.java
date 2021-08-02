/**
 * 
 */
package com.clarivate.stayconnectedservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clarivate.stayconnectedservice.entity.UserGroup;

/**
 * @author Vidyashree Muralidhara
 *
 */

@Repository
public interface UserGroupRepo extends JpaRepository<UserGroup, Long> {

	@Query(value="select * from user_group_mapping where user_id =:userId",nativeQuery = true)
	List<UserGroup> findByUserId(@Param("userId") Long userId);

	@Query(value="select * from user_group_mapping where group_id = :groupId",nativeQuery = true)
	List<UserGroup> findByGroupId(@Param("groupId") Long groupId);
	
	@Query(value="select  from user_group_mapping where group_id = :groupId",nativeQuery = true)
	Long findLastSequence();
	
	
}
