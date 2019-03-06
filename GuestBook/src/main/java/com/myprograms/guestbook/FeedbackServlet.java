package com.myprograms.guestbook;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FeedbackServlet extends HttpServlet {

    private FeedbackService feedbackService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        this.feedbackService = (FeedbackService) servletContext.getAttribute("feedbackService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Feedback> list = feedbackService.getFeedbackOrderedByDate();
        req.setAttribute("feedbacks", list);
        req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Feedback feedback = new Feedback();
        feedback.setName(req.getParameter("name"));
        feedback.setText(req.getParameter("comment"));
        feedback.setRank(Integer.parseInt(req.getParameter("rating")));
        feedbackService.createFeedback(feedback.getName(), feedback.getText(), feedback.getRank());

        resp.sendRedirect("/guestbook");
    }
}