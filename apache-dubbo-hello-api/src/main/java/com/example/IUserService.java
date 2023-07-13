package com.example;

import com.example.pojo.UserDTO;

import java.io.Serializable;

public interface IUserService extends Serializable {

    Response<UserDTO> queryUserById(Long id);

}
