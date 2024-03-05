import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCarServlet")
public class add_car extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbURL = "jdbc:mysql://localhost:3306/car_data";
        String username = "root";
        String password = "1234";

        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            String make = request.getParameter("make");
            String model = request.getParameter("model");
            int year = Integer.parseInt(request.getParameter("year"));
            int mileage = Integer.parseInt(request.getParameter("mileage"));
            String location = request.getParameter("location");
            double price = Double.parseDouble(request.getParameter("price"));

            String sql = "INSERT INTO cars (make, model, year, mileage, location, price) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, make);
            statement.setString(2, model);
            statement.setInt(3, year);
            statement.setInt(4, mileage);
            statement.setString(5, location);
            statement.setDouble(6, price);

            if (statement.executeUpdate() > 0) {
                response.getWriter().println("Car added successfully.");
            } else {
                response.getWriter().println("Error adding car.");
            }

            statement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            response.getWriter().println("Error: " + ex.getMessage());
        }
    }
}
