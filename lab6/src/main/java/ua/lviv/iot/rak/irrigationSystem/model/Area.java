package ua.lviv.iot.rak.irrigationSystem.model;

import javax.persistence.*;

@Entity
public class Area {
    private Integer id;
    private String location;
    private int irrigationSystemId;

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
    @Column(name = "location", nullable = false, length = 45)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "irrigation_system_id")
    public int getIrrigationSystemId() {
        return irrigationSystemId;
    }

    public void setIrrigationSystemId(int irrigationSystemId) {
        this.irrigationSystemId = irrigationSystemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Area area = (Area) o;

        if (id != area.id) return false;
        if (irrigationSystemId != area.irrigationSystemId) return false;
        if (location != null ? !location.equals(area.location) : area.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + irrigationSystemId;
        return result;
    }
}
