package com.sp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user", url = "http://localhost:8083/users")
public interface UserClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/buy")
    void buy(@PathVariable int id, @RequestParam int amount);

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/sell")
    void sell(@PathVariable int id, @RequestParam int amount);
}
