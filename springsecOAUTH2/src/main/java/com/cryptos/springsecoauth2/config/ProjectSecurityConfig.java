package com.cryptos.springsecoauth2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Value("${GITHUB_CLIENT_ID}")
    private String githubClientId;

    @Value("${GITHUB_CLIENT_SECRET}")
    private String githubClientSecret;

    @Value("${FACEBOOK_CLIENT_ID}")
    private String facebookClientId;

    @Value("${FACEBOOK_CLIENT_SECRET}")
    private String facebookClientSecret;

    @Bean
    SecurityFilterChain defaultSecurityChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/secure").authenticated()
                                .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults())
                .build();
    }

//    @Bean
//    ClientRegistrationRepository clientRegistrationRepository() {
//        ClientRegistration github = githubClientRegistration();
//        ClientRegistration facebook = facebookClientRegistration();
//        return new InMemoryClientRegistrationRepository(github, facebook);
//    }
//
//
//    private ClientRegistration githubClientRegistration() {
//        return CommonOAuth2Provider.GITHUB.getBuilder("github")
//                .clientId(githubClientId)
//                .clientSecret(githubClientSecret)
//                .build();
//    }
//
//    private ClientRegistration facebookClientRegistration() {
//        return CommonOAuth2Provider.FACEBOOK.getBuilder("facebook")
//                .clientId(facebookClientId)
//                .clientSecret(facebookClientSecret)
//                .build();
//    }
}
