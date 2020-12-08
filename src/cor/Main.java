package cor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Msg msg = new Msg();
        msg.setMsg("大家好:)<script> 欢迎访问 mashibing.com, 大家都是996");

        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter());
//          .add(new SensitiveFilter());

        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter()).add(new UrlFilter());

        fc.add(fc2);
        fc.doFilter(msg);

        System.out.println(msg.getMsg());
    }
}

class Msg {
    String name; //姓名
    String msg; //具体的信息

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                ", msg='" + msg + '\'' +
                '}';
    }
}

interface Filter {

    boolean doFilter(Msg m);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {

        String r = m.getMsg();
        r = r.replace("<", "[");
        r = r.replace(">", "]");
        m.setMsg(r);
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {

        String r = m.getMsg();
        r = r.replaceAll("996", "955");
        m.setMsg(r);
        return false;
    }
}

class FaceFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {

        String r = m.getMsg();
        r = r.replace(":)", "^v^");
        m.setMsg(r);
        return true;
    }
}

class UrlFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {

        String r = m.getMsg();
        r = r.replace("mashibing.com", "http://www.mashibing.com");
        m.setMsg(r);
        return true;
    }
}

class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter f) {

        filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Msg msg) {

        for (Iterator<Filter> iterator = filters.iterator(); iterator.hasNext();) {
            Filter next = iterator.next();
            if (!next.doFilter(msg)) return false;

        }

        return true;
    }
}