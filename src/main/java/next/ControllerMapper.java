package next;

import next.controller.Controller;
import next.controller.CreateUserController;
import next.controller.HomeController;

import javax.naming.ldap.Control;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;

/**
 * Created by gingeraebi on 2017. 4. 17..
 */
public class ControllerMapper {
    private static HashMap<String, Controller> mappers;

    static{
        mappers.put("", new HomeController());
        mappers.put("/users/create", new CreateUserController());
        mappers.put("/users/form", new CreateUserController());
    }

    public static Controller getControllerByPath(String path) {
        return mappers.get(path);
    }
}
