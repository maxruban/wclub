package com.repository;

import com.domain.ProductPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPreferenceRepository extends JpaRepository<ProductPreference, Integer> {
}
