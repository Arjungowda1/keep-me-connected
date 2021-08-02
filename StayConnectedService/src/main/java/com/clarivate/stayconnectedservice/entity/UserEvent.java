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
@Table (name="user_event_mapping")
@Getter
@Setter
public class UserEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_event_mapping_generator")
	@SequenceGenerator(name = "user_event_mapping_generator", sequenceName = "user_event_mapping_seq", allocationSize = 1)
	Long id;
	
	@Column (name="user_Id")
	Long userId;
	
	@Column (name="event_Id")
	Long eventId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	
	
}
