package com.gm.config;

import com.gm.handler.LoginFailureHandler;
import com.gm.handler.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName WebSecurityConfig
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/13/013 22:28
 * @Version 1.0
 **/
@Component
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private LoginSuccessHandler loginSuccessHandler;
    @Resource
    private LoginFailureHandler loginFailureHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //存入内存使用
        auth.inMemoryAuthentication().withUser("admin").password("123456").authorities("addOrder");
        //        auth.inMemoryAuthentication().withUser("user").password("12345").authorities("add");

/*
        //从数据库获取用户验证
        auth.userDetailsService(myUserDetails).passwordEncoder(new PasswordEncoder() {

            //将输入的密码加密
            @Override
            public String encode(CharSequence charSequence) {
                return EncryptionUtils.md5Hex(charSequence.toString());
            }


            //检验输入的密码与数据库密码
            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return EncryptionUtils.md5Hex(charSequence.toString()).equals(s);
            }
        });

 */
    }

    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //放行login页面，拦截其他页面
        http.authorizeRequests().antMatchers("/admin/**", "/seller/login", "/css/**", "/js/**", "/img/**", "/plugins/**").permitAll()
                .anyRequest().fullyAuthenticated().and().formLogin().loginPage("/seller/login")
                .successHandler(loginSuccessHandler).failureHandler(loginFailureHandler).and().logout().and().csrf().disable();
        http.headers()
                .frameOptions().sameOrigin()
                .httpStrictTransportSecurity().disable();  /*允许同源开iframe*/
        //从数据库获取需要权限访问的url
/*       ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests = http.authorizeRequests();
        List<Permission> permissionList = permissionService.findAllPermission();
        permissionList.forEach(e -> authorizeRequests.antMatchers(e.getUrl()).hasAuthority(e.getPermTag()));
        //放行login页面，拦截其他页面
        authorizeRequests.antMatchers("/login").permitAll()
                .anyRequest().fullyAuthenticated().and().formLogin().loginPage("/login").and().csrf().disable();
    }

 */
    }
}
