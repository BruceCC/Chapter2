package org.leave.chapter2.helper;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.leave.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class DatabaseHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);
    private static final QueryRunner QUERY_RUNNNER = new QueryRunner();
    private static final ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<Connection>();

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
        Connection conn = CONNECTION_HOLDER.get();
        if(conn == null){
            try{
                conn =  DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e){
                LOGGER.error("Get connection failure !", e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.set(conn);
            }
        }
        return conn;
    }

    public static void closeConnection(){
        Connection conn = CONNECTION_HOLDER.get();
        if(conn != null){
            try{
                conn.close();
            } catch (SQLException e){
                LOGGER.error("Close collection failure !", e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }

    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params){
        List<T> entityList;
        try{
            Connection conn = getConnection();
            entityList = QUERY_RUNNNER.query(conn, sql, new BeanListHandler<T>(entityClass), params);
        } catch (SQLException e){
            LOGGER.error("Query entity list failure !", e);
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return entityList;
    }

    public static <T> T queryEntity(Class<T> entityClass, String sql, Object... params){
        T entity;
        try{
            Connection conn = getConnection();
            entity = QUERY_RUNNNER.query(conn, sql, new BeanHandler<T>(entityClass), params);
        } catch (SQLException e){
            LOGGER.error("Query entity list failure !", e);
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return entity;
    }
}
