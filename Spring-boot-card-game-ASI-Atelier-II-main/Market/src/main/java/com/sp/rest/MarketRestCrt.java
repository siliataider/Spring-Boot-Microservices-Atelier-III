package com.sp.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.dto.DTO_Card;
import com.sp.service.MarketService;

import antlr.collections.List;

@RestController
@CrossOrigin
public class MarketRestCrt {
	@Autowired
    MarketService mService;
	

	 @RequestMapping(method=RequestMethod.GET,value="/buy")
     public DTO_Card[] getBuyList() {
        return mService.getBuyList();
     }
	 
	 @RequestMapping(method=RequestMethod.GET, value="/sell/user/{idUser}")
	 public DTO_Card[] getSellList(@PathVariable String idUser) {
		 return mService.getSellList(idUser);
	 }
	 
	 @RequestMapping(method=RequestMethod.POST, value="/buy/{id_card}/user/{id_user}")
	 public void buy(@PathVariable String id_card,@PathVariable String id_user) {
		 mService.buy(id_user,id_card);
	 }
	 
	 @RequestMapping(method=RequestMethod.POST, value="/sell/{id_card}/user/{id_user}")
	 public void sell(@PathVariable String id_card,@PathVariable String id_user) {
		 mService.sell(id_user,id_card);
	 }
}
