package models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "FIELD")
public class Field {

	@Id @GeneratedValue
	@Column(name = "field_id")
	private int fieldID;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "subject_fk")
	private Subject subject;
	
//	@OneToMany
//	@JoinColumn(name = "child_fk")
//	private List<Field> children;
//	
//	@OneToMany
//	@JoinColumn(name = "parent_fk")
//	private List<Field> parents;
	
	//TODO Ordered or indexed?
	@OneToMany(mappedBy = "field")
	@OrderBy("title")
	private List<Connection> connectionList;
	
	public Field(){
		
	}
	
	public Field(String title, String description, Subject subject) {
		this.title = title;
		this.description = description;
		this.subject = subject;
		active = true;
	}
	
	public int getFieldID() {
		return fieldID;
	}

	public void setfieldID(int fieldID) {
		this.fieldID = fieldID;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

//	public List<Field> getChildren() {
//		return children;
//	}
//
//	public void setChildren(List<Field> children) {
//		this.children = children;
//	}
//
//	public List<Field> getParents() {
//		return parents;
//	}
//
//	public void setParents(List<Field> parents) {
//		this.parents = parents;
//	}

	public List<Connection> getConnectionList() {
		return connectionList;
	}

	public void setConnectionList(List<Connection> connectionList) {
		this.connectionList = connectionList;
	}
	
	/* TODO broken many to many, using query via connection
	@ManyToMany(
			targetEntity = models.User.class,
			cascade = {CascadeType.ALL},
			mappedBy = "mentorList")
	private List<User> mentorUserList;
	
	@ManyToMany(
			targetEntity = models.User.class,
			cascade = {CascadeType.ALL},
			mappedBy = "traineeList")
	private List<User> traineeUserList;
	*/
	
	/*
	public List<User> getMentorUserList() {
		return  mentorUserList;
	}

	public void setMentorUserList(ArrayList<User> mentorUserList) {
		this.mentorUserList = mentorUserList;
	}

	public List<User> getTraineeUserList() {
		return traineeUserList;
	}

	public void setTraineeUserList(ArrayList<User> traineeUserList) {
		this.traineeUserList = traineeUserList;
	}
	*/
	
}
