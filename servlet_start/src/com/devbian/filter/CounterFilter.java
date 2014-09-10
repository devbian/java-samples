package com.devbian.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by phnix on 2014/9/9.
 */
public class CounterFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("in filter!!!******bull shit.");
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
