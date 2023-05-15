package com.example.cosmeticingredientcheckerbe.domain.mapper;

import com.example.cosmeticingredientcheckerbe.domain.dto.response.cosmetic.CosmeticResponse;
import com.example.cosmeticingredientcheckerbe.domain.entity.Cosmetic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CosmeticMapper {
    CosmeticMapper INSTANCE = Mappers.getMapper(CosmeticMapper.class);

    @Mapping(target = "productId", source = "id")
    CosmeticResponse toCosmeticResponse(Cosmetic cosmetic);
}
