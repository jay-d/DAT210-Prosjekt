package hibernate;

import java.util.ArrayList;
import java.util.Iterator;

import models.Subject;
import models.Field;
import models.User;

public class SubjectDBTest {


	public static void main(String[] args) {
		
		SubjectManagement sm = new SubjectManagement();
		FieldManagement fm = new FieldManagement();
		UserManagement um = new UserManagement();
		ConnectionManagement xm = new ConnectionManagement();
		
		Subject catJava = new Subject("Java", "THIS IS JAVAAAAA");
		Subject catCsharp = new Subject("C#", "Kinda like Java but not really");
		Subject catCplus = new Subject("C++", "Cplusplus");
		Subject catJavaScript = new Subject("JavaScript", "Programming language for adding dynamic elements in websites");
		Subject catPython = new Subject("Python", "Programming language, often used as scripting language");
		Subject catPerl = new Subject("Perl", "Programming language");
		
		sm.addSubject(catJava);
		sm.addSubject(catCsharp);
		sm.addSubject(catCplus);
		
		Field subJava3D = new Field("Java 3D", "Old 3D graphics API for n00bs", sm.getByTitle("Java").get(0));
		Field subJava2D = new Field("Java 2D", "2D Java graphics API", sm.getByTitle("Java").get(0));
		
		Field subCSh1 = new Field("C# field 1", "C# for everybody", sm.getByTitle("C#").get(0));
		Field subCSh2 = new Field("C#", "C# for extreme", sm.getByTitle("C#").get(0));
		Field subCSh3 = new Field("C#","C# General",sm.getByTitle("C#").get(0));
		Field subCpluss = new Field("C++","C++ General",sm.getByTitle("C++").get(0));
		
		fm.addField(subJava3D);
		fm.addField(subJava2D);
		fm.addField(subCSh1);
		fm.addField(subCSh2);
		fm.addField(subCSh3);
		fm.addField(subCpluss);
		
		User user1 = new User("Bob", "Smith", "bob@smith.com", "here", "", "345678");
		User user2 = new User("Glen", "Smiths", "basdfg@smith.com", "there", "",  "2323");
		User user3 = new User("Tom", "Smite", "bob@adrbafd.com", "over here", "", "7865425");
		User user4 = new User("Alex", "Smile", "bob@6ytghj.com", "over there", "", "456412");
		User user5 = new User("Dave", "Store", "bob@adfbafv.com", "here", "", "34898745");
		User user6 = new User("John", "Robertson", "65tghj@smith.com", "here", "", "3893564");
		
		um.addUser(user1);
		xm.createOpenMentor(user1, subCSh3);
		xm.createOpenMentor(user1, subJava2D);
		xm.createOpenTrainee(user1, subCpluss);
		xm.createOpenTrainee(user1, subJava3D);
		
		um.addUser(user2);
		xm.createOpenMentor(user2, subCSh2);
		xm.createOpenMentor(user2, subJava2D);
		xm.createOpenTrainee(user2, subJava3D);
		
		um.addUser(user3);
		xm.createOpenTrainee(user3, subCpluss);
		xm.createOpenTrainee(user3, subJava2D);
		
		um.addUser(user4);
		xm.createOpenMentor(user4, subCpluss);
		
		um.addUser(user5);
		xm.createOpenMentor(user5, subCpluss);
		xm.createOpenMentor(user5, subJava3D);
		xm.createOpenTrainee(user5, subCSh1);
		
		um.addUser(user6);
		xm.createOpenMentor(user6, subJava2D);
		xm.createOpenTrainee(user6, subJava3D);

		
		
		sm.getAllSubjects();
		
		sm.updateTitle(sm.getSingleByTitle("C#"), "C sharp");
		sm.updateDescription(sm.getSingleByTitle("C sharp"), "Cminusminus");
		
		System.out.println("-----------------------------------------------");
		
		sm.getAllSubjects();
		
		System.out.println("-----------------------------------------------");
		System.out.println(fm.getSingleByTitle("Java 3D").getSubject().getTitle());
		
		System.out.println("-----------------------------------------------");
		
		ArrayList<User> mentorTestList = (ArrayList<User>) fm.getMentors(subCpluss);
		if(mentorTestList.isEmpty()){
			System.out.println("EMPTY");
		}
		for(Iterator<User> iterator = mentorTestList.iterator(); iterator.hasNext();){
			User current = iterator.next();
			System.out.println(current.getFirstName() + " " + current.getLastName());
		}
		
		System.out.println("-----------------------------------------------");
		
		ArrayList<User> traineeTestList = (ArrayList<User>) fm.getTrainees(subJava3D);
		if(traineeTestList.isEmpty()){
			System.out.println("EMPTY");
		}
		for(Iterator<User> iterator = traineeTestList.iterator(); iterator.hasNext();){
			User current = iterator.next();
			System.out.println(current.getFirstName() + " " + current.getLastName());
		}
	}
}
