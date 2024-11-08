package org.crews.controller;

import lombok.RequiredArgsConstructor;
import org.crews.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class AccountController {
    private final AccountService accountService;
}
