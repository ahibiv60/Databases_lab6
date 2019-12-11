package ua.lviv.iot.rak.irrigationSystem.model;

import javax.persistence.*;

@Entity
public class Nozzle {
    private Integer id;
    private String status;
    private String location;
    private int maxWaterConsumption;
    private int areaId;

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
    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "location", nullable = false, length = 45)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "max_water_consumption", nullable = false)
    public int getMaxWaterConsumption() {
        return maxWaterConsumption;
    }

    public void setMaxWaterConsumption(int maxWaterConsumption) {
        this.maxWaterConsumption = maxWaterConsumption;
    }

    @Basic
    @Column(name = "area_id")
    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nozzle nozzle = (Nozzle) o;

        if (id != nozzle.id) return false;
        if (maxWaterConsumption != nozzle.maxWaterConsumption) return false;
        if (areaId != nozzle.areaId) return false;
        if (status != null ? !status.equals(nozzle.status) : nozzle.status != null) return false;
        if (location != null ? !location.equals(nozzle.location) : nozzle.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + maxWaterConsumption;
        result = 31 * result + areaId;
        return result;
    }
}
