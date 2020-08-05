package com.cisco.icam.brand_service.controller;

import com.cisco.icam.brand_service.entity.Brand;
import com.cisco.icam.brand_service.entity.PageResult;
import com.cisco.icam.brand_service.entity.Result;
import com.cisco.icam.brand_service.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult findPage(Integer pageNum, Integer pageSize){
        return brandService.findPage(pageNum, pageSize);
    }


    @GetMapping("/search")
    public PageResult search(Integer pageNum, Integer pageSize, @RequestBody Brand brand){
        return brandService.search(pageNum, pageSize, brand);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Brand brand){
        try {
            brandService.add(brand);
            return new Result(true, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "保存失败");
        }
    }

    @RequestMapping("/findOne")
    public Brand findOne(Long id){
        return brandService.findOne(id);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Brand brand){
        try {
            brandService.update(brand);
            return new Result(true, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "更新失败");
        }
    }

    @GetMapping("/delete")
    public Result delete(Long[] ids){
        try {
            brandService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("/selectOptionList")
    public List<Map<String, String>> selectOptionList(){
        return brandService.selectOptionList();
    }
}
