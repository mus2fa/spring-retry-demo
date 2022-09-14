package org.mustafa.springretrydemo.service;

import org.mustafa.springretrydemo.exception.MyException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DbService {

    @Retryable(value = MyException.class, backoff = @Backoff(delay = 2000))
    public String saveToDb(Long number){
        log.info("In Retryable method");
        try {
            Long l = number/0;
            return l.toString();
        } catch (RuntimeException e) {
           throw new MyException(e.getMessage());
        }
        
    }

    @Recover
    public String handleRecover(MyException ex){
        Object o = ex;
        log.info(o.getClass().getName());
        log.error("In Recover method");
        log.error("Error:: "+ex.getLocalizedMessage());
        return ex.getMessage();
    }
}
