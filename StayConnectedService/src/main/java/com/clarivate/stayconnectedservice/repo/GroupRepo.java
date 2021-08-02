/**
 * 
 */
package com.clarivate.stayconnectedservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clarivate.stayconnectedservice.entity.Group;

/**
 * @author Vidyashree Muralidhara
 *
 */

@Repository
public interface GroupRepo extends JpaRepository<Group, Long> {

}
