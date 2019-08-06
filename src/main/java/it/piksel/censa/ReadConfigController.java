package it.piksel.censa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ReadConfigController {

	@Value("${mongodb.url}")
	private String mongodbUrl;

	@RequestMapping(value = "/mongoDbUrl", method = RequestMethod.GET)
	public String getMongodbUrll() {
		return mongodbUrl;
	}
}
