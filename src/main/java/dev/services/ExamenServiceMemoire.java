package dev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.entites.Examen;

@Service
public class ExamenServiceMemoire extends ServiceMemoire {

	private List<Examen> examens = new ArrayList<>();

	public ExamenServiceMemoire() {
		super("jdd/jdd-examens.xml", Examen.class);
	}

}
