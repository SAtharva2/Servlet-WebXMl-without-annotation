

//import java.io.IOException;

//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/LoginContextjdbc")
public class LoginContextjdbc extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nm=request.getParameter("t1"); //accept parameter from user
		    String em=request.getParameter("t2");
		    
		    System.out.println(nm+ " "+em);
    
    PrintWriter out=response.getWriter();
    
    String ddriver=getServletContext().getInitParameter("driver");
    String durl=getServletContext().getInitParameter("url");
    
    String duser=getServletConfig().getInitParameter("user");
    String dpwd=getServletConfig().getInitParameter("pwd");
    
    out.println(ddriver +" "+durl+ " "+duser+ " "+dpwd);
    
    Class.forName(ddriver);

    Connection con;

     con = DriverManager.getConnection(durl,duser,dpwd);	 

	 PreparedStatement pst=con.prepareStatement("select * from user432 where name=? and  email=?" );
	
	 pst.setString(1, nm);
	 pst.setString(2, em);
	 
	 
     ResultSet rs=pst.executeQuery();
     
    
	 if(rs.next())
        out.println("welcome"); 
     else
    	 out.println("try again"); 
     

		
	}
	
	catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
	
	
	
	
	
	
	
	
	
	
	
	







//========================================================

//    public LoginContextjdbc() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
