/**
 * 
 */
package com.clarivate.stayconnectedservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clarivate.stayconnectedservice.entity.Event;

/**
 * @author Vidyashree Muralidhara
 *
 */

@Repository
public interface EventRepo extends JpaRepository<Event,Long>{

}
