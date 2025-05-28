package ejercicio16b.ejercicio16b.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ejercicio16b.ejercicio16b.models.likes;

@Service
public class LikeService {

    @Value("${spring.datasource.url}")
private String dbUrl;

@Value("${spring.datasource.username}")
private String dbUsername;

@Value("${spring.datasource.password}")
private String dbPassword;

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    public likes obtenerLikes() {
        String query = "SELECT * FROM meGusta";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return new likes(
                        rs.getInt("likeImagen1"),
                        rs.getInt("likeImagen2"),
                        rs.getInt("likeImagen3")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new likes(); 
    }

    public void aumentarLike(int imagen) {
    String column = switch (imagen) {
        case 1 -> "likeImagen1";
        case 2 -> "likeImagen2";
        case 3 -> "likeImagen3";
        default -> null;
    };

    if (column == null) return;

   String update = "UPDATE meGusta SET " + column + " = " + column + " + 1 WHERE id = 1";

    try (Connection conn = getConnection();
         Statement stmt = conn.createStatement()) {
        stmt.executeUpdate(update);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
