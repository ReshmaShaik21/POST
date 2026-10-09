package org.example;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // Handles login form data submitted using POST
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Read form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Set response content type
        response.setContentType("text/html;charset=UTF-8");

        // Display result
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Login Form Results</h2>");
        out.println("<p>Username: " + escapeHtml(username) + "</p>");

        // Demonstration only: do not display passwords
        if (username != null && !username.isBlank()
                && password != null && !password.isBlank()) {
            out.println("<p>Login form submitted successfully.</p>");
        } else {
            out.println("<p>Please enter your username and password.</p>");
        }

        out.println("</body></html>");
    }

    // Escapes user input before displaying it in HTML
    private String escapeHtml(String value) {
        if (value == null) {
            return "";
        }

        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
