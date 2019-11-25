package com.host.shangguigusuanfa.queue;

import java.math.BigDecimal;

/**
 * Created by xiaoy on 2019/11/20
 * 用数组模拟队列 先进先出
 */
public class ArrayQueueDemo {
    public static void main(String[] args){


//        Queue queue = new Queue(4);
//        queue.addQueue(1);
//        queue.addQueue(2);
//        queue.showQueue();
//
//        queue.getQueue();
//        System.out.println("--");
//        queue.showQueue();
        BigDecimal price = new BigDecimal("10").divide(new BigDecimal("3"),5,BigDecimal.ROUND_HALF_UP);
        System.out.println(price);
    }
}

class Queue{
    private int maxSize;//队列的长度
    private int front;//队列头部
    private int rear;//队列尾部
    private int[] arr;//用于存放数据，模拟队列

    public Queue(int maxSize) {

        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部的前一个位置，
        rear = -1;//指向队列尾部的数据，包含这个数
    }
    //判断队列是否满
    public boolean isFull(){
       return this.rear+1 % maxSize == front;
    }
    //判断队列是否空
    public boolean isEmpty(){
        return front == rear;
    }

    //队列添加一个元素，在队尾添加
    public void addQueue (int val){
        if (!isFull()){

            arr[rear] = val;
            rear = (rear +1) %maxSize;
        }
        else {
            System.out.println("队列满了");
        }
    }

    //获取队列数据，出队列
    public int getQueue (){
        if (isEmpty()){
            System.out.println("队列为空");
            return -1;
        }
       else{
           int value = arr[front];
           front = (front+1)%maxSize;
           return value;
        }

    }

    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }
        for (int i = front ;i <rear ;i++){
            System.out.println(arr[i]+"   ");
        }
    }
    //查看队列的头部
    public int peek(){
        if (isEmpty()){
            System.out.println("队列为空");
            throw  new RuntimeException("队列为空");
        }
        return arr[front+1];
    }

}
