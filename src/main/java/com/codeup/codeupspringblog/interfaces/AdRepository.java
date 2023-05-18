package com.codeup.codeupspringblog.interfaces;

public interface AdRepository extends JpaRepository<Ad,Long>{
    Ad findByTitle(String title);
    Ad findFirstByTitle(String title);

    Object findAll();
}
