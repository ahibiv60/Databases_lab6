package ua.lviv.iot.rak.irrigationSystem.services;

import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.rak.irrigationSystem.controller.area.AreaController;
import ua.lviv.iot.rak.irrigationSystem.controller.irrigationSystem.IrrigationSystemController;
import ua.lviv.iot.rak.irrigationSystem.controller.motor.MotorController;
import ua.lviv.iot.rak.irrigationSystem.controller.nozzle.NozzleController;
import ua.lviv.iot.rak.irrigationSystem.controller.password.PasswordController;
import ua.lviv.iot.rak.irrigationSystem.controller.pump.PumpController;
import ua.lviv.iot.rak.irrigationSystem.controller.sensor.SensorController;
import ua.lviv.iot.rak.irrigationSystem.controller.statisticOfSensor.StatisticOfSensorController;
import ua.lviv.iot.rak.irrigationSystem.controller.user.UserController;
import ua.lviv.iot.rak.irrigationSystem.model.*;

@RestController
public class Routes {


    private Session session;

    /**
     *
     * Show data
     */

    @RequestMapping("/")
    public String irrigationSystem(){
        return "irrigation_system";
    }

    @RequestMapping("/area")
    public JSONArray areaTable(){
        AreaController controller = new AreaController(this.session);
        return controller.read();
    }

    @RequestMapping("/irrigation_system")
    public JSONArray irrigationSystemTable(){
        IrrigationSystemController controller = new IrrigationSystemController(this.session);
        return controller.read();
    }

    @RequestMapping("/motor")
    public JSONArray motorTable(){
        MotorController controller = new MotorController(this.session);
        return controller.read();
    }

    @RequestMapping("/nozzle")
    public JSONArray nozzleTable(){
        NozzleController controller = new NozzleController(this.session);
        return controller.read();
    }

    @RequestMapping("/password")
    public JSONArray passwordTable(){
        PasswordController controller = new PasswordController(this.session);
        return controller.read();
    }

    @RequestMapping("/pump")
    public JSONArray pumpTable(){
        PumpController controller = new PumpController(this.session);
        return controller.read();
    }

    @RequestMapping("/sensor")
    public JSONArray sensorTable(){
        SensorController controller = new SensorController(this.session);
        return controller.read();
    }

    @RequestMapping("/statistic_of_sensor")
    public JSONArray statisticOfSensorTable(){
        StatisticOfSensorController controller = new StatisticOfSensorController(this.session);
        return controller.read();
    }

    @RequestMapping("/user")
    public JSONArray userTable(){
        UserController controller = new UserController(this.session);
        return controller.read();
    }

