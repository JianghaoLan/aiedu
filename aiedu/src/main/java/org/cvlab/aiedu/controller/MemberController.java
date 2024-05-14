package org.cvlab.aiedu.controller;

import lombok.extern.slf4j.Slf4j;
import org.cvlab.aiedu.vo.LoginVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {

    @PostMapping("/login")
    public String login(@RequestBody LoginVo loginVo) {
        log.info("Login: {}, {}", loginVo.getUsername(), loginVo.getPassword());
        return "success";
    }
}
