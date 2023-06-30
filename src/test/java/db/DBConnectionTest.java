package db;

import com.baseballmanager.bmapp.db.DBConnection;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import org.assertj.core.api.Assertions;
public class DBConnectionTest {
    @Test
    void DBConnectionTest() {
        Connection connection = DBConnection.getConnection();

        Assertions.assertThat(connection).isNull();
    }
}
