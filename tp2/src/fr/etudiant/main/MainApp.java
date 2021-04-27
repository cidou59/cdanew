package fr.etudiant.main;
import java.awt.EventQueue;

import fr.etudiant.graphique.GestionTd;


public class MainApp {
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {	
					new GestionTd();
			}
		});
		
    }
}
