import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateTaskServlet")
public class CreateTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(CreateTaskServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String dueDate = request.getParameter("dueDate");
        String priority = request.getParameter("priority");

        if (title == null || title.isEmpty() ||
            description == null || description.isEmpty() ||
            dueDate == null || dueDate.isEmpty() ||
            priority == null || priority.isEmpty()) {

            logger.warning("Failed to create task: missing fields");
            String proxyUri = System.getenv("VSCODE_PROXY_URI");
            if (proxyUri != null) {
                response.sendRedirect(proxyUri + "/error.jsp");
            } else {
                response.sendRedirect("error.jsp");  // Fallback if proxy URI is not set
            }
        } else {
            Task task = new Task(title, description, dueDate, priority);
            request.setAttribute("task", task);

            logger.info("Task created successfully: " + task.getTitle());
            String proxyUri = System.getenv("VSCODE_PROXY_URI");
            if (proxyUri != null) {
                response.sendRedirect(proxyUri + "/success.jsp");
            } else {
                response.sendRedirect("success.jsp");  // Fallback if proxy URI is not set
            }
        }
    }
}