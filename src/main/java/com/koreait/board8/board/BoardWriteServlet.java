package com.koreait.board8.board;

import com.koreait.board8.MyUtils;
import com.koreait.board8.dao.BoardDAO;
import com.koreait.board8.model.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (MyUtils.isLogout(req)) {
            req.setAttribute("err", "!!!올바른 방법으로 접근하세요!!!");
            req.getRequestDispatcher("/user/login").forward(req, res);
            return;
        }
        MyUtils.disForward(req, res, "/board/write");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String title = req.getParameter("title");
        String ctnt = req.getParameter("ctnt");

        BoardVO parma = new BoardVO();

        parma.setTitle(title);
        parma.setCtnt(ctnt);
        parma.setWriter(MyUtils.getLoginUserPk(req));

        int result = BoardDAO.insBoard(parma);

        switch (result) {
            case 1:
                res.sendRedirect("/board/list");
                break;
            default:
                req.setAttribute("err", "글등록을 실패하였습니다.");
                req.setAttribute("data", parma);
                doGet(req, res);
                break;
        }
    }
}
