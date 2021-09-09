package com.kia;

class Player{
	private int baseHealth;
	private int baseAttack;
	private int incrementHealth;
	private int incrementAttack;
	private int level;
	private int defencePower;
	private int attackPower;
	
	private String player_name;
	private Weapon weapon;
	private Armor armor;
	
	
	Player(String name){
		this.player_name = name;
		this.baseHealth = 100;
		this.baseAttack = 50;
		this.incrementHealth = 10;
		this.incrementAttack = 5;
		this.level = 1;
	}
	
	public void display() {
		System.out.println("======================================");
		System.out.println("Player : " + this.player_name);
		System.out.println("Health : " + this.baseHealth);
		
		try {
			System.out.println("Armor  : " + this.defencePower);
			System.out.println("Attack : " + this.maxAttack());
		}catch(Exception e) {
			System.out.println("Armor  : " + 0);
			System.out.println("Attack : " + this.baseAttack);
		}

		System.out.println("Level  : " + this.level);
		System.out.println("======================================\n");
	}
	
	private void levelUp() {
		this.level++;
		this.baseHealth += this.incrementHealth;
		this.baseAttack += this.incrementAttack;
	}
	
	public void attack(Player opponent) {
		opponent.defencePower -= this.maxAttack();
		
		if(opponent.defencePower < 0) {
			opponent.baseHealth += opponent.defencePower;
			opponent.defencePower = 0;
		}
		
		this.levelUp();
	}
	
	public void setArmor(Armor armor) {
		this.armor = armor;
		this.defencePower = this.armor.getDefencePower();
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
		this.attackPower = this.weapon.getAttackPower();
	}
	
	private int maxHealth() {
		return this.baseHealth + this.defencePower;
	}
	
	private int maxAttack() {
		return this.baseAttack + this.attackPower;
	}
}

class Armor{
	private String armor_name;
	private int defence_power;
	
	Armor(String name, int power){
		this.armor_name = name;
		this.defence_power = power;
	}
	
	public int getDefencePower() {
		return this.defence_power;
	}
}

class Weapon{
	private String weapon_name;
	private int attack_power;
	
	Weapon(String name, int power){
		this.weapon_name = name;
		this.attack_power = power;
	}
	
	public int getAttackPower() {
		return this.attack_power;
	}
}

public class Main {

	public static void main(String[] args) {
		
		Player player1 = new Player("Ucup");
		Player player2 = new Player("Otong");
		
		Armor armor1 = new Armor("Golden Helmet", 50);
		Armor armor2 = new Armor("Silver Helmet", 75);
		
		Weapon weapon1 = new Weapon("Golden Sword", 25);
		Weapon weapon2 = new Weapon("Silver Sword", 35);

		player1.setArmor(armor2);
		player2.setArmor(armor1);
		
		player1.setWeapon(weapon2);
		player2.setWeapon(weapon1);
		
		player1.display();
		player2.display();
		
		player1.attack(player2);
		
		player1.display();
		player2.display();
		

	}

}
