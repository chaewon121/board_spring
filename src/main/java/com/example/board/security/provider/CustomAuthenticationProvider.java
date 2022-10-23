package com.example.board.security.provider;

import com.example.board.security.service.AccountContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        AccountContext accountContext = (AccountContext)userDetailsService.loadUserByUsername(username);

        if (!passwordEncoder.matches(password, accountContext.getAccount().getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        } //일치하는지 검증

        UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(accountContext.getAccount(),null,accountContext.getAuthorities());


        return authenticationToken;
    } //검증을 위한 구현

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
     //어쎈티케이션
}
