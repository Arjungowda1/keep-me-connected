/**
 * 
 */
package com.clarivate.stayconnectedservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Vidyashree Muralidhara
 *
 */

@Entity
@Table (name="event")
@Getter
@Setter
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "event_generator")
	@SequenceGenerator(name = "event_generator", sequenceName = "event_seq", allocationSize = 1)
	Long eventId;
	
	@Column(name="event_name")
	String eventName;
	
	@Column(name="event_description")
	String eventDescription;
	
	@Column(name="event_date")
	String eventDate;
	
	@Column(name="event_time")
	String eventTime;
	
	@Column(name="event_time_timezone")
	String eventTimeTimezone;
	
	@Column(name="created_date")
	String createdDate;
	
	@Column(name="is_active")
	String isActive;
	
	@Column(name="max_participants")
	int maxParticipants;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventTimeTimezone() {
		return eventTimeTimezone;
	}

	public void setEventTimeTimezone(String eventTimeTimezone) {
		this.eventTimeTimezone = eventTimeTimezone;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}
	
	
}
