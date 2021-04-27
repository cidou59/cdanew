package fr.magasin.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity @Table(name="Table_Acces")
public class Acces {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idAcces;
    private String libelle;
    
    @ManyToMany
    @JoinTable( name = "Table_Users_Acces",
                joinColumns = @JoinColumn( name = "idAcces" ),
                inverseJoinColumns = @JoinColumn( name = "idUser" ) )
    private List<User> users = new ArrayList<>();
            

    
    public Acces() {
        this.idAcces = 0;
        this.libelle = "unknown";
    }
    
    public int getidAcces() {
        return idAcces;
    }
    
    public void setidAcces(int idAcces) {
        this.idAcces = idAcces;
    }
    
    public String getLibelle() {
        return libelle;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    public List<User> getUsers() {
        return users;
    }
    
    
    @Override
    public String toString() {
        return "[" + this.libelle + "]";
    }
    
}