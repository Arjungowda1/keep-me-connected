/**
 * 
 */
package com.clarivate.stayconnectedservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clarivate.stayconnectedservice.entity.User;

/**
 * @author Vidyashree Muralidhara
 *
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	@Query(value="select * from user_info where email=:email",nativeQuery = true)
	User findByEmail(@Param("email")String email);
	
}
