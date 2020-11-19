package gr.company.example.controller;

import gr.company.example.model.Employee;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class AppController {

    @GetMapping("/hello")
    public String home(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        model.addAttribute("greeting", "hello");
        return "index.html";
    }

    @GetMapping("/")
    public String indexPage(){
        return "index";
      }

//    @GetMapping("/")
//    public String indexPage2(){
//        return "index2";
//    }


    @GetMapping("/george")
    @ResponseBody
    public Employee greetingPage(HttpServletRequest request){

        if (request.isUserInRole("AUTHOR")){
            Employee employee = new Employee();
            employee.setName("Author");


            return employee;
        }
        else {
            Employee employee = new Employee();
            employee.setName("User");


            return employee;
        }


//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null && auth.getAuthorities().stream()
//                .anyMatch(a -> a.getAuthority().equals("AUTHOR")))
    }
}
