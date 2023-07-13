package com.example.rpc;

import com.example.IUserService;
import com.example.Response;
import com.example.pojo.UserDTO;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class UserService implements IUserService {

    @Override
    public Response<UserDTO> queryUserById(Long id) {

        UserDTO userDTO = new UserDTO(id, "hello-world", "some describe...");
        return new Response<UserDTO>(userDTO, "OK", 0);
    }
}
