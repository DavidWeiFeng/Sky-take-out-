package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/dish")

public class DishController {
    /**
     * 新增菜品
     */
    @Autowired
    private DishService dishService;
    @PostMapping
    @ApiOperation("新增菜品")
    public void save(@RequestBody DishDTO dishDTO){
        log.info("新增菜品:{}",dishDTO);
        dishService.saveWithFlavor(dishDTO);

    }

    @GetMapping("/page")
    @ApiOperation("菜品分页查询")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO)
    {
        log.info("菜品分页查询：{}",dishPageQueryDTO);
        PageResult pageResult= dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);

    }

    @DeleteMapping
    @ApiOperation("菜品批量刪除")
    public Result delete(@RequestParam List<Long> ids){
        dishService.deleteBatch(ids);
        return Result.success();
    }


    @PostMapping("/status/{status}")
    @ApiOperation("菜品起售、停售")
    public Result startOrStop(@PathVariable Integer status,Long id)
    {
        log.info("菜品{} 狀態：{}",id,status);
        dishService.startOrStop(status,id);
        return Result.success("刪除菜品成功");
    }
}
