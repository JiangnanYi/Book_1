package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WebUtil {
    public static String popSessionMsg(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String msg = (String) session.getAttribute("msg");

        String result = "";

        if (msg != null && !msg.isEmpty()) {
            result = "<div class='alert alert-danger'>" + msg + "</div>";
        }
        session.setAttribute("msg", null);

        return result;
    }
}
