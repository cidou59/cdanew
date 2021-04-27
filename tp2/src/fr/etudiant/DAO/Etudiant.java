package fr.etudiant.DAO;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity @Table(name="etudiant")
public class Etudiant {
	
	@Id @GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id_etudiant;
	
    private String nom;
    
    private String prenom;
    
    private String date;
    
    @ManyToOne (cascade = CascadeType.REMOVE)  
    @JoinColumn( name="id_group", nullable = false)
    private Group group;
    
 
    
  
    
    public Etudiant() {
       
    }



	public Etudiant(String nom, String prenom, String date, Group group) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.group = group;
	}



	public int getId_etudiant() {
		return id_etudiant;
	}






	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public Group getGroup() {
		return group;
	}



	public void setGroup(Group group) {
		this.group = group;
	}



	@Override
	public String toString() {
		return "Etudiant [id_etudiant=" + id_etudiant + ", nom=" + nom + ", prenom=" + prenom + ", date=" + date
				+ ", group=" + group + "]";
	}
    
    
   



    
}
