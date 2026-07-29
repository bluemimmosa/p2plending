package com.niraj.p2plending.common.logging;


import jakarta.servlet.*;
import jakarta.servlet.http.*;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * Adds request correlation ID to every request.
 */
@Component
public class RequestIdFilter implements Filter {


    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {


        HttpServletRequest httpRequest =
                (HttpServletRequest) request;


        HttpServletResponse httpResponse =
                (HttpServletResponse) response;


        String requestId =
                httpRequest.getHeader(
                        LoggingConstants.REQUEST_ID_HEADER
                );


        if(requestId == null || requestId.isBlank()) {

            requestId =
                    RequestIdGenerator.generate();
        }


        MDC.put(
                LoggingConstants.REQUEST_ID_MDC,
                requestId
        );


        httpResponse.setHeader(
                LoggingConstants.REQUEST_ID_HEADER,
                requestId
        );


        try {

            chain.doFilter(
                    request,
                    response
            );

        }
        finally {

            MDC.clear();

        }

    }

}