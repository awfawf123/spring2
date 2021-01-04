package co.company.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component 
public class TV {
	@Autowired 
	@Qualifier("apple")
	//@Resource(name="apple") ////@Autowired + @Qualifier("apple")
	Speaker speaker;
	
	public void voluemup() {
		speaker.volumeup();
	}
	public TV() {
		System.out.println("TV생성됨");
	}
	public void init() {
		System.out.println("init 생성됨");
	}
	public void destroy() {
		System.out.println("destory 소멸됨");
	}
}
