package com.example.jatdauree.src.domain.practice;


import com.example.jatdauree.config.BaseException;
import com.example.jatdauree.config.BaseResponse;
import com.example.jatdauree.src.domain.practice.dao.PracDao;
import com.example.jatdauree.src.domain.practice.dto.GetItemRes;
import com.example.jatdauree.src.domain.practice.dto.PostItemsReq;
import com.example.jatdauree.src.domain.practice.dto.PostItemsRes;
import com.example.jatdauree.src.domain.practice.service.PracService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/prac")
public class PracController {
    @Autowired
    private final PracService pracService;

    public PracController(PracService pracService, PracDao pracDao) {
        this.pracService = pracService;
    }

    @ResponseBody
    @PostMapping("/items")
    public BaseResponse<PostItemsRes> inputItems(@RequestBody PostItemsReq postItemsReq){
        System.out.println("hello");
        try{
            PostItemsRes postItemRes = pracService.inputItems(postItemsReq);
            return new BaseResponse<>(postItemRes);
        }catch (BaseException baseException){
            return new BaseResponse<>(baseException.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/items")
    public BaseResponse<ArrayList<GetItemRes>> outputItems(){
        try{
            ArrayList<GetItemRes> getItemRes = pracService.outputItems();
            return new BaseResponse<>(getItemRes);
        }catch (BaseException baseException){
            return new BaseResponse<>(baseException.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/item")
    // @RequestParam 사용하여 아이디를 이용하여 아이템을 조회하기
    public BaseResponse<GetItemRes> outputItemsByParamId(@RequestParam int id){
        try{
            GetItemRes postItemRes = pracService.outputItemsByParamId(id);
            return new BaseResponse<>(postItemRes);
        }catch (BaseException baseException){
            return new BaseResponse<>(baseException.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/items/{id}")
    // @PathVariable 사용하여 아이디를 이용하여 아이템을 조회하기
    public BaseResponse<GetItemRes> outputItemsPathId(@PathVariable int id){
        try{
            GetItemRes postItemRes = pracService.outputItemsByParamId(id);
            return new BaseResponse<>(postItemRes);
        }catch (BaseException baseException){
            return new BaseResponse<>(baseException.getStatus());
        }
    }
}
