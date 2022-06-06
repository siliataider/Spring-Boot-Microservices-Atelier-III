package com.sp.client;

import com.sp.dto.DTO_Card;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.ListIterator;

@FeignClient(name = "card", url = "http://localhost:8081/")
public interface CardClient {

    @RequestMapping(method= RequestMethod.GET,value="/buy")
    DTO_Card[] getBuyList();

    @RequestMapping(method = RequestMethod.GET, value = "/sell/{idUser}")
    DTO_Card[] getSellList(@PathVariable String idUser);

    @RequestMapping(method = RequestMethod.POST, value = "/buy/{idUser}/{idCard}")
    DTO_Card buy(@PathVariable String idUser,@PathVariable String idCard);


    @RequestMapping(method = RequestMethod.POST, value = "/sell/{idUser}/{idCard}")
    DTO_Card sell(@PathVariable String idUser,@PathVariable String idCard);

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{userId}/random_cards")
    public List<DTO_Card> gatUserRandomCards(@PathVariable int userId);
}
