package com.usb.usbtestapp.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

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
	@NotNull
	private long id;
	
	@Column(length = 50, nullable = false)
	@NotEmpty(message="空白は不可")
	private String name;
	
	@Column(length = 200, nullable = false)
	@Email(message="メールアドレスのみ")
	private String mail;
	
	@Column(nullable = false)
	@Min(0)
	@Max(200)
	private Integer age;
	
	@Column(nullable = true)
	private String memo;
}
