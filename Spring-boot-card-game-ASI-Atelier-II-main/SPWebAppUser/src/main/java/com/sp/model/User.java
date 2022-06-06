package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.lang.NonNull;

@Entity
@Table(
		uniqueConstraints=@UniqueConstraint(columnNames={"name", "surname"})
)
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private String surname;  
	@NonNull
	private String password;
	private int money;
	//private List<Card>
	
	public User() {
	}

	public User(Integer id, String name, String surname, String password, int money) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.money = money;
	}

	public User(String surname, String password) {
		super();
		this.surname = surname;
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", password=" + password + ", money="
				+ money + "]";
	}
	
	

}
