package com.abc.controler;

import java.io.IOException;

import com.abc.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/Register")
public class Register extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String custid =request.getParameter("custid");		
		String saccno =request.getParameter("accno");//collects the data in the form of string
		int accno = Integer.parseInt(saccno);//convert string data into integer data	
		String pwd =request.getParameter("pwd");		
		String sbal =request.getParameter("bal");
		int bal = Integer.parseInt(sbal);	
		String email =request.getParameter("email");
		
		System.out.println("register java file ...");
		
		try {
			Model m = new Model();
			m.setName(name);
			m.setCustid(custid);
			m.setAccno(accno);
			m.setPwd(pwd);
			m.setBal(bal);
			m.setEmail(email);
			
			boolean b=m.resister();
			
			if(b==true) {
				response.sendRedirect("/BankingApplication/SuccessReg.html");
			}
			else {
				response.sendRedirect("/BankingApplication/FailureReg.html");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
































