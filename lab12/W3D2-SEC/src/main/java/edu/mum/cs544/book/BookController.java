package edu.mum.cs544.book;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {

	@Resource
	private BookService s;
	
//	 @GetMapping("/")
//	 public String redirectRoot() {
//	 	return "redirect:/book";
//	 }
	
	@GetMapping("")
	public String getAll(Model model) {
		model.addAttribute("list", s.getAll());
		System.out.println(s.getAll());
		return "book/list";
	}
	
	@PostMapping("/add")
	public String add(@Valid Book en, BindingResult result) {
		System.out.println(result.hasErrors() + "------------");
		if(result.hasErrors()){
			return "book/detail";
		}
		else{
			s.add(en);
			return "redirect:/book";
		}
	}

	@GetMapping("/add")
	public String viewAdd(@ModelAttribute Book book, Model model) {
		model.addAttribute("msg", "Add");
		return "book/detail";
	}

	@GetMapping("/d/{id}")
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("book", s.get(id));
		model.addAttribute("msg", "Update");
		return "book/detail";
	}
	
	@PostMapping("/d/{id}")
	public String update(Book en, @PathVariable int id) {
		s.update(en); // car.id already set by binding
		return "redirect:/book";
	}
	
	@PostMapping("/delete")
	public String delete(int id) {
		s.delete(id);
		return "redirect:/book";
	}
}
