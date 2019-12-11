package ua.lviv.iot.rak.irrigationSystem.controller.statisticOfSensor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ua.lviv.iot.rak.irrigationSystem.model.StatisticOfSensor;
import ua.lviv.iot.rak.irrigationSystem.persistant.SessionManager;

public class StatisticOfSensorController implements StatisticOfSensorImpl {
    private Session session;

    public StatisticOfSensorController(Session session) {
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "StatisticOfSensor");

            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                StatisticOfSensor item = (StatisticOfSensor) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId().toString());
                result.put("time", item.getTime());
                result.put("temperature", item.getTemperature());
                result.put("lighting", item.getLighting());
                result.put("humidity", item.getHumidity());
                result.put("sensor_id", item.getSensorId());
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }


    @Override
    public void create(StatisticOfSensor entity) {
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
    public void update(StatisticOfSensor entity) {
        session = SessionManager.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        session = SessionManager.getSession();
        StatisticOfSensor item = session.get(StatisticOfSensor.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
