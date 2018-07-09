package dev.repositories.examen;

import dev.repositories.BaseRepositoryMemoire;
import org.springframework.stereotype.Service;

import dev.entites.Examen;

@Service
public class ExamenBaseRepositoryMemoire extends BaseRepositoryMemoire {

	public ExamenBaseRepositoryMemoire() {
		super("jdd/jdd-examens.xml", Examen.class);
	}

}
