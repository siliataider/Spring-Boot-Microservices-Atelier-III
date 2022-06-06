package com.sp.service;

import java.util.*;

import com.sp.dto.DTO_Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.repository.CardRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardService {
	private List<DTO_Card> myCardList ;
	@Autowired
	CardRepository cRepository;
	//UserService uService;
	
	
	public DTO_Card addCard(Card h) {
		Card createdCard=cRepository.save(h);
		return createdCard.toDto();
	}
	
	public Card getCard(Integer id) {
		Optional<Card> hOpt = cRepository.findById(id);
		if (hOpt.isPresent()) {

			return hOpt.get();
		}else {
			return null;
		}
	}
	
	public List<Card> getSellList(int idUser){
		List<Card> buyList =  new LinkedList<Card>();
		Iterable<Card> cardIt = cRepository.findAll();
		cardIt.forEach((card) -> {
									if(card.getId_user() == idUser){
										buyList.add(card);
										}
								}
		);
		
		return(buyList);
	}
	
	
	public List<Card> getBuyList(){
		return cRepository.findByUserNull();
	}

	@Transactional
	public DTO_Card buy(Integer idUser, Integer idCard) {
		Card card = getCard(idCard);
		card.setId_user(idUser);
		cRepository.save(card);
		return card.toDto();
	}
	
	@Transactional
	public DTO_Card sell(Integer idUser, Integer idCard) {
		Card card = getCard(idCard);
		card.setId_user(0);
		cRepository.save(card);
		return card.toDto();
	}

	@Transactional
	public List<DTO_Card> getRandomCards(Integer userId) {
		List<Card> cardIt = cRepository.findByUserNull();
		List<DTO_Card> myRandomList = new ArrayList();
		Random rand = new Random();
		int numberOfElements = 5;
		for (int i = 0; i < numberOfElements; i++) {
			int randomIndex = rand.nextInt(cardIt.size());
			myRandomList.add(cardIt.get(randomIndex).toDto());
			cardIt.get(randomIndex).setId_user(userId);
			cRepository.save(cardIt.get(randomIndex));
			cardIt.remove(randomIndex);
		}
		return myRandomList;
	}

}

