package co.company.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.company.spring.config.DBConfiguration;
import co.company.spring.dao.EmpDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class } )
public class EmpDaoClient {
	
	@Autowired EmpDAO empDAO;
	@Test
	public void empdaotest() {
		//EmpDAO dao = new EmpDAO(); DAO에 @Component 생성시 필요없음	
		System.out.println(empDAO.getList());
	}

}
