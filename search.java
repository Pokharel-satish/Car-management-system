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

@WebServlet("/SearchCarsServlet")
public class search extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbURL = "jdbc:mysql://localhost:3306/car_data";
        String usernameDB = "root";
        String passwordDB = "1234";

        try {
            Connection conn = DriverManager.getConnection(dbURL, usernameDB, passwordDB);

            String model = request.getParameter("model");
            String location = request.getParameter("location");

            String sql = "SELECT * FROM cars WHERE model LIKE ? AND location LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            String modelParam = "%" + model + "%";
            String locationParam = "%" + location + "%";
            statement.setString(1, modelParam);
            statement.setString(2, locationParam);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                response.getWriter().println("Car Make: " + result.getString("make") + "<br>");
                response.getWriter().println("Car Model: " + result.getString("model") + "<br>");
                response.getWriter().println("Year: " + result.getInt("year") + "<br>");
                response.getWriter().println("Mileage: " + result.getInt("mileage") + "<br>");
                response.getWriter().println("Location: " + result.getString("location") + "<br>");
                response.getWriter().println("Price: " + result.getDouble("price") + "<br>");
                response.getWriter().println("<hr>");
            }

            statement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            response.getWriter().println("Error: " + ex.getMessage());
        }
    }
}
