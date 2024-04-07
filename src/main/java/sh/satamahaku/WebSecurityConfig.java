package sh.satamahaku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

import sh.satamahaku.web.UserDetailService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
    @Autowired
    private UserDetailService userDetailsService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
        .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/loginpage").permitAll()
                                .requestMatchers("/newuser").permitAll()
                                .requestMatchers("/savenewuser").permitAll()
                                .requestMatchers(toH2Console()).permitAll() // for h2console
                                .anyRequest().authenticated()
                                )
                                .csrf(csrf -> csrf
                                .ignoringRequestMatchers(toH2Console())
                                )
                                .headers(headers -> headers                 //for h2console
                                .frameOptions(frameoptions -> frameoptions  //for h2console
                                .disable())                                    //for h2console
                                )
                                .formLogin(formlogin -> formlogin
                                .loginPage("/login")
                                .defaultSuccessUrl("/harbourlist", true)
                                .permitAll()
                                )
                                .logout(logout -> logout
                                .permitAll()
                                );
                                return http.build();
    }


    @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
