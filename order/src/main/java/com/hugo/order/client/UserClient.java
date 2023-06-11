package com.hugo.order.client;


import com.hugo.order.controller.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")
public interface UserClient {

    @GetMapping("/user/{id}")
    public UserDTO findById(@PathVariable("id") Long id);
}
