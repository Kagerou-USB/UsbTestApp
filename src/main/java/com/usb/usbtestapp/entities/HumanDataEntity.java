package com.usb.usbtestapp.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity：エンティティクラスを示すアノテーション
 * Table(name="")：テーブル指定（省略した場合、クラス名がテーブル名になる）
 * Id：【必須】プライマリキー
 * GeneratedValue(strategy = GenerationType.AUTO)：プライマリキーを自動生成
 *         -> strategyで生成方法を指定）
 * Column：カラム指定（諸略した場合、フィールド名がカラム名になる）
 *         -> カラムにルールを追加できる
 **/

@Entity
@Table(name="human")
@Data
public class HumanDataEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 200, nullable = false)
	private String mail;
	
	@Column(nullable = false)
	private Integer age;
	
	@Column(nullable = true)
	private String memo;
}
