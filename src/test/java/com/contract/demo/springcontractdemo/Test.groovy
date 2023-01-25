package com.contract.demo.springcontractdemo

import static org.springframework.cloud.contract.spec.Contract.make

[
    make {
        request {
            name("test")
            method 'GET'
            urlPath('/test')
        }
        response {
            status OK()
            body( 'tes': "\"escaped-body\"")
            headers {
                contentType('application/json')
                header('Escaped-Header',  '\"escaped-header\"')
                header(contentDisposition(), 'attachment; filename="test.pdf"')
            }
        }
    }
]