package ua.lviv.iot.rak.irrigationSystem.controller.password;

import org.json.simple.JSONArray;
import ua.lviv.iot.rak.irrigationSystem.model.Password;

public interface PasswordImpl {
    public JSONArray read();
    public void create(Password entity);
    public void update(Password entity);
    public void delete(int id);
}
