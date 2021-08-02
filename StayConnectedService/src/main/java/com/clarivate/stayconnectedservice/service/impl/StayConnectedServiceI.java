/**
 * 
 */
package com.clarivate.stayconnectedservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clarivate.stayconnectedservice.entity.Event;
import com.clarivate.stayconnectedservice.entity.Group;
import com.clarivate.stayconnectedservice.entity.User;
import com.clarivate.stayconnectedservice.entity.UserEvent;
import com.clarivate.stayconnectedservice.entity.UserGroup;

/**
 * @author Vidyashree Muralidhara
 *
 */

@Service
public interface StayConnectedServiceI {

	boolean authenicateUser(String email, String password);
	
	List<Group> getGroupsByUser(Long userId);
	
	List<Event> getEventsByGroup(Long groupId);
	
	List<User> getGroupMembersByGroupId(Long groupId);
	
	List<Event> getEventsByUser(Long userId);

	List<User> getUsersByEvent(Long eventId);

	List<Group> getGroupsByUserEmail(String emailId);

	List<Event> getEventsByUserEmail(String email);
	
	String saveUsertoGroup(UserGroup userGroup);

	String saveUsertoEvent(UserEvent userEvent);
	
	User getInfoUserEmail(String email);
	
	List<Group> getAllGroups();
	
}
