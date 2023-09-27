package it.jdk.demoapigatewayservice.filter;

import com.netflix.discovery.converters.Auto;
import io.jsonwebtoken.Jwt;
import it.jdk.demoapigatewayservice.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class AuthenticationFilter extends AbstractGatewayFilterFactory <AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator routeValidator;

    public AuthenticationFilter(){
        super(Config.class);
    }

    @Autowired
    private JwtUtil jwtUtil;

   // @Autowired
    //private RestTemplate restTemplate;

    @Override
    public GatewayFilter apply(Config config) {
        log.info("INSIDE APPLY ");
        return (((exchange, chain) -> {

            if(routeValidator.isSecured.test(exchange.getRequest())){
                //header contains token or not
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("missing authorization header");
                }
                String authheaders=exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if(authheaders!=null && authheaders.startsWith("Bearer ")){
                    authheaders=authheaders.substring(7);
                }
                try{
                    //Rest call to auth service
                    jwtUtil.validateToken(authheaders);
                    //restTemplate.getForObject("http://auth-service//validate?token"+authheaders,String.class);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return chain.filter(exchange);
        }));
    }

    public static class Config{

    }

}
