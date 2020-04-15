package com.planner.calc.service.prop.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;



@Configuration
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private final Auth auth = new Auth();    
    

    public static class Auth {
        private String tokenCheckPointUrl;
        private String tokenSecret;
        private List<String> allowedEndPoints;

		public List<String> getAllowedEndPoints() {
			return allowedEndPoints;
		}

		public void setAllowedEndPoints(List<String> allowedEndPoints) {
			this.allowedEndPoints = allowedEndPoints;
		}

		public String getTokenCheckPointUrl() {
			return tokenCheckPointUrl;
		}

		public void setTokenCheckPointUrl(String tokenCheckPointUrl) {
			this.tokenCheckPointUrl = tokenCheckPointUrl;
		}

		public String getTokenSecret() {
			return tokenSecret;
		}

		public void setTokenSecret(String tokenSecret) {
			this.tokenSecret = tokenSecret;
		}
		

		
      
    }
    public Auth getAuth() {
        return auth;
    }

}
