package fr.etudiant.graphique;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import fr.etudiant.DAO.Etudiant;
import fr.etudiant.DAO.Group;
import fr.etudiant.DAO.Salle;
import fr.etudiant.service.EtudiantDaoImp;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
@SuppressWarnings("serial")

public class GestionTd extends JFrame {
	
	EtudiantDaoImp edi = new EtudiantDaoImp();
	 private JPanel contentPane;
	JTabbedPane onglets = new JTabbedPane();
	
	// atribut pour l'onglet etudiant
	 private JPanel p1 = new JPanel();
	 private JTable table1,table11;
	 private JScrollPane scrollPane1,scrollPane11;
	 private JTextField codeNom , codeprenom,  codeIdEtudiant,codeDate;
	 private JLabel ajouterEtudiant ,Labelerreur,dateEtudiant, prenomEtudiant,nomEtudiant,  nomEtudiant2,afficherEtudiant, group;
	 private JButton AjouterButton1 , AfficherButton1;
	 private JComboBox<Object> c1;
		
	// atribut pour l'onglet salle
	 private JPanel p2 = new JPanel();
	 private JTable table2, table22;
	 private JScrollPane scrollPane2, scrollPane22;
	 private JTextField codeOrdi , codePlace ,codeSalle;
	 private JLabel nomOrdi , nomPlace, videoProj,  codeSalle2,  affSalle,ajouterSalle,Labelerreur2;
	 private JButton AjouterButton2 , AfficherButton2;
	 JRadioButton j1 = new JRadioButton("Oui") ;
	 JRadioButton j2 = new JRadioButton("Non") ;
	 ButtonGroup G= new ButtonGroup();
	 private JComboBox<Object> c3;
	 
	 
	
	 
	 
