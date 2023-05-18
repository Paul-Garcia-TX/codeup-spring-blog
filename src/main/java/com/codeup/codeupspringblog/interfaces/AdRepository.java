package com.codeup.codeupspringblog.interfaces;

import com.codeup.codeupspringblog.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad,Long> {

    @Query("from Ad a where a.id like ?1")
    Ad getAdById(long id);

    @Query("from Ad a where a.title like %:term%")
    List<Ad> searchByTitleLike(@Param("term") String term);


}
