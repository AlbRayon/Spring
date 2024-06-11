package rayon.inombrable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
	public ModelAndView raiz() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("raiz");
		System.out.println("Se consulto la pagina: " +  mv.getViewName());
		return mv;

	}
	@RequestMapping(value = "/chiqui", method = RequestMethod.GET, produces = "text/html")
	public ModelAndView raiztest() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("chiqui");
		System.out.println("Se consulto la pagina: " +  mv.getViewName());
		return mv;

	}
	
	@RequestMapping(value = "/intragen", method = RequestMethod.GET, produces = "text/html")
	public ModelAndView intragen() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("intragen");
		System.out.println("Se consulto la pagina: " +  mv.getViewName());
		return mv;

	}
	
	@RequestMapping(value = "/ingreso", method = RequestMethod.GET, produces = "text/html")
	public ModelAndView ingreso() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("ingreso");
		System.out.println("Se consulto la pagina: " + mv.getViewName());
		return mv;

	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces = "text/html")
	public ModelAndView usuarios() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuarios");
		System.out.println("Se consulto la pagina: " +  mv.getViewName());
		return mv;

	}
	
	
	
	
}
