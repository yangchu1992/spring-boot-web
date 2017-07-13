package com.icec.mapper;

import com.icec.enums.ImeiImportEnum;
import com.icec.modal.ImeiInfo;
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
    private ImeiInfoMapper imeiInfoMapper;


    @Test
    public void testInsert() throws Exception {
        imeiInfoMapper.insert(new ImeiInfo("华为畅享6S(全网通)-金色(中邮集采)", "864193039580947", ImeiImportEnum.DONE,"深度机型",""));
        imeiInfoMapper.insert(new ImeiInfo("华为畅享6S(全网通)-金色(中邮集采)", "864658031340409", ImeiImportEnum.DONE,"深度机型",""));
        imeiInfoMapper.insert(new ImeiInfo("中兴 S36(移动)-白(集采)", "861571031216003", ImeiImportEnum.UNABLE,"普通机型",""));
        imeiInfoMapper.insert(new ImeiInfo("中兴 S36(移动)-白(集采)", "861571031215781", ImeiImportEnum.UNABLE,"普通机型",""));
        imeiInfoMapper.insert(new ImeiInfo("中兴 S36(移动)-白(集采)", "861571031214909", ImeiImportEnum.UNABLE,"普通机型",""));
        imeiInfoMapper.insert(new ImeiInfo("中兴 S36(移动)-白(集采)", "861571031213521", ImeiImportEnum.UNABLE,"普通机型",""));
        imeiInfoMapper.insert(new ImeiInfo("华为NOVA青春版-魅海蓝(中邮集采)", "865121036382685", ImeiImportEnum.UNDONE,"普通机型",""));
        imeiInfoMapper.insert(new ImeiInfo("华为NOVA青春版-魅海蓝(中邮集采)", "865121036391314", ImeiImportEnum.UNDONE,"普通机型",""));
        imeiInfoMapper.insert(new ImeiInfo("华为NOVA青春版-魅海蓝(中邮集采)", "865121036473625", ImeiImportEnum.UNDONE,"普通机型",""));
        imeiInfoMapper.insert(new ImeiInfo("华为NOVA青春版-魅海蓝(中邮集采)", "865121036525598", ImeiImportEnum.UNDONE,"普通机型",""));
        Assert.assertEquals(10, imeiInfoMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<ImeiInfo> list = imeiInfoMapper.getAll();
        for (ImeiInfo p : list) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void testUpdate() throws Exception {
        ImeiInfo i = imeiInfoMapper.find(1L);
        System.out.println(i.toString());
        i.setName("test");
        imeiInfoMapper.update(i);
        Assert.assertTrue(("test".equals(imeiInfoMapper.find(1L).getName())));
    }

}
