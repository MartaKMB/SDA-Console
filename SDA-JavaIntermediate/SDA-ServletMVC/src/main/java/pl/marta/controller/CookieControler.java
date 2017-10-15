package pl.marta.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CookieControler implements Controller {

//        dodanie ciasteczka, zapisane przez 1000sek w przegladarce

    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("hello", "world");
        cookie.setMaxAge(1000);
        response.addCookie(cookie);

        response.getWriter().write("<h1>Hello from cookie controller</h1>");
    }

}
