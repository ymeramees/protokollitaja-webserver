package ee.zone.web.protokollitajawebserver.entity;

import org.bson.types.ObjectId;

public class Users {

	public ObjectId id;
	
	public String username;
	public String password;
	
	public Users() {}
	
	public Users(ObjectId id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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
}
