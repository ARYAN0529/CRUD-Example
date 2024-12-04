
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?autoReconnect=true&useSSL=false", "root", "root");

            PreparedStatement stmt = con.prepareStatement("select password from user905 where email=?");

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            rs.next();

            String realpassword = rs.getString(1);

            if (password.equals(realpassword)) {
              
                HttpSession session=request.getSession();
                session.setAttribute("email",email);
                if (email.equals("aryandz0529@gmail.com"))
                    response.sendRedirect("adminview");
                else
                    response.sendRedirect("view");
                
            } else {
                response.sendRedirect("login.html");
                                                                                            
            }

        } catch (Exception e) {

            System.out.println(e);
            response.sendRedirect("login.html");
        }
    }
}
