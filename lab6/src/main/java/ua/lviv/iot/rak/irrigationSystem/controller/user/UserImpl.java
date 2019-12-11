package ua.lviv.iot.rak.irrigationSystem.controller.user;

import org.json.simple.JSONArray;
import ua.lviv.iot.rak.irrigationSystem.model.User;

public interface UserImpl {
    public JSONArray read();
    public void create(User entity);
    public void update(User entity);
    public void delete(int id);
}
