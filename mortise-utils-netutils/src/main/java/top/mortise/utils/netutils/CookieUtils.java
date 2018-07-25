package top.mortise.utils.netutils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eric.Zhang on 2017/3/13.
 */
public class CookieUtils {
    /**
     * 根据名字获取cookie
     * @param request
     * @param name cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie)cookieMap.get(name);
            return cookie;
        }else{
            return null;
        }
    }
    /**
     * 设置cookie
     * @param response
     * @param name  cookie名字
     * @param value cookie值
     * @param maxAge cookie生命周期  以秒为单位 默认传0
     * @param  path cookie的路径
     * @param  domain cookie的域 默认传空
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge,String domain,String path ){
        Cookie cookie = new Cookie(name,value);
        if(path!=""){
            cookie.setPath(path);
        }else{
            cookie.setPath("/");
        }
        if(maxAge>0)  cookie.setMaxAge(maxAge);
        if(domain!=null&&domain!="") cookie.setDomain(domain);
        response.addCookie(cookie);
    }


    /**
     * 将cookie封装到Map里面
     * @param request
     * @return
     */
    private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
    /**
     * 设置cookie
     * @param request
     * @param name  cookie名字
     */
    public static void delCookie(HttpServletRequest request, String name ){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie)cookieMap.get(name);
            cookie.setMaxAge(0);
        }
    }
}