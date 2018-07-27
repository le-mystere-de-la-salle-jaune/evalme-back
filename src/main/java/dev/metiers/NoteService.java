package dev.metiers;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.entites.Note;
import dev.repositories.note.NoteDataJpaRepo;

@Service
public class NoteService {
	private NoteDataJpaRepo noteRepository;

	/**
	 * @param noteRepository
	 */
	public NoteService(NoteDataJpaRepo noteRepository) {
		super();
		this.noteRepository = noteRepository;
	}

	public List<Note> lister() {
		return noteRepository.findAll();
	}
}
