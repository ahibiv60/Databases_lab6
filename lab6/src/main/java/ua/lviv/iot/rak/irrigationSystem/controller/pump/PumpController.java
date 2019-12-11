package ua.lviv.iot.rak.irrigationSystem.controller.pump;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ua.lviv.iot.rak.irrigationSystem.model.Pump;
import ua.lviv.iot.rak.irrigationSystem.persistant.SessionManager;

public class PumpController implements PumpImpl {
    private Session session;

    public PumpController(Session session) {
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Pump");

            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                Pump item = (Pump) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId().toString());
                result.put("status", item.getStatus());
                result.put("amount_of_pumped_water", item.getAmountOfPumpedWater());
                result.put("area_id", item.getAreaId());
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }


    @Override
    public void create(Pump entity) {
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
    public void update(Pump entity) {
        session = SessionManager.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        session = SessionManager.getSession();
        Pump item = session.get(Pump.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
