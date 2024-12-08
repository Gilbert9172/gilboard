package com.gilboard.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminV1Controller {

    @GetMapping("/admin/v1")
    public void test() {
        System.out.println("Admin Test");
    }

}
