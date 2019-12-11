package ua.lviv.iot.rak.irrigationSystem.model;

import javax.persistence.*;

@Entity
@Table(name = "statistic_of_sensor", schema = "irrigation_system", catalog = "")
public class StatisticOfSensor {
    private Integer id;
    private String time;
    private String temperature;
    private String lighting;
    private String humidity;
    private int sensorId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "temperature", nullable = false, length = 45)
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "lighting", nullable = false, length = 45)
    public String getLighting() {
        return lighting;
    }

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    @Basic
    @Column(name = "humidity", nullable = false, length = 45)
    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @Basic
    @Column(name = "sensor_id")
    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatisticOfSensor that = (StatisticOfSensor) o;

        if (id != that.id) return false;
        if (sensorId != that.sensorId) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (temperature != null ? !temperature.equals(that.temperature) : that.temperature != null) return false;
        if (lighting != null ? !lighting.equals(that.lighting) : that.lighting != null) return false;
        if (humidity != null ? !humidity.equals(that.humidity) : that.humidity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        result = 31 * result + (lighting != null ? lighting.hashCode() : 0);
        result = 31 * result + (humidity != null ? humidity.hashCode() : 0);
        result = 31 * result + sensorId;
        return result;
    }
}
