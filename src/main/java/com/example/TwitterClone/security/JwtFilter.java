package com.example.TwitterClone.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtFilter implements javax.servlet.Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String header = httpServletRequest.getHeader("authorization");

        String token = header.substring(7);
        Claims claims = Jwts.parser().setSigningKey("[83, 73, -109, -4, 73, 85, -21, -104, -88, -102, 11, -21, 78, -118, -110, -30]").parseClaimsJws(token).getBody();
        servletRequest.setAttribute("claims", claims);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
