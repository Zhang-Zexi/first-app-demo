package com.imooc.firstappdemo.config;

import com.imooc.firstappdemo.domain.User;
import com.imooc.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * 路由器函数配置
 */
@Configurable
public class RouterFunctionConfiguration {

    /**
     * Servlet 请求接口：Servlet 或者 HttpServletRequest
     * 响应接口：ServletReponse 或者 HttpServletResponse
     * Spring5.0 重新定义了服务接口和相应接口
     * 请求接口：ServerRequest
     * 相应接口：ServerResponse
     * 既可以支持Servlet规范，也可以支持自定义，比如Netty （Web Server）
     * 以本利
     * 定义GET请求，并返回所有的用户对象URI：/perosn/find/all
     * Flux 是 0 - N个对象集合
     * Mono 是 0 - 1个对象集合
     * Reactive 中的 Flux 或者 Mono 它是异步处理（非阻塞）
     * 集合对象基本上是同步处理（阻塞）
     * Flux 或者 Mono都是 Publisher
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {



        return RouterFunctions.route(RequestPredicates.GET("/perosn/find/all"),
                request -> {
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux, User.class);
                });
    }
}
