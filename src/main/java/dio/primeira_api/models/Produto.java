package dio.primeira_api.models;
import jakarta.persistence.*;

@Entity
public class Produto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true, nullable = false, insertable = false)
    @Id
    private Long id;

    @Column(length = 100,name = "name", updatable = false,nullable = false, unique = true)
    private String name;

    @Column(length = 255, name = "description")
    private String description;

    @Column(name = "unitcost", nullable = false)
    private Double unitcost;

    @Column(name = "status", nullable = false)
    private String status;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(Double unitcost) {
        this.unitcost = unitcost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\"=" + id +
                ", \"name\"=\"" + name + '"' +
                ", \"description\"=\"" + description + '"' +
                ", \"unitcost\"=" + unitcost +
                ", \"status\"=\"" + status + '"' +
                '}';
    }
}
