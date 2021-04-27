package fr.magasin.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.magasin.DAO.Acces;
import fr.magasin.DAO.Reservation;
import fr.magasin.DAO.User;
import fr.magasin.DAO.UserInformations;

public class MonMagasin {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			/**************** OneToOne *****************/
			entityManagerFactory = Persistence.createEntityManagerFactory("magasin");
			entityManager = entityManagerFactory.createEntityManager();

			User user = entityManager.find(User.class, 1);
			System.out.println(user);
			System.out.println(user.getUserInformations());
			
			

			/***************** ManyToOne ***************/
			Reservation reservation = entityManager.find(Reservation.class, 1);
			System.out.println(reservation);

			User user1 = reservation.getUser();
			System.out.println(user1);

			/***************** OneToMany ***************/
			User user2 = entityManager.find(User.class, 1);
			for (Reservation resa : user2.getReservation()) {
				System.out.println(resa);
			}

			/***************** ManyToMany ***************/

			User user3 = entityManager.find(User.class, 1);
			System.out.println("Rôles associés à Anderson");
			for (Acces acces : user3.getAcces()) {
				System.out.println(acces);
			}

			Acces acces = entityManager.find(Acces.class, 1);
			System.out.println("Utilisateurs possédant le rôle VIP");
			for (User user4 : acces.getUsers()) {
				System.out.println(user4);
			}
			
			/*****************Transaction****************/
			EntityTransaction trans = entityManager.getTransaction();
            trans.begin();
            
            UserInformations userInfo = new UserInformations( "35 rue toto" , "lille","toto@fff.com","0706050402" );
            entityManager.persist( userInfo );
    
            User toto = new User("toto","435267", 45663, userInfo);
            entityManager.persist( toto );
            
            toto.getAcces().add(entityManager.find(Acces.class, 3));
            entityManager.persist(toto);
            
            //User userToRemove = entityManager.find(User.class, 18);
            //entityManager.remove(userToRemove);
            
            /**********************JPQL*******************/
            Query q1= entityManager.createQuery("select u from User u");
            List<User> utilisateurs = q1.getResultList();
            for (User util : utilisateurs) {
            	System.out.println(util.getLogin());
            }
             Query q= entityManager.createQuery("select a.libelle,u.login	from User u	join u.acces a where u.idUser = :id");
             q.setParameter("id", 1);
             List<Object[]> results = q.getResultList();
             for(Object[] result : results) {
            	 System.out.println((String)result[0] +"  "+ (String)result[1]);
             }
			/*
			 * List<Produit> results = entityManager.createQuery("from Produit",
			 * Produit.class).getResultList(); for( Produit article : results) {
			 * System.out.println( article ); }
			 */
    
			/*
			 * System.out.println( "- Modification d'un article --------------" );
			 * 
			 * newProduit.setPrix( 90000 ); entityManager.persist( newProduit );
			 * 
			 * results = entityManager.createQuery("from Produit",
			 * Produit.class).getResultList(); for( Produit article : results) {
			 * System.out.println( article ); }
			 * 
			 * System.out.println( "- Suppression d'un article ---------------" );
			 * 
			 * entityManager.remove( newProduit );
			 * 
			 * results = entityManager.createQuery("from Produit",
			 * Produit.class).getResultList(); for( Produit article : results) {
			 * System.out.println( article ); }
			 */
                    
            trans.commit();

		} finally {
			if (entityManager != null)
				entityManager.close();
			if (entityManagerFactory != null)
				entityManagerFactory.close();
		}

	}
}
