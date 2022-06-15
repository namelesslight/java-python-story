package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2022-06-15
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

    /**
     * <p>
     *     在对应模块添加未编辑书籍
     * </p>
     * @param modelId 模块编号
     * @return
     */
    Integer addBook(Integer modelId);

    /**
     * <p>
     *     取消编辑书籍
     * </p>
     * @param bookId 书籍编号
     * @return
     */
    Integer cancelCommit(Integer bookId);

    /**
     * <p>
     *     提交书籍
     * </p>
     * @param bookId 书籍编号
     * @return
     */
    Integer commitBook(Integer bookId);

    /**
     * <p>
     *     修改书籍信息
     * </p>
     * @param bookId 书籍编号
     * @param name 书籍名
     * @param introduce 书籍简介
     * @return
     */
    Integer updateBook(Integer bookId, String name, String introduce);

    /**
     * <p>
     *     修改书籍封面
     * </p>
     * @param bookId 书籍编号
     * @param picture 书籍文件
     * @return
     * @throws IOException
     */
    Integer updateBookPicture(Integer bookId, String picture) throws IOException;

    /**
     * <p>
     *     修改书籍pdf文件
     * </p>
     * @param bookId 书籍编号
     * @param file 书籍文件
     * @return
     * @throws IOException
     */
    Integer updateBookFile(Integer bookId, String file) throws IOException;

    /**
     * <p>
     *     书籍编号
     * </p>
     * @param bookId 书籍编号
     * @return
     */
    Integer deleteBook(Integer bookId);

    /**
     * <p>
     *     通过模块获取书籍
     * </p>
     * @param modelId 模块编号
     * @return
     */
    List<Book> listBookByModel(Integer modelId);

    /**
     * <p>
     *     通过模块获取未提交的书籍
     * </p>
     * @param modelId 模块编号
     * @return
     */
    List<Book> listUnCommitBook(Integer modelId);

    /**
     * <p>
     *     通过书籍编号获取单个书籍信息
     * </p>
     * @param bookId 书籍编号
     * @return
     */
    Book queryOneBookById(Integer bookId);

}
