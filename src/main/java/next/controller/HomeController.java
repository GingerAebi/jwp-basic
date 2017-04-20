package next.controller;

import core.db.DataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements Controller {
    private static final long serialVersionUID = 1L;

    @Override
    public String service(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("users", DataBase.findAll());
        return "indext.jsp";
    }
}
