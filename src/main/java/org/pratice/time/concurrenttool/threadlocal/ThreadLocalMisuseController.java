package org.pratice.time.concurrenttool.threadlocal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * ThreadLocal滥用
 *
 * @date 2020/11/22 12:24
 */
@RequestMapping("threadlocal")
public class ThreadLocalMisuseController {

    private static final ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);

    @GetMapping("wrong")
    public Map wrong(@RequestParam("userId") Integer userId) {
        String before = Thread.currentThread().getName() + ":"  + currentUser.get();
        currentUser.set(userId);
        String after = Thread.currentThread().getName() + ":"  + currentUser.get();
        Map result = new HashMap();
        result.put("before",before);
        result.put("after",after);
        return result;
    }

    @GetMapping("right")
    public Map right(@RequestParam("userId")Integer userId) {
        String before = Thread.currentThread().getName() + ":"  + currentUser.get();
        currentUser.set(userId);
        try {
            String after = Thread.currentThread().getName() + ":" + currentUser.get();
            Map result = new HashMap();
            result.put("before", before);
            result.put("after", after);
            return result;
        } finally {
            currentUser.remove();
        }
    }




}
