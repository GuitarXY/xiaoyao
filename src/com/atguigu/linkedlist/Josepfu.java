package com.atguigu.linkedlist;

public class Josepfu {
	/**
	 * 约瑟夫问题
	 * 一群小孩围成一个圈0-n
	 * 从第k个小孩报数,报到第M个数的小孩出列，有下一个小孩重新开始报数，
	 * 直到所有小孩都出列，问小孩的出列顺序
	 *
	 * @param args
	 */

	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(25);// ����5��С���ڵ�
		circleSingleLinkedList.showBoy();
		
		circleSingleLinkedList.countBoy(1, 2, 25); // 2->4->1->5->3
		//String str = "7*2*2-5+1-5+3-3";
	}

}
//单项环形链表
class CircleSingleLinkedList {

	private Boy first = null;
	//添加小孩链表围城一个环形
	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("nums��ֵ����ȷ");
			return;
		}
		Boy curBoy = null; //辅助指针，帮助构建环形链表，总是指向最后的
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				first.setNext(first); // ���ɻ�
				curBoy = first; // ��curBoyָ���һ��С��
			} else {
				curBoy.setNext(boy);//当前最后节点指向新加节点
				boy.setNext(first);//新加节点指向first
				curBoy = boy;//curBoy辅助指针移向末尾
			}
		}
	}

	// ������ǰ�Ļ�������
	public void showBoy() {
		// �ж������Ƿ�Ϊ��
		if (first == null) {
			System.out.println("û���κ�С��~~");
			return;
		}
		// ��Ϊfirst���ܶ������������Ȼʹ��һ������ָ����ɱ���
		Boy curBoy = first;
		while (true) {
			System.out.printf("小孩 %d \n", curBoy.getNo());
			if (curBoy.getNext() == first) {// ˵���Ѿ��������
				break;
			}
			curBoy = curBoy.getNext(); // curBoy����
		}
	}

	/**
	 * 
	 * @param startNo
	 * @param countNum
	 * @param nums
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("输入非法");
			return;
		}
		Boy helper = first;
		while (true) {
			if (helper.getNext() == first) { //
				break;
			}
			helper = helper.getNext();
		}
		for(int j = 0; j < startNo - 1; j++) {//报数前让first和helper移动k次
			first = first.getNext();
			helper = helper.getNext();
		}
		while(true) {
			if(helper == first) { //当圈中只有一个人
				break;
			}
			for(int j = 0; j < countNum - 1; j++) {//让移动countNum次，出圈
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.printf("小孩%d 出圈\n", first.getNo());
			first = first.getNext();
			helper.setNext(first); //
			
		}
		System.out.printf("小孩%d出圈 \n", first.getNo());
		
	}
}

// ����һ��Boy�࣬��ʾһ���ڵ�
class Boy {
	private int no;// ���
	private Boy next; // ָ����һ���ڵ�,Ĭ��null

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}

}
