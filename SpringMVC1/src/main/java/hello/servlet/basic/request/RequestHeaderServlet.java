package hello.servlet.basic.request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//http://localhost:8080/request-header?username=hello

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);
        response.getWriter().write("ok");
    }

    //start line 정보 (HTTP 메소드, URL, 쿼리스트링, 스키마, 프로토콜)
    private void printStartLine(HttpServletRequest request) {
        System.out.println("request.getMethod() = " + request.getMethod()); //GET
        System.out.println("request.getProtocol() = " + request.getProtocol()); //HTTP / 1.1
        System.out.println("request.getScheme() = " + request.getScheme()); //http
        System.out.println("request.getRequestURL() = " + request.getRequestURL());//http://localhost:8080/request-header
        System.out.println("request.getRequestURI() = " + request.getRequestURI());//request-header
        System.out.println("request.getQueryString() = " + request.getQueryString());//username=hi
        System.out.println("request.isSecure() = " + request.isSecure()); //https 사용 유무(false)
        System.out.println();
    }

    //Header 모든 정보 조회
    private void printHeaders(HttpServletRequest request) {
        /*
         Enumeration<String> headerNames = request.getHeaderNames(); //http 요청 메소드에 있는 모든 헤더 정보 출력
         while (headerNames.hasMoreElements()) { 다음요소가 있으면
         String headerName = headerNames.nextElement(); 값을 꺼내서 출력
         System.out.println(headerName + ": " + request.getHeader(headerName));//아래와 같이 간단하게 작성 가능
         }
        */
        request.getHeaderNames().asIterator().forEachRemaining(headerName -> System.out.println(headerName + ": " + request.getHeader(headerName)));
        System.out.println();
    }

    //Header 편리한 조회
    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " + request.getServerName()); //Host 헤더(localhost)
        System.out.println("request.getServerPort() = " + request.getServerPort()); //Host 헤더(8080)
        System.out.println();
        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = " + locale));
        //locale = ko, en_US, en, ko_KR 웹 브라우저에서 원하는 언어의 순서 설정 가능
        System.out.println("request.getLocale() = " + request.getLocale());//request.getLocale() = ko : 가장 위에 있는 것 출력
        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {//쿠키 있으면
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());//원하는 쿠키값 출력
            }
        }
        System.out.println();
        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType());//null(GET방식은 바디에 내용 없음)
        System.out.println("request.getContentLength() = " + request.getContentLength());//-1
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());//utf-8
        System.out.println();
    }

    //기타 정보
    private void printEtc(HttpServletRequest request) {
        System.out.println("[Remote 정보]");//요청이 온것에 대한 정보
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost()); // 0:0:0:0:0:0:0:1
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr()); // 0:0:0:0:0:0:0:1
        System.out.println("request.getRemotePort() = " + request.getRemotePort()); // 51365
        System.out.println();
        System.out.println("[Local 정보]");//나의 서버에 대한 정보
        System.out.println("request.getLocalName() = " + request.getLocalName()); // 0:0:0:0:0:0:0:1
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr()); // 0:0:0:0:0:0:0:1
        System.out.println("request.getLocalPort() = " + request.getLocalPort()); // 8080
        System.out.println();
    }


}