package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController//body에 문자 그대로 반환(controller는 뷰로 반환해야해)
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        //로그 레벨에 따라 설정
        log.trace("trace log={}", name);//로컬pc
        log.debug("debug log={}", name);//개발서버에서 디버그할때 사용
        log.info(" info log={}", name);//비즈니스 정보, 운영시스템에서 봐야하는 정보
        log.warn(" warn log={}", name);//경고
        log.error("error log={}", name);//위험

        //로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X
        log.debug("String concat log=" + name);
        return "ok";
    }
}