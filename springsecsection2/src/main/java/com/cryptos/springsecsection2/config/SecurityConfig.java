package com.cryptos.springsecsection2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception {

        /* Desc: Below regexPattern will hold true for :
         *        - pattern containing health in its resource
         *        - pattern if it not contains
         *           > /actuator/<something>
         *           > /v2/api-docs
         *           > /swagger-ui.html
         * */
        String regexPattern = "^(?!.*(/actuator/.*|/v2/api-docs|/swagger-ui.html)).*$";
        RegexRequestMatcher regexRequestMatcher = new RegexRequestMatcher(regexPattern, null);
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(regexRequestMatcher).permitAll()
                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
