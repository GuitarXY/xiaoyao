package com.atguigu.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		//锟斤拷锟叫诧拷锟斤拷
		//锟饺达拷锟斤拷锟节碉拷
		HeroNode hero1 = new HeroNode(1, "锟轿斤拷", "锟斤拷时锟斤拷");
		HeroNode hero2 = new HeroNode(2, "卢锟斤拷锟斤拷", "锟斤拷锟斤拷锟斤拷");
		HeroNode hero3 = new HeroNode(3, "锟斤拷锟斤拷", "锟角讹拷锟斤拷");
		HeroNode hero4 = new HeroNode(4, "锟街筹拷", "锟斤拷锟斤拷头");
		
		//锟斤拷锟斤拷要锟斤拷锟斤拷锟斤拷
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		
		//锟斤拷锟斤拷
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero4);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);

		// 锟斤拷锟斤拷一锟铰碉拷锟斤拷锟斤拷姆锟阶拷锟斤拷锟�
		System.out.println("原锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷~~");
		singleLinkedList.list();
		
//		System.out.println("锟斤拷转锟斤拷锟斤拷锟斤拷~~");
//		reversetList(singleLinkedList.getHead());
//		singleLinkedList.list();
		
		System.out.println("锟斤拷锟斤拷锟斤拷锟斤拷锟接★拷锟斤拷锟斤拷锟�, 没锟叫改憋拷锟斤拷锟斤拷慕峁箏~");
		reversePrint(singleLinkedList.getHead());
		
/*		
		//锟斤拷锟诫按锟秸憋拷诺锟剿筹拷锟�
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero3);
		
		//锟斤拷示一锟斤拷
		singleLinkedList.list();
		
		//锟斤拷锟斤拷锟睫改节碉拷拇锟斤拷锟�
		HeroNode newHeroNode = new HeroNode(2, "小卢", "锟斤拷锟斤拷锟斤拷~~");
		singleLinkedList.update(newHeroNode);
		
		System.out.println("锟睫改猴拷锟斤拷锟斤拷锟斤拷锟斤拷~~");
		singleLinkedList.list();
		
		//删锟斤拷一锟斤拷锟节碉拷
		singleLinkedList.del(1);
		singleLinkedList.del(4);
		System.out.println("删锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷~~");
		singleLinkedList.list();
		
		//锟斤拷锟斤拷一锟斤拷 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷效锟节碉拷母锟斤拷锟�
		System.out.println("锟斤拷效锟侥节碉拷锟斤拷锟�=" + getLength(singleLinkedList.getHead()));//2
		
		//锟斤拷锟斤拷一锟铰匡拷锟斤拷锟角凤拷玫锟斤拷说锟斤拷锟斤拷锟終锟斤拷锟节碉拷
		HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
		System.out.println("res=" + res);
*/		
		
	}

	/**
	 * 鍊掑彊杈撳嚭鍗曢摼琛�
	 * 浣跨敤鏍堢殑鏂瑰紡锛屽厛鎶婇摼琛ㄥ帇鍏ユ爤锛岀洿鎺ヨ緭鍑烘爤
	 * @param head
	 */
	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			return;
		}
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		while(cur != null) {
			stack.push(cur);
			cur = cur.next; //cur锟斤拷锟狡ｏ拷锟斤拷锟斤拷锟酵匡拷锟斤拷压锟斤拷锟斤拷一锟斤拷锟节碉拷
		}
		//锟斤拷栈锟叫的节碉拷锟斤拷写锟接�,pop 锟斤拷栈
		while (stack.size() > 0) {
			System.out.println(stack.pop()); //stack锟斤拷锟截碉拷锟斤拷锟饺斤拷锟斤拷锟�
		}
	}

	//鍙嶈浆鍗曢摼琛�
	public static void reversetList(HeroNode head) {
		if(head.next == null || head.next.next == null) {
			return ;
		}
		
		HeroNode cur = head.next;
		HeroNode next = null;// 指鐩墠涓虹┖
		HeroNode reverseHead = new HeroNode(0, "", "");//杈呭姪閾捐〃
		while(cur != null) {
			next = cur.next;//褰撳墠鎸囬拡鎸囧悜涓嬩竴涓妭鐐圭殑閾捐〃
			cur.next = reverseHead.next;//濡傛灉鏄涓�涓妭鐐圭殑璇濓紝鍙嶈浆鍚庡氨鎸囧悜绌�
			reverseHead.next = cur; //reverseHead.next鍙樻垚褰撳墠鑺傜偣
			cur = next;//鎸囬拡鎸囧悜涓嬩竴涓�
		}

		head.next = reverseHead.next;
	}
	//鎵惧埌閾捐〃涓�掓暟绗琸涓妭鐐�
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		if(head.next == null) {
			return null;
		}
		//绗竴娆￠亶鍘嗗緱鍒伴摼琛ㄨ妭鐐逛釜鏁�
		int size = getLength(head);
		if(index <=0 || index > size) {
			return null; 
		}
		HeroNode cur = head.next; //3 // 3 - 1 = 2
		for(int i =0; i< size - index; i++) {
			cur = cur.next;
		}
		return cur;
		
	}
	
	/**
	 * 鑾峰彇鍒板崟閾捐〃鑺傜偣涓暟濡傛灉鏄甫澶磋妭鐐癸紝鍒欎笉缁熻澶磋妭鐐�
	 * @param head
	 * @return
	 */
	public static int getLength(HeroNode head) {
		if(head.next == null) {// 閾捐〃涓虹┖
			return 0;
		}
		int length = 0;
		//鎸囧悜涓嬩竴涓妭鐐�
		HeroNode cur = head.next;
		while(cur != null) {
			length++;
			cur = cur.next; //
		}
		return length;
	}

}


