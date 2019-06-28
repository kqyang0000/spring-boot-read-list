package com.imocc.springbootreadlist.repository;

import com.imocc.springbootreadlist.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, String> {
}
