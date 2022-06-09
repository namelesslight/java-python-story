package com.example.javapythonstory.code.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PythonRunUtil {

    public static String runPython(String code){
        try {
            File f = new File("process.py");
            f.createNewFile();
            FileOutputStream fos = new FileOutputStream(f);
            fos.write((code).getBytes(StandardCharsets.UTF_8));
            fos.flush();
            fos.close();
            String[] arguments = new String[]{"python3", "process.py"};
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = in.readLine()) != null){
                sb.append(line + "\r\n");
            }
            in.close();
            while ((line = error.readLine()) != null){
                sb.append(line + "\r\n");
            }
            error.close();
            int i = process.waitFor();
            sb.append("exit code " + i);
            f.delete();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传代码出错";
    }

}
