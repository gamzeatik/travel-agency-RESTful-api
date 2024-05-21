package travelAgency.agency.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
public class SecurityConfig {

    private final LogoutHandler logoutHandler;

    public SecurityConfig(LogoutHandler logoutHandler) {
        this.logoutHandler = logoutHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/webjars/**",
                                "/swagger-resources/**",
                                "/configuration/ui",
                                "/configuration/security",
                                "/user/**",
                                "/about-us/about-list",
                                "/about-us/about/**",
                                "about-us/about/",
                                "/blogs/blog-list",
                                "/blogs/blog/**",
                                "/contact-us/post-contact-us",
                                "reservation/post-reservation",
                                "tours/tour-list",
                                "tours/tour/**",
                                "transfers/transfer-list",
                                "transfers/transfer/**",
                                "vehicles/vehicle/**",
                                "vehicles/vehicle-list",
                                "transfers/search-transfer"
                        ).permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/user/logout")
                        .addLogoutHandler(logoutHandler)
                        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                );

        return http.build();
    }
}
//gamze
