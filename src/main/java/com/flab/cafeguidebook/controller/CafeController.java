package com.flab.cafeguidebook.controller;

import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.service.CafeService;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity addCafe(HttpSession httpSession,
      @RequestBody @Validated CafeDTO cafeDTO,
      BindingResult bindingResult) {
    Long userId = (Long) httpSession.getAttribute("userId");
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

  @DeleteMapping("/{cafeId}")
  public ResponseEntity deleteCafe(@PathVariable Long cafeId, HttpSession httpSession) {
    Long userId = (Long) httpSession.getAttribute("userId");
    boolean deleteCafe = cafeService.deleteCafe(cafeId);
    if(!deleteCafe) {
      LOGGER.info("카페를 삭제할 수 없습니다. userId ={}, cafeId={}", userId, cafeId);
      return ResponseEntity.badRequest().build();
    }else {
      return ResponseEntity.ok().build();
    }
  }
}
