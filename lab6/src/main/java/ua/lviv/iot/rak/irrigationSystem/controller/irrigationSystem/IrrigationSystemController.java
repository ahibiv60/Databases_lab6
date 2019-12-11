package ua.lviv.iot.rak.irrigationSystem.controller.irrigationSystem;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ua.lviv.iot.rak.irrigationSystem.model.IrrigationSystem;
import ua.lviv.iot.rak.irrigationSystem.persistant.SessionManager;

public class IrrigationSystemController implements IrrigationSystemImpl {
    private Session session;

    public IrrigationSystemController(Session session) {
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "IrrigationSystem");
            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                IrrigationSystem item = (IrrigationSystem) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId().toString());
                result.put("status", item.getStatus());
                result.put("time", item.getTime());
                result.put("user_id", item.getUserId());
                full_result.add(result);
            }

            return full_result;
        } finally {
            session.close();
        }
    }


    @Override
    public void create(IrrigationSystem entity) {
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
    public void update(IrrigationSystem entity) {
        session = SessionManager.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        session = SessionManager.getSession();
        IrrigationSystem item = session.get(IrrigationSystem.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
