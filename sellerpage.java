
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class sellerpage extends HttpServlet {
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
            String fullName = request.getParameter("full_name");
            String email = request.getParameter("email");

            // Hash the password
            String hashedPassword = hashPassword(password);

            String sql = "INSERT INTO sellers (username, password, full_name, email) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, hashedPassword);
            statement.setString(3, fullName);
            statement.setString(4, email);

            if (statement.executeUpdate() > 0) {
                response.getWriter().println("Registration successful. You can now <a href='login.html'>login</a>.");
            } else {
                response.getWriter().println("Error: Registration failed.");
            }

            statement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            response.getWriter().println("Error: " + ex.getMessage());
        }
    }

    // Function to hash the password
    private String hashPassword(String password) {
        // Your password hashing implementation here
        // Example:
        // return BCrypt.hashpw(password, BCrypt.gensalt());
        return password; // For demonstration purpose, returning plain password
    }
}
