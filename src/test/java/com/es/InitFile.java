package com.es;

import com.es.entity.DocFile;
import com.es.repository.FileRepository;
import com.es.utils.fileUtils.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitFile {


    @Autowired
    private FileRepository fileRepository;


    @Test
    public void initFile(){
        //原始文件
        File file = new File("D:\\Lucene_Document");
        List<DocFile> list = new ArrayList<>();
        int count = 0;
        for (File f : file.listFiles()) {
            count ++;
            //文件名
            String fileName = f.getName();
            String fileContent = "";
            //文件内容
            try{
                fileContent = FileUtil.getContext(f);
            }catch (Exception e){

                e.printStackTrace();
            }

            //文件路径
            String path = f.getPath();
            DocFile doc= new DocFile();
            doc.setId(UUID.randomUUID().toString());
            doc.setFileName(fileName);
            doc.setFileContent(fileContent);
            doc.setFilePath(path);
            doc.setSort(count);
            list.add(doc);
        }
       fileRepository.saveAll(list);
    }
}
