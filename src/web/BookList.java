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
import java.util.List;

public class BookList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO bookDAO = new BookInMemoryDAO();
        request.setAttribute("books", bookDAO.listAll());
        //  HttpSession session=request.getSession();
        request.getRequestDispatcher("/jsp/book_list.jsp").forward(request, response);

    }
}
