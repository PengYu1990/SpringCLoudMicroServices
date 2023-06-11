package com.hugo.order.model;

import com.hugo.order.controller.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;

    private String title;
    private LocalDateTime ctime;

}
