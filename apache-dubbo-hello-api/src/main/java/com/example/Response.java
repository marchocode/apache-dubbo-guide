package com.example;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Response<T> implements Serializable {

    private T data;

    private String info;

    private Integer success;

}
