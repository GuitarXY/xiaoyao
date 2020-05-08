package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// 锟斤拷锟斤拷
		System.out.println("");
		// 锟饺达拷锟斤拷锟节碉拷
		HeroNode2 hero1 = new HeroNode2(1, "锟轿斤拷", "锟斤拷时锟斤拷");
		HeroNode2 hero2 = new HeroNode2(2, "卢锟斤拷锟斤拷", "锟斤拷锟斤拷锟斤拷");
		HeroNode2 hero3 = new HeroNode2(3, "锟斤拷锟斤拷", "锟角讹拷锟斤拷");
		HeroNode2 hero4 = new HeroNode2(4, "锟街筹拷", "锟斤拷锟斤拷头");
		// 锟斤拷锟斤拷一锟斤拷双锟斤拷锟斤拷锟斤拷
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		doubleLinkedList.add(hero4);
		
		doubleLinkedList.list();
		
		// 锟睫革拷
		HeroNode2 newHeroNode = new HeroNode2(4, "锟斤拷锟斤拷胜", "锟斤拷锟斤拷锟斤拷");
		doubleLinkedList.update(newHeroNode);
		System.out.println("锟睫改猴拷锟斤拷锟斤拷锟斤拷锟斤拷");
		doubleLinkedList.list();
		
		// 删锟斤拷
		doubleLinkedList.del(3);
		System.out.println("删锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷~~");
		doubleLinkedList.list();
		
		
		
	}

}
//鍙屽悜閾捐〃
class DoubleLinkedList {

	private HeroNode2 head = new HeroNode2(0, "", "");

	public HeroNode2 getHead() {
		return head;
	}

	// 锟斤拷锟斤拷双锟斤拷锟斤拷锟斤拷姆锟斤拷锟�
	// 锟斤拷示锟斤拷锟斤拷[锟斤拷锟斤拷]
	public void list() {
		if (head.next == null) {
			System.out.println("绌�");
			return;
		}
		HeroNode2 temp = head.next;
		while (true) {
			// 锟叫讹拷锟角凤拷锟斤拷锟斤拷锟斤拷锟�
			if (temp == null) {
				break;
			}
			// 锟斤拷锟斤拷诘锟斤拷锟斤拷息
			System.out.println(temp);
			// 锟斤拷temp锟斤拷锟狡ｏ拷 一锟斤拷小锟斤拷
			temp = temp.next;
		}
	}

	public void add(HeroNode2 heroNode) {

		HeroNode2 temp = head;
		while (true) {
			if (temp.next == null) {//
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
		heroNode.pre = temp;
	}

	public void update(HeroNode2 newHeroNode) {
		// 锟叫讹拷锟角凤拷锟�
		if (head.next == null) {
			System.out.println("锟斤拷锟斤拷为锟斤拷~");
			return;
		}
		// 锟揭碉拷锟斤拷要锟睫改的节碉拷, 锟斤拷锟斤拷no锟斤拷锟�
		// 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		HeroNode2 temp = head.next;
		boolean flag = false; // 锟斤拷示锟角凤拷锟揭碉拷锟矫节碉拷
		while (true) {
			if (temp == null) {
				break; // 锟窖撅拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
			}
			if (temp.no == newHeroNode.no) {
				// 锟揭碉拷
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// 锟斤拷锟斤拷flag 锟叫讹拷锟角凤拷锟揭碉拷要锟睫改的节碉拷
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else { // 没锟斤拷锟揭碉拷
			System.out.printf("没锟斤拷锟揭碉拷 锟斤拷锟� %d 锟侥节点，锟斤拷锟斤拷锟睫革拷\n", newHeroNode.no);
		}
	}

	// 锟斤拷双锟斤拷锟斤拷锟斤拷锟斤拷删锟斤拷一锟斤拷锟节碉拷,
	// 说锟斤拷
	// 1 锟斤拷锟斤拷双锟斤拷锟斤拷锟斤拷锟斤拷锟角匡拷锟斤拷直锟斤拷锟揭碉拷要删锟斤拷锟斤拷锟斤拷锟斤拷诘锟�
	// 2 锟揭碉拷锟斤拷锟斤拷锟斤拷删锟斤拷锟斤拷锟斤拷
	public void del(int no) {

		if (head.next == null) {// 锟斤拷锟斤拷锟斤拷
			System.out.println("锟斤拷锟斤拷为锟秸ｏ拷锟睫凤拷删锟斤拷");
			return;
		}

		HeroNode2 temp = head.next; // 锟斤拷锟斤拷锟斤拷锟斤拷(指锟斤拷)
		boolean flag = false; // 锟斤拷志锟角凤拷锟揭碉拷锟斤拷删锟斤拷锟节碉拷锟�
		while (true) {
			if (temp == null) { // 锟窖撅拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
				break;
			}
			if (temp.no == no) {
				// 锟揭碉拷锟侥达拷删锟斤拷锟节碉拷锟角耙伙拷锟斤拷诘锟絫emp
				flag = true;
				break;
			}
			temp = temp.next; // temp锟斤拷锟狡ｏ拷锟斤拷锟斤拷
		}
		// 锟叫讹拷flag
		if (flag) { // 锟揭碉拷
			// 锟斤拷锟斤拷删锟斤拷
			// temp.next = temp.next.next;[锟斤拷锟斤拷锟斤拷锟斤拷]
			temp.pre.next = temp.next;
			// 锟斤拷锟斤拷锟斤拷锟角的达拷锟斤拷锟斤拷锟斤拷锟斤拷?
			// 锟斤拷锟斤拷锟斤拷锟斤拷一锟斤拷锟节点，锟酵诧拷锟斤拷要执锟斤拷锟斤拷锟斤拷锟斤拷浠帮拷锟斤拷锟斤拷锟斤拷锟街匡拷指锟斤拷
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.printf("要删锟斤拷锟斤拷 %d 锟节点不锟斤拷锟斤拷\n", no);
		}
	}

}

//
class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next; // 鍚庝竴涓妭鐐�
	public HeroNode2 pre; // 鍓嶄竴涓妭鐐�

	public HeroNode2(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}
