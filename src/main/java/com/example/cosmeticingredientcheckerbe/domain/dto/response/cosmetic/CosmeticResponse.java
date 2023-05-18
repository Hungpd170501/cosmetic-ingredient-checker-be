package com.example.cosmeticingredientcheckerbe.domain.dto.response.cosmetic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CosmeticResponse {
    private Long productId;
    private String name;
    private String description;
    private String image;
}
