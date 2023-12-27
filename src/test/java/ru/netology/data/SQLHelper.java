package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLHelper {
    private static final QueryRunner runner = new QueryRunner();
    private static final String url = System.getProperty("db.url");
    private static final String user = System.getProperty("db.user");
    private static final String pass = System.getProperty("db.password");

    private SQLHelper() {

    }

    @SneakyThrows
    private static Connection getConn() {
        return DriverManager.getConnection(url, user, pass);
    }

    @SneakyThrows
    public static String getPaymentStatus() {
        var statusSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        var conn = getConn();
        return runner.query(conn, statusSQL, new ScalarHandler<String>());
    }

    @SneakyThrows
    public static String getCreditRequestStatus() {
        var statusSQL = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1;";
        var conn = getConn();
        return runner.query(conn, statusSQL, new ScalarHandler<String>());
    }

    @SneakyThrows
    public static void cleanDB() {
        var conn = getConn();
        runner.execute(conn, "DELETE FROM credit_request_entity");
        runner.execute(conn, "DELETE FROM order_entity");
        runner.execute(conn, "DELETE FROM payment_entity");
    }
}