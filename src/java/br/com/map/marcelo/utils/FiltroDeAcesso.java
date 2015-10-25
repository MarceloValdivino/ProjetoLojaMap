/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.utils;

import br.com.map.marcelo.entidades.Funcionario;
import java.io.IOException;
import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marcelo
*/
@WebFilter(servletNames = {"Faces Servlet"})
public class FiltroDeAcesso implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession(false);

        Funcionario funcionario = (session != null) ? (Funcionario) session.getAttribute("funcionario") : null;
        String loginURL = request.getContextPath() + "/login.jsf";

        boolean loginRequest = request.getRequestURI().startsWith(loginURL);
        boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);

        if (funcionario != null || loginRequest || resourceRequest) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURL);
        }
    }

    @Override
    public void destroy() {
        
    }
    
}
