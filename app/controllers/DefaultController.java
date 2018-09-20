package controllers;

import models.Website;
import models.Websitea;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.UUID;

/**
 * @author Florian Pradines <florian.pradines@gmail.com>
 */
public class DefaultController extends Controller {

    public Result fail() {
        Website website = (Website) Website.getById(UUID.fromString("3feff467-cce5-4914-a5e1-ba8e021ccf8e"));
        website.getDomains().forEach(domain -> Logger.debug(domain.getDomain()));
        return ok();
    }

    public Result success() {
        Websitea website = Websitea.getById(UUID.fromString("3feff467-cce5-4914-a5e1-ba8e021ccf8e"));
        website.getDomains().forEach(domain -> Logger.debug(domain.getDomain()));
        return ok();
    }
}
