/**
 * 
 */
package com.clarivate.stayconnectedservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarivate.stayconnectedservice.entity.Event;
import com.clarivate.stayconnectedservice.entity.Group;
import com.clarivate.stayconnectedservice.entity.GroupEvent;
import com.clarivate.stayconnectedservice.entity.User;
import com.clarivate.stayconnectedservice.entity.UserEvent;
import com.clarivate.stayconnectedservice.entity.UserGroup;
import com.clarivate.stayconnectedservice.repo.EventRepo;
import com.clarivate.stayconnectedservice.repo.GroupEventRepo;
import com.clarivate.stayconnectedservice.repo.GroupRepo;
import com.clarivate.stayconnectedservice.repo.UserEventRepo;
import com.clarivate.stayconnectedservice.repo.UserGroupRepo;
import com.clarivate.stayconnectedservice.repo.UserRepo;
import com.clarivate.stayconnectedservice.service.impl.StayConnectedServiceI;

/**
 * @author Vidyashree Muralidhara
 *
 */
@Service
public class StayConnectedServiceImpl implements StayConnectedServiceI {

	@Autowired
	UserRepo userRepo;

	@Autowired
	EventRepo eventRepo;

	@Autowired
	GroupRepo groupRepo;

	@Autowired
	UserGroupRepo userGroupRepo;

	@Autowired
	UserEventRepo userEventRepo;

	@Autowired
	GroupEventRepo groupEventRepo;

	@Override
	public boolean authenicateUser(String email, String password) {
		User user = userRepo.findByEmail(email);
		return (user != null && user.getPassword().equals(password)) ? true : false;
	}

	@Override
	public List<Group> getGroupsByUser(Long userId) {

		List<UserGroup> userGroupList = userGroupRepo.findByUserId(userId);
		List<Group> groupList = new ArrayList<Group>();
		if (userGroupList != null) {

			for (UserGroup userGroup : userGroupList) {
				Long grpId = userGroup.getGroupId();
				Optional<Group> group = groupRepo.findById(grpId);
				if (group.isPresent()) {
					groupList.add(group.get());

				}
			}

		}
		return groupList;

	}

	@Override
	public List<Event> getEventsByGroup(Long groupId) {

		List<Event> eventList = new ArrayList<Event>();
		List<GroupEvent> groupEventList = groupEventRepo.findByGroupId(groupId);

		for (GroupEvent grpEvent : groupEventList) {
			Long eventId = grpEvent.getEventId();
			Optional<Event> event = eventRepo.findById(eventId);
			if (event.isPresent()) {
				eventList.add(event.get());
			}
		}

		return eventList;
	}

	@Override
	public List<User> getGroupMembersByGroupId(Long groupId) {

		List<User> memberList = new ArrayList<User>();
		List<UserGroup> userGroupList = userGroupRepo.findByGroupId(groupId);

		for (UserGroup userGroup : userGroupList) {
			Long userId = userGroup.getUserId();
			Optional<User> user = userRepo.findById(userId);
			if (user.isPresent()) {
				memberList.add(user.get());
			}
		}

		return memberList;
	}

	@Override
	public List<Event> getEventsByUser(Long userId) {

		List<Event> eventList = new ArrayList<Event>();
		List<UserEvent> userEventList = userEventRepo.findByUserId(userId);

		for (UserEvent userEvent : userEventList) {
			Long eventId = userEvent.getEventId();
			Optional<Event> event = eventRepo.findById(eventId);
			if (event.isPresent()) {
				eventList.add(event.get());
			}
		}
		return eventList;
	}

	@Override
	public List<User> getUsersByEvent(Long eventId) {

		List<User> userList = new ArrayList<User>();
		List<UserEvent> userEventList = userEventRepo.findByUserId(eventId);

		for (UserEvent userEvent : userEventList) {
			Long userId = userEvent.getUserId();
			Optional<User> user = userRepo.findById(userId);
			if (user.isPresent()) {
				userList.add(user.get());
			}
		}
		return userList;
	}

	@Override
	public List<Group> getGroupsByUserEmail(String email) {

		User user = userRepo.findByEmail(email);
		System.out.println("user : " + user);
		System.out.println("email : " + email);

		return getGroupsByUser(user.getUserId());

	}

	@Override
	public List<Event> getEventsByUserEmail(String email) {

		User user = userRepo.findByEmail(email);
		System.out.println("user : " + user);
		System.out.println("email : " + email);
		return getEventsByUser(user.getUserId());
	}

	@Override
	public String saveUsertoGroup(UserGroup ug) {
		String msg;
		if (ug.getGroupId() != null && ug.getUserId() != null) {
			userGroupRepo.save(ug);
			msg = "User added to group";
		} else {
			msg = "Failed adding user to group!";
		}
		return msg;

	}

	@Override
	public String saveUsertoEvent(UserEvent userEvent) {
		String msg;
		if (userEvent.getEventId() != null && userEvent.getUserId() != null) {
			userEventRepo.save(userEvent);
			msg = "User registered to event";
		} else {
			msg = "Failed registering user to the event!";
		}
		return msg;
	}

	public User getInfoUserEmail(String email) {
		User user = userRepo.findByEmail(email);
		return user;
	}

	public List<Group> getAllGroups() {
		return groupRepo.findAll();
	}

}
