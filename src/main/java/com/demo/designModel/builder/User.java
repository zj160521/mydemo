package com.demo.designModel.builder;

public class User {
	  private final String firstName; // required
	  private final String lastName; // required
	  private final int age; // optional
	  private final String phone; // optional
	  private String address; // optional
	 
	  private User(UserBuilder builder) {
	    this.firstName = builder.firstName;
	    this.lastName = builder.lastName;
	    this.age = builder.age;
	    this.phone = builder.phone;
	    this.address = builder.address;
	  }
	  
	  public void setAddress(String address) {
		this.address = address;
	  }

	  public String getFirstName() {
	    return firstName;
	  }
	 
	  public String getLastName() {
	    return lastName;
	  }
	 
	  public int getAge() {
	    return age;
	  }
	 
	  public String getPhone() {
	    return phone;
	  }
	 
	  public String getAddress() {
	    return address;
	  }
	 
	  public static class UserBuilder {
	    private final String firstName;
	    private final String lastName;
	    private int age;
	    private String phone;
	    private String address;
	 
	    public UserBuilder(String firstName, String lastName) {
	      this.firstName = firstName;
	      this.lastName = lastName;
	    }
	 
	    public UserBuilder age(int age) {
	      this.age = age;
	      return this;
	    }
	 
	    public UserBuilder phone(String phone) {
	      this.phone = phone;
	      return this;
	    }
	 
	    public UserBuilder address(String address) {
	      this.address = address;
	      return this;
	    }
	 
	    public User build() {
	      return new User(this);
	    }
	 
	  }

	@Override
	public String toString() {
		return "姓名："+this.firstName+this.lastName+" 地址："+this.address+" 年龄："+this.age+" 电话："+this.phone;
	}
	  
	  
}
