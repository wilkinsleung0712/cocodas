package com.bfd.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse resposne = (HttpServletResponse) res;
		
		String authHeader = request.getHeader("Authorization");
		if("OPTIONS".equals(request.getMethod())){
			resposne.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(request, resposne);
			
		}else{
			if(authHeader == null || !authHeader.startsWith("Bearer ")){
				throw new ServletException ("Missing or invalid Authorization header");
			}
			
			final String token = authHeader.substring(7);
			
			try{
				final Claims claims = Jwts.parser().setSigningKey("securetkey").parseClaimsJws(token).getBody();
				request.setAttribute("claims", claims);
			}catch (final SignatureException e) {
        		throw new ServletException ("Invalid token");
        	}
			
			chain.doFilter(req, res);
		}
	}

}
