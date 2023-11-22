package project.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static project.config.ConstansConfig.*;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Configuration WebSecurity
     */

    private final UserDetailsService userDetailsService;

    /**
     * Configuration WebSecurity
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(LOGIN).permitAll()
                .antMatchers(REGISTRATION).permitAll()
                .and()
                .formLogin(form -> {
                    try {
                        form
                                .loginPage(LOGIN)
                                .permitAll()
                                .defaultSuccessUrl(DEFAULT_SUCCESS_URL, true)
                                .and()
                                .logout()
                                .permitAll()
                                .logoutSuccessUrl(LOGIN);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
