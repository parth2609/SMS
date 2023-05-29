
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class View extends HttpServlet {

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
          PreparedStatement st=con.prepareStatement("Select * from registration where email=");
          st.setString(1,rq.getParameter("t1"));
          ResultSet r1=st.executeQuery();
          if(r1.next())
          out.print(r1.getString(1)+"\t"+r1.getString(2)+"\t"+r1.getString("email"));
          else
              out.print("Records Not Exist");
          //rq.getRequestDispatcher("index.html").include(rq,rs);
        
      }
      catch(Exception e)
      {
          
      }
    }
}