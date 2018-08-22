package web;

import dao.BookDAO;
import dao.BookInMemoryDAO;
import entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/book/q")
public class BookSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String condition = request.getParameter("condition");

        BookDAO bookDAO = new BookInMemoryDAO();
        List<Book> books = bookDAO.getBooksByName(condition);

        request.setAttribute("books", books);

        request.getSession().setAttribute("msg", "当前查询条件为:[" + condition + "]");

        request.getRequestDispatcher("/jsp/book_list.jsp").include(request, response);

    }
}
