package com.abc.controler;

import java.io.IOException;

import com.abc.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Loan")
public class Loan extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		int accno = (int) session.getAttribute("accno");
		
		try {
			Model m = new Model();
			m.setAccno(accno);
			
			boolean b=m.applyLoan();
			
			if(b==true) {
				session.setAttribute("name", m.getName());
				session.setAttribute("email", m.getEmail());
				response.sendRedirect("/BankingApplication/LoanSuccess.jsp");
			}
			else {
				response.sendRedirect("/BankingApplication/LoanFail.html");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}


}
