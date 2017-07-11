package com.icec.mapper;

import com.icec.enums.PhoneStockImportEnum;
import com.icec.modal.MobileEquipmentIdentity;
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
public interface MobileEquipmentIdentityMapper {

    @Select("select * from phone_stock")
    @Results({
            @Result(property = "isImport", column = "import", javaType = PhoneStockImportEnum.class)
    })
    List<MobileEquipmentIdentity> getAll();

    @Select("select * from phone_stock where id=#{id}")
    @Results({
            @Result(property = "isImport", column = "import", javaType = PhoneStockImportEnum.class)
    })
    MobileEquipmentIdentity find(Long id);


    @Select("select * from phone_stock where serialNumber=#{serialNumber}")
    @Results({
            @Result(property = "isImport", column = "import", javaType = PhoneStockImportEnum.class)
    })
    MobileEquipmentIdentity findBySerialNumber(String serialNumber);

    @Insert("insert into phone_stock(name, serialNumber, import, model) values (#{name}, #{serialNumber}, #{isImport}, #{model})")
    void insert(MobileEquipmentIdentity entity);

    @Update("update phone_stock set name=#{name}, serialNumber=#{serialNumber}, import=#{isImport}, model=#{model} where id=#{id}")
    void update(MobileEquipmentIdentity entity);

    @Delete("delete from phone_stock where id=#{id}")
    void delete(Long id);
}
