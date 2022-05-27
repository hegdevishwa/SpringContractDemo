package com.contract.demo.springcontractdemo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TestModel> get() {

        final HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.set("Escaped-Header", "\"escaped-header\"");
        return ResponseEntity.ok().headers(headers).body(new TestModel("\"escaped-body\""));
    }

    public static class TestModel {

        private final String test;

        public TestModel(final String test) {
            this.test = test;
        }

        public String getTest() {
            return test;
        }
    }
}
