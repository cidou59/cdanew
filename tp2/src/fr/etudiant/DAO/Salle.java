package fr.etudiant.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name="salle")
public class Salle {

	
	@Id @GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id_salle;
	
	private int nom_ordi;
	private int nom_place;
	boolean video;
	
	
	@OneToMany( targetEntity=Group.class, mappedBy="salle" )
    private List<Group> listGroup = new ArrayList<>();
	
	

	

	
	public int getNom_ordi() {
		return nom_ordi;
	}


	public void setNom_ordi(int nom_ordi) {
		this.nom_ordi = nom_ordi;
	}


	public int getNom_place() {
		return nom_place;
	}


	public void setNom_place(int nom_place) {
		this.nom_place = nom_place;
	}


	public boolean isVideo() {
		return video;
	}


	public void setVideo(boolean video) {
		this.video = video;
	}


	public Salle(int nom_ordi, int nom_place, boolean video) {
		super();
		this.nom_ordi = nom_ordi;
		this.nom_place = nom_place;
		this.video = video;
	}


	public Salle() {
		super();
	}


	public int getId_salle() {
		return id_salle;
	}

	public void setId_salle(int id_salle) {
		this.id_salle = id_salle;
	}

	public List<Group> getListGroup() {
		return listGroup;
	}

	public void setListGroup(List<Group> listGroup) {
		this.listGroup = listGroup;
	}

	@Override
	public String toString() {
		return this.id_salle+"";
	}
	
	
	
}
