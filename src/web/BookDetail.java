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

@WebServlet(value = "/book/detail")
public class BookDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        BookDAO bookdao=new BookInMemoryDAO();
        Book book=bookdao.getBookById(id);
        String result="{\"id\":\""+book.getId()+"\",\"name\":\""+book.getName()+"\",\"price\":\""+book.getPrice()+"\",\"author\":\""+book.getAuthor()+"\",\"press\":\""+book.getPress()+"\"}";
        response.getWriter().write(result);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BookDAO bookDAO = new BookInMemoryDAO();
        request.setAttribute("book", bookDAO.getBookById(id));
        HttpSession session=request.getSession();
        request.getRequestDispatcher("/jsp/book_detail.jsp").forward(request, response);
    }
}
