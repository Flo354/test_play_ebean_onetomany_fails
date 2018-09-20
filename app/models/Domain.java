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
public final class Domain extends Model {

    @Embeddable
    public static class Key implements Serializable {

        private UUID websiteId;

        @Constraints.MinLength(3)
        @Constraints.MaxLength(255)
        private String domain;

        protected Key() {}

        public Key(UUID websiteId, String domain) {
            this.websiteId = websiteId;
            this.domain = domain;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (!websiteId.equals(key.websiteId)) return false;
            return domain.equals(key.domain);
        }

        @Override
        public int hashCode() {
            int result = websiteId.hashCode();
            result = 31 * result + domain.hashCode();
            return result;
        }
    }

    @EmbeddedId
    private Key key;

    @NotNull
    @MapsId("websiteId")
    @JoinColumn(name = "website_id", insertable = false, updatable = false)
    @ManyToOne
    private BaseWebsite website;

    public Domain(BaseWebsite website, String domain) {
        setKey(website, domain);
    }

    public void setKey(BaseWebsite website, String domain) {
        this.key = new Key(website.getId(), domain);
        this.website = website;
    }

    public BaseWebsite getWebsite() {
        return website;
    }

    public void setWebsite(BaseWebsite website) {
        this.website = website;
        this.key.websiteId = website.getId();
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

        Domain domain = (Domain) o;

        return key.equals(domain.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    public static final Finder<Key, Domain> find = new Finder<>(Domain.class);
}
