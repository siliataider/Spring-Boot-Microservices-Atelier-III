package com.sp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.sp.model.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {

	public List<Card> findByName(String name);

	@Query("select c from Card c where c.id_user = 0")
	public List<Card> findByUserNull();

	@Override
	public List<Card> findAll();
}
