package br.com.siag.filters;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SegurancaFilter implements Filter {
    
    private FilterConfig filterConfig = null;
    
    public SegurancaFilter() {
        
    }    
    
public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        Connection connection = (Connection) request.getAttribute("CONEXAO");
        String sistema = "publico";
        boolean autenticado = false;
        boolean autorizado = false;
        HttpServletRequest req = ((HttpServletRequest) request);
        HttpServletResponse res = ((HttpServletResponse) response);
        HttpSession sessao = ((HttpServletRequest)request).getSession();
        
        String SUBDIR = req.getAttribute("SUBDIR").toString();
        String requestURI = req.getAttribute("requestURI").toString();
        String[] uri = (String[]) req.getAttribute("URI");
        
        if (sistema.equalsIgnoreCase("publico")){
            autenticado = true;
            autorizado = true;
            request.setAttribute("MENU", "publico");
        } else {
            if (autenticado){
                String UserSys = sessao.getAttribute("UserSystem").toString();
                if (sistema.equalsIgnoreCase("admin")){
                    if (UserSys.equalsIgnoreCase("A")) autorizado = true;
                    request.setAttribute("MENU", "admin");
                } else if (sistema.equalsIgnoreCase("desif")){
                    if (UserSys.equalsIgnoreCase("D")) autorizado = true;
                    request.setAttribute("MENU", "desif");
                } else if (sistema.equalsIgnoreCase("nfse")){
                    if (UserSys.equalsIgnoreCase("N")) autorizado = true;
                    request.setAttribute("MENU", "nfse");
                } else {
                    autenticado = false;
                    autorizado = false;
                    request.setAttribute("MENU", "publico");
                }
            }
        }
        
        if (!autenticado){
            res.sendRedirect(SUBDIR+"/Login");
            return;
        }
        
        if (!autorizado){
            res.sendRedirect(SUBDIR+"/NaoAutorizado");
            return;
        }
        
        chain.doFilter(request, response);
        
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {        
    }

    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }
        
}
