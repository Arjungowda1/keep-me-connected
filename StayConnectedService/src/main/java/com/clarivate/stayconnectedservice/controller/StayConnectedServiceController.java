/**
 * 
 */
package com.clarivate.stayconnectedservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.stayconnectedservice.entity.Event;
import com.clarivate.stayconnectedservice.entity.Group;
import com.clarivate.stayconnectedservice.entity.User;
import com.clarivate.stayconnectedservice.entity.UserEvent;
import com.clarivate.stayconnectedservice.entity.UserGroup;
import com.clarivate.stayconnectedservice.service.StayConnectedServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



/**
 * @author Vidyashree Muralidhara
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/stayconnectedservice")
@Api(value = "stayconnectedservice")

public class StayConnectedServiceController {

	@Autowired
	StayConnectedServiceImpl stayConnectedService;

	@PostMapping("/authenticate")
	public String authenticateUser(@RequestBody User user) {
		boolean authenticated = false;
		if (user.getEmail() != null && user.getPassword() != null) {
			authenticated = stayConnectedService.authenicateUser(user.getEmail(), user.getPassword());
		}

		String message = (authenticated) ? "Success" : "failure";

		System.out.println("User authenticated : " + authenticated);
		return message;
	}
	
	@GetMapping("/userData/{email}")
	public User getNameByUserEmail(@PathVariable("email") String email)
	{
		return stayConnectedService.getInfoUserEmail(email);
		
	}
	
	@GetMapping("/allgroups")
	public List<Group> getAllGroups()
	{
		return stayConnectedService.getAllGroups();
		
	}
	
	@GetMapping("/groups/{email}")
	public List<Group> getGroupsByUserEmail(@PathVariable("email") String email)
	{
		return stayConnectedService.getGroupsByUserEmail(email);
		
	}
	
	//@ApiOperation(value = "Get all events by Group id", response = List.class)
	@GetMapping("/groupEvents/{groupId}")
	public List<Event> getEventsByGroup(@PathVariable("groupId") String groupId)
	{
		Long grpId = Long.parseLong(groupId);
		return stayConnectedService.getEventsByGroup(grpId);
		
	}
	@ApiOperation(value = "Get the list of members in a group")	
	@GetMapping("/groupUsers/{groupId}")
	public List<User> getGroupMembersByGroupId(@PathVariable("groupId") String groupId)
	{
		Long grpId = Long.parseLong(groupId);
		return stayConnectedService.getGroupMembersByGroupId(grpId);
	}
	
	@GetMapping("/userEvents/{email}")
	public List<Event> getEventsByUser(@PathVariable("email") String email)
	{
		return stayConnectedService.getEventsByUserEmail(email);
	}
	
	
	@PostMapping("/joinGroup")
	public String saveUsertoGroup(@RequestBody UserGroup userGroup)
	{
		return stayConnectedService.saveUsertoGroup(userGroup);
	}
	
	@PostMapping("/eventRegister")
	public String saveUsertoEvent(@RequestBody UserEvent userEvent)
	{
		return stayConnectedService.saveUsertoEvent(userEvent);
	}
	
}
