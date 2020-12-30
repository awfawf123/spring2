package co.company.spring.dao;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
	
	public List<Emp> getEmpList(EmpSearch emp);
	public int getCount(EmpSearch emp);
	public int updateEmp(Emp emp);
	public Emp getEmp(Emp emp);
	public int insertEmp(Emp emp);
	public int deleteEmp(Emp emp);
	public int deleteMultiEmp(EmpSearch emp);
	public int insertEmpProc(Emp emp);
	public List<Map<String,Object>> getStatDept();
	public List<Jobs> jobSelect();
	public List<Departments> departmentSelect();
	

}
