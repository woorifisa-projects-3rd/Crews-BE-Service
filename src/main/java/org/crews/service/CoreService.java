package org.crews.service;

import lombok.extern.slf4j.Slf4j;
import org.crews.dto.CustomerToCore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Service
@Slf4j
public class CoreService {
    private final WebClient webClient;
    private final String accessKey;
    private final String secretKey;

    // 생성자를 통해 의존성을 주입받음
    public CoreService(
            @Value("${core.api.base-url}") String baseUrl,
            @Value("${bank.core.access-key}") String accessKey,
            @Value("${bank.core.secret-key}") String secretKey) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl) // baseUrl 주입
                .build();
        this.accessKey = accessKey; // accessKey 주입
        this.secretKey = secretKey; // secretKey 주입
    }

    // POST 요청 - 블로킹 방식
    public String postTestBlocking(CustomerToCore customer) {
        try {
            log.info("블로킹 방식 API 호출 시작 - Access Key: {}", accessKey);
            return webClient.post()
                    .uri("/test-api/block")
                    .headers(headers -> {
                        headers.set("X-ACCESS-KEY", accessKey);
                        headers.set("X-SECRET-KEY", secretKey);
                        log.info("Request Headers: X-ACCESS-KEY={}, X-SECRET-KEY={}", accessKey, secretKey);
                    })
                    .bodyValue(customer)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();  // 블로킹 방식으로 Mono 값을 얻음
        } catch (WebClientResponseException e) {
            log.error("API 호출 중 오류 발생", e);
            return "호출 실패: " + e.getMessage();
        }
    }

    // POST 요청 - 논블로킹 방식
    public Mono<String> postTestNonBlocking(CustomerToCore customer) {
        log.info("논블로킹 방식 API 호출 시작 - Access Key: {}", accessKey);

        return webClient.post()
                .uri("/test-api/nonblock")
                .headers(headers -> {
                    headers.set("X-ACCESS-KEY", accessKey);
                    headers.set("X-SECRET-KEY", secretKey);
                    log.info("Request Headers: X-ACCESS-KEY={}, X-SECRET-KEY={}", accessKey, secretKey);
                })
                .bodyValue(customer)
                .retrieve()
                .bodyToMono(String.class)
                .retryWhen(Retry.backoff(3, Duration.ofSeconds(5)) // 재시도 로직 설정
                        .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) -> {
                            log.error("재시도 횟수 초과. 마지막 오류: {}", retrySignal.failure());
                            return retrySignal.failure();
                        })
                )
                .doOnError(e -> log.error("API 호출 중 오류 발생", e));
    }

    // POST 요청- 사용자의 모든 계좌 조회
//    public
    // POST 요청 - 계좌 등록 (핀테크이용번호발급)

    // POST 요청 - 계좌 이체 (핀테크이용번호사용)

}
