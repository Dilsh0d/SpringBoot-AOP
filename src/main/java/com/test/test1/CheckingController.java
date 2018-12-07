package com.test.test1;

import com.test.test1.aspect.BeforeVerificationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ForkJoinPool;

@RestController
@RequestMapping("/checking")
public class CheckingController {

    @GetMapping("/req")
    @BeforeVerificationRequest
    public DeferredResult<ResponseEntity> checking() {
        DeferredResult<ResponseEntity> deferredResult = new DeferredResult<>();

        ForkJoinPool.commonPool().submit(() -> {
            deferredResult.setResult(ResponseEntity.ok().build());
        });

        return deferredResult;
    }

}
