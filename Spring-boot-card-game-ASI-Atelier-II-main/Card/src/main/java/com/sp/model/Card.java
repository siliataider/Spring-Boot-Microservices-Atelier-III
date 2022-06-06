package com.sp.model;

import com.sp.dto.DTO_Card;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Card {
	@Id
	@GeneratedValue
	private Integer id; 
	private String name;
	private String description;
	private String family_name;
	private String img_src;
	private String affinity;
	private int hp;
	private int energy;
	private int attack;
	private int defense;
	private int price;
	private int id_user;



	public Card() {
	}
	public Card(int id,String family_name, String img_src, String name, String description, int hp, int energy, int attack,int defense,String affinity) {
		this.id=id;
		this.name = name;
		this.description=description;
		this.family_name=family_name;
		this.img_src=img_src;
		this.hp=hp;
		this.energy=energy;
		this.attack=attack;
		this.defense=defense;
		this.id_user=0;
		this.price=50;
		this.affinity=affinity;
	}
	
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public String getImg_src() {
		return img_src;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "HERO ["+this.id+"]: name:"+this.name+", familyName:"+this.family_name+", price:"+this.price+" Owner:" + this.id_user;
	}

	public String getAffinity() {
		return affinity;
	}

	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}

	public DTO_Card toDto() {
		DTO_Card dto = new DTO_Card();
		dto.setId(this.id);
		dto.setAffinity(this.affinity);
		dto.setAttack(this.attack);
		dto.setDefense(this.defense);
		dto.setId_user(this.id_user);
		dto.setDescription(this.description);
		dto.setPrice(this.price);
		dto.setEnergy(this.energy);
		dto.setHp(this.hp);
		dto.setImg_src(this.img_src);
		dto.setFamily_name(this.family_name);
		return dto;

	}
}
