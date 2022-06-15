package com.example.javapythonstory.code.entity.vo.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookFileInfo {

    private Integer updateCode;

    private String filePath;

}
