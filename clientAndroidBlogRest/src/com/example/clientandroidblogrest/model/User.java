package com.example.clientandroidblogrest.model;

import java.sql.Date;

import com.example.clientandroidblogrest.resttool.NameResourceREST;
import com.example.clientandroidblogrest.resttool.ObjectRest;

@NameResourceREST(value="user")
public class User extends ObjectRest{
		
	 
		private String firstName ;
	    private String lastName ;
	    private String about ;
	    private String username ;
	    private String password ;
	    private Date   last_connected ;
        private Role role ;
	    
	    public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getAbout() {
			return about;
		}
		public void setAbout(String about) {
			this.about = about;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Date getLast_connected() {
			return last_connected;
		}
		public void setLast_connected(Date last_connected) {
			this.last_connected = last_connected;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		
}
