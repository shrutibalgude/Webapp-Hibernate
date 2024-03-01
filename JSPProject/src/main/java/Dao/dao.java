package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class dao {
	private static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root.130");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/picture","root","root.130");
		return con;
	}

	public static boolean validate(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		boolean st=false;
		Connection con=getConnection();
		String sql="select * from student where email=? and pass=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1,email);
		ps.setString(2,password);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			st=true;
		}
		
		return st;
	}
	
	public static int save(String fname,String lname,String email, String password, String address, int gen, String date ) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		String sql="insert into student(fname,lname,email,pass,address,gender,dob) values(?,?,?,?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1,fname);
		ps.setString(2,lname);
		ps.setString(3,email);
		ps.setString(4,password);
		ps.setString(5,address);
		ps.setInt(6,gen);
		ps.setString(7,date);
	
		int st=ps.executeUpdate();
		
		return st;
	}
	
	public static List<Student> listofstudent() throws SQLException{
		List<Student> list=new ArrayList<>();
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from student");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			Student st=new Student();
			st.setId(rs.getInt(1));
			st.setFname(rs.getString(2));
			st.setLname(rs.getString(3));
			st.setEmail(rs.getString(4));
			st.setPass(rs.getString(5));
			st.setAddress(rs.getString(6));
			st.setGender(rs.getString(7));
			st.setDob(rs.getString(8));
			list.add(st);
		}
		return list;
	}
	
	public static Student studentById(int id) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from student where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		Student st=new Student();
		
		
		
		if(rs.next()) {
			
			st.setId(rs.getInt(1));
			st.setFname(rs.getString(2));
			st.setLname(rs.getString(3));
			st.setEmail(rs.getString(4));
			st.setPass(rs.getString(5));
			st.setAddress(rs.getString(6));
			st.setGender(rs.getString(7));
			st.setDob(	rs.getString(8));
			
		}
		return st;
		
		
	}

	public static int UpdateStudent(Student st) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("update student set fname=?,lname=?,email=?,pass=?,address=?,gender=?,dob=?  where id=?");
		ps.setString(1, st.getFname());
		ps.setString(2, st.getLname());
		ps.setString(3, st.getEmail());
		ps.setString(4, st.getPass());
		ps.setString(5, st.getAddress());
		if(st.getGender().equals("male")) {
			ps.setInt(6, 1);
		}else {
			ps.setInt(6, 2);
		}
		ps.setString(7, st.getDob());
		ps.setInt(8, st.getId());
		int ab=ps.executeUpdate();
		return ab;
		
	}
	

	public static int DeleteStudent(int id) {
		
		return 0;
	}
}
