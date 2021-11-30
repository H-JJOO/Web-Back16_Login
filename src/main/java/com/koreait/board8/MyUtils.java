package com.koreait.board8;

import com.koreait.board8.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyUtils {
    //jsp 경로
    public static void disForward(HttpServletRequest req, HttpServletResponse res, String jsp) throws ServletException, IOException {
        String path = "/WEB-INF/view" + jsp + ".jsp";
        req.getRequestDispatcher(path).forward(req, res);
    }
    //문자열 정수형으로 파싱 (예외시 정해진 기본값 리턴)
    public static int parseStringToInt(String str, int defVal) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return defVal;
        }
    }
    //정수가 아니면 0으로 파싱
    public static int parseStringToInt(String str) {
        return parseStringToInt(str, 0);
    }

    //문자열 정수형으로 파싱(key)
    public static int getParameterInt(HttpServletRequest req, String key) {
        String strVal = req.getParameter(key);
        int intVal = parseStringToInt(strVal);
        return intVal;
    }

    public static int getParameterInt(HttpServletRequest req, String key, int defVal) {
        return parseStringToInt(req.getParameter(key), defVal);
    }

    //세션에 로그인 값 있는지 확인
    public static UserVO getLoginUser(HttpServletRequest req) {
        HttpSession session = req.getSession();
        return  (UserVO)session.getAttribute("loginUser");
    }
    //있으면 로그인
    public static boolean isLogin(HttpServletRequest req) {
        return getLoginUser(req) != null;
    }
    //없으면 로그아웃
    public static  boolean isLogout(HttpServletRequest req) {
        return getLoginUser(req) == null;
    }
    //로그아웃 상태이면 0, 로그인 상태이면 iuser(PK)값 리턴
    public static int getLoginUserPk(HttpServletRequest request) {
        UserVO loginUser = getLoginUser(request);
        return loginUser == null ? 0 : loginUser.getIuser();
    }


}
