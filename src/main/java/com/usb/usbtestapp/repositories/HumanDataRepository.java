package com.usb.usbtestapp.repositories;

import com.usb.usbtestapp.entities.HumanDataEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository：データアクセスクラスを示す（@Controllerなどと同様）
 * JpaRepository：新たなリポジトリを作成する際の土台
 */

@Repository
public interface HumanDataRepository extends JpaRepository<HumanDataEntity, Long> {

	/**
	 * Repository：データアクセスクラスを示す（@Controllerなどと同様）
	 * JpaRepository：新たなリポジトリを作成する際の土台
	 */
}
