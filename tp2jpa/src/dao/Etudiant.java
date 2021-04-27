package dao;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
	
	
	
	@Entity @Table( name="etudiant" )
	public class Etudiant {
		@Id @GeneratedValue( strategy=GenerationType.IDENTITY )
		private int id_etudiant;
		
	    private String nom;
	    
	    private String prenom;
	    
	    private String date_naissance;

		public Etudiant(int id_etudiant, String nom, String prenom, String date_naissance) {
			super();
			this.id_etudiant = id_etudiant;
			this.nom = nom;
			this.prenom = prenom;
			this.date_naissance = date_naissance;
		}
	    
	    
		public Etudiant() {
			
		}


		public int getId_etudiant() {
			return id_etudiant;
		}


		public void setId_etudiant(int id_etudiant) {
			this.id_etudiant = id_etudiant;
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


		public String getDate_naissance() {
			return date_naissance;
		}


		public void setDate_naissance(String date_naissance) {
			this.date_naissance = date_naissance;
		}
	    
	    
	 

}
