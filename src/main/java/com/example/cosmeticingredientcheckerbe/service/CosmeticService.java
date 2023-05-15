package com.example.cosmeticingredientcheckerbe.service;

import com.example.cosmeticingredientcheckerbe.domain.dto.response.cosmetic.CosmeticResponse;
import com.example.cosmeticingredientcheckerbe.domain.entity.Cosmetic;
import com.example.cosmeticingredientcheckerbe.domain.mapper.CosmeticMapper;
import com.example.cosmeticingredientcheckerbe.repository.CosmeticRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CosmeticService {
    private final CosmeticRepository cosmeticRepository;

    public List<CosmeticResponse> getAllCosmeticsSearchByNameWithPaginate(String query, Integer offset, Integer limit) {
        Page<Cosmetic> cosmeticPage = cosmeticRepository.findAllByNameContainingIgnoreCase(query, PageRequest.of(offset, limit));
        return cosmeticPage.stream().map(CosmeticMapper.INSTANCE::toCosmeticResponse).toList();
    }

    public List<CosmeticResponse> getAllCosmeticsSearchByNameEscapeAccentWithPaginate(String query, Integer offset, Integer limit) {
        Page<Cosmetic> cosmeticPage = cosmeticRepository.findAllByNameContainingIgnoreCaseEscapeAccent(StringUtils.stripAccents(query), PageRequest.of(offset, limit));
        return cosmeticPage.stream().map(CosmeticMapper.INSTANCE::toCosmeticResponse).toList();
    }
}
