package com.briup.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.briup.bean.Agreement;
import com.briup.exception.MyException;
import com.briup.service.IAgreementService;

@Controller
@RequestMapping("/agr")
public class AgreementController {

    @Autowired
    private IAgreementService agreementService;

    @RequestMapping("/page")
    @ResponseBody
    public Map<String, Object> findAgreement(int pageNum, String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = agreementService.findAgreement(pageNum, name);
        map.put("status", 200);
        return map;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteAgreement(int selectId) {
        agreementService.deleteAgr(selectId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        return map;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> updateAgreement(@RequestParam("file") MultipartFile[] files, Date time, int selectId, HttpServletRequest request) {
        String fileName = "";
        java.sql.Date time1 = new java.sql.Date(time.getTime());
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                // 保存文件
                saveFile(request, file);
                fileName = file.getOriginalFilename();
            }
        }
        Agreement agr = new Agreement();
        agr.setAgreement_id(selectId);
        agr.setAgreement_btime(time1);
        agr.setAgreement_content(fileName);
        agreementService.updateAgr(agr);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        return map;
    }


    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, Object> insertAgreement(@RequestParam("file") MultipartFile[] files, Date time, @RequestParam("StaffId") int StaffId, @RequestParam("StaffId2") int agreementId, HttpServletRequest request) throws MyException {
        System.out.println(" 0");
        String fileName = "";
        java.sql.Date time1 = new java.sql.Date(time.getTime());
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                // 保存文件
                saveFile(request, file);
                fileName = file.getOriginalFilename();
            }
            System.out.println("files != null && files.length > 0");
        }
        Agreement agr = new Agreement();
        agr.setP_id(StaffId);
        agr.setAgreement_id(agreementId);
        agr.setAgreement_btime(time1);
        agr.setAgreement_content(fileName);
        System.out.println(agr);
        int flag = agreementService.insertAgr(agr);
        Map<String, Object> map = new HashMap<String, Object>();
        if (flag == 1) {
            map.put("status", 200);
            System.out.println("200");
        } else {
            map.put("status", 300);
            System.out.println("300");
        }
        System.out.println("flag=" + flag);
        System.out.println(map.get("arg.Agreement_content"));
        return map;
    }

    private void saveFile(HttpServletRequest request, MultipartFile file) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                //保存的文件路径
                //需要的话可以给文件名上加时间戳
                String filePath = request.getServletContext().getRealPath("/") + "file/"
                        + file.getOriginalFilename();
                File newFile = new File(filePath);
                //文件所在目录不存在就创建
                if (!newFile.getParentFile().exists()) {
                    newFile.getParentFile().mkdirs();
                }

                // 转存文件
                file.transferTo(newFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
