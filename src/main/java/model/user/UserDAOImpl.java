package model.user;

import model.Membership;
import model.SQLSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {


    private static Logger logger = LoggerFactory.getLogger(SQLSessionFactory.class);

    SQLSessionFactory SQLSessionFactory = new SQLSessionFactory();

    @Override
    public void register(String name, String surname, String email, String password, Membership membership) {
        User newUser = new User();

        newUser.setName(name);
        newUser.setSurname(surname);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setMembership(membership);

        save(newUser);
        logger.info("User registered");
    }

    @Override
    public void save(User u) {
        String query = "INSERT INTO users (name, surname, email, password, membeshipId) VALUES (?,?,?,?,?)";

        try (PreparedStatement statement = SQLSessionFactory.getConnection().prepareStatement(query)) {
            //parameterIndex zaczyna się od 1!
            statement.setString(1, u.getName());
            statement.setString(2, u.getSurname());
            statement.setString(3, u.getEmail());
            statement.setString(4, u.getPassword());
            statement.setInt(5, u.getMembership().getMembershipId());
            int i = statement.executeUpdate();
            if (i == 0) {
                logger.info("User not added");
            }
        } catch (SQLException e) {
            logger.error("User cannot be added", e);
        }
    }

    @Override
    public void update(User u) {
        String query = "UPDATE users SET name = ?, surname =?, mail =?, password= ? WHERE userId= ?";

        try (PreparedStatement statement = SQLSessionFactory.getConnection().prepareStatement(query)) {
            statement.setString(1, u.getName());
            statement.setString(2, u.getSurname());
            statement.setString(3, u.getEmail());
            statement.setString(4, u.getPassword());
            statement.setInt(5, u.getUserId());
            int i = statement.executeUpdate();
            if (i == 0) {
                logger.info("Nothing changed");
            } else {
                logger.info(i + " users changed");
            }

        } catch (SQLException e) {
            logger.error("User cannot be changed", e);
        }
    }

    @Override
    public void delete(String id) {
        String query = "DELETE FROM users WHERE userId= ?";

        try (PreparedStatement statement = SQLSessionFactory.getConnection().prepareStatement(query)) {
            statement.setString(1, id);
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.info("Nothing deleted");
            } else {
                logger.info("User deleted");
            }

        } catch (SQLException e) {
            logger.error("User cannot be deleted", e);
        }
    }

    @Override
    public User find(String id) {
        User user = new User();

        String query = "SELECT * FROM users WHERE userId= ?";

        try (PreparedStatement statement = SQLSessionFactory.getConnection().prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user.setName(result.getString("userId"));
                user.setSurname(result.getString("surname"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setUserId(result.getInt("userId"));
                user.setMembership(getMembershipById(result.getInt("membeshipId")));
            } else {
                logger.info("Nothing found");
                return null;
            }
        } catch (SQLException e) {
            logger.error("Error searching users", e);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();

        String query = "SELECT * FROM users";

        try (Statement statement = SQLSessionFactory.getConnection().createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                User user = new User();
                user.setUserId(result.getInt("userId"));
                user.setName(result.getString("name"));
                user.setSurname(result.getString("surname"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setMembership(getMembershipById(result.getInt("membeshipId")));
                list.add(user);
            }
        } catch (SQLException e) {
            logger.error("Error listing all users", e);
        }

        return list;

    }

    @Override
    public int login(String email, String password) {
        User user = new User();

        String query = "SELECT * FROM users WHERE email= ? && password= ?";

        try (PreparedStatement statement = SQLSessionFactory.getConnection().prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user.setName(result.getString("userId"));
                user.setSurname(result.getString("surname"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setUserId(result.getInt("userId"));
                user.setMembership(getMembershipById(result.getInt("membeshipId")));
            } else {
                logger.info("Error login user");
                return 0;
            }
        } catch (SQLException e) {
            logger.error("Error login user", e);
        }
        return user.getUserId();
    }

    @Override
    public String getEmail(String id) {
        String email = find(id).getEmail();
        return email;
    }

    @Override
    public Membership getMembershipById(int membershipId) {

        switch (membershipId) {
            case 1:
                return Membership.STUDENT;
            case 2:
                return Membership.TEACHER;
            case 3:
                return Membership.PARENT;
            case 4:
                return Membership.DIRECTOR;
            default:
                return Membership.UNSET;
        }
    }
}
