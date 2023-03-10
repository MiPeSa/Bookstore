package k23BE.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import k23BE.Bookstore.web.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailServiceImpl userDetailsService;	
	
    private static final AntPathRequestMatcher[] WHITE_URLS = {
    	new AntPathRequestMatcher("/api/**"),
    	new AntPathRequestMatcher("/h2-console/**"),
    	new AntPathRequestMatcher("/books/**")
    };
    
    private static final AntPathRequestMatcher[] ADMIN_URLS = {
        	new AntPathRequestMatcher("/admin/**"),
    };
    
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().requestMatchers(ADMIN_URLS).hasAuthority("ADMIN")
        .and()
        .authorizeRequests()
        	.requestMatchers(WHITE_URLS).permitAll() // Enable css when logged out
        	.anyRequest().authenticated()
        	.and()
        	.headers().frameOptions().disable()
        	.and()
      .formLogin()
          .defaultSuccessUrl("/booklist", true)
          .permitAll()
          .and()
      .logout()
          .permitAll()
          .and()
     .httpBasic();
        
        http.cors().and().csrf().disable();
        
     return http.build();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
