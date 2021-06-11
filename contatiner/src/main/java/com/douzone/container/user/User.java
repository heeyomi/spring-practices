package com.douzone.container.user;

import java.util.List;

public class User {
	private int no = 0;
	private String name = "윤희경";
	
	private Friend friend;
	private List<String> friends;
	
	public User() {
	}

	public User(String name) {
		this.name = name;
	}
	
	public User(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", friend=" + friend + ", friends=" + friends + "]";
	}

}
