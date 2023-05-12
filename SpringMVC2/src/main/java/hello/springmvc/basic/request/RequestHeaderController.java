package hello.springmvc.basic.request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request, HttpServletResponse response, HttpMethod httpMethod, Locale locale,
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value = "myCookie", required = false) String cookie) {

        log.info("request={}", request);//request=org.apache.catalina.connector.RequestFacade@37b7748
        log.info("response={}", response);//response=org.apache.catalina.connector.ResponseFacade@e954832
        log.info("httpMethod={}", httpMethod);//httpMethod=GET
        log.info("locale={}", locale);//locale=ko_KR (가장 우선순위가 높은 언어)
        log.info("headerMap={}", headerMap);//headerMap={content-type=[application/json], user-agent=[Postman/7.32.2]...(모든헤더정보)
        log.info("header host={}", host);//header host=localhost:8080 (필수헤더)
        log.info("myCookie={}", cookie);//myCookie=null
        return "ok";
    }
}