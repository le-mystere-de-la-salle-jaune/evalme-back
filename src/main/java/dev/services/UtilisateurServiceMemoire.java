package dev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.entites.Utilisateur;

@Service
public class UtilisateurServiceMemoire extends ServiceMemoire {

	private List<Utilisateur> utilisateurs = new ArrayList<>();

	public UtilisateurServiceMemoire() {
		super("jdd/jdd-utilisateur.xml", UtilisateurServiceMemoire.class);
	}

}
