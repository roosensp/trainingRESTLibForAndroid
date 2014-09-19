package com.example.clientandroidblogrest.activity;

import com.example.clientandroidblogrest.resttool.NameResourceREST;
import com.example.clientandroidblogrest.resttool.ObjectRest;


@NameResourceREST(value="tokenkey")
public class TokenKeyRequest extends ObjectRest {

	private IdentificationUser user = new IdentificationUser() ;
	
	private Integer timestampClient ;
	
	public IdentificationUser getUser() {
		return user;
	}
	public void setUser(IdentificationUser user) {
		this.user = user;
	}
	public Integer getTimestampClient() {
		return timestampClient;
	}
	public void setTimestampClient(Integer timestampClient) {
		this.timestampClient = timestampClient;
	}
	
	public class IdentificationUser 
	{
	
		private String username ;
		private String password ;
		
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
		
	}
	
}
