package ua.lviv.iot.rak.irrigationSystem.controller.nozzle;

import org.json.simple.JSONArray;
import ua.lviv.iot.rak.irrigationSystem.model.Nozzle;

public interface NozzleImpl {
    public JSONArray read();
    public void create(Nozzle entity);
    public void update(Nozzle entity);
    public void delete(int id);
}
