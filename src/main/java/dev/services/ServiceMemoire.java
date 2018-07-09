package dev.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.entites.BaseEntite;

public abstract class ServiceMemoire<T extends BaseEntite> implements CrudService<T> {

	private List<T> entityList = new ArrayList<>();
	private String contextpath;
	private final Class<T> typeOfArray;

	public ServiceMemoire(String contextpath, Class<T> typeOfArray) {
		this.contextpath = contextpath;
		this.typeOfArray = typeOfArray;
	}

	@PostConstruct
	protected void initialiser() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(contextpath)) {
			context.getBeansOfType(typeOfArray).forEach((k, v) -> entityList.add(v));
		}
	}

	@Override
	public List<T> findAll() {
		return entityList;
	}

	@Override
	public void save(T entite) {
		entityList.add(entite);

	}

	@Override
	public void update(T entityWithId) {
		for (T elem : entityList) {
			if (elem.getId().equals(entityWithId.getId())) {
				entityList.set(entityList.indexOf(elem), entityWithId);
			}
		}
	}

	@Override
	public void delete(T entite) {
		if (entityList.contains(entite)) {
			entityList.remove(entite);
		}
	}

}
