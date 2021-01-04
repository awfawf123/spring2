package co.company.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"co.company.test"})
public class IOCConfiguration {
	
//	@Bean(initMethod = "", destroyMethod = "")
//	@Scope("prototype")//singletone,request,session
//	public TV tv() {
//		return new TV();
//	}
//	
	
}
