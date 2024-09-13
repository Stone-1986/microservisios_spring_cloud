package com.netec.ms_gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Component
public class GlobalFilters implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Ejecutando el Filtro PRE {}, {} ", exchange, chain);
        exchange.getRequest().mutate().headers(x -> x.add("token", "12345"));
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            exchange.getResponse().getCookies().add("nombre", ResponseCookie.from("nombre", "taller_Micro_Cookie").build());
            exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
            Optional.ofNullable(exchange.getRequest().getHeaders().getFirst("token")).ifPresent(token -> {
                exchange.getResponse().getHeaders().add("token", token);
            });
        }));
    }
}
