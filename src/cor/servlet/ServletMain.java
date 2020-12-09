package cor.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServletMain {

    public static void main(String[] args) {

        Request request = new Request();
        request.str = "request";
        Response response = new Response();
        response.str = "response";

        FilterChain fc = FilterChain.getInstance();
        FilterChain fc2 = FilterChain.getInstance();

        fc.add(new HTMLFilter());
        fc.add(new SensitiveFilter());
        fc.add(fc2);
        fc.doFilter(request, response, fc);

        System.out.println(request.str);
        System.out.println(response.str);
    }
}

interface Filter {

    boolean doFilter(Request request, Response response, FilterChain fc);
}

class Request {
    String str;
}

class Response {
    String str;
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain fc) {

        String replace = request.str.replace("r", "R");
        System.out.println("html request 1 r-》R");
        request.str = replace;

        fc.doFilter(request, response, fc);
        String s = response.str.replaceAll("s", "S");
        System.out.println("html response 1 s-》S");

        response.str = s;

        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain fc) {

        String replace = request.str.replace("e", "E");
        System.out.println("sensitive request 2 e-》E");

        request.str = replace;
        fc.doFilter(request, response, fc);
        String s = response.str.replaceAll("o", "O");
        System.out.println("sensitive response 2 o-》O");

        response.str = s;

        return false;
    }
}

class FilterChain implements Filter{

    private FilterChain() {}

    private static FilterChain INSTANCE = new FilterChain();

    public static FilterChain getInstance() {
        return INSTANCE;
    }

    List<Filter> filters = new ArrayList<>();
    private Iterator<Filter> iterator;

    public FilterChain add(Filter f) {

        filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain fc) {

        if (iterator == null){
            iterator = filters.iterator();
        }

        if (iterator.hasNext()){
            Filter next = iterator.next();
            return next.doFilter(request, response, fc);

        }
        return true;
    }
}