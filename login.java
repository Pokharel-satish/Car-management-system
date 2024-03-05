import java.io.IOException;
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

@WebServlet("/LoginServlet")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbURL = "jdbc:mysql://localhost:3306/car_data";
        String usernameDB = "root";
        String passwordDB = "1234";

        try {
            Connection conn = DriverManager.getConnection(dbURL, usernameDB, passwordDB);

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                response.getWriter().println("Login successful. Redirect to a protected page.");
            } else {
                response.getWriter().println("Login failed. Please check your credentials.");
            }

            statement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            response.getWriter().println("Error: " + ex.getMessage());
        }
    }
}
