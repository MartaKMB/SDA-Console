package pl.sda.servlets;

import org.codehaus.jackson.map.ObjectMapper;
import pl.sda.entities.User;
import pl.sda.services.UserService;
import pl.sda.servlets.responses.CreateUserResponse;
import pl.sda.servlets.responses.DeleteUserResponse;
import pl.sda.servlets.responses.UpdateUserResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class JSONReceiver extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        obsluga zapytania, czyli z obiektu req

        BufferedReader reader = req.getReader();

//        pobieranie zawartosci

        StringBuffer json = new StringBuffer();

//        obiekt trzymajacy aktualnie wczytywana linie z req
//        przypisujemy poczatkowa wartosc

        String line = null;

//        przyrownanie czy line jest rozne od null'a, jak tak to to jsnona doklejamy przez append
//        doklejamy tekst wpisany w body na postman'ie

        while ((line = reader.readLine()) != null) {
            json.append(line);
        }

//        obiekt odpowiedzi i pobieramy writera i wywolujemy metode write z parametrem StringBuffer'a
        /*
        resp.getWriter().write(json.toString());
        System.out.println("");
        */

        UserService userService = new UserService();
        CreateUserResponse response = userService.addUser(json.toString());

        ObjectMapper mapper = new ObjectMapper();

        resp.getWriter().write(mapper.writeValueAsString(response));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("id");
        UserService userService = new UserService();

        User user = userService.getUserByUUID(userId);

        ObjectMapper mapper = new ObjectMapper();

//        nie jest niezbedne, bo sprawdzamy w postman'ie

        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();

        writer.write(mapper.writeValueAsString(user));

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        UserService userService = new UserService();

//        bez wykorzystanie klasy DeleteUserResponse, ponizej z wykorzystaniem tej klasy
//        String outMsg = userService.removeUserByUUID(id);

        DeleteUserResponse result = userService.removeUserById(id);

        ObjectMapper mapper = new ObjectMapper();

        PrintWriter writer = resp.getWriter();

        writer.write(mapper.writeValueAsString(result));

        resp.setContentType("application/json");
    }

//    PUT aktualizuje dane uzytkownika

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();

        StringBuffer json = new StringBuffer();

        String line = null;

        while ((line = reader.readLine()) != null) {
            json.append(line);
        }

        ObjectMapper mapper = new ObjectMapper();

//        mapper zamienia na obiekt User

        User user = mapper.readValue(json.toString(), User.class);

        UserService userService = new UserService();
        UpdateUserResponse response = userService.updateUser(user);

        resp.getWriter().write(mapper.writeValueAsString(response));
    }
}
