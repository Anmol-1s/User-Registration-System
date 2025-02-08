package in.sp.backened;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class register extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // Fetching user input from the form
        String myname = req.getParameter("name");
        String mysurname = req.getParameter("surname");
        String myemail = req.getParameter("email");
        String mypassword = req.getParameter("password");
        String mycity = req.getParameter("city");
        String mygender = req.getParameter("gender");

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Registration/register", "root", "your_password");

            // SQL query
            String query = "INSERT INTO valueinsert (name, surname, email_id, password, city, gender) VALUES (?, ?, ?, ?, ?, ?)";

            // Prepare statement
            ps = connection.prepareStatement(query);
            ps.setString(1, myname);
            ps.setString(2, mysurname);
            ps.setString(3, myemail);
            ps.setString(4, mypassword);
            ps.setString(5, mycity);
            ps.setString(6, mygender);

            // Execute update
            int rowAffected = ps.executeUpdate();

            // Response handling
            if (rowAffected > 0) {
                out.print("<h3 style='color:green;'>User Registered Successfully</h3>");
            } else {
                out.print("<h3 style='color:red;'>User Registration Failed</h3>");
            }

            // Redirecting to register page
            RequestDispatcher rs = req.getRequestDispatcher("register.jsp");
            rs.include(req, resp);

        } catch (Exception e) {
            out.print("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
            RequestDispatcher rs = req.getRequestDispatcher("register.jsp");
            rs.include(req, resp);
        } finally {
            try {
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
