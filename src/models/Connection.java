package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "CONNECTION")
public class Connection {
	
	@OneToMany(mappedBy = "connectionMentor")
	private User mentor;

	@OneToMany(mappedBy = "connectionTrainee")
	private User trainee;
	
	@ManyToOne
	@JoinColumn(name = "subject_fk")
	private Subject subject;
	
	@Id @GeneratedValue
	@Column(name = "connection_id")
	private int connectionID;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "difficulty_level")
	private int difficultyLevel;
	
	@OneToMany(mappedBy = "connection")
	@OrderBy("timestamp")
	private List<Comment> comments;
	
	public Connection(){
		
	}
	
	public Connection(User mentor, User trainee, Subject subject) {
		this.mentor = mentor;
		this.trainee = trainee;
		this.subject = subject;
		comments = new ArrayList<Comment>();
	}
	
	public Connection(User mentor, User trainee, Subject subject, int difficultyLevel) {
		this(mentor, trainee, subject);
		this.difficultyLevel = difficultyLevel;
	}

	public User getMentor() {
		return mentor;
	}

	public void setMentor(User mentor) {
		this.mentor = mentor;
	}

	public User getTrainee() {
		return trainee;
	}

	public void setTrainee(User trainee) {
		this.trainee = trainee;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	public int getConnectionID() {
		return connectionID;
	}

	public void setConnectionID(int connectionID) {
		this.connectionID = connectionID;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
