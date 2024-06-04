package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.beens.Member;

public class MemberDAO extends DAO {

    // 会員情報をデータベースに登録するメソッド
    public boolean registerMember(Member member) throws Exception {
        String sql = "INSERT INTO members (userId, password, lastName, firstName, gender, birthYear, birthMonth, birthDay, phoneNumber, email, occupation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // プレースホルダーに値を設定
            statement.setString(1, member.getUserId());
            statement.setString(2, member.getPassword());
            statement.setString(3, member.getLastName());
            statement.setString(4, member.getFirstName());
            statement.setString(5, member.getGender());
            statement.setString(6, member.getBirthYear());
            statement.setString(7, member.getBirthMonth());
            statement.setString(8, member.getBirthDay());
            statement.setString(9, member.getPhoneNumber());
            statement.setString(10, member.getEmail());
            statement.setString(11, member.getOccupation());

            // SQL文を実行し、更新行数を取得
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
    }
}
