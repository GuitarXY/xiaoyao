package com.atguigu.linkedlist;

public class Josepfu {
	/**
	 * 绾︾憻澶棶棰�
	 * 涓�缇ゅ皬瀛╁洿鎴愪竴涓湀0-n
	 * 浠庣k涓皬瀛╂姤鏁�,鎶ュ埌绗琈涓暟鐨勫皬瀛╁嚭鍒楋紝鏈変笅涓�涓皬瀛╅噸鏂板紑濮嬫姤鏁帮紝
	 * 鐩村埌鎵�鏈夊皬瀛╅兘鍑哄垪锛岄棶灏忓鐨勫嚭鍒楅『搴�
	 *
	 * @param args
	 */

	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(25);// 锟斤拷锟斤拷5锟斤拷小锟斤拷锟节碉拷
		circleSingleLinkedList.showBoy();
		
		circleSingleLinkedList.countBoy(1, 2, 25); // 2->4->1->5->3
		//String str = "7*2*2-5+1-5+3-3";
	}

}
//鍗曢」鐜舰閾捐〃
class CircleSingleLinkedList {

	private Boy first = null;
	//娣诲姞灏忓閾捐〃鍥村煄涓�涓幆褰�
	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("nums锟斤拷值锟斤拷锟斤拷确");
			return;
		}
		Boy curBoy = null; //杈呭姪鎸囬拡锛屽府鍔╂瀯寤虹幆褰㈤摼琛紝鎬绘槸鎸囧悜鏈�鍚庣殑
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				first.setNext(first); // 锟斤拷锟缴伙拷
				curBoy = first; // 锟斤拷curBoy指锟斤拷锟揭伙拷锟叫★拷锟�
			} else {
				curBoy.setNext(boy);//褰撳墠鏈�鍚庤妭鐐规寚鍚戞柊鍔犺妭鐐�
				boy.setNext(first);//鏂板姞鑺傜偣鎸囧悜first
				curBoy = boy;//curBoy杈呭姪鎸囬拡绉诲悜鏈熬
			}
		}
	}

	// 锟斤拷锟斤拷锟斤拷前锟侥伙拷锟斤拷锟斤拷锟斤拷
	public void showBoy() {
		// 锟叫讹拷锟斤拷锟斤拷锟角凤拷为锟斤拷
		if (first == null) {
			System.out.println("没锟斤拷锟轿猴拷小锟斤拷~~");
			return;
		}
		// 锟斤拷为first锟斤拷锟杰讹拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟饺皇癸拷锟揭伙拷锟斤拷锟斤拷锟街革拷锟斤拷锟缴憋拷锟斤拷
		Boy curBoy = first;
		while (true) {
			System.out.printf("灏忓 %d \n", curBoy.getNo());
			if (curBoy.getNext() == first) {// 说锟斤拷锟窖撅拷锟斤拷锟斤拷锟斤拷锟�
				break;
			}
			curBoy = curBoy.getNext(); // curBoy锟斤拷锟斤拷
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
			System.out.println("杈撳叆闈炴硶");
			return;
		}
		Boy helper = first;
		while (true) {
			if (helper.getNext() == first) { //
				break;
			}
			helper = helper.getNext();
		}
		for(int j = 0; j < startNo - 1; j++) {//鎶ユ暟鍓嶈first鍜宧elper绉诲姩k娆�
			first = first.getNext();
			helper = helper.getNext();
		}
		while(true) {
			if(helper == first) { //褰撳湀涓彧鏈変竴涓汉
				break;
			}
			for(int j = 0; j < countNum - 1; j++) {//璁╃Щ鍔╟ountNum娆★紝鍑哄湀
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.printf("灏忓%d 鍑哄湀\n", first.getNo());
			first = first.getNext();
			helper.setNext(first); //
			
		}
		System.out.printf("灏忓%d鍑哄湀 \n", first.getNo());
		
	}
}

// 锟斤拷锟斤拷一锟斤拷Boy锟洁，锟斤拷示一锟斤拷锟节碉拷
class Boy {
	private int no;// 锟斤拷锟�
	private Boy next; // 指锟斤拷锟斤拷一锟斤拷锟节碉拷,默锟斤拷null

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
