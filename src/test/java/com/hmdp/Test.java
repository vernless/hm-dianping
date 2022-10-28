package com.hmdp;

import java.util.*;

/**
 * @Author 滨
 * @Date 2022/10/26 18:49
 * @Description: TODO
 * @Version 1.0
 */
public class Test {

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> order = new ArrayDeque<>();
        Queue<Integer> now = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            int t = sc.nextInt();
            order.add(t);
        }
        for(int i = 0; i < n; i++){
            int t = sc.nextInt();
            now.add(t);
        }
        int result = 0;
        while(!now.isEmpty()){
            int nowInt = now.poll();
            if(order.peek() == nowInt){
                order.poll();
            }else{
                order.remove(nowInt);
                result++;
            }
        }
        System.out.println(result);
    }*/

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int mid = n / 2;
        int[] level = new int[n];
        for(int i = 0; i < n; i++){
            level[i] = sc.nextInt();
        }
        if(n == 1){
            System.out.println(level[0] + k);
        }else{
            Arrays.sort(level);
            System.out.println(level[mid]);
            loop:
            while(k > 0){
                //应该给中位数及往后的武器升级
                //每次都要从mid开始，加到和mid+1相等为止
                while(level[mid] + 1 <= level[mid + 1]){
                    level[mid] += 1;
                    k--;
                    if(k == 0){
                        break loop;
                    }
                }
                System.out.println(level[mid]);
                int big = mid + 1;
                for(int i = big; i < n; i++){
                    if(level[i] > level[mid]){
                        System.out.println("big:    "+big);
                        big = i - 1;
                        break;
                    }
                }

                for(int i = big; i >= mid; i--){
                    level[i] += 1;
                    k--;
                    if(k == 0){
                        break loop;
                    }
                }
            }
        }
        System.out.println("result:"+level[mid]);
        //1：强化的数量增多
        //2: 在1的前提下强化的中位数变最大
        // 1 2 3 4 5 7 7 9 10 12 15    5
        //         6
        //         7
        //         7 7 8
        //         7 8 8

        // 1 2 3 4 5 7 8 9 10 12 15    5
        //           8
        //           8  9
        //           9  9
        //           9  9  10
        //           9  10  10
    }
}
