package next;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gingeraebi on 2017. 4. 17..
 */
@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        response(ControllerMapper.getControllerByPath(req.getRequestURI()).service(req, resp), req, resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        response(ControllerMapper.getControllerByPath(req.getRequestURI()).service(req, resp), req, resp );
    }

    private void response(String resourceInfo, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(resourceInfo.startsWith("redirect:")) {
            resp.sendRedirect(resourceInfo.split(":",2)[1]);
        }
        RequestDispatcher rd = req.getRequestDispatcher(resourceInfo);
        rd.forward(req, resp);
    }

}
