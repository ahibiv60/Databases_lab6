package ua.lviv.iot.rak.irrigationSystem.controller.irrigationSystem;

import org.json.simple.JSONArray;
import ua.lviv.iot.rak.irrigationSystem.model.IrrigationSystem;

public interface IrrigationSystemImpl {
    public JSONArray read();
    public void create(IrrigationSystem entity);
    public void update(IrrigationSystem entity);
    public void delete(int id);
}
