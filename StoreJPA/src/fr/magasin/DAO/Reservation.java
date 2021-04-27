package fr.magasin.DAO;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  @Table(name="Table_Reservation")
public class Reservation {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idReservation;
    
    @ManyToOne @JoinColumn(name="idUser", nullable=false)
    private User user;
    
    private Date commandDate;
    
    
    public Reservation() {}
    
    public Reservation( User user, Date commandDate ) {
        this.setUser( user );
        this.setCommandDate( commandDate );
    }

    public int getIdReservation() {
        return idReservation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Date getCommandDate() {
        return commandDate;
    }
    
    public void setCommandDate(Date commandDate) {
        this.commandDate = commandDate;
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append( "Commande de >> " ).append( this.user )
               .append( " - " ).append( this.commandDate ).append( "\n" );
        return builder.toString();
    }   
    
}