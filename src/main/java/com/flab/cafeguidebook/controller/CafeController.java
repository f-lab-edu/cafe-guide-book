package com.flab.cafeguidebook.controller;

import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.dto.HeartDTO;
import com.flab.cafeguidebook.service.CafeService;
import com.flab.cafeguidebook.util.SessionKeys;
import java.util.List;
import com.flab.cafeguidebook.service.HeartService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/owner/cafe")
@RestController
public class CafeController {

  private static final Logger LOGGER = LogManager.getLogger(CafeController.class);

  @Autowired
  private CafeService cafeService;

  @PostMapping
  @Autowired
  private HeartService heartService;

  @PostMapping
  public ResponseEntity addCafe(HttpSession httpSession,
      @RequestBody @Validated CafeDTO cafeDTO,
      BindingResult bindingResult) {
    Long userId = (Long) httpSession.getAttribute(SessionKeys.USER_ID);
    cafeDTO.setUserId(userId);

    if (bindingResult.hasErrors()) {
      bindingResult.getAllErrors().forEach(error -> {
        LOGGER.info(error);
      });
      return ResponseEntity.badRequest().build();
    }
    cafeService.addCafe(cafeDTO);
    return ResponseEntity.ok(cafeDTO);
  }

  @PatchMapping("/registeration/approve/{cafeId}/")
  public void resolveRegistration(@PathVariable Long cafeId) {
    cafeService.approveRegistration(cafeId);
  }

  @PatchMapping("/registeration/deny/{cafeId}")
  public void denyRegistration(@PathVariable Long cafeId) {
    cafeService.denyRegistration(cafeId);
  }

  @GetMapping
  public ResponseEntity getMyAllCafe(HttpSession httpSession) {
    Long userId = (Long) httpSession.getAttribute(SessionKeys.USER_ID);
    List<CafeDTO> myAllCafe = cafeService.getMyAllCafe(userId);
    if (myAllCafe.size() > 0) {
      return ResponseEntity.ok().body(myAllCafe);
    } else {
      LOGGER.info("사장님의 카페를 조회할 수 없습니다.");
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/{cafeId}")
  public ResponseEntity getMyCafe(@PathVariable Long cafeId,
      HttpSession httpSession) {
    Long userId = (Long) httpSession.getAttribute(SessionKeys.USER_ID);
    CafeDTO myCafe = cafeService.getMyCafe(cafeId, userId);
    if (myCafe == null) {
      LOGGER.info("사장님의 카페를 조회할 수 없습니다. cafeId ={}, loginUser={}", cafeId, userId);
      return ResponseEntity.badRequest().build();
    } else {
      return ResponseEntity.ok(myCafe);
    }
  }

  @PatchMapping("/{cafeId}")
  public ResponseEntity updateCafe(@PathVariable long cafeId,
      @RequestBody @Validated CafeDTO cafeDTO, BindingResult bindingResult,
      HttpSession httpSession) {
    Long userId = (Long) httpSession.getAttribute(SessionKeys.USER_ID);
    if (bindingResult.hasErrors()) {
      bindingResult.getAllErrors().forEach(error -> {
        LOGGER.info("카페를 수정할 수 없습니다. userId = {}, cafeId = {}", userId, cafeId);
      });
      return ResponseEntity.badRequest().build();
    }
    cafeService.updateCafe(cafeDTO);
    return ResponseEntity.ok(cafeDTO);
  }
  @GetMapping("/hearts/{cafeId}")
  public List<HeartDTO> getCafesHearts(@PathVariable Long cafeId) {
    return heartService.getCafesHearts(cafeId);
  }
}
