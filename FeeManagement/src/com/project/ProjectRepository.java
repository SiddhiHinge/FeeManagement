package com.project;

import java.sql.*;
import java.util.*;

import com.project.Beans.Accountant;
import com.project.Beans.Student;
import com.project.Utility.DbUtil;

public class ProjectRepository {

	public boolean checkLoginAdmin(String adminEmail, String adminPassword) {
		boolean result = false;
		Connection con = DbUtil.getMysqlDbConnection();
		String sql = "select * from admin where admin_email=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, adminEmail);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println("Admin Found !");
				String admin_password = rs.getString("admin_password");
				if (adminPassword.equals(admin_password)) {
					result = true;
					System.out.println("Password Matched !");
				}
			}
		} catch (Exception e) {
			System.out.println("error" + e);

		}

		return result;

	}

	public boolean checkLoginAccountant(String accEmail, String accPassword) {
		boolean result = false;
		Connection con = DbUtil.getMysqlDbConnection();
		String sql = "select * from accountant where acc_email=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, accEmail);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String passfromDB = rs.getString("acc_password");
				if (accPassword.equals(passfromDB)) {
					System.out.println("Accountant login success");
					result = true;
				}
			}
		} catch (Exception e) {
			System.out.println("error" + e);

		}

		return result;

	}

	public void addAccountant(Accountant accountant) {
		Connection con = DbUtil.getMysqlDbConnection();
		String sql = "insert into accountant values(?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, accountant.getAccName());
			pst.setString(2, accountant.getAccEmail());
			pst.setString(3, accountant.getAccPassword());
			pst.setString(4, accountant.getAccContact());

			int result = pst.executeUpdate();

			if (result == 0)
				System.out.println("Data Insertion Failed");
			else
				System.out.println("Data Inserted Successfully");
		} catch (SQLException e) {
			System.out.println("Exception occurred while inserting the records : " + e);
		}
	}

	public void addStudent(Student student) {
		Connection con = DbUtil.getMysqlDbConnection();
		String sql = "insert into student values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, student.getStudName());
			pst.setInt(2, student.getStudRoll());
			pst.setString(3, student.getStudGender());
			pst.setString(4, student.getStudContact());
			pst.setString(5, student.getStudEmail());
			pst.setString(6, student.getStudCourse());
			pst.setInt(7, student.getStudTotalFee());
			pst.setInt(8, student.getStudPaidFee());
			pst.setInt(9, student.getStudDueFee());

			int result = pst.executeUpdate();

			if (result == 0)
				System.out.println("Data Insertion Failed");
			else
				System.out.println("Data Inserted Successfully");
		} catch (SQLException e) {
			System.out.println("Exception occurred while inserting the records : " + e);
		}
	}

	public List<Accountant> getAllAccountants() {
		List<Accountant> listOfAllAccountants = new ArrayList<Accountant>();
		Connection con = DbUtil.getMysqlDbConnection();
		String sql = "select * from accountant";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String accName = rs.getString("acc_name");
				String accEmail = rs.getString("acc_email");
				String accPassword = rs.getString("acc_password");
				String accContact = rs.getString("acc_contact");
				Accountant accountant = new Accountant(accName, accEmail, accPassword, accContact);
				listOfAllAccountants.add(accountant);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Occured" + e);
		}

		return listOfAllAccountants;
	}

	public List<Student> getAllStudents() {
		List<Student> listOfAllStudents = new ArrayList<Student>();
		Connection con = DbUtil.getMysqlDbConnection();
		String sql = "select * from student";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String studName = rs.getString("stud_name");
				int studRoll = rs.getInt("stud_roll");
				String studGender = rs.getString("stud_gender");
				String studContact = rs.getString("stud_contact");
				String studEmail = rs.getString("stud_email");
				String studCourse = rs.getString("stud_course");
				int studTotalFee = rs.getInt("stud_totalfee");
				int studPaidFee = rs.getInt("stud_paidfee");
				int studDueFee = rs.getInt("stud_duefee");
				Student student = new Student(studName, studRoll, studGender, studContact, studEmail, studCourse,
						studTotalFee, studPaidFee, studDueFee);

				listOfAllStudents.add(student);

				System.out.println("In getAllStudent repository!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Occured" + e);
		}
		return listOfAllStudents;
	}

	public List<Student> getStudentDue() {
		List<Student> listOfAllStudents = new ArrayList<Student>();
		Connection con = DbUtil.getMysqlDbConnection();
		String sql = "select * from student where stud_duefee > 0";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String studName = rs.getString("stud_name");
				int studRoll = rs.getInt("stud_roll");
				String studGender = rs.getString("stud_gender");
				String studContact = rs.getString("stud_contact");
				String studEmail = rs.getString("stud_email");
				String studCourse = rs.getString("stud_course");
				int studTotalFee = rs.getInt("stud_totalfee");
				int studPaidFee = rs.getInt("stud_paidfee");
				int studDueFee = rs.getInt("stud_duefee");
				Student student = new Student(studName, studRoll, studGender, studContact, studEmail, studCourse,
						studTotalFee, studPaidFee, studDueFee);

				listOfAllStudents.add(student);

				System.out.println("In getAllStudent repository!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Occured" + e);
		}
		return listOfAllStudents;
	}

	public Accountant getAccountant(String accEmail) {

		Connection con = DbUtil.getMysqlDbConnection();
		String sql = "select * from accountant where acc_email=?";
		Accountant accountant = null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, accEmail);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String accName = rs.getString("acc_name");
				String password = rs.getString("acc_password");
				String accContact = rs.getString("acc_contact");
				accountant = new Accountant(accName, accEmail, password, accContact);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return accountant;
	}

	public void updateAccountant(Accountant accountant) {
		Connection con = DbUtil.getMysqlDbConnection();
		String sql = "update accountant set acc_email=?, acc_contact=? where acc_name=?";
		try {

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, accountant.getAccEmail());
			pst.setString(2, accountant.getAccContact());
			pst.setString(3, accountant.getAccName());

			int result = pst.executeUpdate();
			if (result == 0) {
				System.out.println("Updation Failed");
			} else {
				System.out.println("updated Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void updateStudent(Student student) {
		Connection con = DbUtil.getMysqlDbConnection();
		String sql = "update student set stud_name=?, stud_gender=?, stud_contact=?, stud_email=?, stud_course=?, stud_totalfee=?, stud_paidfee=?, stud_duefee=? where stud_roll=?";
		try {
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, student.getStudName());
			pst.setString(2, student.getStudGender());
			pst.setString(3, student.getStudContact());
			pst.setString(4, student.getStudEmail());
			pst.setString(5, student.getStudCourse());
			pst.setInt(6, student.getStudTotalFee());
			pst.setInt(7, student.getStudPaidFee());
			pst.setInt(8, student.getStudDueFee());
			pst.setInt(9, student.getStudRoll());
			
			int result=pst.executeUpdate();
			if(result==0) {
				System.out.println("Updation Failed");
			}else {
				System.out.println("updated Successfully");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	public void deleteAccountant(String accEmail) {
		Connection con = DbUtil.getMysqlDbConnection();
		String sql = "delete from accountant where acc_email=?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, accEmail);
			int result = pst.executeUpdate();
			if (result == 0) {
				System.out.println("Deletion Failed");
			} else {
				System.out.println("Deletion Successful");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deleteStudent(int studRoll)
	{
		Connection con = DbUtil.getMysqlDbConnection();
		String sql = "delete from student where stud_roll=?";
			
		try
		{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, studRoll);
			int result = pst.executeUpdate();
			if(result==0)
			{
				System.out.println("Deletion Failed");
			}
			else
			{
				System.out.println("Deletion Successful");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public Student searchStudentByRoll(int studRoll) {
		Connection con = DbUtil.getMysqlDbConnection();
		String sql = "select * from student where stud_roll=?";
		Student student = null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, studRoll);
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String studName = rs.getString("stud_name");
				studRoll = rs.getInt("stud_roll");
				String studGender = rs.getString("stud_gender");
				String studContact = rs.getString("stud_contact");
				String studEmail = rs.getString("stud_email");
				String studCourse = rs.getString("stud_course");
				int studTotalFee = rs.getInt("stud_totalfee");
				int studPaidFee = rs.getInt("stud_paidfee");
				int studDueFee = rs.getInt("stud_duefee");
				student = new Student(studName, studRoll, studGender, studContact, studEmail, studCourse,
						studTotalFee, studPaidFee, studDueFee);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return student;
	}

}
