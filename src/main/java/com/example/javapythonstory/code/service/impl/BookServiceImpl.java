package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.Book;
import com.example.javapythonstory.code.entity.vo.book.UpdateBookFileInfo;
import com.example.javapythonstory.code.mapper.BookMapper;
import com.example.javapythonstory.code.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.javapythonstory.code.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZCL
 * @since 2022-06-15
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private BookMapper bookMapper;

    /**
     * <p>
     *     在对应模块添加未编辑书籍
     * </p>
     * @param modelId 模块编号
     * @return
     */
    @Override
    public Integer addBook(Integer modelId) {
        Integer addBook = bookMapper.addBook(modelId);
        return addBook;
    }

    /**
     * <p>
     *     取消编辑书籍
     * </p>
     * @param bookId 书籍编号
     * @return
     */
    @Override
    public Integer cancelCommit(Integer bookId) {
        Integer deleteCode = bookMapper.cancelCommit(bookId);
        return deleteCode;
    }

    /**
     * <p>
     *     提交书籍
     * </p>
     * @param bookId 书籍编号
     * @return
     */
    @Override
    public Integer commitBook(Integer bookId) {
        Book book = bookMapper.queryOneBookById(bookId);
        Boolean nameJudge = "".equals(book.getBName());
        Boolean introduceJudge = "".equals(book.getBIntroduce());
        Boolean headerJudge = "".equals(book.getBHeader());
        Boolean fileJudge = "".equals(book.getBFile());
        if (nameJudge && introduceJudge && headerJudge && fileJudge){
            return 0;
        }
        Integer commitCode = bookMapper.commitBook(bookId);
        return commitCode;
    }

    /**
     * <p>
     *     修改书籍信息
     * </p>
     * @param bookId 书籍编号
     * @param name 书籍名
     * @param introduce 书籍简介
     * @return
     */
    @Override
    public Integer updateBook(Integer bookId, String name, String introduce) {
        Integer updateCode = bookMapper.updateBook(bookId, name, introduce);
        return updateCode;
    }

    /**
     * <p>
     *     修改书籍封面
     * </p>
     * @param bookId 书籍编号
     * @param picture 书籍文件
     * @return
     * @throws IOException
     */
    @Override
    public UpdateBookFileInfo updateBookPicture(Integer bookId, MultipartFile picture) throws IOException {
        String path = "/usr/local/src/spring/file/image/book_header/" + bookId;
        String filePath = FileUtil.addImg(picture, path);
        Integer updateCode = bookMapper.updateBookPicture(bookId, filePath);
        UpdateBookFileInfo updateBookFileInfo = new UpdateBookFileInfo(updateCode, filePath);
        return updateBookFileInfo;
    }

    /**
     * <p>
     *     修改书籍pdf文件
     * </p>
     * @param bookId 书籍编号
     * @param file 书籍文件
     * @return
     * @throws IOException
     */
    @Override
    public UpdateBookFileInfo updateBookFile(Integer bookId, MultipartFile file) throws IOException {
        String path = "/usr/local/src/spring/file/book/" + bookId;
        String filePath = FileUtil.addPdf(file, path);
        Integer updateCode = bookMapper.updateBookFile(bookId, filePath);
        UpdateBookFileInfo updateBookFileInfo = new UpdateBookFileInfo(updateCode, filePath);
        return updateBookFileInfo;
    }

    /**
     * <p>
     *     书籍编号
     * </p>
     * @param bookId 书籍编号
     * @return
     */
    @Override
    public Integer deleteBook(Integer bookId) {
        Integer deleteCode = bookMapper.deleteBook(bookId);
        return deleteCode;
    }

    /**
     * <p>
     *     通过模块获取书籍
     * </p>
     * @param modelId 模块编号
     * @return
     */
    @Override
    public List<Book> listBookByModel(Integer modelId) {
        List<Book> data = bookMapper.listBookByModel(modelId);
        return data;
    }

    /**
     * <p>
     *     通过模块获取未提交的书籍
     * </p>
     * @param modelId 模块编号
     * @return
     */
    @Override
    public List<Book> listUnCommitBook(Integer modelId) {
        List<Book> data = bookMapper.listUnCommitBook(modelId);
        return data;
    }

    /**
     * <p>
     *     通过书籍编号获取单个书籍信息
     * </p>
     * @param modelId 书籍编号
     * @return
     */
    @Override
    public Book queryOneBookById(Integer modelId) {
        Book data = bookMapper.queryOneBookById(modelId);
        return data;
    }
}
