package top.aprillie.module.test.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.aprillie.module.test.entity.Test;
import top.aprillie.module.test.entity.TestList;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/1 15:31
 * @Modified By:
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("/test")
    public List<TestList> test(@RequestBody Test test) {
        System.out.println(test.toString());
        Test newTest = new Test();
        newTest.setAge(test.getAge() + 1);
        newTest.setName(test.getName() + "circle");

        TestList testList = new TestList();
        testList.setId(1);
        testList.setAttribute("test");
        testList.setTest(newTest);

        List<TestList> testLists = new ArrayList<>();
        testLists.add(testList);
        testLists.add(testList);
        testLists.add(testList);
        return testLists;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        File uploadFile = new File("C://Users//illure//Desktop//uploadFiles//" + name);
        System.out.println(uploadFile.getPath());
        file.transferTo(uploadFile);
        return "success";
    }

    @RequestMapping("/uploads")
    @ResponseBody
    public String uploads(MultipartFile[] files) throws IOException {
        for (MultipartFile file : files) {
            String name = file.getOriginalFilename();
            File uploadFile = new File("C://Users//illure//Desktop//uploadFiles//" + name);
            System.out.println(uploadFile.getPath());
            file.transferTo(uploadFile);
        }
        return "success";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download() throws IOException {
        String path = "C:/Users/illure/Desktop/uploadFiles/logo.PNG";
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", path);
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}
