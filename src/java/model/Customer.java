package model;
// Generated Mar 17, 2018 3:43:56 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name="customer"
    ,catalog="threadther"
)
public class Customer  implements java.io.Serializable {


     private int userId;
     private User user;
     private Integer balance;
     private Integer phoneNumber;
     private Date birthDate;

    public Customer() {
    }

	
    public Customer(User user) {
        this.user = user;
    }
    public Customer(User user, Integer balance, Integer phoneNumber, Date birthDate) {
       this.user = user;
       this.balance = balance;
       this.phoneNumber = phoneNumber;
       this.birthDate = birthDate;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="user"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="user_id", unique=true, nullable=false)
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="balance")
    public Integer getBalance() {
        return this.balance;
    }
    
    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    
    @Column(name="phone_number")
    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="birth_date", length=10)
    public Date getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }




}


