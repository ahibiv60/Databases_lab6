package ua.lviv.iot.rak.irrigationSystem.controller.motor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ua.lviv.iot.rak.irrigationSystem.model.Motor;
import ua.lviv.iot.rak.irrigationSystem.persistant.SessionManager;

public class MotorController implements MotorImpl {
    private Session session;

    public MotorController(Session session) {
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Motor");

            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                Motor item = (Motor) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId().toString());
                result.put("time", item.getTime());
                result.put("status", item.getStatus());
                result.put("pump_id", item.getPumpId());
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }


    @Override
    public void create(Motor entity) {
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
    public void update(Motor entity) {
        session = SessionManager.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        session = SessionManager.getSession();
        Motor item = session.get(Motor.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
