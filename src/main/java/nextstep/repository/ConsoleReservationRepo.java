package nextstep.repository;

import nextstep.domain.reservation.Reservation;

import java.sql.*;

public class ConsoleReservationRepo implements ReservationRepo {
    public Reservation findById(long id) {
        return null;
    }

    public long add(Reservation reservation) {
        Connection con = null;
        Long id = null;

        // 드라이버 연결
        try {
            con = DriverManager.getConnection("jdbc:h2:~/test;AUTO_SERVER=true", "sa", "");
            System.out.println("정상적으로 연결되었습니다.");
        } catch (SQLException e) {
            System.err.println("연결 오류:" + e.getMessage());
            e.printStackTrace();
        }

        try {
            String sql = "INSERT INTO reservation (date, time, name, theme_name, theme_desc, theme_price) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setDate(1, Date.valueOf(reservation.getDate()));
            ps.setTime(2, Time.valueOf(reservation.getTime()));
            ps.setString(3, reservation.getName());
            ps.setString(4, reservation.getTheme().getName());
            ps.setString(5, reservation.getTheme().getDesc());
            ps.setInt(6, reservation.getTheme().getPrice());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                id = rs.getLong(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            System.err.println("con 오류:" + e.getMessage());
        }

        return id;
    }

    public int delete(long id) {
        return 0;
    }
}
