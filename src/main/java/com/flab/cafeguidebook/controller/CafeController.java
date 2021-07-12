package com.flab.cafeguidebook.controller;

import com.flab.cafeguidebook.dto.cafe.CafeDTO;
import com.flab.cafeguidebook.service.CafeService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/owner/cafe")
@RestController
public class CafeController {

    @Autowired
    private CafeService cafeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCafe(HttpSession httpSession,
        @RequestBody @Validated CafeDTO cafeDTO,
        BindingResult bindingResult){

        //String id = (String) httpSession.getAttribute("id");
        //cafeDTO.setId(id);
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error);
            });
            return ResponseEntity.badRequest().build();
        }
        //cafeService.addCafe(cafeDTO);
        return ResponseEntity.ok(cafeDTO);
    }

}
