package com.example.javapythonstory.code.controller;

import com.example.javapythonstory.code.entity.dto.py.PythonCodeDto;
import com.example.javapythonstory.code.result.WebResult;
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

    /**
     * <p>
     *     运行代码
     * </p>
     * @param pythonCodeDto 运行DTO
     * @return
     */
    @PostMapping("/common/run")
    public WebResult runPythonCode(@RequestBody PythonCodeDto pythonCodeDto){
        Map<String,Object> message = new HashMap<>();
        String codeResult = PythonRunUtil.runPython(pythonCodeDto.getCode());
        message.put("codeResult", codeResult);
        return new WebResult().result200(message, "/common/run");
    }

}
