package ua.lviv.iot.rak.irrigationSystem.controller.sensor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ua.lviv.iot.rak.irrigationSystem.model.Sensor;
import ua.lviv.iot.rak.irrigationSystem.persistant.SessionManager;

public class SensorController implements SensorImpl {
    private Session session;

    public SensorController(Session session) {
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Sensor");

            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                Sensor item = (Sensor) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId().toString());
                result.put("status", item.getStatus());
                result.put("location", item.getLocation());
                result.put("area_id", item.getAreaId());
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }


    @Override
    public void create(Sensor entity) {
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
    public void update(Sensor entity) {
        session = SessionManager.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        session = SessionManager.getSession();
        Sensor item = session.get(Sensor.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
