package vttp2022.ssfworkshop16.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import vttp2022.ssfworkshop16.Service.RedisService;

@RestController
public class UserRestController {
    @Autowired
    RedisService service;

}
