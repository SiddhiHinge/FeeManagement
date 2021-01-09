package com.project;

import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Beans.Accountant;
import com.project.Beans.Student;

public class ProjectController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		ProjectRepository repository = new ProjectRepository();
		String requestAction = request.getParameter("requestAction");
		System.out.println("requestAction = " + requestAction);
		//String logout1 = request.getParameter("logout1");
		//System.out.println("logout1 = "+logout1);

		if (requestAction.equalsIgnoreCase("adminLogin")) {
			System.out.println("In login method now !");
			String adminEmail = request.getParameter("adminEmail");
			String adminPassword = request.getParameter("adminPassword");

			boolean loginResult = repository.checkLoginAdmin(adminEmail, adminPassword);
			if (loginResult) {
				try {
					System.out.println("Login Success !");
					response.sendRedirect("AdminPanel.jsp");
				} catch (Exception e) {
					System.out.println("error" + e);
				}

			} else {

				try {
					response.sendRedirect("Login.jsp");

				} catch (Exception e) {
					System.out.println("Error" + e);
				}
			}
		}
		
		else if (requestAction.equalsIgnoreCase("accountantLogin")) {
			String accEmail = request.getParameter("accEmail");
			String accPassword = request.getParameter("accPassword");

			boolean loginResult = repository.checkLoginAccountant(accEmail, accPassword);
			if (loginResult) {
				try {
					response.sendRedirect("AccountantPanel.jsp");
				} catch (Exception e) {
					System.out.println("error" + e);
				}

			} else {

				try {
					response.sendRedirect("Login.jsp");

				} catch (Exception e) {
					System.out.println("error" + e);
				}
			}
		}
		
		else if (requestAction.equalsIgnoreCase("Logout Admin")) {
			System.out.println("In logout admin");
			String message1 = "Logged out successfully";
			
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			request.setAttribute("message1", message1);
			
			try {
				rd.forward(request, response);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(requestAction.equalsIgnoreCase("Admin Panel")) {
			System.out.println("In admin panel display function !");
			RequestDispatcher rd = request.getRequestDispatcher("AdminPanel.jsp");
			
			try {
				rd.forward(request, response);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(requestAction.equalsIgnoreCase("Accountant Panel")) {
			System.out.println("In Accountant panel display function !");
			RequestDispatcher rd = request.getRequestDispatcher("AccountantPanel.jsp");
			
			try {
				rd.forward(request, response);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (requestAction.equalsIgnoreCase("Logout Accountant")) {
			System.out.println("In logout accountant");
			String message2 = "Logged out successfully";
			
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			request.setAttribute("message2", message2);
			
			try {
				rd.forward(request, response);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

		else if (requestAction.equalsIgnoreCase("viewAllAccountant")) {
			System.out.println("Inside View All Accountant !");

			repository.getAllAccountants();
			List<Accountant> listOfAllAccountants = repository.getAllAccountants();
			RequestDispatcher rd = request.getRequestDispatcher("ViewAccountant.jsp");
			request.setAttribute("listOfAllAccountants", listOfAllAccountants);
			try {
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println("Exception Occured:" + e);
			}
		}
		
		else if(requestAction.equalsIgnoreCase("viewAllStudent")) {
			System.out.println("I am inside view Student !");
			
			List<Student> listOfAllStudents = repository.getAllStudents();
			RequestDispatcher rd = request.getRequestDispatcher("ViewStudent.jsp");
			request.setAttribute("listOfAllStudents", listOfAllStudents);
			try {
				rd.forward(request,response);
			}catch(Exception e) {
				System.out.println("Exception Occured:"+e);
			}
			}

		else if (requestAction.equalsIgnoreCase("addAccountant")) {
			String accName = request.getParameter("accName");
			String accEmail = request.getParameter("accEmail");
			String accPassword = request.getParameter("accPassword");
			String accContact = request.getParameter("accContact");

			System.out.println("Name : " + accName);
			System.out.println("Email-ID : " + accEmail);
			System.out.println("Password : " + accPassword);
			System.out.println("Contact No. : " + accContact);

			Accountant accountant = new Accountant(accName, accEmail, accPassword, accContact);
			repository.addAccountant(accountant);
			String message = "Accountant Added Successfully !";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("AddAccountant.jsp");
			try {
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		else if (requestAction.equalsIgnoreCase("addStudent")) {
			String studName = request.getParameter("studName");
			int studRoll = Integer.parseInt(request.getParameter("studRoll"));
			String studGender = request.getParameter("studGender");
			String studEmail = request.getParameter("studEmail");
			String studCourse = request.getParameter("studCourse");
			String studContact = request.getParameter("studContact");
			int studTotalFee = Integer.parseInt(request.getParameter("studTotalFee"));
			int studPaidFee = Integer.parseInt(request.getParameter("studPaidFee"));
			int studDueFee = studTotalFee - studPaidFee;
			
			Student student = new Student(studName, studRoll, studGender, studContact, studEmail, studCourse, studTotalFee, studPaidFee, studDueFee);
			System.out.println(student);
			repository.addStudent(student);
			String message = "Student Added Successfully !";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("AddStudent.jsp");
			try {
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (requestAction.equalsIgnoreCase("updateFormAccountant")) {
			System.out.println("In update Method ! ");
			String accEmail = request.getParameter("accEmail");

			Accountant accountant = repository.getAccountant(accEmail);

			RequestDispatcher rd = request.getRequestDispatcher("EditAccountant.jsp");
			request.setAttribute("accountant", accountant);

			try {
				rd.forward(request, response);

			} catch (Exception e) {
				System.out.println("Exception Occured:" + e);
			}
		}
		
		else if (requestAction.equalsIgnoreCase("updateFormStudent")) {
			int studRoll = Integer.parseInt(request.getParameter("studRoll"));
			Student student = repository.searchStudentByRoll(studRoll);
			System.out.println(student);
			RequestDispatcher rd= request.getRequestDispatcher("EditStudent.jsp");
			request.setAttribute("student", student);
			try {
				rd.forward(request, response);
				
				}catch(Exception e) {
					System.out.println("Exception Occured:" + e);
				}

		}
		
		else if(requestAction.equals("updateAccountant")) {
			String accEmail = request.getParameter("accEmail");
			String accName = request.getParameter("accName");
			String accPassword = request.getParameter("accPassword");
			String accContact = request.getParameter("accContact");
			
			Accountant accountant=new Accountant(accName, accEmail, accPassword, accContact);
			repository.updateAccountant(accountant);
			try {
				response.sendRedirect("AdminPanel.jsp");
			} catch (Exception e) {
				
				e.printStackTrace();
			}

		}
		
		else if(requestAction.equals("updateStudent")) {
			String studName= request.getParameter("studName");
			int studRoll= Integer.parseInt(request.getParameter("studRoll"));
			String studGender= request.getParameter("studGender");
			String studContact= request.getParameter("studContact");
			String studEmail= request.getParameter("studEmail");
			String studCourse= request.getParameter("studCourse");
			int studTotalFee= Integer.parseInt(request.getParameter("studTotalFee"));
			int studPaidFee= Integer.parseInt(request.getParameter("studPaidFee"));
			//int studDueFee= Integer.parseInt(request.getParameter("studDueFee"));
			
			int studDueFee=studTotalFee-studPaidFee;
			
			Student student=new Student(studName,studRoll,studGender,studContact,studEmail,studCourse,studTotalFee,studPaidFee,studDueFee);
			repository.updateStudent(student);
			
			try {
				response.sendRedirect("AccountantPanel.jsp");
			} catch (Exception e) {
				
				e.printStackTrace();
			}


		}
		
		else if(requestAction.equalsIgnoreCase("deleteAccountant")) {
			System.out.println("We are going to delete the record");

			String accEmail = request.getParameter("accEmail");
			repository.deleteAccountant(accEmail);
			
			try
			{
				response.sendRedirect("AdminPanel.jsp");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
		if(requestAction.equalsIgnoreCase("deleteStudent"))
		{
		 	System.out.println("In delete Student");
			
			int studRoll = Integer.parseInt(request.getParameter("studRoll"));
			repository.deleteStudent(studRoll);
				
			try
			{
			   response.sendRedirect("AccountantPanel.jsp");
			}
			catch(Exception e)
			{
			   System.out.println(e);
			}
		}
		
		else if(requestAction.equalsIgnoreCase("viewStudentDue")) {
			System.out.println("In student due view controller !");
			List<Student> listOfAllStudents = repository.getStudentDue();
			RequestDispatcher rd = request.getRequestDispatcher("ViewStudentDue.jsp");
			request.setAttribute("listOfAllStudents", listOfAllStudents);
			try {
				rd.forward(request,response);
			}catch(Exception e) {
				System.out.println("Exception Occured:"+e);
			}
		}
		
		else if (requestAction.equalsIgnoreCase("searchStudentForm")){
			System.out.println("In searchStudentForm controller");
			RequestDispatcher rd = request.getRequestDispatcher("SearchStudentForm.jsp");
			try {
				rd.forward(request,response);
			}catch(Exception e) {
				System.out.println("Exception Occured:"+e);
			}
		}
		
		else if(requestAction.equalsIgnoreCase("searchStudent")) {
			System.out.println("In searchStudent controller");
			int studRoll = Integer.parseInt(request.getParameter("studRoll"));
			Student student = repository.searchStudentByRoll(studRoll);
			System.out.println(student);
			if(student != null) {
			RequestDispatcher rd = request.getRequestDispatcher("SearchStudent.jsp");
			request.setAttribute("student", student);
			try {
				rd.forward(request,response);
			}catch(Exception e) {
				System.out.println("Exception Occured:"+e);
			}
		}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("SearchStudentForm.jsp");
				String message = "Student not found !";
				request.setAttribute("message", message);
				try {
					rd.forward(request,response);
				}catch(Exception e) {
					System.out.println("Exception Occured:"+e);
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
}
