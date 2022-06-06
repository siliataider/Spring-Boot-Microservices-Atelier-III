package com.sp.rest;

import com.sp.dto.LoginDto;
import com.sp.exception.FunctionnalException;
import com.sp.model.User;
import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8083", "http://127.0.0.1:8083"})
public class LoginRestCrt {

    @Autowired
    private UserService uService;

    @RequestMapping(method= RequestMethod.POST, value = "/login")
    public String checkUser(@RequestBody LoginDto user) {
        try {
            return uService.checkUser(user);
        } catch (FunctionnalException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
