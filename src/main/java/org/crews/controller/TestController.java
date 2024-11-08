package org.crews.controller;

import lombok.RequiredArgsConstructor;
import org.crews.dto.CustomerToCore;
import org.crews.service.CoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final CoreService coreService;

    /**
     * 블로킹 방식으로 API 호출 수행
     * 해당 메소드는 동기적으로 호출되며, 응답을 받을 때까지 현재 스레드를 대기시킵니다.
     * @return
     */
    @PostMapping("/block")
    public String callTestApiBlock(){
        CustomerToCore customer = CustomerToCore.builder()
                .identity("ABC")
                .name("홍길동")
                .juminNumber("123123123")
                .build();
        return coreService.postTestBlocking(customer); // API 호출
    }

    /**
     * 논블로킹 방식으로 API 호출을 수행
     * 해당 메소드는 비동기적으로 호출되며, Mono 객체를 반환하여 이후 처리될 수 있도록 합니다.
     * @return
     */
    @PostMapping("/nonblock")
    public Mono<String> callTestApiNonBlock(){
        CustomerToCore customer = CustomerToCore.builder()
                .identity("ABC")
                .name("임걱정")
                .juminNumber("000101123456")
                .build();
        return coreService.postTestNonBlocking(customer);
    }
}
