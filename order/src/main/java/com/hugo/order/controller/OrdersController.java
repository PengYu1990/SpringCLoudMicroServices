package com.hugo.order.controller;

import com.hugo.order.client.UserClient;
import com.hugo.order.controller.dto.OrdersTDO;
import com.hugo.order.model.Orders;
import com.hugo.order.controller.dto.UserDTO;
import com.hugo.order.repository.OrdersRepository;
import jakarta.ws.rs.HeaderParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;
    @GetMapping("/{id}")
    public OrdersTDO get(@PathVariable("id") Long id, @RequestHeader("p") String param){
        Orders order = ordersRepository.findById(id).get();
        OrdersTDO ordersTDO = new OrdersTDO();
        BeanUtils.copyProperties(order, ordersTDO);
//        String url = "http://userservice/user/" + order.getUserId();
//        UserDTO user = restTemplate.getForObject(url, UserDTO.class);

        UserDTO user = userClient.findById(order.getUserId());
        ordersTDO.setUser(user);

        System.out.println(param);
        return ordersTDO;
    }
}
