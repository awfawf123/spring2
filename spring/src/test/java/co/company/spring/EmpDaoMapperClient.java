package co.company.spring;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.company.spring.config.DBConfiguration;
import co.company.spring.config.MybatisConfiguration;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class,MybatisConfiguration.class } )
public class EmpDaoMapperClient {
	
	@Autowired EmpMapper empDAO;
	
	//@Test
	public void InsertTest() {
		Emp emp = new Emp();
		emp.setFirstName("test2");
		emp.setLastName("test2");
		emp.setJobId("IT_PROG");
		emp.setEmail("abcde2@naver.com");
		emp.setHireDate(new Date(System.currentTimeMillis()));
		empDAO.insertEmp(emp);
		System.out.println(emp.getEmployeeId());
	}
	
	//@Test
	public void InsertProcTest() {
		Emp emp = new Emp();
		emp.setLastName("test3");
		emp.setJobId("IT_PROG");
		emp.setEmail("abcde5@naver.com");
		empDAO.insertEmpProc(emp);
		System.out.println(emp.getEmployeeId()+":"+ emp.getMsg());
	}
	//@Test
	public void CountTest() {
		EmpSearch emp = new EmpSearch();
		int count = empDAO.getCount(emp);
		System.out.println(count);
	}
	@Test
	public void getStatDept() {
		List<Map<String,Object>> list = empDAO.getStatDept();
		System.out.println(list.get(0));
	}
	
	//@Test
	public void deleteMultiTest() {
		EmpSearch emp = new EmpSearch();
		emp.setList(new String[] {"1000","1001"});
		empDAO.deleteMultiEmp(emp);
	}
	
	//@Test
	public void updateTest() {
		Emp emp = new Emp();
		emp.setEmployeeId("102");
		System.out.println(empDAO.getEmp(emp));
		
		emp.setFirstName("hong");
		empDAO.updateEmp(emp);
		
		System.out.println(empDAO.getEmp(emp));
	}
	
	//@Test
	public void empdaotest() {
		EmpSearch empvo = new EmpSearch();
		//empvo.setFirstName("pat");
		//empvo.setDepartmentId("20");
		//empvo.setMinSalary(5000);
		//empvo.setMaxSalary(10000);
		
		List<Emp> list = empDAO.getEmpList(empvo);
		for(Emp emp : list) {
			System.out.println(emp.getEmployeeId()+":"+emp.getFirstName()+":"+emp.getDepartmentId()+":"+emp.getJobId()+":"+emp.getSalary());
		}
	}

}
