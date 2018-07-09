package dev.services;

import org.springframework.stereotype.Service;

import dev.entites.Examen;

@Service
public class ExamenServiceMemoire extends ServiceMemoire {

	public ExamenServiceMemoire() {
		super("jdd/jdd-examens.xml", Examen.class);
	}

}
