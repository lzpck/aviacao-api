package tech.devinhouse.aviacao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                        .anyRequest().authenticated())
                .httpBasic();

        // Desabilita as opções de frame para permitir o acesso à console H2
        http.headers().frameOptions().disable();

        // Desabilita a proteção CSRF para permitir o acesso à console H2
        http.csrf().disable();

        return http.build();
    }
}