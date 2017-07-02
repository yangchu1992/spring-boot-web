package com.icec.mapper;

import com.icec.enums.PhoneStockImportEnum;
import com.icec.modal.PhoneStock;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jqChu on 2017/6/19.
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 */
@Repository
public interface PhoneStockMapper {

    @Select("select * from phone_stock")
    @Results({
            @Result(property = "isImport", column = "import", javaType = PhoneStockImportEnum.class)
    })
    List<PhoneStock> getAll();

    @Select("select * from phone_stock where id=#{id}")
    @Results({
             @Result(property = "isImport", column = "import", javaType = PhoneStockImportEnum.class)
    })
    PhoneStock find(Long id);


    @Select("select * from phone_stock where serialNumber=#{serialNumber}")
    @Results({
            @Result(property = "isImport", column = "import", javaType = PhoneStockImportEnum.class)
    })
    PhoneStock findBySerialNumber(String serialNumber);

    @Insert("insert into phone_stock(name, serialNumber, import, model) values (#{name}, #{serialNumber}, #{isImport}, #{model})")
    void insert(PhoneStock p);

    @Update("update phone_stock set name=#{name}, serialNumber=#{serialNumber}, import=#{isImport}, model=#{model} where id=#{id}")
    void update(PhoneStock p);

    @Delete("delete from phone_stock where id=#{id}")
    void delete(Long id);
}
