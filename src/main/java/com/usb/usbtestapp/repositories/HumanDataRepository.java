package com.usb.usbtestapp.repositories;

import com.usb.usbtestapp.entities.HumanDataEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Optional
 *  Java 8から登場した「nullかもしれないオブジェクトをラップするためのクラス」
 *  例)
 *   findByIdを指定してHumanDataEntityを取得する際、IDの値がnullかもしれない…
 *   Optionalを使うことで、結果は必ずOptionalインスタンスとして得られるようになる。
 *    -> nullだった場合の処理を考えなくて良い
 *    Optionalから「get」というメソッドを呼び出せば、ラップしたインスタンス取り出すことができる。
 */
import java.util.Optional;

/**
 * Repository：データアクセスクラスを示す（@Controllerなどと同様）
 * JpaRepository：新たなリポジトリを作成する際の土台
 */

@Repository
public interface HumanDataRepository extends JpaRepository<HumanDataEntity, Long> {

	/**
	 * 「リポジトリ」は、メソッド名を元にエンティティを検索する処理を自動生成する
	 */
	
	public Optional<HumanDataEntity> findById(Long id);
	
	@Query("SELECT d FROM HumanDataEntity d ORDER BY d.name")
	public List<HumanDataEntity> findAllOrderByName();
}
