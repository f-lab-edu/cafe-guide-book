package com.flab.cafeguidebook.controller;

import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.dto.UpdateCafeDTO;
import com.flab.cafeguidebook.service.CafeService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
=======
>>>>>>> develop
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

<<<<<<< HEAD
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMyAllCafe(HttpSession httpSession) {
        String userId = (String) httpSession.getAttribute("userId");
        List<CafeDTO> myAllCafe = cafeService.getMyAllCafe(userId);
        if (myAllCafe.size() > 0) {
            return ResponseEntity.ok().body(myAllCafe);
        } else {
            LOGGER.info("사장님의 카페를 조회할 수 없습니다.");
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{cafeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMyCafe(@PathVariable String cafeId,
        HttpSession httpSession) {
        String userId = (String) httpSession.getAttribute("userId");
        cafeService.validateMyCafe(cafeId, userId);
        CafeDTO myCafe = cafeService.getMyCafe(cafeId, userId);
        if (myCafe == null) {
            LOGGER.info("사장님의 카페를 조회할 수 없습니다. cafeId ={}, loginUser={}", cafeId, userId);
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(myCafe);
        }
    }

    @PatchMapping("/{cafeId}")
    public ResponseEntity updateCafe(@PathVariable String cafeId,
        @RequestBody final UpdateCafeDTO updateCafeDTO, HttpSession httpSession) {
        String userId = (String) httpSession.getAttribute("userId");
        final UpdateCafeDTO copyData = UpdateCafeDTO.copyWithId(updateCafeDTO, cafeId, userId);
        boolean updateCafe = cafeService.updateCafe(copyData);
        if (!updateCafe) {
            LOGGER.info("카페를 수정할 수 없습니다. updateCafeDTO ={}", updateCafeDTO);
            return ResponseEntity.badRequest().build();
        } else {
            CafeDTO updatedCafe = cafeService.getMyCafe(cafeId, userId);
            return ResponseEntity.ok(updatedCafe);
        }
    }
=======
  @PatchMapping("/registeration/deny/{cafeId}")
  public void denyRegistration(@PathVariable Long cafeId) {
    cafeService.denyRegistration(cafeId);
  }
>>>>>>> develop
}
