
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Add extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
    {
      try
      {
          String a=rq.getParameter("t1");
          String b=rq.getParameter("t2");
          String c=rq.getParameter("t3");
          rs.setContentType("text/html");
          PrintWriter out=rs.getWriter();
          //step1 [load & register the driver]
          Class.forName("com.mysql.jdbc.Driver");
          //step2 [create the connection btw cse & sms]
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse?autoReconnect=true&useSSL=false","root","root");
          PreparedStatement ps=con.prepareStatement("insert into registration values(?,?,?)");
          ps.setString(1,a);
          ps.setString(2,b);
          ps.setString(3,c);
          out.print("<html><marquee>Data Submitted</marquee></html>");
          rq.getRequestDispatcher("index.html").include(rq,rs);
        
      }
      catch(Exception e)
      {
          
      }
    }
}    