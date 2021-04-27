package fr.etudiant.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import fr.etudiant.DAO.Etudiant;
import fr.etudiant.DAO.Group;
import fr.etudiant.DAO.Salle;


public class EtudiantDaoImp implements EtudiantDao{

	EntityManagerFactory emf;
	private EntityManager em;
		
	
	public EtudiantDaoImp() {
		super();
		this.emf = Persistence.createEntityManagerFactory("etudianttp");
		this.em = emf.createEntityManager();
	}

	
	@Override
	public void ajouterEtudiant(Etudiant e) {
		EntityTransaction trans = em.getTransaction();
        trans.begin();
		em.persist(e); 
		trans.commit();	
		
	}


	@Override
	public void ajouterGroup(Group g) {
		EntityTransaction trans = em.getTransaction();
        trans.begin();
		em.persist(g); 
		trans.commit();	
		
	}


	@Override
	public void ajouterSalle(Salle s) {
		EntityTransaction trans = em.getTransaction();
        trans.begin();
		em.persist(s); 
		trans.commit();	
		
	}


	public Etudiant getEtudient(int i) {	
		String query ="select c from Etudiant c where c.id_etudiant="+i;
 	    return   em.createQuery( query, Etudiant.class ).getSingleResult();		
	}


	public List<Etudiant> getListEtudiant(int i) {
		
		Group group = em.getReference(Group.class, i);
		return group.getListEtudiant();
	}


	
	public List<Group> getListGroup(int i) {
		Salle salle = em.getReference(Salle.class, i);
		return salle.getListGroup();
	}


	@Override
	public Number getSalleNom() {
		String query ="select COUNT(c) from Salle c ";
 	    return  (Number)    em.createQuery( query).getSingleResult();
		
	}


	@Override
	public Salle getSalle(int i) {
		
		String query ="select c from Salle c where c.id_salle="+i;
 	    return   em.createQuery( query, Salle.class ).getSingleResult();	
		
	}


	public Number getGroupNom() {
		
		String query ="select COUNT(c) from Group c ";
 	    return  (Number)    em.createQuery( query).getSingleResult();
	}


	
	
	
	public Group getGroup(int i) {
		String query ="select g from Group g where g.id_group="+i;
 	    return   em.createQuery( query, Group.class ).getSingleResult();
	}



	
	

}
