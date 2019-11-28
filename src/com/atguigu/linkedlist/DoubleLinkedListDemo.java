package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// ����
		System.out.println("");
		// �ȴ����ڵ�
		HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
		HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
		HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");
		// ����һ��˫������
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		doubleLinkedList.add(hero4);
		
		doubleLinkedList.list();
		
		// �޸�
		HeroNode2 newHeroNode = new HeroNode2(4, "����ʤ", "������");
		doubleLinkedList.update(newHeroNode);
		System.out.println("�޸ĺ���������");
		doubleLinkedList.list();
		
		// ɾ��
		doubleLinkedList.del(3);
		System.out.println("ɾ������������~~");
		doubleLinkedList.list();
		
		
		
	}

}
//双向链表
class DoubleLinkedList {

	private HeroNode2 head = new HeroNode2(0, "", "");

	public HeroNode2 getHead() {
		return head;
	}

	// ����˫������ķ���
	// ��ʾ����[����]
	public void list() {
		if (head.next == null) {
			System.out.println("空");
			return;
		}
		HeroNode2 temp = head.next;
		while (true) {
			// �ж��Ƿ��������
			if (temp == null) {
				break;
			}
			// ����ڵ����Ϣ
			System.out.println(temp);
			// ��temp���ƣ� һ��С��
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
		// �ж��Ƿ��
		if (head.next == null) {
			System.out.println("����Ϊ��~");
			return;
		}
		// �ҵ���Ҫ�޸ĵĽڵ�, ����no���
		// ����һ����������
		HeroNode2 temp = head.next;
		boolean flag = false; // ��ʾ�Ƿ��ҵ��ýڵ�
		while (true) {
			if (temp == null) {
				break; // �Ѿ�����������
			}
			if (temp.no == newHeroNode.no) {
				// �ҵ�
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// ����flag �ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else { // û���ҵ�
			System.out.printf("û���ҵ� ��� %d �Ľڵ㣬�����޸�\n", newHeroNode.no);
		}
	}

	// ��˫��������ɾ��һ���ڵ�,
	// ˵��
	// 1 ����˫���������ǿ���ֱ���ҵ�Ҫɾ��������ڵ�
	// 2 �ҵ�������ɾ������
	public void del(int no) {

		if (head.next == null) {// ������
			System.out.println("����Ϊ�գ��޷�ɾ��");
			return;
		}

		HeroNode2 temp = head.next; // ��������(ָ��)
		boolean flag = false; // ��־�Ƿ��ҵ���ɾ���ڵ��
		while (true) {
			if (temp == null) { // �Ѿ�����������
				break;
			}
			if (temp.no == no) {
				// �ҵ��Ĵ�ɾ���ڵ��ǰһ���ڵ�temp
				flag = true;
				break;
			}
			temp = temp.next; // temp���ƣ�����
		}
		// �ж�flag
		if (flag) { // �ҵ�
			// ����ɾ��
			// temp.next = temp.next.next;[��������]
			temp.pre.next = temp.next;
			// �������ǵĴ���������?
			// ��������һ���ڵ㣬�Ͳ���Ҫִ��������仰��������ֿ�ָ��
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.printf("Ҫɾ���� %d �ڵ㲻����\n", no);
		}
	}

}

//
class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next; // 后一个节点
	public HeroNode2 pre; // 前一个节点

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
