package com.prueba.bancooccidente.dto;

public class RequestDTO {
	
	private String groups;

	public String[] getGroups() {
		return groups.split(",");
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	

}
