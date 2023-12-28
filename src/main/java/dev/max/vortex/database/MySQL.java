package dev.max.vortex.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import dev.max.vortex.database.connection.MySQLConnection;
import dev.max.vortex.database.model.MySQLInfo;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author gokimax at 12/28/2023
 * @project api
 */
public class MySQL {

    private static final String OPTIONS = "?jdbcCompliantTruncation=false&autoReconnect=true&zeroDateTimeBehavior=convertToNull&max_allowed_packet=512M&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";

    public static MySQLConnection createConnection(String host, int port, String database, String user, String password) {
        return new MySQLConnection(new MySQLInfo(host, port, database, user, password)).openConnection();
    }

    public static Connection openConnection(MySQLInfo info) {
        String host = info.getHost();
        int port = info.getPort();
        String database = info.getDatabase();
        String user = info.getUser();
        String password = info.getPassword();

        MysqlDataSource source = new MysqlDataSource();
        source.setUrl("jdbc:mysql://" + host + ":" + port + "/" + database + OPTIONS);
        try {
            source.setAutoReconnect(true);
            source.setAutoReconnectForPools(true);
            return source.getConnection(user, password);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

}
