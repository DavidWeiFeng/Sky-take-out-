package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.service.DishService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void save(DishDTO dishDTO){
        log.info("新增菜品:{}",dishDTO);
        dishService.saveWithFlavor(dishDTO);

    }
}