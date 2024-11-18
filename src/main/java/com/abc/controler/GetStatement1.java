package com.abc.controler;

import java.io.IOException;
import java.util.ArrayList;

import com.abc.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/GetStatement1")
public class GetStatement1 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		
		try {
			Model m = new Model();
			m.setAccno(accno);
			ArrayList a1 = m.getStatement();
			
			
			
			
			if(a1.isEmpty()==true) {
				response.sendRedirect("/BankingApplication/StatementFail.html");
			}
			else {
				session.setAttribute("sal", m.sal);
				session.setAttribute("ral", m.ral);
				session.setAttribute("al", m.al);
				response.sendRedirect("/BankingApplication/StatementSuccess.jsp");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
