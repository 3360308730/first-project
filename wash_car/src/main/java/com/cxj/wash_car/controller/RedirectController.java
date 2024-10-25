package com.cxj.wash_car.controller;

import com.wf.captcha.SpecCaptcha;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class RedirectController {

    @GetMapping("/getCode")
    public String getCode() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        String code = specCaptcha.text().toLowerCase();
        return specCaptcha.toBase64();
    }
}
