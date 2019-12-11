package ua.lviv.iot.rak.irrigationSystem.controller.motor;

import org.json.simple.JSONArray;
import ua.lviv.iot.rak.irrigationSystem.model.Motor;

public interface MotorImpl {
    public JSONArray read();
    public void create(Motor entity);
    public void update(Motor entity);
    public void delete(int id);
}
