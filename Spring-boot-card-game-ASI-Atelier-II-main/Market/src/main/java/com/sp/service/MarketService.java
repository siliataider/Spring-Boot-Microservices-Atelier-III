package com.sp.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import com.sp.client.CardClient;
import com.sp.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sp.dto.DTO_Card;

import antlr.collections.List;

@Service
public class MarketService {

	@Autowired
	private UserClient userClient;

	@Autowired
	private CardClient cardClient;

	public DTO_Card[] getBuyList() {
		return cardClient.getBuyList();
	}
	
	public DTO_Card[] getSellList(String idUser) {
		return cardClient.getSellList(idUser);
	}

	public void buy(String id_user,String id_card) {
		DTO_Card cardDto = cardClient.buy(id_user, id_card);
		userClient.buy(Integer.parseInt(id_user), cardDto.getPrice());
	}

	public void sell(String id_user,String id_card) {
		DTO_Card cardDto = cardClient.sell(id_user, id_card);
		userClient.sell(Integer.parseInt(id_user), cardDto.getPrice());
	}
	
	
}
