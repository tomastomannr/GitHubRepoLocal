package sk.toman.model;

public class LoginModel {
	
	public boolean checkLogin(String userName, String userPass){
		if(userName.equals("a") && userPass.equals("a")){
			return true;
		}
		return false;
	}
}
