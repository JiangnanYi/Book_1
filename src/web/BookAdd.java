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

@WebServlet(value = "/book/add")
public class BookAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String author = request.getParameter("author");
        String press = request.getParameter("press");

        Book book = new Book(id, name, price, author, press);

        BookDAO bookDAO = new BookInMemoryDAO();
        bookDAO.add(book);

        response.sendRedirect("/book/index");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/book_add_form.jsp").forward(request, response);
    }
}
