package br.com.siag.controllers;

import br.com.fradetecnologia.controllers.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Index extends Controller{
    
    public Index(HttpServletRequest request, HttpServletResponse response, HttpSession session, String[] args) {
        super(request, response, session, args);
    }    
    
    public void index() throws ServletException, IOException{
        //for(int i = 0; i<args.length; i++){
        //    System.out.println("arg["+Integer.toString(i)+"] = "+args[i]);
        //}
        session.setAttribute("Titulo", "Index");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
