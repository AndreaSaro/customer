package it.piksel.censa.configuration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Documentation {

	@Bean
    public Docket api() throws FileNotFoundException, IOException, XmlPullParserException {
		MavenXpp3Reader reader = new MavenXpp3Reader();
        Model pomModel = reader.read(new FileReader("pom.xml"));
		
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("it.piksel.censa.controller"))
          .paths(PathSelectors.any())
          .build().apiInfo(
        		  new ApiInfo(pomModel.getName(), pomModel.getDescription(), pomModel.getVersion(), null, new Contact("Censa", null, "censa@censa.it"), null, null));
        
	}

}