package fr.magasin.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity @Table(name = "Table_Users")
public class User {

    @Id  @GeneratedValue( strategy=GenerationType.IDENTITY )
    private int idUser;
    
    private String login;
    
    private String password;
    
    private int connectionNumber;
    
    @OneToOne (cascade = CascadeType.REMOVE)  
    @JoinColumn( name="idUserInformations", nullable = false)
    private UserInformations userInformations;
    
    @OneToMany( targetEntity=Reservation.class, mappedBy="user" )
    private List<Reservation> reservation = new ArrayList<>();
    
    @ManyToMany
    @JoinTable( name = "Table_Users_Acces",
                joinColumns = @JoinColumn( name = "idUser" ),
                inverseJoinColumns = @JoinColumn( name = "idAcces" ) )
    private List<Acces> acces = new ArrayList<>();

    public User() { }
    
    public User( String login, String password, int connectionNumber,UserInformations userInformations ) {
        super();
        this.setLogin( login );
        this.setPassword( password );
        this.setConnectionNumber( connectionNumber );
        this.userInformations = userInformations;
    }

    
    public int getIdUser() {
        return idUser;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getConnectionNumber() {
        return connectionNumber;
    }
    
    public void setConnectionNumber(int connectionNumber) {
        this.connectionNumber = connectionNumber;
    }
    
    public UserInformations getUserInformations() {
        return userInformations;
    }

    public void setUserInformations(UserInformations userInfos) {
        this.userInformations = userInfos;
    }

    public List<Acces> getAcces() {
        return acces;
    }
  
    
    public List<Reservation> getReservation() {
		return reservation;
	}
    
    public String toString() {
        return this.idUser + ": " + this.login + "/" + this.password 
             + " - " + this.connectionNumber + " connexion(s)";
    }
    
}
