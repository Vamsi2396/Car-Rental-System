package model;

public class AdminModel {

	public String Username;

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}
	
	public AdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminModel(String username) {
		super();
		Username = username;
	}
	public void validateAdminModel(AdminModel admin, revoke_errormsgs adminerrormsgs) {
		adminerrormsgs.setR_usernameError(validaterevokeusername(admin.getUsername()));
	}
		private String validaterevokeusername (String Username) {
			String result="";
			user u=new user();
			//UserDAO us = new UserDAO();
			if (!stringSize(Username,4,10))
				result= "Your username must between 4 and 10 digits";
			else
				if (!isAlphanumeric(Username))
					result="Your Username must be alphanumeric";
			
			return result;				
		}
		private boolean isAlphanumeric(String username2) {
			// TODO Auto-generated method stub
			boolean s1;
			s1=username2.matches("[a-zA-Z0-9]+");
			
			return s1;
		}
		private boolean stringSize(String string, int min, int max) {
			return string.length()>=min && string.length()<=max;
		}
	}

