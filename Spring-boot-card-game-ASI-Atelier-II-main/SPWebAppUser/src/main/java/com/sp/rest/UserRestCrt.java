package com.sp.rest;

import java.util.List;

import com.sp.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.sp.exception.FunctionnalException;
import com.sp.model.User;
import com.sp.service.UserService;


@RestController()
@RequestMapping("/users")
@CrossOrigin(origins = {"localhost:8083", "127.0.0.1:8083"})
public class UserRestCrt implements UserClient {
	@Autowired
    UserService uService;

    @RequestMapping(method=RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        uService.addUser(user);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/{id}")
    public User getUser(@PathVariable String id) {
    	User u=uService.getUser(Integer.valueOf(id));
        return u;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public Iterable<User> getUsers() {
    	return uService.getUsers();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/buy")
    public void buy(@PathVariable int id,@RequestParam int amount)  {
        uService.buy(id, amount);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/sell")
    public void sell(@PathVariable int id, @RequestParam int amount)  {
        uService.sell(id, amount);
    }
    
    
}
