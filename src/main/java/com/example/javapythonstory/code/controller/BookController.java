package com.example.javapythonstory.code.controller;


import com.example.javapythonstory.code.entity.dto.book.AddBookDto;
import com.example.javapythonstory.code.entity.dto.book.CommitBookDto;
import com.example.javapythonstory.code.entity.dto.book.DeleteBookDto;
import com.example.javapythonstory.code.entity.dto.book.UpdateBookInfoDto;
import com.example.javapythonstory.code.entity.po.Book;
import com.example.javapythonstory.code.entity.vo.book.UpdateBookFileInfo;
import com.example.javapythonstory.code.result.WebResult;
import com.example.javapythonstory.code.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author
 * @since 2022-06-15
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * <p>
     *     在对应模块添加未编辑书籍
     * </p>
     * @param addBookDto 添加未书籍视频DTO
     * @return
     */
    @PostMapping("/super/addBook")
    public WebResult addBook(@RequestBody AddBookDto addBookDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = bookService.addBook(addBookDto.getModelId());
        message.put("addCode", addCode);
        return new WebResult().result200(message, "/super/addBook");
    }

    /**
     * <p>
     *     取消编辑书籍
     * </p>
     * @param commitBookDto 取消编辑书籍DTO
     * @return
     */
    @PostMapping("/super/cancelCommitBook")
    public WebResult cancelCommitBook(@RequestBody CommitBookDto commitBookDto){
        Map<String, Object> message = new HashMap<>();
        Integer cancelCode = bookService.cancelCommit(commitBookDto.getBookId());
        message.put("cancelCode", cancelCode);
        return new WebResult().result200(message, "/super/cancelCommitBook");
    }

    /**
     * <p>
     *     提交书籍
     * </p>
     * @param commitBookDto 提交书籍DTO
     * @return
     */
    @PostMapping("/super/commitBook")
    public WebResult commitBook(@RequestBody CommitBookDto commitBookDto){
        Map<String, Object> message = new HashMap<>();
        Integer commitCode = bookService.commitBook(commitBookDto.getBookId());
        message.put("commitCode", commitCode);
        return new WebResult().result200(message, "/super/commitBook");
    }

    /**
     * <p>
     *     修改视频信息
     * </p>
     * @param updateBookInfoDto 修改视频信息DTO
     * @return
     */
    @PostMapping("/super/updateBook")
    public WebResult updateBook(@RequestBody UpdateBookInfoDto updateBookInfoDto){
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = bookService.updateBook(
                updateBookInfoDto.getBookId(),
                updateBookInfoDto.getBookName(),
                updateBookInfoDto.getBookIntroduce());
        message.put("updateCode", updateCode);
        return new WebResult().result200(message, "/super/updateBook");
    }

    /**
     * <p>
     *     修改视频封面
     * </p>
     * @param bookId 视频编号
     * @param picture 图片文件
     * @return
     * @throws IOException
     */
    @PostMapping("/super/updateBookPicture")
    public WebResult updateBookPicture(@RequestParam Integer bookId,
                                        @RequestParam MultipartFile picture) throws IOException {
        Map<String, Object> message = new HashMap<>();
        UpdateBookFileInfo updateInfo = bookService.updateBookPicture(bookId, picture);
        message.put("updateInfo", updateInfo);
        return new WebResult().result200(message, "/super/updateBookPicture");
    }

    /**
     * <p>
     *     修改视频封面
     * </p>
     * @param bookId 视频编号
     * @param file 图片文件
     * @return
     * @throws IOException
     */
    @PostMapping("/super/updateBookFile")
    public WebResult updateBookFile(@RequestParam Integer bookId,
                                       @RequestParam MultipartFile file) throws IOException {
        Map<String, Object> message = new HashMap<>();
        UpdateBookFileInfo updateInfo = bookService.updateBookFile(bookId, file);
        message.put("updateInfo", updateInfo);
        return new WebResult().result200(message, "/super/updateBookFile");
    }

    /**
     * <p>
     *    删除视频
     * </p>
     * @param deleteBookDto 删除视频
     * @return
     */
    @PostMapping("/super/deleteBook")
    public WebResult deleteBook(@RequestBody DeleteBookDto deleteBookDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = bookService.deleteBook(deleteBookDto.getBookId());
        message.put("deleteCode", deleteCode);
        return new WebResult().result200(message, "/super/deleteBook");
    }

    /**
     * <p>
     *     通过模块获取视频
     * </p>
     * @param modelId 模块编号
     * @return
     */
    @GetMapping("/common/listBookByModel")
    public WebResult listBookByModel(@RequestParam Integer modelId){
        Map<String, Object> message = new HashMap<>();
        List<Book> data = bookService.listBookByModel(modelId);
        message.put("data", data);
        return new WebResult().result200(message, "/common/listBookByModel");
    }

    /**
     * <p>
     *     通过模块获取未提交的视频
     * </p>
     * @param modelId 模块编号
     * @return
     */
    @GetMapping("/super/listUnCommitBook")
    public WebResult listUnCommitBook(@RequestParam Integer modelId){
        Map<String, Object> message = new HashMap<>();
        List<Book> data = bookService.listUnCommitBook(modelId);
        message.put("data", data);
        return new WebResult().result200(message, "/super/listUnCommitBook");
    }

    /**
     * <p>
     *     通过视频编号获取单个视频信息
     * </p>
     * @param bookId 视频编号
     * @return
     */
    @GetMapping("/common/queryOneBookById")
    public WebResult queryOneBookById(@RequestParam Integer bookId){
        Map<String, Object> message = new HashMap<>();
        Book data = bookService.queryOneBookById(bookId);
        message.put("data", data);
        return new WebResult().result200(message, "/common/queryOneBookById");
    }

}