    /**
     *
     * Del data
     */
    @DeleteMapping(path= "/area", consumes = "application/json", produces = "application/json")
    public void deleteArea(@RequestBody Area body) throws Exception {
        AreaController controller = new AreaController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/irrigation_system", consumes = "application/json", produces = "application/json")
    public void deleteIrrigationSystem(@RequestBody IrrigationSystem body) throws Exception {
        IrrigationSystemController controller = new IrrigationSystemController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/motor", consumes = "application/json", produces = "application/json")
    public void deleteMotor(@RequestBody Motor body) throws Exception {
        MotorController controller = new MotorController(session);
        controller.delete(body.getPumpId());
    }

    @DeleteMapping(path= "/nozzle", consumes = "application/json", produces = "application/json")
    public void deleteNozzle(@RequestBody Nozzle body) throws Exception {
        NozzleController controller = new NozzleController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/password", consumes = "application/json", produces = "application/json")
    public void deletePassword(@RequestBody Password body) throws Exception {
        PasswordController controller = new PasswordController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/pump", consumes = "application/json", produces = "application/json")
    public void deletePump(@RequestBody Pump body) throws Exception {
        PumpController controller = new PumpController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/sensor", consumes = "application/json", produces = "application/json")
    public void deleteSensor(@RequestBody Sensor body) throws Exception {
        SensorController controller = new SensorController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/statistic_of_sensor", consumes = "application/json", produces = "application/json")
    public void deleteStatisticOfSensor(@RequestBody StatisticOfSensor body) throws Exception {
        StatisticOfSensorController controller = new StatisticOfSensorController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/user", consumes = "application/json", produces = "application/json")
    public void deleteUser(@RequestBody User body) throws Exception {
        UserController controller = new UserController(session);
        controller.delete(body.getId());
    }

    /**
     *
     * Create data
     */
    @PostMapping(path= "/area", consumes = "application/json", produces = "application/json")
    public void addArea(@RequestBody Area body) throws Exception
    {
        System.out.println(body);
        AreaController controller = new AreaController(session);
        controller.create(body);
    }

    @PostMapping(path= "/irrigation_system", consumes = "application/json", produces = "application/json")
    public void addIrrigationSystem(@RequestBody IrrigationSystem body) throws Exception {
        IrrigationSystemController controller = new IrrigationSystemController(session);
        controller.create(body);
    }

    @PostMapping(path= "/motor", consumes = "application/json", produces = "application/json")
    public void addMotor(@RequestBody Motor body) throws Exception {
        MotorController controller = new MotorController(session);
        controller.create(body);
    }

    @PostMapping(path= "/nozzle", consumes = "application/json", produces = "application/json")
    public void addNozzle(@RequestBody Nozzle body) throws Exception {
        NozzleController controller = new NozzleController(session);
        controller.create(body);
    }

    @PostMapping(path= "/password", consumes = "application/json", produces = "application/json")
    public void addPassword(@RequestBody Password body) throws Exception {
        PasswordController controller = new PasswordController(session);
        controller.create(body);
    }

    @PostMapping(path= "/pump", consumes = "application/json", produces = "application/json")
    public void addPump(@RequestBody Pump body) throws Exception {
        PumpController controller = new PumpController(session);
        controller.create(body);
    }

    @PostMapping(path= "/sensor", consumes = "application/json", produces = "application/json")
    public void addSensor(@RequestBody Sensor body) throws Exception {
        SensorController controller = new SensorController(session);
        controller.create(body);
    }

    @PostMapping(path= "/statistic_of_sensor", consumes = "application/json", produces = "application/json")
    public void addStatisticOfSensor(@RequestBody StatisticOfSensor body) throws Exception {
        StatisticOfSensorController controller = new StatisticOfSensorController(session);
        controller.create(body);
    }

    @PostMapping(path= "/user", consumes = "application/json", produces = "application/json")
    public void addUser(@RequestBody User body) throws Exception {
        UserController controller = new UserController(session);
        controller.create(body);
    }

    /**
     *
     * Update data
     */
    @PostMapping(path= "/area/update", consumes = "application/json", produces = "application/json")
    public void updateArea(@RequestBody Area body) throws Exception
    {
        System.out.println(body);
        AreaController controller = new AreaController(session);
        controller.create(body);
    }

    @PostMapping(path= "/irrigation_system/update", consumes = "application/json", produces = "application/json")
    public void updateIrrigationSystem(@RequestBody IrrigationSystem body) throws Exception {
        IrrigationSystemController controller = new IrrigationSystemController(session);
        controller.update(body);
    }

    @PostMapping(path= "/motor/update", consumes = "application/json", produces = "application/json")
    public void updateMotor(@RequestBody Motor body) throws Exception {
        MotorController controller = new MotorController(session);
        controller.update(body);
    }

    @PostMapping(path= "/nozzle/update", consumes = "application/json", produces = "application/json")
    public void updateNozzle(@RequestBody Nozzle body) throws Exception {
        NozzleController controller = new NozzleController(session);
        controller.update(body);
    }

    @PostMapping(path= "/password/update", consumes = "application/json", produces = "application/json")
    public void updatePassword(@RequestBody Password body) throws Exception {
        PasswordController controller = new PasswordController(session);
        controller.update(body);
    }

    @PostMapping(path= "/pump/update", consumes = "application/json", produces = "application/json")
    public void updatePump(@RequestBody Pump body) throws Exception {
        PumpController controller = new PumpController(session);
        controller.update(body);
    }

    @PostMapping(path= "/sensor/update", consumes = "application/json", produces = "application/json")
    public void updateSensor(@RequestBody Sensor body) throws Exception {
        SensorController controller = new SensorController(session);
        controller.update(body);
    }

    @PostMapping(path= "/statistic_of_sensor/update", consumes = "application/json", produces = "application/json")
    public void updateStatisticOfSensor(@RequestBody StatisticOfSensor body) throws Exception {
        StatisticOfSensorController controller = new StatisticOfSensorController(session);
        controller.update(body);
    }

    @PostMapping(path= "/user/update", consumes = "application/json", produces = "application/json")
    public void updateUser(@RequestBody User body) throws Exception {
        UserController controller = new UserController(session);
        controller.update(body);
    }
}