class SingleLinkedList {
	//锟饺筹拷始锟斤拷一锟斤拷头锟节碉拷, 头锟节点不要锟斤拷, 锟斤拷锟斤拷啪锟斤拷锟斤拷锟斤拷锟斤拷
	private HeroNode head = new HeroNode(0, "", "");
	
	
	//锟斤拷锟斤拷头锟节碉拷
	public HeroNode getHead() {
		return head;
	}

	//锟斤拷咏诘愕斤拷锟斤拷锟斤拷锟斤拷锟�
	//思路锟斤拷锟斤拷锟斤拷锟斤拷锟角憋拷锟剿筹拷锟绞�
	//1. 锟揭碉拷锟斤拷前锟斤拷锟斤拷锟斤拷锟斤拷诘锟�
	//2. 锟斤拷锟斤拷锟斤拷锟斤拷锟节碉拷锟絥ext 指锟斤拷 锟铰的节碉拷
	public void add(HeroNode heroNode) {
		
		//锟斤拷为head锟节点不锟杰讹拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟揭伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟� temp
		HeroNode temp = head;
		//锟斤拷锟斤拷锟斤拷锟斤拷锟揭碉拷锟斤拷锟�
		while(true) {
			//锟揭碉拷锟斤拷锟斤拷锟斤拷锟斤拷
			if(temp.next == null) {//
				break;
			}
			//锟斤拷锟矫伙拷锟斤拷业锟斤拷锟斤拷, 锟斤拷锟斤拷temp锟斤拷锟斤拷
			temp = temp.next;
		}
		//锟斤拷锟剿筹拷while循锟斤拷时锟斤拷temp锟斤拷指锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		//锟斤拷锟斤拷锟斤拷锟斤拷锟节碉拷锟絥ext 指锟斤拷 锟铰的节碉拷
		temp.next = heroNode;
	}
	
