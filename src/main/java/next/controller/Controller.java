package next.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gingeraebi on 2017. 4. 17..
 */
public interface Controller {
    public String service(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
