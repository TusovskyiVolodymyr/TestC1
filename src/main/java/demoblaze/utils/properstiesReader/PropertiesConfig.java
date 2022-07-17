package demoblaze.utils.properstiesReader;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources({"classpath:config.properties"})
public interface PropertiesConfig extends Config {

    PropertiesConfig CONFIG_PROPERTIES = ConfigFactory.create(PropertiesConfig.class, System.getenv(), System.getProperties());

    @Key("base.url")
    String baseUrl();

    @Key("element.timeout")
    int elementTimeout();

    @Key("page.timeout")
    int pageTimeout();

    @Key("browser.name")
    String browserName();
}
