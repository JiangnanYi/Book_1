package web;

import dao.BookDAO;
import dao.BookInMemoryDAO;
import entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/book/update")
public class BookUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String author = request.getParameter("author");
        String press = request.getParameter("press");

        Book book = new Book(id, name, price, author, press);

        BookDAO bookDAO = new BookInMemoryDAO();
        bookDAO.update(book);

        HttpSession session = request.getSession();
        session.setAttribute("msg", "更新成功！");

        response.sendRedirect("/book/detail?id=" + id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BookDAO bookDAO = new BookInMemoryDAO();
        Book book = bookDAO.getBookById(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/jsp/book_update.jsp").forward(request, response);

    }
}
