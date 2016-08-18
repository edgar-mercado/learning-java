package com.ecme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
//@Table(name="blog_post")
public class Person {
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="id",unique=true, nullable=true)
	long id;
	@Column
	String name;
	@Column
	String middleName;
	@Column
	int age;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", middleName=" + middleName + ", age=" + age + "]";
	}
	
}
