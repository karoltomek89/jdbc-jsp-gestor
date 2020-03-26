package controller.grades;

import model.group.Group;
import model.group.GroupDAO;
import model.group.GroupDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "GetGroupListForGradesServlet", value = "/getgrouplistforgrades")
public class GetGroupListForGradesServlet extends HttpServlet {
    List<Group> groupList = new ArrayList<>();
    GroupDAO group = new GroupDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Optional<Object> userIdValue = Optional.ofNullable(req.getSession().getAttribute("userId").toString());

        if (!userIdValue.isEmpty()) {
            groupList = group.findAll();
            req.setAttribute("groupList", groupList);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/teacher/bar/teacherBarChooseGroupForGrades.jsp");
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
