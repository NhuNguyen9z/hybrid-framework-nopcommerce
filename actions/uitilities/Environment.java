package uitilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

// dùng biến ${env} để lấy ra environment dynamic
@Sources({ "file:environmentConfig/${env}.properties" })
public interface Environment extends Config {
	@Key("App.Url")
	String appUrl();

	@Key("App.User")
	String appUser();

	@Key("App.Pass")
	String appPass();

	@Key("DB.Host")
	String dbHostname();

	@Key("DB.User")
	String dbUsername();

	@Key("DB.Pass")
	String dbPassword();

}
