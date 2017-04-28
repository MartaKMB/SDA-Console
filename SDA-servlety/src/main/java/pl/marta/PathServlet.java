package pl.marta;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class PathServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> names = Arrays.asList("Kasia", "Szymon", "Krzysztof", "Arek", "Marta");

        PrintWriter writer = resp.getWriter();

//        System.out.println() = writer.write();

        resp.setContentType("text/html");

//        zwracanie sciezki /SDA-servlety...

        String requestURI = req.getRequestURI();

//        chcemy indeks z ostatniego /
//        split po "sleszach", albo substringiem
//        +1 bo chcemy wziac to co na prawo od /

        /*
        String name = requestURI.substring(requestURI.lastIndexOf("/") + 1);
        writer.write("<h1>" + name + "</h1>");
        */

//        na ostatnim miejscu adresu liczba: przez to pobieramy imie z danego indeksu i zwracamy
//        np numer artykulu

        Integer index = new Integer(requestURI.substring(requestURI.lastIndexOf("/") + 1));
        writer.write("<h1>" + names.get(index) + "</h1>");

    }
}
