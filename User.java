package pojos;
// Generated Dec 11, 2018 12:07:25 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="rsku"
)
public class User  implements java.io.Serializable {


     private String email;
     private String password;

    public User() {
    }

	
    public User(String email) {
        this.email = email;
    }
    public User(String email, String password) {
       this.email = email;
       this.password = password;
    }
   
     @Id 

    
    @Column(name="email", unique=true, nullable=false, length=20)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="password", length=20)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

public String toJson() {
        return "{\"email\":\"" + getEmail()+ "\",\"password\":\"" + getPassword()+ "\"}";
    }


}


