package com.certification.bunasolappBackEnd.metier;

import java.util.List;
import java.util.Optional;

import com.certification.bunasolappBackEnd.entity.TypeEchantillon;

public interface TypeEchantillonMetier {

	List<TypeEchantillon> getListTypeEchantillons();

	Optional<TypeEchantillon> getTypeEchantillonById(Long id);

	TypeEchantillon createTypeEchantillon(TypeEchantillon typeEchantillon);

	TypeEchantillon updateTypeEchantillon(Long id, TypeEchantillon typeEchantillon);

	void deleteTypeEchantillon(Long id);
}
