import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "test", urlPatterns = {"/test"})
@MultipartConfig
public class DemoServlet extends HttpServlet {

    private static void allowCrossOrigin(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Access-Control-Allow-Origin");
    }

    private static void sendResponse(HttpServletResponse response) throws IOException {
        allowCrossOrigin(response);
        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();
        out.println("Hello world!");
        out.close();
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) {
        allowCrossOrigin(response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sendResponse(response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.getParameter("dummy-param"); // Uncomment this and larger uploads will succeed
        sendResponse(response);
    }
}