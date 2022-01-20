package beans;

public class register {
private int id;
private String email;
private String password;
public int getId() {
	return id;
}

public register() {
	super();
}

public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public register(int id, String email, String password) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
}
public register(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}
@Override
public String toString() {
	return "register [email=" + email + ", password=" + password + "]";
}



}
