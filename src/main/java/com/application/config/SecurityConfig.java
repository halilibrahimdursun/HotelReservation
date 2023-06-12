package com.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class    SecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("broekhuis").password(passwordEncoder().encode("broekhuis")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("1")).roles("USER","ADMIN");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/"
                        , "/h2-console/**"
                        , "/index"
                        , "/index.html"
                        , "/about-us.html"
                        , "/contact.html"
                        , "/rooms.html"
                        , "/room-single.html"
                        , "/room-double.html"
                        , "/room-family.html"
                        , "/room-penthouse.html"
                        , "/img/**"
                        , "/images/**"
                        , "/fonts/**"
                        , "/Source/**"
                        , "/js/**"
                        , "/css/**"
                        , "/api/**"
                        ,"/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui/**",
                        "/webjars/**"
                ).permitAll()
                .requestMatchers("/customer*", "/room").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/reservation*").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/index")
                .invalidateHttpSession(true)
                .permitAll()
        ;

        return http.build();

    }
}
