package com.example.cosmeticingredientcheckerbe.controller;

import com.example.cosmeticingredientcheckerbe.domain.dto.response.cosmetic.CosmeticResponse;
import com.example.cosmeticingredientcheckerbe.service.CosmeticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cosmetic")
public class CosmeticController {
    private final CosmeticService cosmeticService;

    @GetMapping("/search")
    public ResponseEntity<List<CosmeticResponse>> getAllCosmeticsSearchByNameWithPaginate(
            @RequestParam(name = "query", defaultValue = "") String query,
            @RequestParam(name = "limit", defaultValue = "5") Integer limit,
            @RequestParam(name = "offset", defaultValue = "0") Integer offset
    ) {
        List<CosmeticResponse> cosmeticResponseList = cosmeticService.getAllCosmeticsSearchByNameEscapeAccentWithPaginate(query, offset, limit);
        return ResponseEntity.status(HttpStatus.OK).body(cosmeticResponseList);
    }

}
