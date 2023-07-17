package com.example.seata.web;

import com.example.seata.api.BusinessService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BusinessController {

    @DubboReference
    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping("/test")
    public ResponseEntity test() {
        businessService.purchase("1", "coat", 4);
        return ResponseEntity.ok(null);
    }


}
