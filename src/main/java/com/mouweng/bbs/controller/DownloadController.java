package com.mouweng.bbs.controller;

import com.mouweng.bbs.pojo.Download;
import com.mouweng.bbs.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class DownloadController {

    @Autowired
    DownloadService downloadService;

    @GetMapping({"/download"})
    public String download(Model model){
        List<Download> downloadList = downloadService.selectAll();
        model.addAttribute("downloadList",downloadList);
        return "page/download";
    }





}

