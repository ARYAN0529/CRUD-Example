
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AdminDeleteServlet extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        
        
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?autoReconnect=true&useSSL=false", "root", "root");

            PreparedStatement stmt = con.prepareStatement("delete from user905 where email=?");
            String email = request.getParameter("email");
            stmt.setString(1,email);

            stmt.executeUpdate();

            response.sendRedirect("adminview");
        } catch (Exception e) {

            System.out.println(e);

            response.sendRedirect("adminview");
        }
        
    }


}
