package movietickets.controller;

import java.net.PasswordAuthentication;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import movietickets.database.DBTables;
import movietickets.model.User;

@Controller
@RequestMapping("rest")
public class UserController {

	private User user;
	private String emailId;
	private String password;
	
	@PostConstruct
	public void init() {
	
		System.out.println("Executing the init method");
		
		if (DBTables.users == null)
			DBTables.users = new ArrayList<>();
		
		DBTables.users.add( new User(101, "Nikhil", "Pawar", "nikhilpawar43@ymail.com", "test1234") );
		DBTables.users.add( new User(102, "Ankur", "Badamikar", "ankurb9@gmail.com", "password") );
		DBTables.users.add( new User(103, "Amey", "Sinkar", "ameysinkar@gmail.com", "capital1") );
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public @ResponseBody User getHomePage(HttpServletRequest request) {
		
		emailId = request.getParameter("emailid");
		password = request.getParameter("password");
		
		if ( emailId != null && !emailId.isEmpty() && password != null && !password.isEmpty() ) {
			for (User user : DBTables.users) {
				if ( user.getEmailId().equals( emailId ) && user.getPassword().equals( password )) {
					return user;
				}
			}
		}
		
		
		return null;
	}
}
