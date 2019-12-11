package ua.lviv.iot.rak.irrigationSystem.model;

import javax.persistence.*;

@Entity
public class Motor {
    private Integer id;
    private String  status;
    private String time;
    private int pumpId;

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
    @Column(name = "time", nullable = false)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "pump_id")
    public int getPumpId() {
        return pumpId;
    }

    public void setPumpId(int pumpId) {
        this.pumpId = pumpId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Motor motor = (Motor) o;

        if (id != motor.id) return false;
        if (pumpId != motor.pumpId) return false;
        if (status != null ? !status.equals(motor.status) : motor.status != null) return false;
        if (time != null ? !time.equals(motor.time) : motor.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + pumpId;
        return result;
    }
}
