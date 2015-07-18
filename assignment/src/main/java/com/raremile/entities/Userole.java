package com.raremile.entities;

@SuppressWarnings("serial")
public class Userole implements java.io.Serializable {
	private long userId;
	private String useRole;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUseRole() {
		return useRole;
	}
	public void setUseRole(String useRole) {
		this.useRole = useRole;
	}
	

}
