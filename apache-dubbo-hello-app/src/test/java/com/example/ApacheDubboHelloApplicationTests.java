package com.example;

import com.example.pojo.UserDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApacheDubboHelloApplicationTests {

    @DubboReference
    private IUserService iUserService;

    @Test
    public void test_userService() {
        Response<UserDTO> userDTO = iUserService.queryUserById(1l);
        System.out.println(userDTO);
    }

}
