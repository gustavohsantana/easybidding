package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/login")
    @ResponseBody
    public ModelAndView login(@RequestParam(value="name", defaultValue="World") String name) {
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        modelAndView.addObject("name",name);
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView cadastro(@RequestParam(value="name", defaultValue="World") String name) {
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        modelAndView.addObject("name",name);
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/resultado", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView resultado(@RequestParam(value="name", defaultValue="World") String name) {
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("resultado.html");
        modelAndView.addObject("name",name);
        
        return modelAndView;
    }
}
