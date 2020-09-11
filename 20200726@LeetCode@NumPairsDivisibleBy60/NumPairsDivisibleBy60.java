package com.dl.textL;

public class NumPairsDivisibleBy60 {
	
    public int numPairsDivisibleBy60(int[] time) {
        int[] record = new int[60];
        int count = 0;
        for(int t : time){
            t %= 60;        //�����ʱ�������
            if(t != 0)  
                count += record[60 - t];    //���ʱ��������Ϊ0���ҳ����Ϊ0�������ܺ����
            else count += record[t];        //���Ϊ0��������Ϊ0����
            record[t] ++;
        }
        return count;
    }

}
