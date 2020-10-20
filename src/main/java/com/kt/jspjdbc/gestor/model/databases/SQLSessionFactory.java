package com.kt.jspjdbc.gestor.model.databases;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLSessionFactory {

    private static final Logger logger = LoggerFactory.getLogger(SQLSessionFactory.class);

    private MysqlDataSource dataSource;

    public SQLSessionFactory() {

        try {
            dataSource = new MysqlDataSource();
            dataSource.setServerName(System.getenv("gestor_jdbc_db_server"));
            dataSource.setDatabaseName(System.getenv("gestor_jdbc_db_name"));
            dataSource.setUser(System.getenv("gestor_jdbc_db_user"));
            dataSource.setPassword(System.getenv("gestor_jdbc_db_password"));
            dataSource.setPort(Integer.parseInt(System.getenv("gestor_jdbc_db_port")));
            dataSource.setServerTimezone("Europe/Warsaw");
            dataSource.setUseSSL(false);
            dataSource.setCharacterEncoding("UTF-8");
            logger.info("DataSource created!");
        } catch (SQLException e) {
            logger.error("Error during creating MysqlDataSource", e);
            return;
        }

    }

    public static void main(String[] args) throws SQLException {

        SQLSessionFactory SQLSessionFactory = new SQLSessionFactory();
        SQLSessionFactory.getConnection();

    }

    public Connection getConnection() throws SQLException {

        Connection connection = dataSource.getConnection();
        logger.info("Connected database successfully!");
        logger.info("Connection = " + connection);
        logger.info("Database name = " + connection.getCatalog());
        return connection;

    }

}
