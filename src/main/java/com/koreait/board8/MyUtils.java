package com.koreait.board8;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyUtils {
    public static void disForward(HttpServletRequest req, HttpServletResponse res, String jsp) throws ServletException, IOException {
        String path = "/WEB-INF/view" + jsp + "/.jsp";
        req.getRequestDispatcher(path).forward(req, res);
    }
}
