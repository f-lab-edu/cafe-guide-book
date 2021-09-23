package com.flab.cafeguidebook.controller;

import com.flab.cafeguidebook.dto.MenuDTO;
import com.flab.cafeguidebook.dto.OptionDTO;
import com.flab.cafeguidebook.service.MenuService;
import com.flab.cafeguidebook.service.OptionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/owner/cafe/{cafeId}/menu")
@RestController
public class MenuController {

  private static final Logger LOGGER = LogManager.getLogger(MenuController.class);

  @Autowired
  private MenuService menuService;

  @Autowired
  private OptionService optionService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity addMenu(@PathVariable long cafeId,
      @RequestBody @Validated MenuDTO menuDTO,
      BindingResult bindingResult) {
    menuDTO.setCafeId(cafeId);

    if (bindingResult.hasErrors()) {
      bindingResult.getAllErrors().forEach(error -> {
        LOGGER.info("메뉴를 등록할 수 없습니다. cafeId = {}, menuId = {}", cafeId, menuDTO.getMenuId());
      });
      return ResponseEntity.badRequest().build();
    }
    menuService.addMenu(menuDTO);
    return ResponseEntity.ok(menuDTO);
  }

  @PostMapping(value = "/{menuId}/options/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity addOption(@PathVariable long cafeId, @PathVariable long menuId,
      @RequestBody @Validated OptionDTO optionDTO,
      BindingResult bindingResult) {

    optionDTO.setMenuId(menuId);

    if (bindingResult.hasErrors()) {
      bindingResult.getAllErrors().forEach(error -> {
        LOGGER.info("옵션을 등록할 수 없습니다. menuId = {}, OptionId = {}", menuId,
            optionDTO.getOptionId());
      });
      return ResponseEntity.badRequest().build();
    }
    optionService.addOption(optionDTO);
    return ResponseEntity.ok(optionDTO);
  }

  @PostMapping(value = "/{menuId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity updateMenu(@PathVariable long cafeId, @PathVariable long menuId,
      @RequestBody @Validated MenuDTO menuDTO, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      bindingResult.getAllErrors().forEach(error -> {
        LOGGER.info("메뉴를 수정할 수 없습니다. cafeId = {}, menuId = {}", cafeId, menuId);
      });
      return ResponseEntity.badRequest().build();
    }
    menuService.updateMenu(menuDTO);
    return ResponseEntity.ok(menuDTO);
  }

  @PostMapping(value = "/{menuId}/options/{optionId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity updateOption(@PathVariable long menuId, @PathVariable long optionId,
      @RequestBody @Validated OptionDTO optionDTO, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      bindingResult.getAllErrors().forEach(error -> {
        LOGGER.info("옵션을 수정할 수 없습니다. menuId = {}, optionId = {}", menuId, optionId);
      });
      return ResponseEntity.badRequest().build();
    }
    optionService.updateOption(optionDTO);
    return ResponseEntity.ok(optionDTO);
  }

}
