package com.exit.config;


import com.exit.service.impl.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    This class is for filter the unauthorized request
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    JwtUtil jwtUtil;

    /*
        This method is for filter the request
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       final String requestTokenHeader = request.getHeader("Authorization");
        System.out.println(requestTokenHeader);
        String username = null;
        String jwtToken=null;

        if (requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
        {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = this.jwtUtil.extractUsername(jwtToken);
            }
            catch (ExpiredJwtException e)
            {
                e.printStackTrace();
                System.out.println("Jwt Token has expired");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("error");
            }

            /*
                Validate the token
             */
            if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
            {
                final UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(username);
                if (this.jwtUtil.validateToken(jwtToken,userDetails))
                {
                    //token is valid
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
            else {
                System.out.println("Token is not valid");
            }
        }
        else {
            System.out.println("Invalid token not starts with Bearer");
        }

        filterChain.doFilter(request,response);
    }
}
