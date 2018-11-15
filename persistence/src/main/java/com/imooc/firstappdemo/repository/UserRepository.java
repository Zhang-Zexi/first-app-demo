package com.imooc.firstappdemo.repository;

import com.imooc.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link Repository}
 */
@Repository
public class UserRepository {

    /**
     * 采用内存型存储方式 -> Map
     */
    private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();

    // id增长生成器
    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用户对象，如果成功
     * @param user
     * @return 如果保存成功过，返回<code>true</code>,否则返回<code>false</code>
     */
    public boolean save(User user){
//        boolean success = false;

        Integer id = idGenerator.incrementAndGet();
        //设置id
        user.setId(id);
        return repository.put(id, user) == null;
    }

    public Collection<User> findAll() {
        return repository.values();
    }
}
