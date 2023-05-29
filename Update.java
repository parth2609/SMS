
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Update extends HttpServlet {

   

    

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
    {
      try
      {
          
          rs.setContentType("text/html");
          PrintWriter out=rs.getWriter();
          //step1 [load & register the driver]
          Class.forName("com.mysql.jdbc.Driver");
          //step2 [create the connection btw cse & sms]
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse?autoReconnect=true&useSSL=false","root","root");
          PreparedStatement ps=con.prepareStatement("update registration set uname=?,address=? where email=?");
          String a = null;
          
          ps.setString(1,a);
          String b = null;
          
          ps.setString(2,b);
          String c = null;
          
          ps.setString(3,c);
          int row=ps.executeUpdate();
          if(row>0)
          out.print("<html><marquee>Data Submitted</marquee></html>");
          else
            out.print("<html><marquee>Data Submitted</marquee></html>");  
          rq.getRequestDispatcher("index.html").include(rq,rs);
        
      }
      catch(Exception e)
      {
          
      }
    }
}