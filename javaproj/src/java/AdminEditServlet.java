
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

public class AdminEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("    <head>");
        out.println("        <meta charset='UTF-8'>");
        out.println("        <meta http-equiv='X-UA-Compatible' content='IE=edge'>");
        out.println("        <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("        <title>Edit</title>");
        out.println("        <link rel='stylesheet' href='style.css'>");
        out.println("        <script src='https://kit.fontawesome.com/97ebdf5864.js' crossorigin='anonymous'></script>");
        out.println("        <style>");
        out.println("            * {");
        out.println("                margin: 0;");
        out.println("                padding: 0;");
        out.println("                box-sizing: border-box;");
        out.println("                font-family: sans-serif;");
        out.println("            }");
        out.println("");
        out.println("            body {");
        out.println("                width: 100vw;");
        out.println("                height: 100vh;");
        out.println("                background: url(./bg.jpg) no-repeat;");
        out.println("                background-position: center;");
        out.println("                background-size: cover;");
        out.println("                display: flex;");
        out.println("                align-items: center;");
        out.println("                justify-content: center;");
        out.println("            }");
        out.println("");
        out.println("            .container {");
        out.println("                width: 400px;");
        out.println("                height: auto;");
        out.println("                background: rgba(0, 0, 0, 0.3);");
        out.println("                backdrop-filter: blur(10px);");
        out.println("                box-shadow: 0 0 30px rgba(0, 0, 0, 0.8);");
        out.println("                display: flex;");
        out.println("                align-items: center;");
        out.println("                justify-content: center;");
        out.println("                flex-direction: column;");
        out.println("                border-radius: 20px;");
        out.println("                border: 3px solid rgba(255, 255, 255, 0.5);");
        out.println("                padding: 30px 20px;");
        out.println("            }");
        out.println("");
        out.println("            h2 {");
        out.println("                color: #fff;");
        out.println("                font-size: 2em;");
        out.println("                text-transform: uppercase;");
        out.println("                padding: 20px 0;");
        out.println("            }");
        out.println("");
        out.println("            .form-group {");
        out.println("                position: relative;");
        out.println("                width: 330px;");
        out.println("                margin: 15px 0;");
        out.println("                border-bottom: 3px solid #fff;");
        out.println("            }");
        out.println("");
        out.println("            .form-group input {");
        out.println("                width: 100%;");
        out.println("                height: 50px;");
        out.println("                padding: 0 35px 0 10px;");
        out.println("                font-size: 1.2em;");
        out.println("                background-color: transparent;");
        out.println("                border: none;");
        out.println("                outline: none;");
        out.println("                color: #fff;");
        out.println("            }");
        out.println("");
        out.println("            .form-group label {");
        out.println("                position: absolute;");
        out.println("                top: 50%;");
        out.println("                left: 10px;");
        out.println("                transform: translateY(-50%);");
        out.println("                font-size: 1.2em;");
        out.println("                color: #fff;");
        out.println("                transition: 0.5s;");
        out.println("            }");
        out.println("");
        out.println("            input:focus ~ label,");
        out.println("            input:valid ~ label {");
        out.println("                top: -5px;");
        out.println("            }");
        out.println("");
        out.println("            .form-group i {");
        out.println("                position: absolute;");
        out.println("                top: 50%;");
        out.println("                right: 10px;");
        out.println("                transform: translateY(-50%);");
        out.println("                color: #fff;");
        out.println("                font-size: 1.2em;");
        out.println("            }");
        out.println("");
        out.println("            p {");
        out.println("                text-align: center;");
        out.println("                color: #fff;");
        out.println("                margin: 10px 0;");
        out.println("            }");
        out.println("");
        out.println("            p>a {");
        out.println("                text-decoration: none;");
        out.println("                color: #fff;");
        out.println("                font-weight: 600;");
        out.println("            }");
        out.println("");
        out.println("            p>a:hover {");
        out.println("                text-decoration: underline;");
        out.println("                font-style: italic;");
        out.println("            }");
        out.println("");
        out.println("            #btn {");
        out.println("                width: 100%;");
        out.println("                height: 50px;");
        out.println("                border-radius: 40px;");
        out.println("                border: none;");
        out.println("                font-size: 1.5em;");
        out.println("                text-transform: uppercase;");
        out.println("                font-weight: 600;");
        out.println("                margin: 10px 0;");
        out.println("                cursor: pointer;");
        out.println("                transition: all 0.5s;");
        out.println("            }");
        out.println("");
        out.println("            #btn:hover {");
        out.println("                background: rgba(0, 0, 0, 0.3);");
        out.println("                color: #fff;");
        out.println("            }");
        out.println("        </style>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("");
        out.println("        <div class='container'>");
        out.println("            <h2>Edit</h2>");
        out.println("");
        out.println("            <form action='adminedit' method='post'>");
        out.println("");
        out.println("                <!-- Name Field -->");
        out.println("                <div class='form-group'>");
        out.println("                    <input type='text' name='name' required placeholder='Full Name'>");
        out.println("                    <i class='fa-solid fa-user'></i>");
        out.println("                </div>");
        out.println("");

        out.println("");
        out.println("                <!-- Password Field -->");
        out.println("                <div class='form-group'>");
        out.println("                    <input type='password' name='password' required placeholder='Password'>");
        out.println("                    <i class='fa-solid fa-lock'></i>");
        out.println("                </div>");
        out.println("");
        out.println("                <!-- Country Field -->");
        out.println("                <div class='form-group'>");
        out.println("                    <input type='text' name='country' required placeholder='Country'>");
        out.println("                    <i class='fa-solid fa-globe'></i>");
        out.println("                </div>");
        out.println("");
        out.println("                <!-- Age Field -->");
        out.println("                <div class='form-group'>");
        out.println("                    <input type='number' name='age' required placeholder='Age' min='18'>");
        out.println("                    <i class='fa-solid fa-calendar'></i>");
        out.println("                </div>");
        out.println("");
        out.println("                <!-- Section Field -->");
        out.println("                <div class='form-group'>");
        out.println("                    <input type='text' name='section' required placeholder='Section'>");
        out.println("                    <i class='fa-solid fa-users'></i>");
        out.println("                </div>");
        out.println("");
        out.println("                <!-- Phone Number Field -->");
        out.println("                <div class='form-group'>");
        out.println("                   <input type='tel' name='phone' required placeholder='Phone Number'>");
        out.println("                    <i class='fa-solid fa-phone'></i>");
        out.println("                </div>");
        out.println("");
        out.println("                <!-- Submit Button -->");
        out.println("                <input name='email' type='hidden' value='"+email+"'>");
        out.println("                <input id='btn' type='submit' value='Save'>");
        out.println("");
        out.println("            </form>");
        out.println("        </div>");
        out.println("");
        out.println("    </body>");
        out.println("</html>");
        out.println("");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String country = request.getParameter("country");
        String age = request.getParameter("age");
        String section = request.getParameter("section");
        String phone = request.getParameter("phone");

        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?autoReconnect=true&useSSL=false", "root", "root");

            PreparedStatement stmt = con.prepareStatement("update user905 set name=?,password=?,country=?,age=?,section=?,phone_no=? where email=?");

            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, country);
            stmt.setString(4, age);
            stmt.setString(5, section);
            stmt.setString(6, phone);
            stmt.setString(7, email);

            stmt.executeUpdate();

            response.sendRedirect("adminview");
        } catch (Exception e) {

            System.out.println(e);
            out.println(e);
            response.sendRedirect("adminview");
        }

    }

}
