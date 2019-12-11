package ua.lviv.iot.rak.irrigationSystem.controller.user;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ua.lviv.iot.rak.irrigationSystem.model.User;
import ua.lviv.iot.rak.irrigationSystem.persistant.SessionManager;

public class UserController implements UserImpl {
    private Session session;

    public UserController(Session session) {
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Motor");

            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                User item = (User) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId().toString());
                result.put("name", item.getName());
                result.put("email", item.getEmail());
                result.put("phone", item.getPhone());
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }


    @Override
    public void create(User entity) {
        session = SessionManager.getSession();
        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            System.out.println(".saved");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(User entity) {
        session = SessionManager.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        session = SessionManager.getSession();
        User item = session.get(User.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
