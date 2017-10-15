package pl.marta.servlet;

import org.apache.commons.lang3.StringUtils;
import pl.marta.controller.Controller;
import pl.marta.controller.CookieControler;
import pl.marta.controller.LoginController;
import pl.marta.controller.UserController;
import pl.sda.file.FileOperations;
import pl.sda.file.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
//import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class HelloServlet extends HttpServlet {

//    pole klasy

    private Map<String, Controller> controllerMap;

//    init z HttpServlet, ktora mozemy nadpisac
//    odpalana raz przy tworzeniu servletu, przy budowaniu war'a
//    tu inicjalizujemy Controller'y - dodajemy kontrolera

    @Override
    public void init() throws ServletException {
        this.controllerMap = new HashMap<String, Controller>();
        controllerMap.put("users", new UserController());
        controllerMap.put("login", new LoginController());
        controllerMap.put("cookie", new CookieControler());

//        przyklad lambdy
//        lambda spodziew sie interfejsu z jedna metoda - Controller jest taka
//        implementacja metody, tworzymy klase anonimowa (bez nazwy) implementujaca interfejs Controller
//        lambdy sluza do tego, co mozna zrobic jedna linijka i wtedy, kiedy nie bedziemy tego reuzywali

        controllerMap.put("default", (request, response) ->
                response.getWriter().write("<h1>Hello from default controller</h1>"));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

//        sprawdzenie sciezki
//        substring po 2gim slaszu
//        ale dodalismy StringUtils z maven do pom'a - wykorzystanie ponizej
//        uwaga aby zaciagnac odpowiednia klase

        String requestURI = req.getRequestURI();
        String relativePath = requestURI.substring(StringUtils.ordinalIndexOf(requestURI, "/", 2) + 1);

//        pobieramy controller odpowiedzialny za to path

        Controller controller = controllerMap.get(relativePath);

//        sytuacja w ktorej ktos wpisal sciezke, ktorej nie obsugujemy
//        wowczas chcemy default

        if (controller == null) {
            controller = controllerMap.get("default");
        }

//        wywolanie metody controllera

        controller.handleGet(req, resp);

        /*
        PrintWriter writer = resp.getWriter();
        writer.write("<h1>Hello World!</h1>");
        */
    }

//    zajecia 07.03.2017

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String body = reader.readLine();
        String[] split = body.split(" ");

        User user = new User();
        user.setFirstName(split[0]);
        user.setLastName(split[1]);
        user.setAge(new Integer(split[2]));

        File file = new File("C:\\Users\\RENT\\Desktop\\test.txt");
        FileOperations.addUserToFile(user, file);

        resp.getWriter().write("OK!");
        resp.setStatus(201);
    }
}
