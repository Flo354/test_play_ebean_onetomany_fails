package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * @author Florian Pradines <florian.pradines@gmail.com>
 */
@Entity
@Table(name="website")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class BaseWebsite extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Domain> domains;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Domain> getDomains() {
        return domains;
    }

    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }

    public static BaseWebsite getById(UUID id) {
        return find.byId(id);
    }

    public static final Finder<UUID, BaseWebsite> find = new Finder<>(BaseWebsite.class);
}
