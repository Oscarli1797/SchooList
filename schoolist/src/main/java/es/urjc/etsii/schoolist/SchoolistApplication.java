package es.urjc.etsii.schoolist;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

@SpringBootApplication
@EnableHazelcastHttpSession
public class SchoolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolistApplication.class, args);
	}
	
	@Bean
	 public Config config() {
	 Config config = new Config();
	 /*
	 //creo que esto solo vale para localhost
	 JoinConfig joinConfig = config.getNetworkConfig().getJoin();
	 joinConfig.getMulticastConfig().setEnabled(false);
	 joinConfig.getTcpIpConfig().setEnabled(true).setMembers(Collections.singletonList("127.0.0.1"));
	 */
	 return config;
	 }

}

