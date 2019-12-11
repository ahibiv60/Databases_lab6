package ua.lviv.iot.rak.irrigationSystem.controller.sensor;

import org.json.simple.JSONArray;
import ua.lviv.iot.rak.irrigationSystem.model.Sensor;

public interface SensorImpl {
    public JSONArray read();
    public void create(Sensor entity);
    public void update(Sensor entity);
    public void delete(int id);
}
