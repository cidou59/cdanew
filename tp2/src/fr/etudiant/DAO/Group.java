package fr.etudiant.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity @Table(name="grouptd")
public class Group {

	@Id @GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id_group;
	
	@ManyToOne (cascade = CascadeType.REMOVE)  
    @JoinColumn( name="id_salle", nullable = false)
    private Salle salle;
	
	@OneToMany( targetEntity=Etudiant.class, mappedBy="group" )
    private List<Etudiant> listEtudiant = new ArrayList<>();

	

	public Group(Salle salle) {
		this.salle = salle;
	}

	public Group() {
		super();
	}

	public int getId_group() {
		return id_group;
	}

	public void setId_group(int id_group) {
		this.id_group = id_group;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public List<Etudiant> getListEtudiant() {
		return listEtudiant;
	}

	public void setListEtudiant(List<Etudiant> listEtudiant) {
		this.listEtudiant = listEtudiant;
	}

	@Override
	public String toString() {
		return this.id_group+"";
	}
	
	
	
}
