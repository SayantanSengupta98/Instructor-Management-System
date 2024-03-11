package com.example.hibernate_DB_mapping.Entity;

public class EntityNotFound {
	private int status;
	private String error;
	private String timeStamp;
	
	
	public EntityNotFound() {
		super();
	}
	
	public EntityNotFound(String error, String timeStamp, int status) {
		super();
		this.error = error;
		this.timeStamp = timeStamp;
		this.status = status;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
