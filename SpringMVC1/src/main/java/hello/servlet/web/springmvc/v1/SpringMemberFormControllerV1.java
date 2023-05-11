package hello.servlet.web.springmvc.v1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//스프링 빈으로 등록, 핸들러 매핑에서 핸들러 정보로 인식하며 꺼낼 수 있는 대상이 됨
public class SpringMemberFormControllerV1 {
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}