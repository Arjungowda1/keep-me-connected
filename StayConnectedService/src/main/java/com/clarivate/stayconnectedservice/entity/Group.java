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
@Table (name="group_info")
@Getter
@Setter
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "group_generator")
	@SequenceGenerator(name = "group_generator", sequenceName = "group_info_seq", allocationSize = 1)
	Long groupId;
	
	@Column(name="group_name")
	String groupName;
	
	@Column(name="group_description")
	String groupDescription;
	
	@Column(name="created_date")
	String createdDate;
	
	@Column(name="is_active")
	String isActive;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
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
	
	
}
