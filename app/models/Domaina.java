package models;

import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.NotNull;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Florian Pradines <florian.pradines@gmail.com>
 */
@Entity
public final class Domaina extends Model {

    @Embeddable
    public static class Key implements Serializable {

        private UUID websiteaId;

        @Constraints.MinLength(3)
        @Constraints.MaxLength(255)
        private String domain;

        protected Key() {}

        public Key(UUID websiteaId, String domain) {
            this.websiteaId = websiteaId;
            this.domain = domain;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (!websiteaId.equals(key.websiteaId)) return false;
            return domain.equals(key.domain);
        }

        @Override
        public int hashCode() {
            int result = websiteaId.hashCode();
            result = 31 * result + domain.hashCode();
            return result;
        }
    }

    @EmbeddedId
    private Key key;

    @NotNull
    @MapsId("websiteaId")
    @JoinColumn(name = "websitea_id", insertable = false, updatable = false)
    @ManyToOne
    private Websitea websitea;

    public Domaina(Websitea websitea, String domain) {
        setKey(websitea, domain);
    }

    public void setKey(Websitea websitea, String domain) {
        this.key = new Key(websitea.getId(), domain);
        this.websitea = websitea;
    }

    public Websitea getWebsitea() {
        return websitea;
    }

    public void setWebsitea(Websitea websitea) {
        this.websitea = websitea;
        this.key.websiteaId = websitea.getId();
    }

    public String getDomain() {
        return key.domain;
    }

    public void setDomain(String domain) {
        key.domain = domain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Domaina domain = (Domaina) o;

        return key.equals(domain.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    public static final Finder<Key, Domaina> find = new Finder<>(Domaina.class);
}
