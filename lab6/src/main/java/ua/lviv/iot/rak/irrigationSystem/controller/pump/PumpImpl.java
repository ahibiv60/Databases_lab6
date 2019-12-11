package ua.lviv.iot.rak.irrigationSystem.controller.pump;

import org.json.simple.JSONArray;
import ua.lviv.iot.rak.irrigationSystem.model.Pump;

public interface PumpImpl {
    public JSONArray read();
    public void create(Pump entity);
    public void update(Pump entity);
    public void delete(int id);
}
