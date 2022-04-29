package ar.edu.unsl.evac.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
public class User {
    @Id
    private String _id;
    @Field
    private String username;
    @Field
    private String pass;
    @Field
    private String email;

    public User() {}

    public User(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public String getId() {
        return this._id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", username='" + getUsername() + "'" + ", pass='"
                + getPass() + "'" + "}";
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
