package com.planner.calc.service.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import com.planner.calc.service.prop.config.AppProperties;
import com.planner.calc.service.services.UserService;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserService userService;

	@Autowired
	private AppProperties appProperties;
	
	@Autowired
	private TokenProvider tokenProvider;

	

	private String ACCESS_TOKEN = "Authorization";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (appProperties.getAuth().getAllowedEndPoints().contains(request.getRequestURI())) {
			filterChain.doFilter(request, response);
		} else {

			String accessToken = request.getHeader(ACCESS_TOKEN);
			boolean isValid = false;
			 if (StringUtils.hasText(accessToken)){
				 isValid = tokenProvider.validateToken(accessToken);				 
			 }

			if (isValid) {
				UserPrincipal userDetails = tokenProvider.getUserPrincipalFromToken(accessToken);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
				filterChain.doFilter(request, response);
			}

			else {
				response.setStatus(response.SC_FORBIDDEN);
			}

		}

	}

}
