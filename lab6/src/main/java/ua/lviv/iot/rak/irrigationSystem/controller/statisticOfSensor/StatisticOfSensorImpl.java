package ua.lviv.iot.rak.irrigationSystem.controller.statisticOfSensor;

import org.json.simple.JSONArray;
import ua.lviv.iot.rak.irrigationSystem.model.StatisticOfSensor;

public interface StatisticOfSensorImpl {
    public JSONArray read();
    public void create(StatisticOfSensor entity);
    public void update(StatisticOfSensor entity);
    public void delete(int id);
}
