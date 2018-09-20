package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Florian Pradines <florian.pradines@gmail.com>
 */
@Entity
@DiscriminatorValue("a")
public final class Website extends BaseWebsite {}
