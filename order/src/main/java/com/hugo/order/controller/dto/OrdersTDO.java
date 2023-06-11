package com.hugo.order.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class OrdersTDO {
    private Long id;
    private Long userId;

    private String title;
    private LocalDateTime ctime;

    private UserDTO user;
}