	//锟节讹拷锟街凤拷式锟斤拷锟斤拷锟接拷锟绞憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟接拷鄄锟斤拷氲街革拷锟轿伙拷锟�
	//(锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟绞э拷埽锟斤拷锟斤拷锟斤拷锟斤拷锟绞�)
	public void addByOrder(HeroNode heroNode) {
		//锟斤拷为头锟节点不锟杰讹拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟饺煌拷锟揭伙拷锟斤拷锟斤拷锟街革拷锟�(锟斤拷锟斤拷)锟斤拷锟斤拷锟斤拷锟揭碉拷锟斤拷拥锟轿伙拷锟�
		//锟斤拷为锟斤拷锟斤拷锟斤拷锟斤拷为锟斤拷锟斤拷锟揭碉拷temp 锟斤拷位锟斤拷 锟斤拷锟轿伙拷玫锟角耙伙拷锟斤拷诘悖拷锟斤拷锟斤拷锟诫不锟斤拷
		HeroNode temp = head;
		boolean flag = false; // flag锟斤拷志锟斤拷拥谋锟斤拷锟角凤拷锟斤拷冢锟侥拷锟轿猣alse
		while(true) {
			if(temp.next == null) {//说锟斤拷temp锟窖撅拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
				break; //
			} 
			if(temp.next.no > heroNode.no) { //位锟斤拷锟揭碉拷锟斤拷锟斤拷锟斤拷temp锟侥猴拷锟斤拷锟斤拷锟�
				break;
			} else if (temp.next.no == heroNode.no) {//说锟斤拷希锟斤拷锟斤拷拥锟絟eroNode锟侥憋拷锟斤拷锟饺伙拷锟斤拷锟�
				
				flag = true; //说锟斤拷锟斤拷糯锟斤拷锟�
				break;
			}
			temp = temp.next; //锟斤拷锟狡ｏ拷锟斤拷锟斤拷锟斤拷前锟斤拷锟斤拷
		}
		//锟叫讹拷flag 锟斤拷值
		if(flag) { //锟斤拷锟斤拷锟斤拷樱锟剿碉拷锟斤拷锟脚达拷锟斤拷
			System.out.printf("准锟斤拷锟斤拷锟斤拷锟接拷鄣谋锟斤拷 %d 锟窖撅拷锟斤拷锟斤拷锟斤拷, 锟斤拷锟杰硷拷锟斤拷\n", heroNode.no);
		} else {
			//锟斤拷锟诫到锟斤拷锟斤拷锟斤拷, temp锟侥猴拷锟斤拷
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	//锟睫改节碉拷锟斤拷锟较�, 锟斤拷锟斤拷no锟斤拷锟斤拷锟斤拷薷模锟斤拷锟絥o锟斤拷挪锟斤拷芨锟�.
	//说锟斤拷
	//1. 锟斤拷锟斤拷 newHeroNode 锟斤拷 no 锟斤拷锟睫改硷拷锟斤拷
	public void update(HeroNode newHeroNode) {
		//锟叫讹拷锟角凤拷锟�
		if(head.next == null) {
			System.out.println("锟斤拷锟斤拷为锟斤拷~");
			return;
		}
		//锟揭碉拷锟斤拷要锟睫改的节碉拷, 锟斤拷锟斤拷no锟斤拷锟�
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		HeroNode temp = head.next;
		boolean flag = false; //锟斤拷示锟角凤拷锟揭碉拷锟矫节碉拷
		while(true) {
			if (temp == null) {
				break; //锟窖撅拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
			}
			if(temp.no == newHeroNode.no) {
				//锟揭碉拷
				flag = true;
				break;
			}
			temp = temp.next;
		}
		//锟斤拷锟斤拷flag 锟叫讹拷锟角凤拷锟揭碉拷要锟睫改的节碉拷
		if(flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else { //没锟斤拷锟揭碉拷
			System.out.printf("没锟斤拷锟揭碉拷 锟斤拷锟� %d 锟侥节点，锟斤拷锟斤拷锟睫革拷\n", newHeroNode.no);
		}
	}
	
	//删锟斤拷锟节碉拷
	//思路
	//1. head 锟斤拷锟杰讹拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟揭伙拷锟絫emp锟斤拷锟斤拷锟节碉拷锟揭碉拷锟斤拷删锟斤拷锟节碉拷锟角耙伙拷锟斤拷诘锟�
	//2. 说锟斤拷锟斤拷锟斤拷锟节比斤拷时锟斤拷锟斤拷temp.next.no 锟斤拷  锟斤拷要删锟斤拷锟侥节碉拷锟絥o锟饺斤拷
	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false; // 锟斤拷志锟角凤拷锟揭碉拷锟斤拷删锟斤拷锟节碉拷锟�
		while(true) {
			if(temp.next == null) { //锟窖撅拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
				break;
			}
			if(temp.next.no == no) {
				//锟揭碉拷锟侥达拷删锟斤拷锟节碉拷锟角耙伙拷锟斤拷诘锟絫emp
				flag = true;
				break;
			}
			temp = temp.next; //temp锟斤拷锟狡ｏ拷锟斤拷锟斤拷
		}
		//锟叫讹拷flag
		if(flag) { //锟揭碉拷
			//锟斤拷锟斤拷删锟斤拷
			temp.next = temp.next.next;
		}else {
			System.out.printf("要删锟斤拷锟斤拷 %d 锟节点不锟斤拷锟斤拷\n", no);
		}
	}
	
	//锟斤拷示锟斤拷锟斤拷[锟斤拷锟斤拷]
	public void list() {
		//锟叫讹拷锟斤拷锟斤拷锟角凤拷为锟斤拷
		if(head.next == null) {
			System.out.println("锟斤拷锟斤拷为锟斤拷");
			return;
		}
		//锟斤拷为头锟节点，锟斤拷锟杰讹拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟揭伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
		HeroNode temp = head.next;
		while(true) {
			//锟叫讹拷锟角凤拷锟斤拷锟斤拷锟斤拷锟�
			if(temp == null) {
				break;
			}
			//锟斤拷锟斤拷诘锟斤拷锟斤拷息
			System.out.println(temp);
			//锟斤拷temp锟斤拷锟狡ｏ拷 一锟斤拷小锟斤拷
			temp = temp.next;
		}
	}
}

class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next; //指锟斤拷锟斤拷一锟斤拷锟节碉拷
	//锟斤拷锟斤拷锟斤拷
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	//为锟斤拷锟斤拷示锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}
