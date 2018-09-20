package models;

import io.ebean.Finder;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * @author Florian Pradines <florian.pradines@gmail.com>
 */
@Entity
public final class Websitea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Domaina> domains;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Domaina> getDomains() {
        return domains;
    }

    public void setDomains(List<Domaina> domains) {
        this.domains = domains;
    }

    public static Websitea getById(UUID id) {
        return find.byId(id);
    }

    public static final Finder<UUID, Websitea> find = new Finder<>(Websitea.class);
}
