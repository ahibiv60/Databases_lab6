package ua.lviv.iot.rak.irrigationSystem.controller.password;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ua.lviv.iot.rak.irrigationSystem.model.Password;
import ua.lviv.iot.rak.irrigationSystem.persistant.SessionManager;

public class PasswordController implements PasswordImpl {
    private Session session;

    public PasswordController(Session session) {
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Password");

            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                Password item = (Password) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId().toString());
                result.put("password", item.getPassword());
                result.put("user_id", item.getUserId());
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }


    @Override
    public void create(Password entity) {
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
    public void update(Password entity) {
        session = SessionManager.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        session = SessionManager.getSession();
        Password item = session.get(Password.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
