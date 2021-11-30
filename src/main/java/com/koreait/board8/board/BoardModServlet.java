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

@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (MyUtils.isLogout(req)) {
            req.setAttribute("err", "!!! 정상적인 방법으로 접근하세요 !!!");
            req.getRequestDispatcher("/user/login").forward(req, res);
            return;
        }

        if (req.getAttribute("data") == null) {
            int iboard = MyUtils.getParameterInt(req, "iboard");
            BoardVO param = new BoardVO();
            param.setIboard(iboard);
            BoardVO data = BoardDAO.selBoardDetail(param);
            req.setAttribute("data", data);
        }
        MyUtils.disForward(req, res, "/board/mod");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int iboard = MyUtils.getParameterInt(req, "iboard");
        String title = req.getParameter("title");
        String ctnt = req.getParameter("ctnt");

        BoardVO param = new BoardVO();

        param.setIboard(iboard);
        param.setTitle(title);
        param.setCtnt(ctnt);
        param.setWriter(MyUtils.getLoginUserPk(req));

        int result = BoardDAO.updBoard(param);

        switch (result) {
            case 1:
                res.sendRedirect("/board/detail?iboard=" + iboard);
                break;
            default:
                req.setAttribute("err", "수정을 실패하였습니다.");
                req.setAttribute("data", param);
                doGet(req, res);
                break;
        }


    }
}
