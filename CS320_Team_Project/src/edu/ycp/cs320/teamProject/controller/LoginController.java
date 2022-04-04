package edu.ycp.cs320.teamProject.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import edu.ycp.cs320.teamProject.model.Login;

public class LoginController {
private Map<String, String> map;
	
	public LoginController() {
		map = new HashMap<String, String>();
		map.put("admin", "12345");
	}
	
	public boolean login(Login model) {
		if (map.containsKey(model.getUsername())) {
			if (map.get(model.getUsername()).equals(model.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
			//map.put(model.getUsername(), model.getPassword());
			//return true;
		}
	}
}
