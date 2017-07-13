package com.icec.mapper;

import com.icec.enums.ImeiImportEnum;
import com.icec.modal.ImeiInfo;
import org.apache.ibatis.annotations.*;
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
 */
@Repository
public interface ImeiInfoMapper {

    @Select("select * from imei_info")
    @Results({
            @Result(property = "isImport", column = "import", javaType = ImeiImportEnum.class)
    })
    List<ImeiInfo> getAll();

    @Select("select * from imei_info where id=#{id}")
    @Results({
            @Result(property = "isImport", column = "import", javaType = ImeiImportEnum.class)
    })
    ImeiInfo find(Long id);


    @Select("select * from imei_info where serialNumber=#{serialNumber}")
    @Results({
            @Result(property = "isImport", column = "import", javaType = ImeiImportEnum.class)
    })
    ImeiInfo findBySerialNumber(String serialNumber);

    @Insert("insert into imei_info(name, serialNumber, import, model, mobileType) values (#{name}, #{serialNumber}, #{isImport}, #{model}, #{mobileType})")
    void insert(ImeiInfo entity);

    @Update("update imei_info set name=#{name}, serialNumber=#{serialNumber}, import=#{isImport}, model=#{model}, mobileType=#{mobileType} where id=#{id}")
    void update(ImeiInfo entity);

    @Delete("delete from imei_info where id=#{id}")
    void delete(Long id);
}
