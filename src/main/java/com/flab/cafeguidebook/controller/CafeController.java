package com.flab.cafeguidebook.controller;

import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.dto.HeartDTO;
import com.flab.cafeguidebook.dto.RegistrationDTO;
import com.flab.cafeguidebook.service.CafeService;
import com.flab.cafeguidebook.service.HeartService;
import com.flab.cafeguidebook.util.SessionKeys;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

  @PatchMapping("/{cafeId}/registration/{approveYn}")
  public void resolveRegistration(@PathVariable Long cafeId,
      @RequestBody RegistrationDTO registrationDTO) {
    if (registrationDTO.getApproveYn()) {
      cafeService.approveRegistration(cafeId);
    } else {
      cafeService.denyRegistration(cafeId);
    }
  }

  @DeleteMapping("/{cafeId}")
  public ResponseEntity deleteCafe(@PathVariable Long cafeId, HttpSession httpSession) {
    Long userId = (Long) httpSession.getAttribute(SessionKeys.USER_ID);
    boolean isMyCafe = cafeService.validateMyCafe(userId, cafeId);
    if (!isMyCafe) {
      LOGGER.info("????????? ????????? ????????? ????????????. userId ={}, cafeId={}", userId, cafeId);
      return ResponseEntity.status(401).build();
    }
    boolean deleteCafe = cafeService.deleteCafe(cafeId);
    if (!deleteCafe) {
      LOGGER.info("????????? ????????? ??? ????????????. userId ={}, cafeId={}", userId, cafeId);
      return ResponseEntity.internalServerError().build();
    } else {
      return ResponseEntity.ok().build();
    }
  }

  @GetMapping
  public ResponseEntity getMyAllCafe(HttpSession httpSession) {
    Long userId = (Long) httpSession.getAttribute(SessionKeys.USER_ID);
    List<CafeDTO> myAllCafe = cafeService.getMyAllCafe(userId);
    if (myAllCafe.size() > 0) {
      return ResponseEntity.ok().body(myAllCafe);
    } else {
      LOGGER.info("???????????? ????????? ????????? ??? ????????????.");
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/{cafeId}")
  public ResponseEntity getMyCafe(@PathVariable Long cafeId,
      HttpSession httpSession) {
    Long userId = (Long) httpSession.getAttribute(SessionKeys.USER_ID);
    CafeDTO myCafe = cafeService.getMyCafe(cafeId, userId);
    if (myCafe == null) {
      LOGGER.info("???????????? ????????? ????????? ??? ????????????. cafeId ={}, loginUser={}", cafeId, userId);
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
        LOGGER.info("????????? ????????? ??? ????????????. userId = {}, cafeId = {}", userId, cafeId);
      });
      return ResponseEntity.badRequest().build();
    }
    cafeService.updateCafe(cafeDTO);
    return ResponseEntity.ok(cafeDTO);
  }

  @GetMapping("/{cafeId}/hearts")
  public List<HeartDTO> getCafesHearts(@PathVariable Long cafeId) {
    return heartService.getCafesHearts(cafeId);
  }
}
