package jp.co.aforce.servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.aforce.DAO.MemberDAO;
import jp.co.aforce.beens.Member;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    // GETリクエスト処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // register.jspへリダイレクト
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/register.jsp");
        dispatcher.forward(request, response);
    }

    // POSTリクエスト処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 文字エンコーディングをUTF-8に設定
        request.setCharacterEncoding("UTF-8");

        // フォームから送信されたデータを取得
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String gender = request.getParameter("gender");
        String birthYear = request.getParameter("birthYear");
        String birthMonth = request.getParameter("birthMonth");
        String birthDay = request.getParameter("birthDay");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String occupation = request.getParameter("occupation");
        String otherOccupation = request.getParameter("otherOccupation");

        // パスワードの長さをチェック
        if (password.length() < 8 || password.length() > 30) {
            request.setAttribute("errorMessage", "パスワードは8文字以上30文字以下で入力してください。");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/register.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // パスワードが一致しない場合のエラーチェック
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "パスワードが一致しません。");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/register.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // 職業が"その他"の場合、テキストボックスの内容を職業に設定
        if ("other".equals(occupation)) {
            occupation = otherOccupation;
        }

        // Memberオブジェクトを作成し、取得したデータを設定
        Member member = new Member();
        member.setUserId(userId);
        member.setPassword(password);
        member.setLastName(lastName);
        member.setFirstName(firstName);
        member.setGender(gender);
        member.setBirthYear(birthYear);
        member.setBirthMonth(birthMonth);
        member.setBirthDay(birthDay);
        member.setPhoneNumber(phoneNumber);
        member.setEmail(email);
        member.setOccupation(occupation);

        MemberDAO memberDAO = new MemberDAO();
        try {
            // 会員情報を登録
            boolean isRegistered = memberDAO.registerMember(member);
            if (isRegistered) {
                // 登録成功の場合、success.jspへリダイレクト
                response.sendRedirect(request.getContextPath() + "/views/success.jsp");
            } else {
                // 登録失敗の場合、エラーメッセージを設定しregister.jspへフォワード
                request.setAttribute("errorMessage", "登録に失敗しました。");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/register.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            // SQL例外発生時のエラーメッセージを設定しregister.jspへフォワード
            e.printStackTrace();
            request.setAttribute("errorMessage", "データベースエラーが発生しました。");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/register.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            // その他の例外発生時のエラーメッセージを設定しregister.jspへフォワード
            e.printStackTrace();
            request.setAttribute("errorMessage", "エラーが発生しました。");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/register.jsp");
            dispatcher.forward(request, response);
        }
    }
}

