package ua.lviv.iot.rak.irrigationSystem.controller.area;

import org.json.simple.JSONArray;
import ua.lviv.iot.rak.irrigationSystem.model.Area;

public interface AreaImpl {
    public JSONArray read();
    public void create(Area entity);
    public void update(Area entity);
    public void delete(int id);
}
