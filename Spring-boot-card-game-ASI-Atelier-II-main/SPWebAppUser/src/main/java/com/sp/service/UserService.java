package com.sp.service;

import java.util.*;


import com.sp.client.CardClient;
import com.sp.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import com.sp.exception.FunctionnalException;
import com.sp.model.User;
import com.sp.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository uRepository;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private CardClient cardClient;

   @Transactional
    public User addUser(User user) {
        user.setMoney(5000);
        User createdUser = uRepository.save(user);
        this.cardClient.gatUserRandomCards(createdUser.getId());
        return user;
    }

    public User getUser(int id) {
        Optional<User> uOpt = uRepository.findById(id);
        if (uOpt.isPresent()) {
            return uOpt.get();
        } else {
            return null;
        }
    }

    public User getUserBySurname(String surname) {
        User u = uRepository.findBySurname(surname);
        if (Objects.isNull(u)) {
            return null;
        } else {
            return u;
        }
    }

    public List<User> getUsers() {
        return (List<User>) uRepository.findAll();
    }

    public String checkUser(LoginDto user) throws FunctionnalException {

        User u = uRepository.findBySurname(user.getUsername());

        if (Objects.isNull(u) || (!user.getPassword().equals(u.getPassword()))) {
            throw new FunctionnalException("utilisateur n existe pas");
        }

        return jwtTokenService.generateToken(u);


    }

    public void buy(int id, int amount) {
        uRepository.findById(id).ifPresent(user ->
                user.setMoney(user.getMoney() - amount));
    }

    public void sell(int id, int amount)  {
        uRepository.findById(id).ifPresent( user ->
        user.setMoney(user.getMoney() + amount));
    }
}
