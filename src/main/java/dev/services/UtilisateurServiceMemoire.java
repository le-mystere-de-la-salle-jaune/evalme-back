package dev.services;

import org.springframework.stereotype.Service;

import dev.entites.Utilisateur;

@Service
public class UtilisateurServiceMemoire extends ServiceMemoire {

	public UtilisateurServiceMemoire() {
		super("jdd/jdd-utilisateur.xml", Utilisateur.class);
	}

}
