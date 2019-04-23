package es.urjc.etsii.schoolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class SchoolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolistApplication.class, args);
	}
	
	@Bean
	public CacheManager cacheManager()
	{
		//LOG.info("Activando cache")
		return new ConcurrentMapCacheManager("SchoolistCache");
	}

}

