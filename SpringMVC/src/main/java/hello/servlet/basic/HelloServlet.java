package hello.servlet.basic;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "helloServlet", urlPatterns = "/hello")//서블릿 어노테이션(서블릿 이름, URL매핑)
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);//org.apache.catalina.connector.RequestFacade@3e83a8f9
        System.out.println("response = " + response);//org.apache.catalina.connector.ResponseFacade@30445159
        String username = request.getParameter("username");//쿼리파라미터로 값 전달
        System.out.println("username = " + username);
        response.setContentType("text/plain");//단순문자
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);//http 메시지 바디
    }
}
