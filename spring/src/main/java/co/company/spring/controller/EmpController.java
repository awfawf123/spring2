package co.company.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.company.spring.dao.Departments;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;
import co.company.spring.dao.Jobs;

@Controller
public class EmpController {
	@Autowired
	EmpMapper dao;
	
	@RequestMapping("/ajax/jobSelect")
	@ResponseBody
	public List<Jobs> jobSelect(){
		return dao.jobSelect();
	}
	@RequestMapping(value="/empSelect",
					method = RequestMethod.GET)
	public ModelAndView select(EmpSearch emp) {
		//조회
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",dao.getEmpList(emp));
		mav.setViewName("emp/Select");
		return mav;
	}
	
	@GetMapping("/empUpdateForm")
	public String updateForm(Model model, Emp emp) {
		model.addAttribute("emp",dao.getEmp(emp));
		//model.addAttribute("jobs",dao.jobSelect());
		//model.addAttribute("departments",dao.departmentSelect());
		return "emp/Insert"; //foward
		
	}
	@GetMapping("/empinsertForm")
	public String insertForm(Model model, Emp emp) {
		//model.addAttribute("jobs",dao.jobSelect());
		//model.addAttribute("departments",dao.departmentSelect());
		return "emp/Insert"; //foward
		
	}
	@ModelAttribute("jobs")
	public List<Jobs> jobs(){
		return dao.jobSelect();
	}
	@ModelAttribute("departments")
	public List<Departments> departments(){
		return dao.departmentSelect();
	}
	@PostMapping("/empInsert")
	public String insert(Model model, Emp emp, Errors errors) { //ModelAttribute = 속성값 변경  ex)${employee.?}
		new EmpValidator().validate(emp, errors);
		if(errors.hasErrors()) {
			return "emp/Insert";
		}
		if(emp.getEmployeeId() == null)
			dao.insertEmp(emp);
		else
			dao.updateEmp(emp);
		return "emp/insertOutPut";
		//return "redirect:/empSelect";
	}
//	@PostMapping("/empInsert")
//	public String insert(HttpServletRequest request,
//						@RequestParam(value="lastName",
//									required = false,
//									defaultValue="noname")
//									String lName,
//						@RequestParam(required = false)
//									int salary,
//									Emp emp) {
//		//파라미터
//		String firstName = request.getParameter("firstName");
//		System.out.println(lName + ":" + firstName + ":" + salary);
//		System.out.println("emp\n" + emp);
//		//등록처리
//		return "redirect:/empSelect";
//	}
	
	

}
