package ecme.springmvc.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="id",unique=true, nullable=true)
	private long id;
	@Column (name="username",nullable=true)
	private String username;
	@Column (name="password",nullable=true)
	private String password;
	@Column (name="enabled", nullable=true)
	private boolean enabled;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<BlogPost> blogPosts;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<BlogPost> getBlogPosts() {
		return blogPosts;
	}
	public void setBlogPosts(List<BlogPost> blogPosts) {
		this.blogPosts = blogPosts;
	}
	

}
