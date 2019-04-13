package com.yan.entity;

import java.util.Date;


/**
 * 实体类的一般要求：
 * 		私有属性共有的get/set方法
 *  	无参构造器 
 */

public class UserBean  implements java.io.Serializable {


    // Fields    

     @Override
	public String toString() {
		return "UserBean [id=" + id + ", username=" + username + ", password="
				+ password + ", birth=" + birth + ", sex=" + sex + "]";
	}

	private Long id;
     private String username;
     private String password;
     private Date birth;
     private Boolean sex;


    // Constructors

    /** default constructor */
    public UserBean() {
    }

	/** minimal constructor */
    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /** full constructor */
    public UserBean(String username, String password, Date birth, Boolean sex) {
        this.username = username;
        this.password = password;
        this.birth = birth;
        this.sex = sex;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth() {
        return this.birth;
    }
    
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Boolean getSex() {
        return this.sex;
    }
    
    public void setSex(Boolean sex) {
        this.sex = sex;
    }
   








}