package ua.lviv.iot.rak.irrigationSystem.model;

import javax.persistence.*;

@Entity
public class Pump {
    private Integer id;
    private String status;
    private Integer amountOfPumpedWater;
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
    @Column(name = "amount_of_pumped_water", nullable = false)
    public Integer getAmountOfPumpedWater() {
        return amountOfPumpedWater;
    }

    public void setAmountOfPumpedWater(Integer amountOfPumpedWater) {
        this.amountOfPumpedWater = amountOfPumpedWater;
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

        Pump pump = (Pump) o;

        if (id != pump.id) return false;
        if (amountOfPumpedWater != pump.amountOfPumpedWater) return false;
        if (areaId != pump.areaId) return false;
        if (status != null ? !status.equals(pump.status) : pump.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + amountOfPumpedWater;
        result = 31 * result + areaId;
        return result;
    }
}
