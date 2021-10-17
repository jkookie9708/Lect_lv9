package data;

public class Hero extends Unit {
	private int potion = 3;
	public Hero(String name, int hp, int att, int def, int pos) {
		super(name, hp, att, def, pos);
	}
	
	public int getPotion() {
		return potion;
	}
	
	public void drink() {
		if(potion>0) {
			System.out.println("회복약을 마십니다");
			System.out.println("체력이 100회복 되었습니다");
			this.setHp(this.getHp()+100);
			System.out.println(this.getName() + "의 남은 체력 : " + this.getHp());
			potion --;
		}
	}
	
	public void attack (Unit target) {
		if(target instanceof UniqueZombie) {
			if(((UniqueZombie) target).shield>0) {
				int dam = (this.getAtt() - target.getDef()) * (rn.nextInt(150)+50)/100;
				if(dam<=0) dam = 1;
				System.out.println(getName()+"의 공격!");
				System.out.println(dam+"의 대미지!");
				((UniqueZombie) target).setShield(((UniqueZombie) target).getShield()-dam);
				if(((UniqueZombie) target).getShield()<=0) {
					System.out.println(target.getName()+"의 쉴드가 박살났다!");
					((UniqueZombie) target).setShield(0);
				}
				System.out.println(target.getName()+"의 남은 체력 : "+target.getHp()+" (쉴드 : "+((UniqueZombie) target).getShield()+")");
			}
			else {
				super.attack(target);
			}
		}
		else {
			super.attack(target);
		}
	}

}