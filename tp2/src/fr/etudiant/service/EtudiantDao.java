package fr.etudiant.service;

import java.util.List;

import fr.etudiant.DAO.Etudiant;
import fr.etudiant.DAO.Group;
import fr.etudiant.DAO.Salle;

public interface EtudiantDao {

	void ajouterEtudiant(Etudiant e);
	void ajouterGroup(Group g);
	void ajouterSalle(Salle s);
	Etudiant getEtudient(int i);
	List<Etudiant> getListEtudiant(int i);
	List<Group> getListGroup(int i);
	Number getSalleNom();
	Number getGroupNom();
	Salle getSalle(int i);
	Group getGroup(int i);
}
