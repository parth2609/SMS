
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class ViewAll extends HttpServlet {

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
          Statement st=con.createStatement();
          String q="Select * from registration";
          ResultSet r1=st.executeQuery(q);
          r1.next();
          out.print(r1.getString(1)+"\t"+r1.getString(2)+"\t"+r1.getString("email"));
          
          //rq.getRequestDispatcher("index.html").include(rq,rs);
        
      }
      catch(Exception e)
      {
          
      }
    }
}