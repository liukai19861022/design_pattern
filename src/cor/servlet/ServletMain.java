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

        final FilterChain fc = new FilterChain();

    }
}

interface Filter {

    boolean doFilter(Request request, Response response);
}

class Request {
    String str;
}

class Response {
    String str;
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response) {


        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response) {

        return false;
    }
}

class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter f) {

        filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response) {

        return true;
    }
}