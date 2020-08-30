package com.gawcode.tameshite.auth;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Instant;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class AuthTokenProvider implements InitializingBean {

   private static final String AUTHORITIES_KEY = "auth";

   private final String base64Secret;
   private final long validity, validityRemember;

   private Key key;


   public AuthTokenProvider(
      @Value("${token.base64-secret}") String base64Secret,
      @Value("${token.token-validity}") long tokenValidityInSeconds,
      @Value("${token.token-validity-remember-me}") long tokenValidityInSecondsForRememberMe) {
      this.base64Secret = base64Secret;
      this.validity = tokenValidityInSeconds * 1000;
      this.validityRemember = tokenValidityInSecondsForRememberMe * 1000;
   }

   @Override
   public void afterPropertiesSet() {
      byte[] keyBytes = Base64.getDecoder().decode(base64Secret);
      this.key = Keys.hmacShaKeyFor(keyBytes);
   }

   public String createToken(Authentication authentication, boolean remember) {
      String authorities = authentication.getAuthorities().stream()
         .map(GrantedAuthority::getAuthority)
         .collect(Collectors.joining(","));

      long now = Instant.now().getEpochSecond();
      Date validity = new Date(now + (remember ? this.validityRemember : this.validity));

      return Jwts.builder()
         .setSubject(authentication.getName())
         .claim(AUTHORITIES_KEY, authorities)
         .signWith(key, SignatureAlgorithm.HS512)
         .setExpiration(validity)
         .compact();
   }

   public Authentication getAuthentication(String token) {
      Claims claims = Jwts.parser()
         .setSigningKey(key)
         .parseClaimsJws(token)
         .getBody();

      Collection<? extends GrantedAuthority> authorities =
         Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

      User principal = new User(claims.getSubject(), "", authorities);

      return new UsernamePasswordAuthenticationToken(principal, token, authorities);
   }

   public boolean validateToken(String authToken) {
      try {
         Jwts.parser().setSigningKey(key).parseClaimsJws(authToken);
         return true;
      } catch (Exception exception) {
         exception.printStackTrace();
      }

      return false;
   }
}