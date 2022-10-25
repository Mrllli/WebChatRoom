package com.github.l.jackson.web.chat.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.l.jackson.web.chat.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @ResponseBody
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public Result login(@RequestBody LoginRequest request){
        log.info("請求 request:{}", request.loginName);
        return new Result(request.getLoginName());
    }

    private static class LoginRequest {
        private String loginName;

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }
    }
}