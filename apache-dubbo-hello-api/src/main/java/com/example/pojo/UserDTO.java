package com.example.pojo;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO implements Serializable {

    private Long id;

    private String name;

    private String desc;

}
