package pl.marta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class MyServlet extends HttpServlet {

//    alt+insert override methods

//    w doGet - co ma sie zadziac, jak ktos wejdzie na strone, zrobi geta po nasza strone
//    req - to co przyszlo od uzytkownika
//    resp - to co oddamy

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        tworzymy liste imion

        List<String> names = Arrays.asList("Kasia", "Szymon", "Krzysztof", "Arek", "Marta");

        PrintWriter writer = resp.getWriter();

//        zaznaczyc, ze to html - mowimy, jak przegladarka ma obslugiwac

        resp.setContentType("text/html");

        writer.write("<h1>");

//        po dodaniu ponizszego, po wpisaniu w wyszukiwarke:
//        http://www.localhost:8081/SDA-servlety-1.0-SNAPSHOT/hello?name=Marta
//        mamy: Hello Marta

        writer.write("Hello " + req.getParameter("name"));

//        lista uporzadkowana

        writer.write("<ul>");

        //        przechodzimy w petli

        names.forEach(e -> writer.write("<li>" + e + "</li>"));

        /*
        writer.write("<li>Mariusz</li>");
        writer.write("<li>Anna</li>");
        */

        writer.write("</ul>");

//        writer.write(req.getRequestURI());

        writer.write("</h1>");

//        counter

        Integer counter = new Integer(req.getParameter("counter"));

        writer.write("<ul>");
        names.stream()
                .limit(counter)
                .forEach(e -> writer.write("<li>" + e + "</li>"));
        writer.write("</ul>");
    }

}
