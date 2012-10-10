package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.search.SearchEngine;
import business.search.SearchResults;
import business.search.UserSuggestion;
import business.user.UserHandler;

import models.User;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SearchResults searchResults;
	private SearchEngine engine;

	public SearchServlet() {
		engine = new SearchEngine();
		engine.createDummyData();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("query");
		
		if(!query.trim().equals("")) {
			searchResults = querySearchEngine(query);
		} else {
			searchResults = new SearchResults();
		}
		
		ArrayList<User> users = searchResults.getUserResults();
		if(users != null) {
			request.setAttribute("users", users);
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/searchresults.jsp");
		dispatcher.forward(request, response);
	}
	
	private SearchResults querySearchEngine(String query) {
		return engine.search(query);
	}

}