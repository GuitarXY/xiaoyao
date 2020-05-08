package com.atguigu.linkedlist;

import java.util.Stack;
//婕旂ず鏍堢殑鍩烘湰浣跨敤
public class TestStack {

	public static void main(String[] args) {
		Stack<String> stack = new Stack();
		// 锟斤拷栈
		stack.add("jack");
		stack.add("tom");
		stack.add("smith");

		// 锟斤拷栈
		// smith, tom , jack
		while (stack.size() > 0) {
			System.out.println(stack.pop());//pop鍑烘爤鐨勬剰鎬�
		}
	}

}
