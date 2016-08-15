package ecme.springmvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Authority {
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="id",unique=true, nullable=true)
	private long id;
	@Column (name="username", nullable=true)
	private String username;
	@Column (name="authority", nullable=true)
	private String authority;
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
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
