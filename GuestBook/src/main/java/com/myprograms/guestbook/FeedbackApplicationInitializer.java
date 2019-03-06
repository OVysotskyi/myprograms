package com.myprograms.guestbook;

import com.zaxxer.hikari.HikariDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

public class FeedbackApplicationInitializer implements ServletContextListener {

    private final HikariDataSource dataSource;
    private final FeedbackService feedbackService;

    public FeedbackApplicationInitializer() {
        this.dataSource = initDataSource();
        this.feedbackService = new FeedbackService(dataSource);
    }

    private HikariDataSource initDataSource() {
        HikariDataSource ds = null;

        if (dataSource == null) {
            ds = new HikariDataSource();
            ds.setDriverClassName("org.postgresql.Driver");
            ds.setJdbcUrl("jdbc:postgresql://127.0.0.1/questbook");
            ds.setUsername("postgres");
            ds.setPassword("aseban71");
        }

        return ds;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        ctx.setAttribute("feedbackService", feedbackService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        HikariDataSource ds = (HikariDataSource) ctx.getAttribute("dataSource");

        try {
            ds.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
