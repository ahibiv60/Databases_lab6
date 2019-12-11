package ua.lviv.iot.rak.irrigationSystem.controller.area;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ua.lviv.iot.rak.irrigationSystem.model.Area;
import ua.lviv.iot.rak.irrigationSystem.persistant.SessionManager;

public class AreaController implements AreaImpl {
    private Session session;

    public AreaController(Session session) {
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Area");
            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                Area item = (Area) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId().toString());
                result.put("location", item.getLocation());
                result.put("irrigation_system_id", item.getIrrigationSystemId());
                full_result.add(result);
            }

            return full_result;
        } finally {
            session.close();
        }
    }


    @Override
    public void create(Area entity) {
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
    public void update(Area entity) {
        session = SessionManager.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        session = SessionManager.getSession();
        System.out.println(id);
        Area item = session.get(Area.class, id);
        System.out.println("session is openned");
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
