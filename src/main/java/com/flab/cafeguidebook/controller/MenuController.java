package com.flab.cafeguidebook.controller;

import com.flab.cafeguidebook.domain.Option;
import com.flab.cafeguidebook.dto.MenuDTO;
import com.flab.cafeguidebook.dto.OptionDTO;
import com.flab.cafeguidebook.service.MenuService;
import com.flab.cafeguidebook.service.OptionService;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getAllMenu(@PathVariable long cafeId) {
    List<MenuDTO> AllMenu = menuService.getAllMenu(cafeId);
    if (AllMenu.size() > 0) {
      return ResponseEntity.ok().body(AllMenu);
    } else {
      LOGGER.info("해당 카페의 전체 메뉴를 조회할 수 없습니다. cafeId = {}", cafeId);
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping(value = "/{menuId}/options", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getAllOption(@PathVariable long cafeId, @PathVariable long menuId) {
    List<OptionDTO> AllOption = optionService.getAllOption(menuId);
    if (AllOption.size() > 0) {
      return ResponseEntity.ok().body(AllOption);
    } else {
      LOGGER.info("해당 메뉴의 전체 옵션을 조회할 수 없습니다. cafeId = {}, menuId = {}", cafeId, menuId);
      return ResponseEntity.badRequest().build();
    }
  }

}