	// atribut pour l'onglet group
	 private JPanel p4 = new JPanel();
	 private JTable table4, table42;
	 private JScrollPane scrollPane4,scrollPane42;
	 private JTextField  codeclient4 , codeGroup;
	 private JLabel choisirSalle , idGroup,ajouterGroup,Labelerreur4;
	 private JButton AjouterButton3 ,AfficherButton3 ;
	 private JComboBox<Object> c2, c4;
	 
	
 	public GestionTd() {
		setVisible(true);
		
		setTitle("Gestion TD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 420);
		onglets.setBounds(0,0,662,400);
	    onglets.add("Etudiant", p1);
		onglets.add("Salle", p2);
		onglets.add("Group", p4);
		
		  
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		add(onglets); 
		
		
		// onglet etudiant
		p1.setLayout(null);
	
		
		 ajouterEtudiant = new JLabel("Ajouter Etudiant ");
		 ajouterEtudiant.setForeground(Color.BLUE);
		 ajouterEtudiant.setFont(new Font("Tahoma", Font.BOLD, 14));
		 ajouterEtudiant.setBounds(10,26, 184,30);
		 p1.add(ajouterEtudiant);
		
		
		
		nomEtudiant = new JLabel("Nom: ");
		nomEtudiant.setForeground(Color.BLUE);
		nomEtudiant.setFont(new Font("Tahoma", Font.BOLD, 12));
		nomEtudiant.setBounds(10,56, 184, 14);
		p1.add(nomEtudiant);
		
		
		prenomEtudiant = new JLabel("Prenom: ");
		prenomEtudiant.setForeground(Color.BLUE);
		prenomEtudiant.setFont(new Font("Tahoma", Font.BOLD, 12));
		prenomEtudiant.setBounds(10,86, 184, 14);
		p1.add(prenomEtudiant);
		
		dateEtudiant = new JLabel("Date de naissance: ");
		dateEtudiant.setForeground(Color.BLUE);
		dateEtudiant.setFont(new Font("Tahoma", Font.BOLD, 12));
		dateEtudiant.setBounds(10,116, 184, 14);
		p1.add(dateEtudiant);
		
		
		group = new JLabel("Group: ");
		group.setForeground(Color.BLUE);
		group.setFont(new Font("Tahoma", Font.BOLD, 12));
		group.setBounds(10,146, 184, 14);
		p1.add(group);
	
		
		codeNom = new JTextField();
		codeNom.setBounds(140,56, 116, 20);
		p1.add(codeNom);
		codeNom.setColumns(10);
		
		codeprenom = new JTextField();
		codeprenom.setBounds(140,86, 116, 20);
		p1.add(codeprenom);
		codeprenom.setColumns(10);
		
		codeDate = new JTextField();
		codeDate.setBounds(140,116, 116, 20);
		p1.add(codeDate);
		codeDate.setColumns(10);
		
		c1 = new JComboBox<>();
		c1.setBounds(140,146, 116, 20);
		p1.add(c1);
		
		for(int i =1;i<=edi.getGroupNom().intValue();i++)
			//c1.addItem(i+8);
			c1.addItem(i);
		
		AjouterButton1 = new JButton("Ajouter");
		AjouterButton1.setFont(new Font("Tahoma", Font.BOLD, 12));
		AjouterButton1.setBounds(140,180, 90, 23);
		p1.add(AjouterButton1);
		AjouterButton1.setEnabled(false);
		
		
		afficherEtudiant = new JLabel("Afficher Etudiant ");
		afficherEtudiant.setForeground(Color.BLUE);
		afficherEtudiant.setFont(new Font("Tahoma", Font.BOLD, 14));
		afficherEtudiant.setBounds(10,210, 184, 14);
		p1.add(afficherEtudiant);
			
		 
		 nomEtudiant2 = new JLabel("Id etudiant: ");
		 nomEtudiant2.setForeground(Color.BLUE);
		 nomEtudiant2.setFont(new Font("Tahoma", Font.BOLD, 12));
		 nomEtudiant2.setBounds(10,240, 184, 14);
		 p1.add(nomEtudiant2);
		
	
		
		Labelerreur = new JLabel(" ");
		Labelerreur.setForeground(Color.RED);
		Labelerreur.setFont(new Font("Tahoma", Font.BOLD, 12));
		Labelerreur.setBounds(10,310, 390, 14);
		p1.add(Labelerreur);
		
		codeIdEtudiant = new JTextField();
		codeIdEtudiant.setBounds(140,240, 116, 20);
		p1.add(codeIdEtudiant);
		codeIdEtudiant.setColumns(10);
		
		
		
		
		AfficherButton1 = new JButton("Afficher");
		AfficherButton1.setFont(new Font("Tahoma", Font.BOLD, 12));
		AfficherButton1.setBounds(140,274, 90, 23);
		p1.add(AfficherButton1);
			
	
		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(290,26, 340, 100);
		p1.add(scrollPane1);
		
		table1 = new JTable();
		table1.setRowHeight(30);
		scrollPane1.setViewportView(table1);
		
		scrollPane11 = new JScrollPane();
		scrollPane11.setBounds(290,150, 340, 100);
		p1.add(scrollPane11);
		
		table11 = new JTable();
		table11.setRowHeight(30);
		scrollPane11.setViewportView(table11);
		
		
		
		codeDate.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(codeNom.getText().length() == 0 || codeprenom.getText().length() == 0|| codeDate.getText().length() == 0)
		                AjouterButton1.setEnabled(false);
		            else
		            {
		            	AjouterButton1.setEnabled(true);
		            }
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				 
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		AjouterButton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					String nom1 = codeNom.getText();
					String prenom1 = codeprenom.getText();
					String date1 = codeDate.getText();
					int i = c1.getSelectedIndex();

					//Group group1 = edi.getGroup(i+9);
					Group group1 = edi.getGroup(1);
					System.out.println(group1.toString());
					Etudiant et = new Etudiant(nom1, prenom1, date1, group1);
					
					edi.ajouterEtudiant(et);
					Labelerreur.setText("Etudiant est bien enregistré");
					
			}
				catch (Exception e1) {

						Labelerreur.setText("Veuillez remplissez correctement tous les champs!");
				}
			}
		});
		
		AfficherButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				DefaultTableModel dt = new DefaultTableModel();
				DefaultTableModel dt1 = new DefaultTableModel();
				table1.removeAll();
				dt.addColumn("Id_etudiant");
				dt.addColumn("Nom");
				dt.addColumn("Prenom");
				dt.addColumn("Date");
				dt1.addColumn("Groupe (id_group)");
				dt1.addColumn("Salle (id_salle)");
				int ii = Integer.parseInt(codeIdEtudiant.getText());
				Etudiant et;
				try {
					et = edi.getEtudient(ii);
					Labelerreur2.setText("");
					Object []tableau={et.getId_etudiant(), et.getNom(), et.getPrenom(), et.getDate()};
					dt.addRow(tableau);
					table1.setModel(dt);
					
					    Object []tableau1= {et.getGroup().toString(), et.getGroup().getSalle().toString()};
						
						dt1.addRow(tableau1);
					    table11.setModel(dt1);
					
				}
				catch (Exception e1) {
					Labelerreur.setText("Id_etudiant n'existe pas!");
				}		
			}	
		});
		
	

		// onglet salle
			 p2.setLayout(null);
		
			
			 ajouterSalle = new JLabel("Ajouter Salle ");
			 ajouterSalle.setForeground(Color.BLUE);
			 ajouterSalle.setFont(new Font("Tahoma", Font.BOLD, 14));
			 ajouterSalle.setBounds(10,26, 184, 30);
			 p2.add(ajouterSalle);
			
			
			
			 nomOrdi = new JLabel("Nombre d'ordi : ");
			 nomOrdi.setForeground(Color.BLUE);
			 nomOrdi.setFont(new Font("Tahoma", Font.BOLD, 12));
			 nomOrdi.setBounds(10,56, 184, 14);
			p2.add(nomOrdi);
			
			
			nomPlace = new JLabel("Nombre de places: ");
			nomPlace.setForeground(Color.BLUE);
			nomPlace.setFont(new Font("Tahoma", Font.BOLD, 12));
			nomPlace.setBounds(10,86, 184, 14);
			p2.add(nomPlace);
			
			videoProj = new JLabel("Video-proj: ");
			videoProj.setForeground(Color.BLUE);
			videoProj.setFont(new Font("Tahoma", Font.BOLD, 12));
			videoProj.setBounds(10,116, 184, 14);
			p2.add(videoProj);
			
			
		
			codeOrdi = new JTextField();
			codeOrdi.setBounds(140,56, 116, 20);
			p2.add(codeOrdi);
			codeOrdi.setColumns(10);
			
			codePlace = new JTextField();
			codePlace.setBounds(140,86, 116, 20);
			p2.add(codePlace);
			codePlace.setColumns(10);
			
		
			
			j1.setBounds(140, 105, 60, 30);
			j2.setBounds(200, 105, 60, 30);
			G.add(j1);
			G.add(j2);
			p2.add(j1);
			p2.add(j2);
			j1.isSelected();
			
			
			AjouterButton2 = new JButton("Valider");
			AjouterButton2.setFont(new Font("Tahoma", Font.BOLD, 12));
			AjouterButton2.setBounds(140,145, 90, 23);
			p2.add(AjouterButton2);
				
			
			
			affSalle = new JLabel("Afficher Salle ");
			affSalle.setForeground(Color.BLUE);
			affSalle.setFont(new Font("Tahoma", Font.BOLD, 14));
			affSalle.setBounds(10,200, 184, 14);
			p2.add(affSalle);
				
			 
			codeSalle2 = new JLabel("Id Salle: ");
			codeSalle2.setForeground(Color.BLUE);
			codeSalle2.setFont(new Font("Tahoma", Font.BOLD, 12));
			codeSalle2.setBounds(10,230, 184, 30);
			p2.add(codeSalle2);
			
		
			c3 = new JComboBox<>();
			c3.setBounds(140,230, 116, 20);
			p2.add(c3);
			
			for(int i =1;i<=edi.getSalleNom().intValue();i++)
				//c3.addItem(i);	
				c3.addItem(i);		
		
			
			
		
			
			
			AfficherButton2 = new JButton("Valider");
			AfficherButton2.setFont(new Font("Tahoma", Font.BOLD, 12));
			AfficherButton2.setBounds(140,290, 90, 23);
			p2.add(AfficherButton2);
				
		
			scrollPane2 = new JScrollPane();
			scrollPane2.setBounds(290,26, 340, 100);
			p2.add(scrollPane2);
			
			table2 = new JTable();
			table2.setRowHeight(40);
			scrollPane2.setViewportView(table2);
			
			
			scrollPane22 = new JScrollPane();
			scrollPane22.setBounds(290,120, 340, 300);
			p2.add(scrollPane22);
			
			table22 = new JTable();
			table22.setRowHeight(40);
			scrollPane22.setViewportView(table22);
			
			
			
			Labelerreur2 = new JLabel(" ");
			Labelerreur2.setForeground(Color.RED);
			Labelerreur2.setFont(new Font("Tahoma", Font.BOLD, 12));
			Labelerreur2.setBounds(10,320, 390, 14);
			p2.add(Labelerreur2);
			
			AjouterButton2.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					try {
						int nordi = Integer.parseInt(codeOrdi.getText());
						int noplace = Integer.parseInt(codePlace.getText());
						Boolean v;
						if(j1.isSelected())
							v=true;
						else 
							v=false;
						edi.ajouterSalle(new Salle(nordi,noplace,v));
							Labelerreur2.setText("Salle est bien enregistrée!");
						
				}
					catch (Exception e1) {

							Labelerreur2.setText("Veuillez remplissez correctement tous les champs!");
					}
				}
			});
			
			AfficherButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					DefaultTableModel dt = new DefaultTableModel();
					DefaultTableModel dt1 = new DefaultTableModel();
					table2.removeAll();
					dt.addColumn("Id_salle");
					dt.addColumn("Nombre d'ordi");
					dt.addColumn("Nombre de places");
					dt.addColumn("Vidéo-proj");
					dt1.addColumn("Groupes assignés(id_group)");
					//int ii = c3.getSelectedIndex()+1;
					//int ii = c3.getSelectedIndex();
					int ii = c3.getSelectedIndex()+1;
					Salle s;
					try {
						s=edi.getSalle(ii);
						Labelerreur2.setText("");
						Object []tableau={s.getId_salle(),s.getNom_ordi(),s.getNom_place(),s.isVideo()};
						dt.addRow(tableau);
						table2.setModel(dt);
						Object []tableau1= new Object[1];
					  
						List<Group> lg =  s.getListGroup();
						if(lg.size()==0)
							Labelerreur2.setText("Pas de groups!");
						for(Group g :lg)
						{
							tableau1[0]=g.toString();
							dt1.addRow(tableau1);
						}
												
						
						table22.setModel(dt1);
						
					
					}
					catch (Exception e1) {
						Labelerreur2.setText("");
					}		
				}	
			});
			
			
			
			
			
		
			
			 //ongler group
			
			 p4.setLayout(null);
			 
			 ajouterGroup= new JLabel("Ajouter Group");
			 ajouterGroup.setForeground(Color.BLUE);
			 ajouterGroup.setFont(new Font("Tahoma", Font.BOLD, 14));
			 ajouterGroup.setBounds(10,26, 184, 30);
			 p4.add(ajouterGroup);
			 
			 choisirSalle = new JLabel("Salle :  ");
			 choisirSalle.setForeground(Color.BLUE);
			 choisirSalle.setFont(new Font("Tahoma", Font.BOLD, 14));
			 choisirSalle.setBounds(40,80, 184, 14);
			 p4.add(choisirSalle);
			 
			 idGroup = new JLabel("Id group: ");
			 idGroup.setForeground(Color.BLUE);
			 idGroup.setFont(new Font("Tahoma", Font.BOLD, 14));
			 idGroup.setBounds(40,220, 184, 30);
			 p4.add(idGroup);
			 
			
			
			 c2 = new JComboBox<>();
				c2.setBounds(150,80, 116, 20);
				p4.add(c2);
				
			for(int i =1;i<=edi.getSalleNom().intValue();i++)
				c2.addItem(i);
			
			c4 = new JComboBox<>();
			c4.setBounds(150,220, 116, 20);
			p4.add(c4);
			
			for(int i =1;i<=edi.getGroupNom().intValue();i++)
				//c4.addItem(i+8);	
			c4.addItem(i);
			 
			
			
			AjouterButton3 = new JButton("Valider");
			AjouterButton3.setFont(new Font("Tahoma", Font.BOLD, 12));
			AjouterButton3.setBounds(150,120, 90, 20);
			p4.add(AjouterButton3);
			
			AfficherButton3 = new JButton("Valideru");
			AfficherButton3.setFont(new Font("Tahoma", Font.BOLD, 12));
			AfficherButton3.setBounds(150,270, 90, 20);
			p4.add(AfficherButton3);
			
			
			
			
			
			
			scrollPane4 = new JScrollPane();
			scrollPane4.setBounds(290,220, 340, 50);
			p4.add(scrollPane4);
			
			
			table4 = new JTable();
			table4.setRowHeight(30);
			scrollPane4.setViewportView(table4);
			
			
		/*	scrollPane42 = new JScrollPane();
			scrollPane42.setBounds(290,185, 340, 150);
			p4.add(scrollPane42);
			
			table42 = new JTable();
			table42.setRowHeight(30);
			scrollPane42.setViewportView(table42);*/
			
			Labelerreur4 = new JLabel(" ");
			Labelerreur4.setForeground(Color.RED);
			Labelerreur4.setFont(new Font("Tahoma", Font.BOLD, 12));
			Labelerreur4.setBounds(10,320, 390, 14);
			p4.add(Labelerreur4);
			
	
			
			AjouterButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int idd = c2.getSelectedIndex();
					
					Salle s;
					
					try {
						s = edi.getSalle(idd+1);
						Group g = new Group(s);
						edi.ajouterGroup(g);
						Labelerreur4.setText("");
						Labelerreur4.setText("Groupe est bien enregistrée");
					
					}
					catch (Exception e1) {
						Labelerreur4.setText("Veuillez remplissez correctement tous les champs!");
					}		
				}	
			});
			
			
			AfficherButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					DefaultTableModel dt = new DefaultTableModel();
				
					
					dt.addColumn("Id_groupe");
					dt.addColumn("Id_salle");
					
					//int ii = c4.getSelectedIndex()+9;
					int ii = c4.getSelectedIndex();
					Group g;
					try {
						
						g=edi.getGroup(ii);
						Labelerreur2.setText("");
						
						Object []tableau={g.getId_group(), g.getSalle().getId_salle()};
						dt.addRow(tableau);
						
					  table4.setModel(dt);	
					}
					
					catch (Exception e1) {
						Labelerreur4.setText("Veuillez remplissez correctement tous les champs!");
					}		
				}	
			});
			
	}
 
}

