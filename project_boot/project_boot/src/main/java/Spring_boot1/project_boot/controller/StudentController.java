package Spring_boot1.project_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Spring_boot1.project_boot.dto.Student;
import Spring_boot1.project_boot.repository.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	StudentRepository repository;
 @GetMapping("/")
 public String load() {
	 return "main.html";
 }
 @GetMapping("/add")
 public String loadAdd() {
	 return "add.html";
 }
 @GetMapping("/fetch")
 public String loadFetch(Model model) {
	 List<Student> list=repository.findAll();
	 model.addAttribute("list", list);
	 return "fetch.html";
 }
 @PostMapping("/add")
 public String add(@ModelAttribute Student student,Model model) {
	repository.save(student);
	model.addAttribute("msg", "data added succesfully");
	return "main.html";
	
 }
 @GetMapping("/delete")
	public String delete(@RequestParam int id,Model model) {
	repository.deleteById(id);
	    model.addAttribute("mess", "Record Deleted Successfuly");
	    return loadFetch(model);
	   
	}
 @GetMapping("/edit")
	public String edit(@RequestParam int id,Model model) {
	Student student=repository.findById(id).get();
	
	    model.addAttribute("student", student);
	    return "edit.html";
	   
	}
 
 @PostMapping("/update")
 public String update(@ModelAttribute Student student,Model model) {
	 repository.save(student);
	 model.addAttribute("msg", "Update Successfully");
	 return loadFetch(model);
 }
 
 
}
