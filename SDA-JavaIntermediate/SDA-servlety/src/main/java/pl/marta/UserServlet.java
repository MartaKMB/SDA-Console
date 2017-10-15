package pl.marta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class UserServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user1 = new User("Marta", "M-B", 31);
        User user2 = new User("Mariusz", "M", 31);
        User user3 = new User("Samosia", "M-B", 11);
        User user4 = new User("Dekiel", "M-B", 7);
        User user5 = new User("Gandzia", "M-B", 6);

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5);

        PrintWriter writer = resp.getWriter();
        
        resp.setContentType("text/html");

//        zaznaczylismy trzy linijki
//        ctrl+shift+a -> method - tworzymy z kodu metode writeUsers

//        writeUsers(users, writer);

//        do counter: w wyszukiwarce /users?counter=3

//        writeUsersWithParam(req, users, writer);

        String requestURI = req.getRequestURI();

        Integer index = new Integer(requestURI.substring(requestURI.lastIndexOf("/") + 1));
        writer.write("<h1>" + users.get(index) + "</h1>");

//        albo, tak jak na zajeciach:
        /*
        User user = users.get(index);
        writer.write("<h1>" + user.getLastName() + "</h1>");
        */
    }

    private void writeUsersWithParam(HttpServletRequest req, List<User> users, PrintWriter writer) {
        Integer counter = new Integer(req.getParameter("counter"));
        writer.write("<ul>");
        users.stream()
                .limit(counter)
                .forEach(e -> writer.write("<li>" + e.getFirstName() + " " + e.getLastName() + "</li>"));
        writer.write("</ul>");
    }

    private void writeUsers(List<User> users, PrintWriter writer) {
        writer.write("<ul>");
        users.forEach(e -> writer.write("<li>" + e.getFirstName() + " " + e.getLastName() + "</li>"));
        writer.write("</ul>");
    }
}
