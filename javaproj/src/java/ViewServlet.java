import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?autoReconnect=true&useSSL=false", "root", "root");

            PreparedStatement stmt = con.prepareStatement("select* from user905 where email=?");

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            rs.next();

            PrintWriter out = response.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("  <meta charset='UTF - 8'>");
            out.println("  <meta name='viewport' content='width-device-width', initial-scale = '1.0'>");
            out.println("    <title>Data Table</title>");
            out.println("    <style>");
            out.println("        * {");
            out.println("            margin: 0;");
            out.println("            padding: 0;");
            out.println("            box-sizing: border-box;");
            out.println("            font-family: sans-serif;");
            out.println("        }");
            out.println("");
            out.println("        body {");
            out.println("            width: 100vw;");
            out.println("            height: 100vh;");
            out.println("            background: url(./bg.jpg) no-repeat center center/cover;");
            out.println("            display: flex;");
            out.println("            align-items: center;");
            out.println("            justify-content: center;");
            out.println("        }");
            out.println("");
            out.println("        .container {");
            out.println("            width: 90%;");
            out.println("            max-width: 1000px;");
            out.println("            background: rgba(0, 0, 0, 0.5);");
            out.println("            backdrop-filter: blur(10px);");
            out.println("            box-shadow: 0 0 30px rgba(0, 0, 0, 0.8);");
            out.println("            display: flex;");
            out.println("            align-items: center;");
            out.println("            justify-content: center;");
            out.println("            flex-direction: column;");
            out.println("            border-radius: 20px;");
            out.println("            border: 3px solid rgba(255, 255, 255, 0.5);");
            out.println("            padding: 30px;");
            out.println("        }");
            out.println("");
            out.println("        h1 {");
            out.println("            color: #ffffff;");
            out.println("            font-size: 2.5rem;");
            out.println("            text-transform: uppercase;");
            out.println("            padding-bottom: 20px;");
            out.println("        }");
            out.println("");
            out.println("        table {");
            out.println("            width: 100%;");
            out.println("            border-collapse: collapse;");
            out.println("        }");
            out.println("");
            out.println("        th, td {");
            out.println("            padding: 12px;");
            out.println("            text-align: left;");
            out.println("            border: 1px solid #d1a3d2;");
            out.println("            color: #fff;");
            out.println("        }");
            out.println("");
            out.println("        th {");
            out.println("            background-color: #6a3d9e;");
            out.println("            font-weight: bold;");
            out.println("        }");
            out.println("");
            out.println("        td {");
            out.println("            background-color: #f9f1fc;");
            out.println("            color: #5b2c8d;");
            out.println("        }");
            out.println("");
            out.println("        tr:hover {");
            out.println("            background-color: #e8d0f5;");
            out.println("        }");
            out.println("");
            out.println("        .form-group {");
            out.println("            position: relative;");
            out.println("            width: 100%;");
            out.println("            margin: 20px 0;");
            out.println("            border-bottom: 2px solid #ffffff;");
            out.println("        }");
            out.println("");
            out.println("        .form-group input {");
            out.println("            width: 100%;");
            out.println("            height: 40px;");
            out.println("            padding: 0 30px;");
            out.println("            font-size: 1.2em;");
            out.println("            background-color: transparent;");
            out.println("            border: none;");
            out.println("            outline: none;");
            out.println("            color: #fff;");
            out.println("        }");
            out.println("");
            out.println("        .form-group label {");
            out.println("            position: absolute;");
            out.println("            top: 50%;");
            out.println("            left: 10px;");
            out.println("            transform: translateY(-50%);");
            out.println("            font-size: 1.2em;");
            out.println("            color: #fff;");
            out.println("            transition: 0.5s;");
            out.println("        }");
            out.println("");
            out.println("        input:focus ~ label,");
            out.println("        input:valid ~ label {");
            out.println("            top: -5px;");
            out.println("        }");
            out.println("");
            out.println("        #btn {");
            out.println("            width: 100%;");
            out.println("            height: 50px;");
            out.println("            border-radius: 10px;");
            out.println("            border: none;");
            out.println("            font-size: 1em;");
            out.println("            text-transform: uppercase;");
            out.println("            font-weight: 600;");
            out.println("            margin: 10px 0;");
            out.println("            padding: 10px;");
            out.println("            cursor: pointer;");
            out.println("            background: #6a3d9e;");
            out.println("            color: #fff;");
            out.println("            transition: all 0.3s;");
            out.println("        }");
            out.println("");
            out.println("        #btn:hover {");
            out.println("            background: rgba(0, 0, 0, 0.3);");
            out.println("        }");
            out.println("");
            out.println("        p {");
            out.println("            text-align: center;");
            out.println("            color: #fff;");
            out.println("            margin: 10px 0;");
            out.println("        }");
            out.println("");
            out.println("        p > a {");
            out.println("            text-decoration: none;");
            out.println("            color: #fff;");
            out.println("            font-weight: 600;");
            out.println("        }");
            out.println("");
            out.println("        p > a:hover {");
            out.println("            text-decoration: underline;");
            out.println("            font-style: italic;");
            out.println("        }");
            out.println("");
            out.println("        /* Responsive adjustments */");
            out.println("        @media (max-width: 768px) {");
            out.println("            table {");
            out.println("                font-size: 0.9rem;");
            out.println("            }");
            out.println("");
            out.println("            th, td {");
            out.println("                padding: 8px;");
            out.println("            }");
            out.println("        }");
            out.println("    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <div class='container'>");
            out.println("        <h1>Data Table</h1>");
            out.println("        <table>");
            out.println("            <thead>");
            out.println("                <tr>");
            out.println("                    <th>ID</th>");
            out.println("                    <th>Name</th>");
            out.println("                    <th>Email</th>");
            out.println("                    <th>Password</th>");
            out.println("                    <th>Country</th>");
            out.println("                    <th>Age</th>");
            out.println("                    <th>Section</th>");
            out.println("                    <th>Phone Number</th>");
            out.println("                </tr>");
            out.println("            </thead>");
            out.println("            <tbody>");
            out.println("                <tr>");
            out.println("                    <td>" + rs.getInt(1) + "</td>");
            out.println("                    <td>" + rs.getString(2) + "</td>");
            out.println("                    <td>" + rs.getString(3) + "</td>");
            out.println("                    <td>" + rs.getString(4) + "</td>");
            out.println("                    <td>" + rs.getString(5) + "</td>");
            out.println("                    <td>" + rs.getInt(6) + "</td>");
            out.println("                    <td>" + rs.getString(7) + "</td>");
            out.println("                    <td>" + rs.getString(8) + "</td>");
            out.println("                </tr>");
            out.println("            </tbody>");
            out.println("        </table>");

            // EDIT Button Form
            out.println("<form action='edit' method='get'>");
            out.println("    <input id='btn' type='submit' value='EDIT'>");
            out.println("</form>");

            // DELETE Button Form
            out.println("<form action='delete' method='post'>");
            out.println("    <input id='btn' type='submit' value='DELETE'>");
            out.println("</form>");
            
            out.println("<form action='logout' method='post'>");
            out.println("    <input id='btn' type='submit' value='LOGOUT'>");
            out.println("</form>");

            out.println("    </div>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
