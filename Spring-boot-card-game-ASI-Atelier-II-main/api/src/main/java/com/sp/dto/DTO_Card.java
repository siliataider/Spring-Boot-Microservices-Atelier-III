package com.sp.dto;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DTO_Card {
	private int id;
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


	public DTO_Card() {
	}

	public DTO_Card(int id,int price,String family_name, String img_src, String name, String description, int hp, int energy, int attack,int defense,String affinity) {
		this.id=id;
		this.name = name;
		this.description=description;
		this.family_name=family_name;
		this.img_src=img_src;
		this.hp=hp;
		this.energy=energy;
		this.attack=attack;
		this.defense=defense;
		this.price=price;
		this.affinity=affinity;
	}

	public DTO_Card(int id,int id_user) {
		this.id = id;
		this.id_user = id_user;
	}
	
	public int getId() {
		return id;
	}

	public int getId_user() {
		return id_user;
	}
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getFamily_name() {
		return family_name;
	}

	public String getImg_src() {
		return img_src;
	}

	public String getAffinity() {
		return affinity;
	}

	public int getHp() {
		return hp;
	}

	public int getEnergy() {
		return energy;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getPrice() {
		return price;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}

	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


}
