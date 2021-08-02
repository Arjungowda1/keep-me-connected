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
@Table(name="group_event_mapping")
@Getter
@Setter
public class GroupEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "group_event_mapping_generator")
	@SequenceGenerator(name = "group_event_mapping_generator", sequenceName = "group_event_mapping_seq", allocationSize = 1)
	Long id;
	
	@Column(name="group_id")
	Long groupId;
	
	@Column(name="event_id")
	Long eventId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	
	
}
