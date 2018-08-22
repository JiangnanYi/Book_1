package web;

import dao.BookInMemoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/book/del")
public class BookDel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("id");
        BookInMemoryDAO dao = new BookInMemoryDAO();
        // 组织成一次数据库操作，一切为了效率
        for (String id : ids) {
            dao.delete(Integer.parseInt(id));
        }

        request.getSession().setAttribute("msg", "删除成功。");

        // req.getRequestDispatcher("/index").forward(req,resp);
        response.sendRedirect("/book/index");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BookInMemoryDAO dao = new BookInMemoryDAO();
        String msg = null;

        if(dao.delete(id)) {
            msg = "delete success.";
        } else {
            msg = "delete failure.";
        }
        //req.getRequestDispatcher("/index").forward(req, resp);
        request.getSession().setAttribute("msg", msg);

        response.sendRedirect("/book/index");
    }
}
