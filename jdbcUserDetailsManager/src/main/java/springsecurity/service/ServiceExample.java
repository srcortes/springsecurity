package springsecurity.service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import lombok.Setter;
import lombok.ToString;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.security.concurrent.DelegatingSecurityContextCallable;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Setter
@ToString
public class ServiceExample {

  String value;

  ExecutorService e = Executors.newCachedThreadPool();



  @Async
  public Future<String> testing(String value) {
    SecurityContext context = SecurityContextHolder.getContext();

    return new AsyncResult<>(context.getAuthentication().getName().concat(value));
  }


  public String newTesting() throws Exception{
    Callable<String> task = () -> {
      SecurityContext context = SecurityContextHolder.getContext();
      return context.getAuthentication().getName();
    };
    ExecutorService e = Executors.newCachedThreadPool();
    try{
      DelegatingSecurityContextCallable<String> delegatingSecurityContextCallable
          = new DelegatingSecurityContextCallable<>(task);
      return "New testing: " + e.submit(delegatingSecurityContextCallable).get() + "!";
    }finally {
      e.shutdown();
    }
  }

  public String testingNew() throws ExecutionException, InterruptedException {
      Callable<Integer> task=()->{
        SecurityContext context=SecurityContextHolder.getContext();

        return context.getAuthentication().getName().length();
      };
      ExecutorService e=Executors.newCachedThreadPool();
      e = new DelegatingSecurityContextExecutorService(e);
      try {
        return "testingNew: " + e.submit(task).get() + "!";

      }finally{
        e.shutdown();
      }
  }





}
