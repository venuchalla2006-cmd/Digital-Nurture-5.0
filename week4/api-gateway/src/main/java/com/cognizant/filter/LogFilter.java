package com.cognizant.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LogFilter implements GlobalFilter, Ordered {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        LOGGER.info("START - LogFilter intercepting request for path: {}", path);
        
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            LOGGER.info("END - LogFilter finished request execution for path: {}", path);
        }));
    }

    @Override
    public int getOrder() {
        return -1; // High priority (executes early in the gateway chain)
    }
}
