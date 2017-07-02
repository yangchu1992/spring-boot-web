package com.icec.mapper;

import com.icec.enums.PhoneStockImportEnum;
import com.icec.modal.PhoneStock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jqChu on 2017/6/18.
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
@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneStockMapperTest {

    @Resource
    private PhoneStockMapper phoneStockMapper;


    @Test
    public void testInsert() throws Exception {
        phoneStockMapper.insert(new PhoneStock("华为畅享6S(全网通)-金色(中邮集采)", "864193039580947", PhoneStockImportEnum.DONE,"深度机型"));
        phoneStockMapper.insert(new PhoneStock("华为畅享6S(全网通)-金色(中邮集采)", "864658031340409", PhoneStockImportEnum.DONE,"深度机型"));
        phoneStockMapper.insert(new PhoneStock("中兴 S36(移动)-白(集采)", "861571031216003", PhoneStockImportEnum.UNABLE,"普通机型"));
        phoneStockMapper.insert(new PhoneStock("中兴 S36(移动)-白(集采)", "861571031215781", PhoneStockImportEnum.UNABLE,"普通机型"));
        phoneStockMapper.insert(new PhoneStock("中兴 S36(移动)-白(集采)", "861571031214909", PhoneStockImportEnum.UNABLE,"普通机型"));
        phoneStockMapper.insert(new PhoneStock("中兴 S36(移动)-白(集采)", "861571031213521", PhoneStockImportEnum.UNABLE,"普通机型"));
        phoneStockMapper.insert(new PhoneStock("华为NOVA青春版-魅海蓝(中邮集采)", "865121036382685", PhoneStockImportEnum.UNDONE,"普通机型"));
        phoneStockMapper.insert(new PhoneStock("华为NOVA青春版-魅海蓝(中邮集采)", "865121036391314", PhoneStockImportEnum.UNDONE,"普通机型"));
        phoneStockMapper.insert(new PhoneStock("华为NOVA青春版-魅海蓝(中邮集采)", "865121036473625", PhoneStockImportEnum.UNDONE,"普通机型"));
        phoneStockMapper.insert(new PhoneStock("华为NOVA青春版-魅海蓝(中邮集采)", "865121036525598", PhoneStockImportEnum.UNDONE,"普通机型"));
        Assert.assertEquals(10, phoneStockMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<PhoneStock> list = phoneStockMapper.getAll();
        for (PhoneStock p : list) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void testUpdate() throws Exception {
        PhoneStock p = phoneStockMapper.find(1L);
        System.out.println(p.toString());
        p.setName("test");
        phoneStockMapper.update(p);
        Assert.assertTrue(("test".equals(phoneStockMapper.find(1L).getName())));
    }

}