package com.example.javapythonstory.code.controller;

import com.example.javapythonstory.code.entity.dto.py.PythonCodeDto;
import com.example.javapythonstory.code.result.Result;
import com.example.javapythonstory.code.util.PythonRunUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/code")
public class CodeController {

    @PostMapping("/common/run")
    public Result runPythonCode(@RequestBody PythonCodeDto pythonCodeDto){
        Map<String,Object> message = new HashMap<>();
        String codeResult = PythonRunUtil.runPython(pythonCodeDto.getCode());
        message.put("codeResult", codeResult);
        return new Result().result200(message, "/common/run");
    }

}
