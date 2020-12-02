package com.es;


import com.es.entity.Shebei;
import com.es.repository.ShebeiRepository;
import com.es.mapper.ShebeiMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitShebei {

    @Autowired
    private ShebeiMapper shebeiMapper;
    @Autowired
    private ShebeiRepository shebeiRepository;

    @Test
    public void initShebei(){
        List<Shebei> list = shebeiMapper.findList(new Shebei());
        shebeiRepository.saveAll(list);
    }
}
