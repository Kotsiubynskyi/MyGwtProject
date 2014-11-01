package ua.company.gwt.server.mvc;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView welcome() {
        boolean isAuthenticated = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        System.out.println("-12--1-2-31=2-3=123-=12-3=12-3=12-312=3213");
//        return new ModelAndView("/loginPage");
        if (isAuthenticated) {
            return new ModelAndView("redirect:/gwt.html");
        } else {
            return new ModelAndView("/loginPage");
        }
    }
}
