package business.search;

import java.util.ArrayList;
import java.util.List;

import models.User;

import business.user.UserHandler;

public class SearchEngine {

	private UserHandler userHandler;

	public SearchEngine(){
		userHandler = new UserHandler();
	}
	private static boolean hasBeenRun = false;
	public void createDummyData(){
		if(!hasBeenRun){
			userHandler.addUser(new User("openID", "Thomas", "Hinna", "email", "location"));
			userHandler.addUser(new User("openID", "Thomas", "Nilsen", "email", "location"));
			userHandler.addUser(new User("openID", "Morten", "Salte", "email", "location"));
			userHandler.addUser(new User("openID", "Morten", "Bla", "email", "location"));
			userHandler.addUser(new User("openID", "Mango", "Bli", "email", "location"));
			userHandler.addUser(new User("openID", "Thomas", "MMM", "email", "location"));
			userHandler.addUser(new User("openID", "Morten", "Nilsen", "email", "location"));
			userHandler.addUser(new User("openID", "Petter", "Salte", "email", "location"));
			userHandler.addUser(new User("openID", "Aleksander", "Bli", "email", "location"));
			userHandler.addUser(new User("openID", "Bli", "Aleksandersen", "email", "location"));
			hasBeenRun=true;
		}
	}

	public SearchResult search(String query){
		query = query.toLowerCase();
		query = query.trim();
		SearchResult result = new SearchResult();

		result.setUserResults(searchForUsers(query));




		return result;
	}

	public ArrayList<UserResult> searchForUsers(String query){
		ArrayList<UserResult> userResults=searchForUsersUsingString(query);

		if(!userResults.isEmpty())return userResults;

		int dottedStringLength = query.length()-2;
		String dottedString = "";
		for (int i=0;i<dottedStringLength;i++){
			dottedString +=".";
		}
		query = query.charAt(0) + dottedString + query.charAt(query.length()-1);
		userResults = searchForUsersUsingDottedString(query);		
		return userResults;

	}

	private ArrayList<UserResult> searchForUsersUsingString(String query){
		ArrayList<UserResult> userResults = new ArrayList<UserResult>();
		User tmpUser;
		for(int i=0;i<userHandler.getUserListSize();i++){
			tmpUser=userHandler.getUserByIndex(i);
			if(tmpUser.getFirstName().toLowerCase().startsWith(query)){
				userResults.add(new UserResult(tmpUser.getUserID(), tmpUser.getFirstName(), tmpUser.getLastName()));
			}else if(tmpUser.getLastName().toLowerCase().startsWith(query)){
				userResults.add(new UserResult(tmpUser.getUserID(), tmpUser.getFirstName(), tmpUser.getLastName()));
			}
		}
		return userResults;
	}

	private ArrayList<UserResult> searchForUsersUsingDottedString(String query){
		ArrayList<UserResult> userResults = new ArrayList<UserResult>();
		User tmpUser;
		for(int i=0;i<userHandler.getUserListSize();i++){
			tmpUser=userHandler.getUserByIndex(i);
			if(tmpUser.getFirstName().toLowerCase().matches(query)){
				userResults.add(new UserResult(tmpUser.getUserID(), tmpUser.getFirstName(), tmpUser.getLastName()));
			}else if(tmpUser.getLastName().toLowerCase().matches(query)){
				userResults.add(new UserResult(tmpUser.getUserID(), tmpUser.getFirstName(), tmpUser.getLastName()));
			}
		}
		return userResults;
	}
}