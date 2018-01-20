package by.itacademy.library.web.handlers;

import by.itacademy.library.web.command.enums.CommandType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.itacademy.library.web.command.enums.CommandType.MAIN;

public class RequestHandler {
    /**
     * @param req HttpServletRequest
     * @return CommandType of the request
     */
    public static CommandType getCommand(HttpServletRequest req) {
        String param = req.getParameter("command");
        if (param == null && "".equals(param)) {
            param = "main.title";
        }


        CommandType type = CommandType.getByPageName(param);
        req.setAttribute("title", type.getPageName());
        HttpSession session = req.getSession();
        String pageName = (String) session.getAttribute("pageName");
        if (pageName != null) {
            session.setAttribute("prevPage", pageName);
            session.setAttribute("pageName", type.getPageName());
            session.setAttribute("pagePath", type.getPagePath());
        } else {
            session.setAttribute("prevPage", type.getPageName());
            session.setAttribute("pageName", MAIN.getPageName());
            session.setAttribute("pagePath", MAIN.getPagePath());
        }

        return type;
    }
}
