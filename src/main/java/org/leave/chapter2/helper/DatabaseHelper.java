package org.leave.chapter2.helper;

import org.leave.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties conf = PropsUtil.loadProps("config.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");

        try{
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e){
            LOGGER.error("can not load jsbc driver", e);
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn =  DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e){
            LOGGER.error("Get connection failure !", e);
        }
        return conn;
    }

    public static void closeConnection(Connection conn){
        if(conn != null){
            try{
                conn.close();
            } catch (SQLException e){
                LOGGER.error("Close collection failure !", e);
            }
        }
    }
}
